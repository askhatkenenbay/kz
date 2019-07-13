package kz.epam.xml_xsd_parsing.entity;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractBanksBuilder {
	private Set<Bank> banks;

	public AbstractBanksBuilder(){
		banks = new HashSet<Bank>();
	}

	public Set<Bank> getBanks(){
		return banks;
	}

	public abstract void buildSetBanks(String fileName);
}
