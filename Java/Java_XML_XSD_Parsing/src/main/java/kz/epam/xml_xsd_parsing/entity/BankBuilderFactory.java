package kz.epam.xml_xsd_parsing.entity;

public class BankBuilderFactory {
	private enum TypeParser {
		SAX, STAX, DOM
	}

	private BankBuilderFactory() {
		throw new IllegalStateException("Utility Class");
	}

	public static AbstractBanksBuilder createBankBuilder(String typeParser) {
		if (typeParser.length() < 3 || typeParser.length() > 4 || typeParser == null) {
			return null;
		}
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		switch (type) {
			case DOM:
				return new BanksDOMBuilder();
			case SAX:
				return new BanksSAXBuilder();
			case STAX:
				return new BanksStAXBuilder();
			default:
				throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
		}
	}
}
