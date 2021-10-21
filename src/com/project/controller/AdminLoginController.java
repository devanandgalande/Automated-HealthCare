package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Adminbean;
import com.project.bean.Disease_Bean;
import com.project.bean.Doc_Location_Bean;
import com.project.dao.AdminDao;
import com.project.service.EmailDemo;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Boolean resultStatus=Boolean.FALSE; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out=response.getWriter();
		
		String adminemail=request.getParameter("adminemail");
		String adminpassword=request.getParameter("password");
		
		System.out.println("adminemail= "+adminemail);
		System.out.println("adminpassword= "+adminpassword);
		
		Adminbean bean=new Adminbean();
		
		bean.setEmail(adminemail);
		bean.setPassword(adminpassword);
		
		AdminDao dao=new AdminDao();
		
		ArrayList<Doc_Location_Bean> loc_list=new ArrayList<Doc_Location_Bean>();
		ArrayList<Disease_Bean> disease_list=new ArrayList<Disease_Bean>();
	
		if(resultStatus=dao.checkAdmin(bean))
		{
			loc_list=dao.get_Doctor_Details();
			disease_list=dao.get_Disease_Details();
			
				HttpSession session=request.getSession();  
		        session.setAttribute("adminemail",adminemail);
		        session.setAttribute("loc_list",loc_list);
		        session.setAttribute("disease_list",disease_list);
				out.println("<script type=\"text/javascript\">");
				//out.println("alert('Admin Login Success!!!');");
				out.println("location='admin_home.jsp';");
				out.println("</script>");
		}
		else
		{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Login Failed!!!');");
				out.println("location='admin_login.jsp';");
				out.println("</script>");
				//response.sendRedirect("userregister.jsp");
		}
			
	}

}
