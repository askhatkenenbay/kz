package kz.epam.xml_xsd_parsing.entity;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class BankHandler extends DefaultHandler {
	private static Logger logger = Logger.getLogger(BankHandler.class);
	private Set<Bank> banks;
	private Bank currentBank;
	private BankEnum currentEnum;
	private static EnumSet<BankEnum> withText = EnumSet.range(BankEnum.AMOUNT_ON_DEPOSIT, BankEnum.DAYS);

	public BankHandler() {
		banks = new HashSet<>();
	}

	public Set<Bank> getBanks() {
		return banks;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) {
		if ("bank".equals(localName)) {
			currentBank = new Bank();
			currentBank.setName(attrs.getValue("name"));
			if (attrs.getValue("country") != null && attrs.getValue("country").length() != 0) {
				currentBank.setCountry(attrs.getValue("country"));
			} else {
				currentBank.setCountry("Kazakhstan");
			}
			try {
				if (attrs.getValue("depositor") != null || attrs.getValue("depositor").length() != 0) {
					currentBank.setDepositor(attrs.getValue("depositor"));
				}
			} catch (NullPointerException e) {

			}
			currentBank.setAccountId(attrs.getValue("account-id"));
			if (attrs.getValue("type") != null && attrs.getValue("type").length() != 0) {
				currentBank.setType(attrs.getValue("type"));
			} else {
				currentBank.setType("до востребования");
			}
		} else {
			String str = localName.toUpperCase();
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '-') {
					stringBuilder.append('_');
				} else {
					stringBuilder.append(str.charAt(i));
				}
			}
			BankEnum temp = BankEnum.valueOf(stringBuilder.toString());
			if (withText.contains(temp)) {
				currentEnum = temp;
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if ("bank".equals(localName)) {
			banks.add(currentBank);
		}
		currentEnum = null;
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		String str = new String(ch, start, length).trim();
		if (currentEnum == null) return;
		switch (currentEnum) {
			case AMOUNT_ON_DEPOSIT:
				currentBank.setAmountOnDeposit(Integer.parseInt(str));
				break;
			case PROFITABILITY:
				currentBank.setProfitability(Double.parseDouble(str));
				break;
			case YEARS:
			case DAYS:
				currentBank.setTimeConstraint(str);
				break;
			case MONTHS:
				currentBank.setTimeConstraint("/" + str + "/");
				break;
			default:
				logger.error(new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name()));
				throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
		}
	}


}
