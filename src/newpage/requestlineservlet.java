package newpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class requestlineservlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("get method:"+request.getMethod()+"<br>");
		out.println("get requestURI:"+request.getRequestURI()+"<br>");
		out.println("get getQueryString:"+request.getQueryString()+"<br>");
		out.println("get getProtocol:"+request.getProtocol()+"<br>");
		out.println("get getContentType:"+request.getContentType()+"<br>");
		out.println("get getPathInfo:"+request.getPathInfo()+"<br>");
		out.println("get getPathTranslated:"+request.getPathTranslated()+"<br>");
		out.println("get getServletPath:"+request.getServletPath()+"<br>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
