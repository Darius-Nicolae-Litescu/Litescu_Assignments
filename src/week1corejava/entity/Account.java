package week1corejava.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Account implements Serializable {

	private int accountNumber;
	private String accountHolderName;
	private int balance;
	private List<Policy> policies;
	private ContactDetails contactDetails;

	public Account() {
	}

	public Account(int accountNumber, String accountHolderName, int balance, List<Policy> policies, ContactDetails contactDetails) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.policies = policies;
		this.contactDetails = contactDetails;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Account account = (Account) o;

		if (accountNumber != account.accountNumber) return false;
		if (balance != account.balance) return false;
		if (!Objects.equals(accountHolderName, account.accountHolderName))
			return false;
		if (!Objects.equals(policies, account.policies)) return false;
		return Objects.equals(contactDetails, account.contactDetails);
	}

	@Override
	public int hashCode() {
		int result = accountNumber;
		result = 31 * result + (accountHolderName != null ? accountHolderName.hashCode() : 0);
		result = 31 * result + balance;
		result = 31 * result + (policies != null ? policies.hashCode() : 0);
		result = 31 * result + (contactDetails != null ? contactDetails.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountNumber=" + accountNumber +
				", accountHolderName='" + accountHolderName + '\'' +
				", balance=" + balance +
				", policies=" + policies +
				", contactDetails=" + contactDetails +
				"}\n";
	}
}
