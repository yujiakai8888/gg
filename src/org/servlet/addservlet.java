package org.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.loginmysql;
import org.entity.loginpeople;

/**
 * Servlet implementation class addservlet
 */
public class addservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				response.setContentType("text/html;charset=utf-8");          
		        /* ������Ӧͷ����ajax������� */  
		        response.setHeader("Access-Control-Allow-Origin", "*");  
		        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
		        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
		        request.setCharacterEncoding("utf-8");
		        //��ȡ΢��С����get�Ĳ���ֵ����ӡ
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");
		        loginpeople people=new loginpeople(username,password);//ʵ�����˶���
		        loginmysql  login=new loginmysql();
		        //ע���˺�����
		        Writer out = response.getWriter(); 
		        if(username.length()!=11)
				{
					System.out.println("���Ȳ���");
					out.write("0");
				}
				for(int i=0;i<username.length();i++)
				{
					if (username.charAt(i)>='0'&&username.charAt(i)<='9') {
						
						continue;
					}
					else
					{
						System.out.println("�з�����");
						out.write("1");
					}
						
				}
				//
		        try {
					boolean  b=login.returnaddlogindata(people);
					if (b==true)
						{
						
						 System.out.println("ע��ɹ�");
					        out.write("1");
					        out.flush();  
						
						}
					else
					{
						
						 System.out.println("ע��ʧ��");
					        out.write("0");
					        out.flush();  
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
