package codered.rokomari.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignUpBean {

	@NotNull
	@Size(min=4,max=40)
	private String firstName;
	@NotNull
	@Size(min=4,max=20)
	private String lastName;
	@NotNull
	private String email;
	@NotNull
	@Size(min=4,max=20)
	private String address;
	@NotNull
	private String contactNo;
	@NotNull
	@Size(min=2,max=40)
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignUpBean [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", address=" + address + ", contactNo="
				+ contactNo + ", password=" + password + "]";
	}
	
	

}
