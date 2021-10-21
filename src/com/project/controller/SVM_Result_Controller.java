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

import com.project.algo.SVMClassification;
import com.project.bean.Disease_Bean;
import com.project.bean.Doc_Location_Bean;
import com.project.bean.Patient_Bean;
import com.project.bean.Result_Bean;
import com.project.dao.AdminDao;
import com.project.dao.PatientDao;

/**
 * Servlet implementation class Naive_Bays_Result_Controller
 */
@WebServlet("/SVM_Result_Controller")
public class SVM_Result_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVM_Result_Controller() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		String p_email=(String)session.getAttribute("p_email");
		String location=(String)session.getAttribute("location");
		
        AdminDao a_dao=new AdminDao();
        
        PatientDao p_dao=new PatientDao();
		
		ArrayList<Patient_Bean> patients_details=new ArrayList<Patient_Bean>();
		
		patients_details=p_dao.getMyDetails(p_email);
		
		ArrayList<Result_Bean> final_result_list=new ArrayList<Result_Bean>();
		
		//ArrayList<Disease_Bean> disease_list=new ArrayList<Disease_Bean>();
		
		String final_disease=null;
		
		SVMClassification sc=new SVMClassification();
		
		for(int i=0; i<patients_details.size(); i++)
		{
			String patient_name=patients_details.get(i).getPatient_name();
			String patient_email=patients_details.get(i).getPatient_email();
			String patient_loc=patients_details.get(i).getPatient_location();
			String patient_symptom1=patients_details.get(i).getPatient_symptom1();
			String patient_symptom2=patients_details.get(i).getPatient_symptom2();
			String patient_symptom3=patients_details.get(i).getPatient_symptom3();
			String patient_symptom4=patients_details.get(i).getPatient_symptom4();
			String patient_symptom5=patients_details.get(i).getPatient_symptom5();
			
			String disease_name_1=null;
			String disease_name_2=null;
			String disease_name_3=null;
			String disease_name_4=null;
			String disease_name_5=null;
			
			ArrayList<Disease_Bean> list1=new ArrayList<Disease_Bean>();
			ArrayList<Disease_Bean> list2=new ArrayList<Disease_Bean>();
			ArrayList<Disease_Bean> list3=new ArrayList<Disease_Bean>();
			ArrayList<Disease_Bean> list4=new ArrayList<Disease_Bean>();
			ArrayList<Disease_Bean> list5=new ArrayList<Disease_Bean>();
			
			Disease_Bean d_bean=new Disease_Bean();
			
			if(patient_symptom1!=null && patient_symptom2!=null && patient_symptom3!=null && patient_symptom4!=null && patient_symptom5!=null)
			{
				
				list1=a_dao.getDiseaseName(patient_symptom1);
				//disease_name_1=d_bean.getDisease_name();
				
				list2=a_dao.getDiseaseName(patient_symptom2);
				//disease_name_2=d_bean.getDisease_name();
				
				list3=a_dao.getDiseaseName(patient_symptom3);
				//disease_name_3=d_bean.getDisease_name();
				
				list4=a_dao.getDiseaseName(patient_symptom4);
				//disease_name_4=d_bean.getDisease_name();
				
				list5=a_dao.getDiseaseName(patient_symptom5);
				//disease_name_5=d_bean.getDisease_name();
			}
			else if(patient_symptom1!=null && patient_symptom2!=null && patient_symptom3!=null && patient_symptom4!=null)
			{
				list1=a_dao.getDiseaseName(patient_symptom1);
				//disease_name_1=d_bean.getDisease_name();
				
				list2=a_dao.getDiseaseName(patient_symptom2);
				//disease_name_2=d_bean.getDisease_name();
				
				list3=a_dao.getDiseaseName(patient_symptom3);
				//disease_name_3=d_bean.getDisease_name();
				
				list4=a_dao.getDiseaseName(patient_symptom4);
				//disease_name_4=d_bean.getDisease_name();
			}
			else if(patient_symptom1!=null && patient_symptom2!=null && patient_symptom3!=null)
			{
				
				list1=a_dao.getDiseaseName(patient_symptom1);
				//disease_name_1=d_bean.getDisease_name();
				
				list2=a_dao.getDiseaseName(patient_symptom2);
				//disease_name_2=d_bean.getDisease_name();
				
				list3=a_dao.getDiseaseName(patient_symptom3);
				//disease_name_3=d_bean.getDisease_name();
			}
			else if(patient_symptom1!=null && patient_symptom2!=null)
			{
				list1=a_dao.getDiseaseName(patient_symptom1);
				//disease_name_1=d_bean.getDisease_name();
				
				list2=a_dao.getDiseaseName(patient_symptom2);
				//disease_name_2=d_bean.getDisease_name();
				
			}
			else if(patient_symptom1!=null)
			{
				list1=a_dao.getDiseaseName(patient_symptom1);
				//disease_name_1=d_bean.getDisease_name();
				
			}
			
			final_disease=sc.classify(list1, list2, list3, list4, list5);
			
			System.out.println("Final Disease Name in SVM Controller= "+final_disease);
			
			if(final_disease!= null && !final_disease.isEmpty())
			 {	
				System.out.println("In if statement!!!");
				d_bean=a_dao.getDiseaseTreatement(final_disease);
			    String treatment=d_bean.getTreatement();
			    System.out.println("Treatement in if part= "+treatment);
			
			    Doc_Location_Bean dc_bean=new Doc_Location_Bean();
			    dc_bean=a_dao.getDoctorName(patient_loc);
			
			    String doc_name=dc_bean.getDoc_name();
			    String doc_cont=dc_bean.getDoc_contact();
			
			    Result_Bean r_bean=new Result_Bean();
			
			    r_bean.setPatient_name(patient_name);
			    r_bean.setPatient_email(patient_email);
			    r_bean.setPatient_location(patient_loc);
			    r_bean.setPatient_symptom_1(patient_symptom1);
			    r_bean.setPatient_symptom_2(patient_symptom2);
			    r_bean.setPatient_symptom_3(patient_symptom3);
			    r_bean.setPatient_symptom_4(patient_symptom4);
			    r_bean.setPatient_symptom_5(patient_symptom5);
			    r_bean.setDisease_name(final_disease);
			    r_bean.setTreatment(treatment);
			    r_bean.setDoc_name(doc_name);
			    r_bean.setDoc_contact(doc_cont);
			
			    final_result_list.add(r_bean);
			}
			else //if(final_disease.equals(null) || final_disease.equals(""))
			{
				System.out.println("In else condition!!!");
				String treatment="Kindly Consult Nearby Doctor!!!";
				System.out.println("treatment in else part= "+treatment);
				
				Doc_Location_Bean dc_bean=new Doc_Location_Bean();
			    dc_bean=a_dao.getDoctorName(patient_loc);
			
			    String doc_name=dc_bean.getDoc_name();
			    String doc_cont=dc_bean.getDoc_contact();
			    
				//String disease_name=NaiveBaysClassification.message;
				
				Result_Bean r_bean=new Result_Bean();
				
				r_bean.setPatient_name(patient_name);
				r_bean.setPatient_email(patient_email);
				r_bean.setPatient_location(patient_loc);
				r_bean.setPatient_symptom_1(patient_symptom1);
				r_bean.setPatient_symptom_2(patient_symptom2);
				r_bean.setPatient_symptom_3(patient_symptom3);
				r_bean.setPatient_symptom_4(patient_symptom4);
			    r_bean.setPatient_symptom_5(patient_symptom5);
				r_bean.setDisease_name("");
				r_bean.setTreatment(treatment);
				r_bean.setDoc_name(doc_name);
				r_bean.setDoc_contact(doc_cont);
				
				final_result_list.add(r_bean);
			}
		}
		
		if(final_result_list.size()!=0)
		{
			
			session.setAttribute("final_result_list", final_result_list);
			out.println("<script type=\"text/javascript\">");
			//out.println("alert('See Final Results!!!');");
			out.println("location='patient_view_final_SVM_results.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Result Failed!!!');");
			out.println("location='patient_home.jsp';");
			out.println("</script>");
		}
		
	
	}


}
