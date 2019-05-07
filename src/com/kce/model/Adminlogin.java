package com.kce.model;
public class Adminlogin {
	private String uname;
	private String psw;
	public  String getUname() {
		return uname;
	}
	public int checkPwd()
	{
		if((psw.equals("admin"))&&(uname.equals("admin")))
		{
			return 1;
		}
		return 0;
	}
	public void setUname(String uname) {
		this.uname = uname;
			}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public Adminlogin(String uname,String psw)
	{
		this.uname=uname;
		this.psw=psw;
	}
	public Adminlogin()
	{
		
	}
}
