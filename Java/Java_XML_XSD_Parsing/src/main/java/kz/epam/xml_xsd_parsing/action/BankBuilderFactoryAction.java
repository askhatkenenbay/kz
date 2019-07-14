package kz.epam.xml_xsd_parsing.action;

import kz.epam.xml_xsd_parsing.entity.*;
import org.apache.log4j.Logger;

public class BankBuilderFactoryAction {
	private static Logger logger = Logger.getLogger(BankBuilderFactoryAction.class);

	private enum TypeParser {
		SAX, STAX, DOM
	}

	public static AbstractBanksBuilder createBankBuilder(String typeParser) {
		BankBuilderFactoryAction.TypeParser type = BankBuilderFactoryAction.TypeParser.valueOf(typeParser.toUpperCase());
		switch (type) {
			case DOM:
				return new BanksDOMBuilder();
			case SAX:
				return new BanksSAXBuilder();
			case STAX:
				return new BanksStAXBuilder();
			default:
				logger.error(new EnumConstantNotPresentException(type.getDeclaringClass(), type.name()));
				throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
		}
	}
}
