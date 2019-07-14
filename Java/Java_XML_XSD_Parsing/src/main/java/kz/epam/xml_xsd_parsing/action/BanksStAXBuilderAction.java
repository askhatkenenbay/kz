package kz.epam.xml_xsd_parsing.action;

import kz.epam.xml_xsd_parsing.entity.Bank;
import kz.epam.xml_xsd_parsing.entity.BankEnum;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BanksStAXBuilderAction {
	private static Logger logger = Logger.getLogger(BanksStAXBuilderAction.class);

	public static Set<Bank> buildSetBanks(String fileName, XMLInputFactory inputFactory) {
		Set<Bank> banks = new HashSet<>();
		FileInputStream inputStream = null;
		XMLStreamReader reader;
		String name;
		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if (name.equals(BankEnum.BANK.getValue())) {
						Bank bank = buildBank(reader);
						banks.add(bank);
					}
				}
			}
			return banks;
		} catch (FileNotFoundException e) {
			logger.error(new FileNotFoundException(e.getMessage()));
			e.printStackTrace();
		} catch (XMLStreamException e) {
			logger.error(new XMLStreamException(e.getMessage()));
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				logger.error(new IOException(e.getMessage()));
				e.printStackTrace();
			}
		}
		return new HashSet<>();
	}

	private static Bank buildBank(XMLStreamReader reader) throws XMLStreamException {
		Bank bank = new Bank();
		bank.setName(reader.getAttributeValue(null, BankEnum.NAME.getValue()));
		if (reader.getAttributeValue(null, BankEnum.COUNTRY.getValue()) != null && reader.getAttributeValue(null, BankEnum.COUNTRY.getValue()).length() != 0) {
			bank.setCountry(reader.getAttributeValue(null, BankEnum.COUNTRY.getValue()));
		} else {
			bank.setCountry("Kazakhstan");
		}
		if (reader.getAttributeValue(null, BankEnum.DEPOSITOR.getValue()) != null) {
			bank.setDepositor(reader.getAttributeValue(null, BankEnum.DEPOSITOR.getValue()));
		}
		bank.setAccountId(reader.getAttributeValue(null, BankEnum.ACCOUNT_ID.getValue()));
		if (reader.getAttributeValue(null, BankEnum.TYPE.getValue()) != null && reader.getAttributeValue(null, BankEnum.TYPE.getValue()).length() != 0) {
			bank.setType(reader.getAttributeValue(null, BankEnum.TYPE.getValue()));
		} else {
			bank.setType("до востребования");
		}

		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
				case XMLStreamConstants.START_ELEMENT:
					String str = reader.getLocalName().toUpperCase();
					StringBuilder stringBuilder = new StringBuilder();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '-') {
							stringBuilder.append('_');
						} else {
							stringBuilder.append(str.charAt(i));
						}
					}
					switch (BankEnum.valueOf(stringBuilder.toString())) {
						case AMOUNT_ON_DEPOSIT:
							bank.setAmountOnDeposit(Integer.parseInt(getXMLText(reader)));
							break;
						case PROFITABILITY:
							bank.setProfitability(Double.parseDouble(getXMLText(reader)));
							break;
						case TIME_CONSTRAINTS:
							bank.setTimeConstraint(getXMLTimeConstraints(reader));
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					String str1 = reader.getLocalName().toUpperCase();
					StringBuilder stringBuilder1 = new StringBuilder();
					for (int i = 0; i < str1.length(); i++) {
						if (str1.charAt(i) == '-') {
							stringBuilder1.append('_');
						} else {
							stringBuilder1.append(str1.charAt(i));
						}
					}
					if (BankEnum.valueOf(stringBuilder1.toString()) == BankEnum.BANK) {
						return bank;
					}
			}
		}
		logger.error(new XMLStreamException("Unknown element in tag Bank"));
		throw new XMLStreamException("Unknown element in tag Bank");
	}

	private static String getXMLTimeConstraints(XMLStreamReader reader) throws XMLStreamException {
		StringBuilder result = new StringBuilder();
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
				case XMLStreamConstants.START_ELEMENT:
					name = reader.getLocalName();
					switch (BankEnum.valueOf(name.toUpperCase())) {
						case YEARS:
							result.append(getXMLText(reader));
							break;
						case MONTHS:
							result.insert(0, "/" + getXMLText(reader) + "/");
							break;
						case DAYS:
							result.insert(0, getXMLText(reader));
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					String str = reader.getLocalName().toUpperCase();
					StringBuilder stringBuilder = new StringBuilder();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == '-') {
							stringBuilder.append('_');
						} else {
							stringBuilder.append(str.charAt(i));
						}
					}
					if (BankEnum.valueOf(stringBuilder.toString()) == BankEnum.TIME_CONSTRAINTS) {
						return result.toString();
					}
			}
		}
		logger.error(new XMLStreamException("Unknown element in tag time-constraints"));
		throw new XMLStreamException("Unknown element in tag time-constraints");
	}

	private static String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String result = null;
		if (reader.hasNext()) {
			reader.next();
			result = reader.getText();
		}
		return result;
	}
}
