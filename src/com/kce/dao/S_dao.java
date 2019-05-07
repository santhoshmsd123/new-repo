package com.kce.dao;
import java.util.List;
import java.util.Scanner;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kce.model.Addinformation;
import com.kce.model.Addinformationplaces;
@Repository
public class S_dao implements S_interface {
	@Autowired
	SessionFactory sf;
	@Transactional
	public int findDistance(String start,String end,String bn)
	{
		Session s=sf.getCurrentSession();
		List<Integer> o1=s.createQuery("select d.distance from Db d where d.place="+"'"+start+"'"+"and d.busno="+"'"+bn+"'").list();
		List<Integer> o2=s.createQuery("select d.distance from Db d where d.place="+"'"+end+"'"+"and d.busno="+"'"+bn+"'").list();
		//Db o2=s.get(Db.class,end);
		int[] ret=new int[o1.size()];
		int i=0;
		for(Integer e:o1)
			ret[i++]=e;
		System.out.println("lkg is"+ret[0]);
		int[] ret1=new int[o2.size()];
		int j=0;
		for(Integer f:o2)
			ret1[j++]=f;
		System.out.println(Math.abs(ret[0]-ret1[0]));
		int k=Math.abs(ret[0]-ret1[0]);
		return k;
	}
	@Autowired
	SessionFactory sf3;
	@Transactional
	public int findDistance1(String start,String end,String bn)
	{
		Session s=sf3.getCurrentSession();
		List<Integer> o1=s.createQuery("select d.distance from Db d where d.place="+"'"+start+"'"+"and d.busno="+"'"+bn+"'").list();
		List<Integer> o2=s.createQuery("select d.distance from Db d where d.place="+"'"+end+"'"+"and d.busno="+"'"+bn+"'").list();
		//Db o2=s.get(Db.class,end);
			int[] ret=new int[o1.size()];
			int i=0;
			for(Integer e:o1)
				ret[i++]=e;
			System.out.println(ret[0]);
		    int[] ret1=new int[o2.size()];
			int j=0;
			for(Integer f:o2)
				ret1[j++]=f;
		//System.out.println(Math.abs(ret[0]-ret1[0]));
		int k=ret[0]-ret1[0];
		return k;
	}
	@Autowired
	SessionFactory sf1;
	@Transactional
	public String findpvt(String date,int key,int k,String fp,String bn)
	{
		Session s1=sf1.getCurrentSession();
		String a="no bus";
		System.out.println("hello guyzzz");
		List<String> o=s1.createQuery("select d.pvtbustime from Db d where d.place="+"'"+fp+"'"+"and d.busno="+"'"+bn+"'").list();
		//List<String> place=s1.createQuery("select d.place from Db d where d.busno="+"'"+33+"'").list();
		//System.out.println(place);
		String o1=o.get(0).toString();
		System.out.println("o1 is"+o1);
		String[] o2=o1.split(",");
		for(int j=0;j<o2.length;j++)
		{
			System.out.println(o2[j]);
		}
		Scanner sc = new Scanner(date);
		System.out.println("sc is"+date);
		int hr=Integer.parseInt(sc.findInLine("[0-9]+"));
		int min=Integer.parseInt(sc.findInLine("[0-9]+"));	
		char t = sc.next().charAt(0);
		if(t=='P' && hr!=12) hr+=12;
		int time = hr*60 + min;
		System.out.println("date plus time is"+time);
		for(String str:o2) {
			sc = new Scanner(str);
			int hr1=Integer.parseInt(sc.findInLine("[0-9]+"));
			int min1=Integer.parseInt(sc.findInLine("[0-9]+"));	
			char t1 = sc.next().charAt(0);
			if(t1=='P' && hr1!=12) hr1+=12;
			int time1=hr1*60+min1+k*2;
			//System.out.println(time1);
			if(time1>time) {
				char temp='A';
				if(time1/60==12) temp = 'P';
				else if(time1/60>12) {
					temp = 'P';
					time1-=12*60;
				}
				System.out.println("testing"+(time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M");
				a=((time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M");
				System.out.println(a);
				break;
			}
		}
		//String a="san";
		return a;
	}
	@Autowired
	SessionFactory sf2;
	@Transactional
	public String findpvt1(String date,int key,int k,String lp,String bn)
	{
		Session s1=sf2.getCurrentSession();
		String a="no bus";
		System.out.println("haiiiiiiiiiiiiiiiii");
		//List<String> o=s1.createQuery("select d.pvtbustime from Db d where d.id="+"'"+17+"'").list();
		List<String> o=s1.createQuery("select d.pvtbustime from Db d where d.place="+"'"+lp+"'"+"and d.busno="+"'"+bn+"'").list();
		String o1=o.get(0);
		String[] o2=o1.split(",");
		Scanner sc = new Scanner(date);
		int hr=Integer.parseInt(sc.findInLine("[0-9]+"));
		int min=Integer.parseInt(sc.findInLine("[0-9]+"));	
		char t=sc.next().charAt(0);
		if(t=='P' && hr!=12) hr+=12;
		int time = hr*60+min;
		//System.out.println(date+time);
		for(String str:o2) {
			sc=new Scanner(str);
			int hr1=Integer.parseInt(sc.findInLine("[0-9]+"));
			int min1=Integer.parseInt(sc.findInLine("[0-9]+"));	
			char t1 = sc.next().charAt(0);
			if(t1=='P' && hr1!=12) hr1+=12;
			int time1 = hr1*60 + min1 + k*2;
			//System.out.println(time1);
			if(time1>time) {
				char temp = 'A';
				if(time1/60==12) temp = 'P';
				else if(time1/60>12) {
					temp = 'P';
					time1-=12*60;
				}
				System.out.println((time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M");
				a=(time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M";
				break;
			}
		}
		return a;
	}
	@Autowired
	SessionFactory sf4;
	@Transactional
	public String findabt(String date,int key,int k,String fp,String bn)
	{
		Session s1=sf4.getCurrentSession();
		String a="no bus";
		System.out.println("haiiiiiiiiiiiiiiiii abt1");
		List<String> o=s1.createQuery("select d.airbustime from Db d where d.place="+"'"+fp+"'"+"and d.busno="+"'"+bn+"'").list();
		String o1=o.get(0);
		String[] o2=o1.split(",");
		Scanner sc = new Scanner(date);
		int hr=Integer.parseInt(sc.findInLine("[0-9]+"));
		int min=Integer.parseInt(sc.findInLine("[0-9]+"));	
		char t = sc.next().charAt(0);
		if(t=='P' && hr!=12) hr+=12;
		int time = hr*60 + min;
		//System.out.println(date+time);
		for(String str : o2) {
			sc=new Scanner(str);
			int hr1=Integer.parseInt(sc.findInLine("[0-9]+"));
			int min1=Integer.parseInt(sc.findInLine("[0-9]+"));	
			char t1 = sc.next().charAt(0);
			if(t1=='P' && hr1!=12) hr1+=12;
			int time1 = hr1*60 + min1 + k*2;
			//System.out.println(time1);
			if(time1>time) {
				char temp = 'A';
				if(time1/60==12) temp = 'P';
				else if(time1/60>12) {
					temp = 'P';
					time1-=12*60;
				}
				System.out.println((time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M");
				a=(time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M";
				break;
			}
		}
		return a;
		}
	@Autowired
	SessionFactory sf5;
	@Transactional
	public String findabt1(String date,int key,int k,String lp,String bn)
	{
		Session s1=sf5.getCurrentSession();
		String a="no bus";
		System.out.println("haiiiiiiiiiiiiiiiii abt2");
		//List<String> o=s1.createQuery("select d.airbustime from Db d where d.id="+"'"+17+"'").list();
		List<String> o=s1.createQuery("select d.airbustime from Db d where d.place="+"'"+lp+"'"+"and d.busno="+"'"+bn+"'").list();
		String o1=o.get(0);
		String[] o2=o1.split(",");
		Scanner sc = new Scanner(date);
		int hr=Integer.parseInt(sc.findInLine("[0-9]+"));
		int min=Integer.parseInt(sc.findInLine("[0-9]+"));	
		char t = sc.next().charAt(0);
		if(t=='P' && hr!=12) hr+=12;
		int time = hr*60 + min;
		//System.out.println(date+time);
		for(String str : o2) {
			sc=new Scanner(str);
			int hr1=Integer.parseInt(sc.findInLine("[0-9]+"));
			int min1=Integer.parseInt(sc.findInLine("[0-9]+"));	
			char t1 = sc.next().charAt(0);
			if(t1=='P' && hr1!=12) hr1+=12;
			int time1 = hr1*60 + min1 + k*2;
			//System.out.println(time1);
			if(time1>time) {
				char temp = 'A';
				if(time1/60==12) temp = 'P';
				else if(time1/60>12) {
					temp = 'P';
					time1-=12*60;
				}
				System.out.println((time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M");
				a=(time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M";
				break;
			}
		}
		return a;
		}
	@Autowired
	SessionFactory sf6;
	@Transactional
	public String findgbt(String date,int key,int k,String fp,String bn)
	{
		Session s1=sf6.getCurrentSession();
		String a="no bus";
		System.out.println("haiiiiiiiiiiiiiiiii gbt");
		//List<String> o=s1.createQuery("select d.govtbustime from Db d where d.id="+"'"+1+"'").list();
		List<String> o=s1.createQuery("select d.govtbustime from Db d where d.place="+"'"+fp+"'"+"and d.busno="+"'"+bn+"'").list();
		String o1=o.get(0);
		String[] o2=o1.split(",");
		Scanner sc = new Scanner(date);
		int hr=Integer.parseInt(sc.findInLine("[0-9]+"));
		int min=Integer.parseInt(sc.findInLine("[0-9]+"));	
		char t = sc.next().charAt(0);
		if(t=='P' && hr!=12) hr+=12;
		int time = hr*60 + min;
		//System.out.println(date+time);
		for(String str : o2) {
			sc=new Scanner(str);
			int hr1=Integer.parseInt(sc.findInLine("[0-9]+"));
			int min1=Integer.parseInt(sc.findInLine("[0-9]+"));	
			char t1 = sc.next().charAt(0);
			if(t1=='P' && hr1!=12) hr1+=12;
			int time1 = hr1*60 + min1 + k*2;
			//System.out.println(time1);
			if(time1>time) {
				char temp = 'A';
				if(time1/60==12) temp = 'P';
				else if(time1/60>12) {
					temp = 'P';
					time1-=12*60;
				}
				System.out.println((time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M");
				a=(time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M";
				break;
			}
		}
		return a;
		}
	@Autowired
	SessionFactory sf7;
	@Transactional
	public String findgbt1(String date,int key,int k,String lp,String bn)
	{
		Session s1=sf7.getCurrentSession();
		String a="no bus";
		//System.out.println("haiiiiiiiiiiiiiiiii gbt2");
		//List<String> o=s1.createQuery("select d.govtbustime from Db d where d.id="+"'"+17+"'").list();
		List<String> o=s1.createQuery("select d.govtbustime from Db d where d.place="+"'"+lp+"'"+"and d.busno="+"'"+bn+"'").list();
		String o1=o.get(0);
		String[] o2=o1.split(",");
		Scanner sc = new Scanner(date);
		int hr=Integer.parseInt(sc.findInLine("[0-9]+"));
		int min=Integer.parseInt(sc.findInLine("[0-9]+"));	
		char t = sc.next().charAt(0);
		if(t=='P' && hr!=12) hr+=12;
		int time = hr*60 + min;
		//System.out.println(date+time);
		for(String str : o2) {
			sc=new Scanner(str);
			int hr1=Integer.parseInt(sc.findInLine("[0-9]+"));
			int min1=Integer.parseInt(sc.findInLine("[0-9]+"));	
			char t1 = sc.next().charAt(0);
			if(t1=='P' && hr1!=12) hr1+=12;
			int time1 = hr1*60 + min1 + k*2;
			//System.out.println(time1);
			if(time1>time) {
				char temp = 'A';
				if(time1/60==12) temp = 'P';
				else if(time1/60>12) {
					temp = 'P';
					time1-=12*60;
				}
				System.out.println((time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M");
				a=(time1/60)+":"+((time1%60<10)?"0":"")+(time1%60)+""+temp+"M";
				break;
			}
		}
		return a;
		
	}
	@Transactional
	public void db(String place, String busno, int distance, String pvtbustime, String airbustime, String govtbustime)
	{
		Session s1=sf6.getCurrentSession();
		Addinformation temp=new Addinformation(place,busno,distance,pvtbustime,airbustime,govtbustime);
		s1.save(temp);
		
		
}
	@Transactional
	public void dbplaces(String place,int distance,String busno)
	{
		Session s1=sf6.getCurrentSession();
		Addinformationplaces temp=new Addinformationplaces(place,distance,busno);
		s1.save(temp);
	}
	@Transactional
	public List<String> findallbusno()
	{
		Session s=sf.getCurrentSession();
		List<String> o1=s.createQuery("select d.busno from Db d").list();
		return o1;
	}
	@Transactional
	 public List<String> findplace(String bn)
	{
		Session s=sf.getCurrentSession();
		List<String> o1=s.createQuery("select d.place from Db d where busno="+"'"+bn+"'"+"order by d.id").list();
		return o1;
		}}