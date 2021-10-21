package com.project.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.project.bean.Patient_Bean;
import com.project.dao.AdminDao;
import com.project.service.EmailDemo;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Patient_Registration_Servlet")
@MultipartConfig(maxFileSize=1024*1024*1024)
public class Patient_Registration_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Patient_Registration_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("p_name");
		String location=request.getParameter("location");
		String email=request.getParameter("email");
		String mobno=request.getParameter("mobno");
		String symptom1=request.getParameter("symptom1");
		String symptom2=request.getParameter("symptom2");
		String symptom3=request.getParameter("symptom3");
		String symptom4=request.getParameter("symptom4");
		String symptom5=request.getParameter("symptom5");
		
		Patient_Bean bean=new Patient_Bean();
		
		bean.setPatient_name(name);
		bean.setPatient_location(location);
		bean.setPatient_email(email);
		bean.setPatient_mobno(mobno);
		bean.setPatient_symptom1(symptom1);
		bean.setPatient_symptom2(symptom2);
		bean.setPatient_symptom3(symptom3);
		bean.setPatient_symptom4(symptom4);
		bean.setPatient_symptom5(symptom5);
		
		AdminDao dao=new AdminDao();
		
		if(dao.registerPatient(bean))
		{
			//EmailDemo ed=new EmailDemo();
			//ed.sendEmail(email);
			HttpSession session = request.getSession();
			session.setAttribute("p_email", email);
			session.setAttribute("location", location);
			out.println("<script type=\"text/javascript\">");
			/*out.println("alert('Patient Registraction Success!!!');");*/
			out.println("location='patient_home.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Patient Registration Failed!!!');");
			out.println("location='patient_register.jsp';");
			out.println("</script>");
		}
	}

}
