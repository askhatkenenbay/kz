package kz.epam.xml_xsd_parsing.entity;

import org.apache.log4j.Logger;

public class BankBuilderFactory {
	private static Logger logger = Logger.getLogger(BankBuilderFactory.class);

	private enum TypeParser {
		SAX, STAX, DOM
	}

	private BankBuilderFactory() {
		logger.error(new IllegalStateException("Utility Class"));
		throw new IllegalStateException("Utility Class");
	}

	public static AbstractBanksBuilder createBankBuilder(String typeParser) {
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
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
