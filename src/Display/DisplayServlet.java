package Display;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.java.jdbc.Mysql;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		    PrintWriter out=response.getWriter();
	        Mysql s=new Mysql();
	        String sql="SELECT * FROM question_1";
	       
	        try {
				/*ResultSet rs=s.display(sql);
				String b=" " ;
				while(rs.next())
				{
					 b=rs.getString("question");
				out.println(b+"<br>");
				}*/
	        	ResultSet rs=s.display(sql);
				String[] b = new String [10];
				int i=0;
				while(rs.next())
				{
					 b[i++]=rs.getString("question");
				}
				for(int i1=0;i<b.length;i++)
				{
					out.println(b[i1]);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
