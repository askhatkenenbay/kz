package kz.epam.xml_xsd_parsing.entity;

public enum BankEnum {
	BANKS("banks"),
	BANK("bank"),
	NAME("name"),
	COUNTRY("country"),
	DEPOSITOR("depositor"),
	ACCOUNT_ID("account-id"),
	TYPE("type"),
	TIME_CONSTRAINTS("time-constraints"),
	AMOUNT_ON_DEPOSIT("amount-on-deposit"),
	PROFITABILITY("profitability"),
	YEARS("years"),
	MONTHS("months"),
	DAYS("days");
	private String value;

	private BankEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
