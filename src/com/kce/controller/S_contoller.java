package com.kce.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kce.dao.S_interface;
import com.kce.model.Addinformation;
import com.kce.model.Addinformationplaces;
import com.kce.model.Adminlogin;
import com.kce.model.Signup;
import com.kce.model.Success;
@Controller
public class S_contoller 
{
	@Autowired
    S_interface d;
	@Autowired
	HttpServletRequest request;
	List<String> flist=new ArrayList<String>();
	@RequestMapping("/")
	public String do1(Model model)
	{
		List<String> list=new ArrayList<String>();
		List<String> unlist=new ArrayList<String>();
		list=d.findallbusno();
		System.out.println(list);
		List<String> ulist = list.stream().distinct().collect(Collectors.toList());
		for(String i:ulist)
		{
			unlist.add(i.trim());
		}
		flist=unlist.stream().distinct().collect(Collectors.toList());
		System.out.println(flist);
		model.addAttribute("flist",flist);
		return "signup";
	}
	String bn;
	String fp;
	String lp;
	List<String> place=new ArrayList<String>();
	@RequestMapping("/signup")
	public String add_detail(@ModelAttribute("signup") Signup ob,Model model) 
	{
		String dis=ob.getDistrict();
		bn=ob.getBusnumber();
		//System.out.println(bn);
		place=d.findplace(bn);
		//System.out.println("the places are"+place);
		fp=place.get(0);
		lp=place.get(place.size()-1);
		//System.out.println(place.get(place.size()-1));
		System.out.println(dis);
		model.addAttribute("place",place);
		model.addAttribute("flist",flist);
		if(dis.equals("COIMBATORE"))
		{
			return "success";
		}
		else
		{
			return "signup";
		}
	}
	@RequestMapping("/admlog")
	public String admindet(@ModelAttribute("admlog") Signup ob,Model model)
	{
		return "adminlogin";
	}
	
	@RequestMapping("/success")
	public String add_detail1(@ModelAttribute("success") Success obj,Model model) 
	{
		System.out.println("bn is"+bn);
		String start=obj.getStart();
		String end=obj.getEnd();
		model.addAttribute("place",place);
		System.out.println("end place is"+end+""+start);
		if(start.equals(end))
		{
			return "success";
		}
		int key=d.findDistance(start,end,bn);
		System.out.println("key is"+key);
		int id=d.findDistance1(start,end,bn);//we will not use modulo
		System.out.println("without using modulo"+id);
		int pmoney,gmoney,amoney;
		System.out.println("the key is"+key);
		System.out.println("the id is"+id);
		if(key<=6)
		{
		 pmoney=6;
		 gmoney=7;
		 amoney=8;
		}
		else if(key>=7 && key<=12)
		{
			pmoney=10;
			 gmoney=11;
			 amoney=12;
		}
		else if(key>=13 && key<=18)
		{
			pmoney=14;
			 gmoney=15;
			 amoney=16;
		}
		else if(key>=19 && key<=24)
		{
			pmoney=18;
			 gmoney=19;
			 amoney=20;
		}
		else if(key>=25 && key<=30)
		{
			pmoney=22;
			 gmoney=23;
			 amoney=24;
		}
		else
		{
			pmoney=26;
			 gmoney=27;
			 amoney=28;
		}
		model.addAttribute("pmoney",pmoney);
		model.addAttribute("gmoney",gmoney);
		model.addAttribute("amoney",amoney);
		if(id<0)
		{
		int k=d.findDistance(fp, start,bn);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("h:mma");
		LocalDateTime now=LocalDateTime.now();
		String date=dtf.format(now);
		System.out.println(date);
		String pvt=d.findpvt(date,key,k,fp,bn);
		String abt=d.findabt(date,key,k,fp,bn);
		String gbt=d.findgbt(date,key,k,fp,bn);
		model.addAttribute("pvt",pvt);
		model.addAttribute("abt",abt);
		model.addAttribute("gbt",gbt);
		}
		else
		{
			int k = d.findDistance(lp,start,bn);
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("h:mma");
			LocalDateTime now=LocalDateTime.now();
			String date=dtf.format(now);
			System.out.println(date);
			String pvt=d.findpvt1(date,key,k,lp,bn);
			String abt=d.findabt1(date,key,k,lp,bn);
			String gbt=d.findgbt1(date,key,k,lp,bn);
			model.addAttribute("pvt",pvt);
			model.addAttribute("abt",abt);
			model.addAttribute("gbt",gbt);
		}
		return "buscost";
}
	@RequestMapping("/adminlogin")
	public String adddetail(@ModelAttribute("adminlogin") Adminlogin o,Model model) 
	{
		int a=o.checkPwd();	  
		if(a==1)
		{
			return "addinformation";
		}
		else
		{
			return "adminlogin";
		}
	}
	String str;
	@RequestMapping("/addinformation")
	public String addinfo(@ModelAttribute("addinformation") Addinformation o,Model model)
	{
		d.db(o.getPlace(),o.getBusno(),o.getDistance(),o.getPvtbustime(),o.getAirbustime(),o.getGovtbustime());
		return "addinformationplaces";
	}
	@RequestMapping("/addinformationplaces")
	public String addinfoplace(@ModelAttribute("addinformationplaces") Addinformationplaces o,Model model)
	{
		d.dbplaces(o.getPlace(),o.getDistance(),o.getBusno());
		String lastbus=request.getParameter("last");
		if(lastbus.equals("yes"))
		{
		return "addinformation";
		}
		else
		{
			return "addinformationplaces";
		}
	}
	}
