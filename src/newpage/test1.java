package newpage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public test1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/heml;charset=utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if("yujiakai".equals(username)&&"123".equals(password))
			response.sendRedirect("/chapter05/welcome.html");
		else
			response.sendRedirect("/chapter05/login.html");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
