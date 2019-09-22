package org.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.dao.loginmysql;
import org.entity.loginpeople;

/**
 * Servlet implementation class loginservlet
 */
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
        request.setCharacterEncoding("utf-8");
        //获取微信小程序get的参数值并打印
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //String username ="hsk";
       // String password ="123";
      //  System.out.println("username="+username+" ,password="+password);
        
        loginpeople people=new loginpeople(username,password);//实例化人对象
       // System.out.println("username="+username+" ,password="+password);
        
        loginmysql sql=new loginmysql();
      // System.out.println("username="+username+" ,password="+password);
        try {
			boolean b=sql.returloginndata(people);
			//System.out.println("username="+username+" ,password="+password);
			
			if(b==true)
			{ //返回值给微信小程序
				 Writer out = response.getWriter(); 
				 System.out.println("正确");
			        out.write("1");
			        out.flush();   
			}
			else
			{ //返回值给微信小程序
				 Writer out = response.getWriter(); 
				 System.out.println("错误");
			        out.write("0");
			        out.flush();   
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // System.out.println("jieshu");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
