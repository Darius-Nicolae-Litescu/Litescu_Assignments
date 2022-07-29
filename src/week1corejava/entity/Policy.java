package week1corejava.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Policy implements Serializable {

	private int policyNumber;
	private String policyName;
	private int premiumAmount;
	private int sumAssuredAmount;
	private LocalDate premiumDate;

	public Policy() {
	}

	public Policy(int policyNumber, String policyName, int premiumAmount, int sumAssuredAmount, LocalDate premiumDate) {
		this.policyNumber = policyNumber;
		this.policyName = policyName;
		this.premiumAmount = premiumAmount;
		this.sumAssuredAmount = sumAssuredAmount;
		this.premiumDate = premiumDate;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public int getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(int premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public int getSumAssuredAmount() {
		return sumAssuredAmount;
	}

	public void setSumAssuredAmount(int sumAssuredAmount) {
		this.sumAssuredAmount = sumAssuredAmount;
	}

	public LocalDate getPremiumDate() {
		return premiumDate;
	}

	public void setPremiumDate(LocalDate premiumDate) {
		this.premiumDate = premiumDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Policy policy = (Policy) o;

		if (policyNumber != policy.policyNumber) return false;
		if (premiumAmount != policy.premiumAmount) return false;
		if (sumAssuredAmount != policy.sumAssuredAmount) return false;
		if (!Objects.equals(policyName, policy.policyName)) return false;
		return Objects.equals(premiumDate, policy.premiumDate);
	}

	@Override
	public int hashCode() {
		int result = policyNumber;
		result = 31 * result + (policyName != null ? policyName.hashCode() : 0);
		result = 31 * result + premiumAmount;
		result = 31 * result + sumAssuredAmount;
		result = 31 * result + (premiumDate != null ? premiumDate.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Policy{" +
				"policyNumber=" + policyNumber +
				", policyName='" + policyName + '\'' +
				", premiumAmount=" + premiumAmount +
				", sumAssuredAmount=" + sumAssuredAmount +
				", premiumDate=" + premiumDate +
				'}';
	}
}
