package kz.epam.xml_xsd_parsing.entity;

import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BanksStAXBuilder extends AbstractBanksBuilder {
	private static Logger logger = Logger.getLogger(BanksStAXBuilder.class);
	private Set<Bank> banks;
	private XMLInputFactory inputFactory;

	public BanksStAXBuilder() {
		banks = new HashSet<>();
		inputFactory = XMLInputFactory.newInstance();
		logger.info("BanksStAXBuilder was created");
	}

	public Set<Bank> getBanks() {
		return banks;
	}

	@Override
	public void buildSetBanks(String fileName) {
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
	}

	private Bank buildBank(XMLStreamReader reader) throws XMLStreamException {
		Bank bank = new Bank();
		bank.setName(reader.getAttributeValue(null, BankEnum.NAME.getValue()));
		bank.setCountry(reader.getAttributeValue(null, BankEnum.COUNTRY.getValue()));
		if (reader.getAttributeValue(null, BankEnum.DEPOSITOR.getValue()) != null) {
			bank.setDepositor(reader.getAttributeValue(null, BankEnum.DEPOSITOR.getValue()));
		}
		bank.setAccountId(reader.getAttributeValue(null, BankEnum.ACCOUNT_ID.getValue()));
		bank.setType(reader.getAttributeValue(null, BankEnum.TYPE.getValue()));
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
