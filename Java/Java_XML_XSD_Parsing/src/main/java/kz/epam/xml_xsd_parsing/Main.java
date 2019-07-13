package kz.epam.xml_xsd_parsing;


import kz.epam.xml_xsd_parsing.entity.AbstractBanksBuilder;
import kz.epam.xml_xsd_parsing.entity.Bank;
import kz.epam.xml_xsd_parsing.entity.BankBuilderFactory;
import kz.epam.xml_xsd_parsing.entity.BanksSAXBuilder;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.util.Iterator;

public class Main {
	public static void main(String[] args){
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		String fileName = "Bank.xml";
		String schemaName = "Bank.xsd";
		SchemaFactory factory = SchemaFactory.newInstance(language);
		File schemaLocation = new File(schemaName);
		try{
			Schema schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			Source source = new StreamSource(fileName);
			validator.validate(source);
			System.out.println(fileName + " is valid");
		}catch(Exception e){
			e.printStackTrace();
		}

		String type = "StAX";
		AbstractBanksBuilder builder = BankBuilderFactory.createBankBuilder(type);
		builder.buildSetBanks("Bank.xml");
		Iterator<Bank> iterator = builder.getBanks().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}
}
