package kz.epam.xml_xsd_parsing.entity;

public class Bank {
	private String name;
	private String country;
	private String type;
	private String accountId;
	private String Depositor;
	private int amountOnDeposit;
	private double profitability;
	private String timeConstraint = ""; // format --> day/month/year

	public Bank() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setDepositor(String depositor) {
		Depositor = depositor;
	}

	public void setAmountOnDeposit(int amountOnDeposit) {
		this.amountOnDeposit = amountOnDeposit;
	}

	public void setProfitability(double profitability) {
		this.profitability = profitability;
	}

	public void setTimeConstraint(String month, String day, String year) {
		this.timeConstraint = day + "/" + month + "/" + year;
	}

	public void setTimeConstraint(String str) {
			this.timeConstraint += str;
	}

	@Override
	public String toString() {
		return "Bank{" +
				"name='" + name + '\'' +
				", country='" + country + '\'' +
				", type='" + type + '\'' +
				", accountId='" + accountId + '\'' +
				", Depositor='" + Depositor + '\'' +
				", amountOnDeposit=" + amountOnDeposit +
				", profitability=" + profitability +
				", timeConstraint='" + timeConstraint + '\'' +
				'}';
	}
}
