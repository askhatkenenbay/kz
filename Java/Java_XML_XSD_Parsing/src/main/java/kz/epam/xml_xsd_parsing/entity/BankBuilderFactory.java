package kz.epam.xml_xsd_parsing.entity;

import kz.epam.xml_xsd_parsing.action.BankBuilderFactoryAction;
import org.apache.log4j.Logger;

public class BankBuilderFactory {
	private static Logger logger = Logger.getLogger(BankBuilderFactory.class);

	private BankBuilderFactory() {
		logger.error(new IllegalStateException("Utility Class"));
		throw new IllegalStateException("Utility Class");
	}

	public static AbstractBanksBuilder createBankBuilder(String typeParser) {
		return BankBuilderFactoryAction.createBankBuilder(typeParser);
	}
}
