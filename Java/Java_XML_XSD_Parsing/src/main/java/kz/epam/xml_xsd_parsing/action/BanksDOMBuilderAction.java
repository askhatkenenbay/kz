package kz.epam.xml_xsd_parsing.action;

import kz.epam.xml_xsd_parsing.entity.Bank;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BanksDOMBuilderAction {
	private static Logger logger = Logger.getLogger(BanksDOMBuilderAction.class);

	public static Set<Bank> buildSetBanks(String fileName, DocumentBuilder documentBuilder) {
		Set<Bank> banks = new HashSet<>();
		Document document;
		try {
			document = documentBuilder.parse(fileName);
			Element root = document.getDocumentElement();
			NodeList bankList = root.getElementsByTagName("bank");
			for (int i = 0; i < bankList.getLength(); i++) {
				Element bankElement = (Element) bankList.item(i);
				Bank bank = buildBank(bankElement);
				banks.add(bank);
			}
			return banks;
		} catch (SAXException e) {
			logger.error(new SAXException(e.getMessage()));
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(new IOException(e.getMessage()));
			e.printStackTrace();
		}
		return new HashSet<>();
	}

	private static Bank buildBank(Element bankElement) {
		Bank bank = new Bank();
		bank.setAccountId(bankElement.getAttribute("account-id"));
		bank.setName(bankElement.getAttribute("name"));
		if (bankElement.getAttribute("country") != null && bankElement.getAttribute("country").length() != 0) {
			bank.setCountry(bankElement.getAttribute("country"));
		} else {
			bank.setCountry("Kazakhstan");
		}

		if (bankElement.getAttribute("depositor") != null) {
			bank.setDepositor(bankElement.getAttribute("depositor"));
		}
		if (bankElement.getAttribute("type") != null && bankElement.getAttribute("type").length() != 0) {
			bank.setType(bankElement.getAttribute("type"));
		} else {
			bank.setType("до востребования");
		}

		bank.setAmountOnDeposit(Integer.parseInt(getElementTextContent(bankElement, "amount-on-deposit")));
		bank.setProfitability(Double.parseDouble(getElementTextContent(bankElement, "profitability")));
		Element timeConstraints = (Element) bankElement.getElementsByTagName("time-constraints").item(0);
		String years = getElementTextContent(timeConstraints, "years");
		String months = getElementTextContent(timeConstraints, "months");
		String days = getElementTextContent(timeConstraints, "days");
		bank.setTimeConstraint(months, days, years);
		return bank;
	}

	private static String getElementTextContent(Element element, String elementName) {
		NodeList nodeList = element.getElementsByTagName(elementName);
		return nodeList.item(0).getTextContent();
	}
}
