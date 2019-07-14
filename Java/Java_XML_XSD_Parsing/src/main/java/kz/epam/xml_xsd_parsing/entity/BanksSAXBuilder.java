package kz.epam.xml_xsd_parsing.entity;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class BanksSAXBuilder extends AbstractBanksBuilder {
	private static Logger logger = Logger.getLogger(BanksSAXBuilder.class);
	private Set<Bank> banks;
	private XMLReader reader;
	private BankHandler bh;


	public BanksSAXBuilder() {
		bh = new BankHandler();
		try {
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(bh);
		} catch (SAXException e) {
			logger.error(new SAXException(e.getMessage()));
			e.printStackTrace();
		}
		logger.info("BankSAXBuilder was created");
	}

	@Override
	public Set<Bank> getBanks() {
		return banks;
	}

	@Override
	public void buildSetBanks(String fileName) {
		try {
			reader.parse(fileName);
		} catch (SAXException e) {
			logger.error(new SAXException(e.getMessage()));
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(new IOException(e.getMessage()));
			e.printStackTrace();
		}
		banks = bh.getBanks();
	}

}
