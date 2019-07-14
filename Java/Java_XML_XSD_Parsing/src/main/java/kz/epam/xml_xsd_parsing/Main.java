package kz.epam.xml_xsd_parsing;


import kz.epam.xml_xsd_parsing.entity.AbstractBanksBuilder;
import kz.epam.xml_xsd_parsing.entity.Bank;
import kz.epam.xml_xsd_parsing.entity.BankBuilderFactory;
import kz.epam.xml_xsd_parsing.entity.BanksSAXBuilder;
import kz.epam.xml_xsd_parsing.validator.ValidatorXML;


import java.util.Iterator;

public class Main {
	public static void main(String[] args){
		if(ValidatorXML.validateXML("Bank.xml","Bank.xsd")){
			System.out.println("valid");
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
