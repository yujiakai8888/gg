package cn.java.jdbc;

import java.io.InputStream;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

import cn.java.utils.jdbcUtils;

public class Mysql {
	//INSERT INTO test1 SET a='C#从入门到放弃'
	
	static {
		//System.out.println("静态代码块");//构造方法之前优先被执行
	}
	public  Mysql()
	{
	//	super();//无参构造方法
	}
	
	@Test
	public boolean insert(String sql) throws Exception
	{
			//String sql ="INSERT INTO test1 (a)VALUES ('aaccaa')";
			int i=jdbcUtils.change(sql);
			if(i>=1)
				return true;
			else
				return false;
		
		
	}
	
	@Test
	public void delete(String sql) throws Exception
	{
		//String sql="DELETE  FROM test1 ";
		jdbcUtils.change(sql);
	}
	
	
	@Test
	public void update(String sql) throws Exception
	{
		
		//String sql="UPDATE test1  SET a=\"def\" ";
		jdbcUtils.change(sql);
		
	}
	@Test
	public boolean select(String sql ) throws Exception
	{
		
//		Properties pro=new Properties();
//		InputStream inputStream=jdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
//		//Common为类名
//		pro.load(inputStream);
//		String driver=pro.getProperty("driver");
//		String address=pro.getProperty("address");
//		String account=pro.getProperty("account");
//		String password=pro.getProperty("password");
//		
//		//String sql="SELECT * FROM test1";
//		
//		
//		   
//		Class.forName(driver);//加载驱动
		Connection conn=jdbcUtils.connection();
		//String sql ="SELECT * FROM test1";
		Statement st = conn.createStatement();
		
		
		
		ResultSet rs=st.executeQuery(sql);
		String a=" ";
		String b=" " ;
		
		while(rs.next())
		{
			 a=rs.getString("name");
			 b=rs.getString("password");
		System.out.println("name="+a);
		System.out.println("password="+b);
		}
		rs.close();
        st.close();
        conn.close();
		jdbcUtils.close(st, conn, rs);
	      
		if(a!=" "&&b!=" ")
			return true;
		else
			return false;
		
	}
	
	public String search(String name ) throws Exception
	{
		
		Connection conn=jdbcUtils.connection();
		Statement st = conn.createStatement();
		String sql="SELECT NAME,url FROM subjec";
		ResultSet rs=st.executeQuery(sql);
		String search_a;
		String search_url="0";
		while(rs.next())
		{
			search_a=rs.getString("name");
			if(name.equals(search_a))
			{
				System.out.printf("xiangdeng");
				search_url=rs.getString("url");
				break;
				
			}
		}
		return search_url;
	}
	public ResultSet display(String sql ) throws Exception
	{
		
		Connection conn=jdbcUtils.connection();
       	Statement st = conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
	      
	return  rs;
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args ) throws Exception
	{
		String name="zs";
		String password="abc";
		System.out.println("lll");
	Mysql a =new Mysql();
	//Boolean s=	a.select("SELECT NAME,PASSWORD FROM loginx WHERE NAME='贺思凯' AND PASSWORD='h1343661407'");
	//Boolean s= a.select("SELECT NAME,PASSWORD FROM loginx ");
	///System.out.println(s);
		a.insert("INSERT INTO loginx (name,password)VALUES ('贺思凯','yujia开')");
	//a.delete("DELETE  FROM test1 ");
	//	a.update("UPDATE test1  SET a=\"def\" ");
		
	}

	
}
