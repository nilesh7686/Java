package com.example.mapping.projections;

public class DetailsProjection {
	
	String companyName ;
	String mobileNo;
	String firstName;
	public DetailsProjection(String companyName, String mobileNo, String firstName) {
		super();
		this.companyName = companyName;
		this.mobileNo = mobileNo;
		this.firstName = firstName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	

}
