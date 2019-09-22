package org.dao;


import org.apache.jasper.tagplugins.jstl.core.Out;
import org.entity.loginpeople;

import cn.java.jdbc.Mysql;

public class loginmysql {
	
	
	
	public boolean returnaddlogindata(loginpeople l) throws Exception
	{
		Mysql  a=new Mysql();
		boolean s=a.insert("INSERT INTO loginx (NAME,PASSWORD) VALUES('"+l.getUsername()+"','"+l.getPassword()+"')");
		return s;
	}
	public boolean returloginndata(loginpeople l) throws Exception
	{
		Mysql a=new Mysql();
		System.out.println("����");
		boolean s=a.select("SELECT NAME,PASSWORD FROM loginx WHERE NAME='"+l.getUsername()+"' AND PASSWORD='"+l.getPassword()+"'");
		System.out.println("s="+s);
		return s;
 	}
	
}
