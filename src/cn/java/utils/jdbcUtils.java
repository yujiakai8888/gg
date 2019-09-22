package cn.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.StreamingNotifiable;
import com.mysql.jdbc.util.PropertiesDocGenerator;

public class jdbcUtils {
	/**
	 * Description jdbc�Ĺ�������</br>
	 * @param sql:��Ҫ�����sql���
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */

	private static String driver=null;
	private static String address=null;
	private static String account=null;
	private static String password=null;
	static {
		try
		{
			Properties pro=new Properties();
			InputStream inputStream=jdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//CommonΪ����
			pro.load(inputStream);
			driver=pro.getProperty("driver");
			address=pro.getProperty("address");
			account=pro.getProperty("account");
			password=pro.getProperty("password");
			//System.out.println(driver+"\t"+address+"\t"+account+"\t"+password);
			Class.forName(driver);//��������
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void close(Statement st,Connection conn,ResultSet rs) throws Exception
	{
		if (rs!=null)
		rs.close();
		if (st!=null)
        st.close();
		if (conn!=null)
        conn.close();
	}
	public static Connection connection() throws Exception
	{
		return DriverManager.getConnection(address, account, password);
	}
	
	public static int change(String sql) throws Exception
	{
		
		Connection conn=connection();
		Statement st = conn.createStatement();
	        int result = st.executeUpdate(sql);
	        jdbcUtils.close(st, conn, null);;
	        if (result>=1)
	        	return 1;
	        else
	        	return 0;
		
	
	     
		
		
	}
	
	
	
}
