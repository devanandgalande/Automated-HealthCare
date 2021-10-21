package com.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Patient_Bean;
import com.project.dao.AdminDao;

/**
 * Servlet implementation class DeleteUserController
 */
@WebServlet("/Delete_Patient_Controller")
public class Delete_Patient_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Patient_Controller() {
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
		
		    int id = Integer.parseInt(request.getParameter("p_id"));
			
		    AdminDao dao=new AdminDao();
			
			ArrayList<Patient_Bean> patient_list=new ArrayList<Patient_Bean>();
			
			
			if(dao.deletePatient(id))
			{
				
				patient_list=dao.getAllPatients();
				
				if(patient_list.size()!=0)
				{
					HttpSession session = request.getSession();
					session.setAttribute("patient_list", patient_list);
					RequestDispatcher rd = request.getRequestDispatcher("admin_view_all_patients_details.jsp");
					rd.forward(request, response);
				}else{
					request.setAttribute("ErrMsg", "Records are not found");
					RequestDispatcher rd = request.getRequestDispatcher("admin_home.jsp");
					rd.forward(request, response);
				}	
				
			}
		   
		  else{
			request.setAttribute("ErrMsg", "Patient Not Removed");
			RequestDispatcher rd = request.getRequestDispatcher("admin_home.jsp");
			rd.forward(request, response);
		    }	
		}
		
	

}
