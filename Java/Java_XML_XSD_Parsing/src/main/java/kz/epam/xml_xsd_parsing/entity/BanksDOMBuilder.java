package kz.epam.xml_xsd_parsing.entity;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BanksDOMBuilder extends AbstractBanksBuilder {
	private DocumentBuilder documentBuilder;
	private Set<Bank> banks;

	public BanksDOMBuilder(){
		banks = new HashSet<>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			documentBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	public Set<Bank> getBanks(){
		return banks;
	}

	@Override
	public void buildSetBanks(String fileName) {
		Document document = null;
		try{
			document = documentBuilder.parse(fileName);
			Element root = document.getDocumentElement();
			NodeList bankList = root.getElementsByTagName("bank");
			for (int i = 0; i < bankList.getLength(); i++) {
				Element bankElement = (Element) bankList.item(i);
				Bank bank = buildBank(bankElement);
				banks.add(bank);
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private Bank buildBank(Element bankElement){
		Bank bank = new Bank();
		bank.setAccountId(bankElement.getAttribute("account-id"));
		bank.setName(bankElement.getAttribute("name"));
		bank.setCountry(bankElement.getAttribute("country"));
		if(bankElement.getAttribute("depositor") != null){
			bank.setDepositor(bankElement.getAttribute("depositor"));
		}
		bank.setType(bankElement.getAttribute("type"));
		bank.setAmountOnDeposit(Integer.parseInt(getElementTextContent(bankElement, "amount-on-deposit")));
		bank.setProfitability(Double.parseDouble(getElementTextContent(bankElement, "profitability")));
		Element timeConstraints = (Element) bankElement.getElementsByTagName("time-constraints").item(0);
		String years = getElementTextContent(timeConstraints, "years");
		String months = getElementTextContent(timeConstraints, "months");
		String days = getElementTextContent(timeConstraints, "days");
		bank.setTimeConstraint(months,days,years);
		return bank;
	}
	private static String getElementTextContent(Element element, String elementName){
		NodeList nodeList = element.getElementsByTagName(elementName);
		return nodeList.item(0).getTextContent();
	}
}
