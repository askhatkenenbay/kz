package kz.epam.xml_xsd_parsing.entity;

import kz.epam.xml_xsd_parsing.action.BanksStAXBuilderAction;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import java.util.HashSet;
import java.util.Set;

public class BanksStAXBuilder extends AbstractBanksBuilder {
	private static Logger logger = Logger.getLogger(BanksStAXBuilder.class);
	private Set<Bank> banks;
	private XMLInputFactory inputFactory;

	public BanksStAXBuilder() {
		banks = new HashSet<>();
		inputFactory = XMLInputFactory.newInstance();
		logger.info("BanksStAXBuilder was created");
	}

	public Set<Bank> getBanks() {
		return banks;
	}

	@Override
	public void buildSetBanks(String fileName) {
		banks = BanksStAXBuilderAction.buildSetBanks(fileName, inputFactory);
	}
}
