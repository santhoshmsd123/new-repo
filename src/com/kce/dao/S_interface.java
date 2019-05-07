package com.kce.dao;

import java.util.List;

public interface S_interface {
	public int findDistance(String start,String end,String bn);
	public int findDistance1(String start,String end,String bn);
	public String findpvt(String date,int key,int k,String fp,String bn);
	public String findpvt1(String date,int key,int k,String lp,String bn);
	public String findabt(String date,int key,int k,String fp,String bn);
	public String findabt1(String date,int key,int k,String lp,String bn);
	public String findgbt(String date,int key,int k,String fp,String bn);
	public String findgbt1(String date,int key,int k,String lp,String bn);
	public void db(String place, String busno, int distance, String pbt, String abt, String gbt);
	public void dbplaces(String place,int distance,String busno);
    public List<String> findallbusno(); 
    public List<String> findplace(String bn);
}
