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

import com.project.bean.Patient_Bean;
import com.project.dao.AdminDao;
import com.project.service.EmailDemo;

/**
 * Servlet implementation class Admin_View_All_Patients_Controller
 */
@WebServlet("/Admin_View_All_Patients_Controller")
public class Admin_View_All_Patients_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_View_All_Patients_Controller() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		AdminDao dao=new AdminDao();
		
		ArrayList<Patient_Bean> patient_list=new ArrayList<Patient_Bean>();
		
		patient_list=dao.getAllPatients();
		
		if(patient_list.size()!=0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("patient_list", patient_list);
			out.println("<script type=\"text/javascript\">");
			//out.println("alert('Data Success!! See Patients!');");
			out.println("location='admin_view_all_patients_details.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Patient Data Not Found!!!');");
			out.println("location='admin_home.jsp';");
			out.println("</script>");
		}
		
	}

}
