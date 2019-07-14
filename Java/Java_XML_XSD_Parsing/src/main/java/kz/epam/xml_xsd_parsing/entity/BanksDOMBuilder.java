package kz.epam.xml_xsd_parsing.entity;


import kz.epam.xml_xsd_parsing.action.BanksDOMBuilderAction;
import org.apache.log4j.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.HashSet;
import java.util.Set;

public class BanksDOMBuilder extends AbstractBanksBuilder {
	private static Logger logger = Logger.getLogger(BanksDOMBuilder.class);
	private DocumentBuilder documentBuilder;
	private Set<Bank> banks;

	public BanksDOMBuilder() {
		banks = new HashSet<>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			documentBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			logger.error(new ParserConfigurationException("Error in creating DocumentBuilder"));
			e.printStackTrace();
		}
		logger.info("BanksDOMBuilder was created");
	}

	@Override
	public Set<Bank> getBanks() {
		return banks;
	}

	@Override
	public void buildSetBanks(String fileName) {
		banks = BanksDOMBuilderAction.buildSetBanks(fileName, documentBuilder);
	}
}
