package com.kce.model;
public class Signup 	
{
	private String district;
	private String busnumber;
	
	public String getBusnumber() {
		return busnumber;
	}
	public void setBusnumber(String busnumber) {
		this.busnumber = busnumber;
	}
	public String getDistrict() 
	{
		return district;
	}
	public void setDistrict(String district)
	{
		this.district=district;
	}
	public Signup(String district,String busnumber)
	{
		this.district=district;
		this.busnumber=busnumber;
	}
	public Signup() 
	{
	}
}
