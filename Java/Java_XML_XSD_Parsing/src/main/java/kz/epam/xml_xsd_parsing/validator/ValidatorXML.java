package kz.epam.xml_xsd_parsing.validator;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ValidatorXML {
	private static final String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
	public static boolean validateXML(String xmlFileName, String xsdFileName){
		SchemaFactory factory = SchemaFactory.newInstance(language);
		File schemaLocation = new File(xsdFileName);
		try{
			Schema schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			Source source = new StreamSource(xmlFileName);
			validator.validate(source);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
