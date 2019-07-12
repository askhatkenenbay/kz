package kz.epam.xml_xsd_parsing;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;


import java.io.IOException;

public class Main {
	public static void main(String[] args){
		String accountId = "7854 4569 8521 1235 4444 4444 4444 4444";
		String regex = "([0-9]{4}\\s){3}[0-9]{4}";
		System.out.println(patternFinder.regexFinder(regex,accountId));


		String filename = "Bank.xml";
		DOMParser parser = new DOMParser();
		try{
			parser.setFeature("http://xml.org/sax/features/validation", true);
			parser.setFeature("http://apache.org/xml/features/validation/schema", true);
			parser.parse(filename);
		}catch (SAXNotRecognizedException e) {
			e.printStackTrace();
			System.out.print("идентификатор не распознан");
		} catch (SAXNotSupportedException e) {
			e.printStackTrace();
			System.out.print("неподдерживаемая операция");
		} catch (SAXException e) {
			e.printStackTrace();
			System.out.print("глобальная SAX ошибка ");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("ошибка I/O потока");
		}
		System.out.print("проверка " + filename + " завершена");
	}
}
