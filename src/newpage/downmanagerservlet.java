package newpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class downmanagerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charser=utf-8");
		PrintWriter out=response.getWriter();
		String referer =request.getHeader("referer");
		String sitepath="http://"+request.getServerName();
		if(referer!=null&&referer.startsWith(sitepath))
			out.println("dealing dowmload");
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("/download.html");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
