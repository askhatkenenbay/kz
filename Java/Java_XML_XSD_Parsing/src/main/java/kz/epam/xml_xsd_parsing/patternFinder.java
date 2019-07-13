package kz.epam.xml_xsd_parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.regex.Pattern;

public class patternFinder {
	public static List<String> regexFinder(String theRegex, String str2Check) {
		List<String> result = new ArrayList<>();
		Pattern checkRegex = Pattern.compile(theRegex, Pattern.DOTALL);
		Matcher regexMatcher = checkRegex.matcher(str2Check);
		while (regexMatcher.find()) {
			result.add(regexMatcher.group());
		}
		return result;
	}

	public static void DOMParser(String xmlFileName) {
//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

//Build Document
		Document document = null;
		try {
			document = builder.parse(new File(xmlFileName));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();

//Here comes the root node
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());

	}
}
