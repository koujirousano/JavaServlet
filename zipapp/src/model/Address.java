package model;

import java.io.Serializable;

public class Address implements Serializable{
	private String Address1;
	private String Address2;
	private String Address3;
	public Address() {}
	public Address(String address1, String address2, String address3) {
		super();
		Address1 = address1;
		Address2 = address2;
		Address3 = address3;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getAddress3() {
		return Address3;
	}
	public void setAddress3(String address3) {
		Address3 = address3;
	}


}
