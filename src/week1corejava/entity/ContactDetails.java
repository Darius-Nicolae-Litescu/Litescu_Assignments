package week1corejava.entity;

import java.io.Serializable;
import java.util.Objects;

public class ContactDetails implements Serializable {

	private String address;
	private String state;
	private long phoneNumber;
	private String email;

	public ContactDetails() {
	}

	public ContactDetails(String address, String state, long phoneNumber, String email) {
		this.address = address;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ContactDetails that = (ContactDetails) o;

		if (phoneNumber != that.phoneNumber) return false;
		if (!Objects.equals(address, that.address)) return false;
		if (!Objects.equals(state, that.state)) return false;
		return Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {
		int result = address != null ? address.hashCode() : 0;
		result = 31 * result + (state != null ? state.hashCode() : 0);
		result = 31 * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ContactDetails{" +
				"address='" + address + '\'' +
				", state='" + state + '\'' +
				", phoneNumber=" + phoneNumber +
				", email='" + email + '\'' +
				'}';
	}
}
