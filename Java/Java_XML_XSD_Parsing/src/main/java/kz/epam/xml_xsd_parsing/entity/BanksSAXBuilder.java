package kz.epam.xml_xsd_parsing.entity;

import kz.epam.xml_xsd_parsing.entity.AbstractBanksBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class BanksSAXBuilder extends AbstractBanksBuilder {
	private Set<Bank> banks;
	private XMLReader reader;
	private BankHandler bh;

	public BanksSAXBuilder() {
		bh = new BankHandler();
		try {
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(bh);
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	public Set<Bank> getBanks(){
		return banks;
	}
	@Override
	public void buildSetBanks(String fileName) {
		try{
			reader.parse(fileName);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		banks = bh.getBanks();
	}

}
