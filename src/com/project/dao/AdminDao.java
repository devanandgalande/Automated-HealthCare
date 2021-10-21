package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.bean.Adminbean;
import com.project.bean.Disease_Bean;
import com.project.bean.Doc_Location_Bean;
import com.project.bean.Patient_Bean;
import com.project.db.DBConnect;

public class AdminDao {
	
	Connection connection=DBConnect.getConnection();
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement psmt;
	ResultSet rs;
	
	public boolean checkAdmin(Adminbean bean)
	{
		
		try {
			String sql="Select * from tbl_admin where admin_email=? and admin_password=?";
			psmt = connection.prepareStatement(sql);
			
			psmt.setString(1,bean.getEmail());
			psmt.setString(2,bean.getPassword());
			ResultSet rs=psmt.executeQuery();
			resultStatus=rs.next();
		    System.out.println("resultStatus= "+resultStatus);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
		return resultStatus;
	}


	/**********************************************************************************************************************/
	
	public  ArrayList<Doc_Location_Bean> get_Doctor_Details()
	{
	   //id, location, doc_name, specialization
	   ResultSet rs=null;
	   
	   ArrayList<Doc_Location_Bean> details = new ArrayList<Doc_Location_Bean>();
	   
       String sql = "Select DISTINCT location from tbl_doc_location ORDER BY location ASC";
		
		try {
			
			Statement stmt=connection.createStatement();
		
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Doc_Location_Bean bean=new Doc_Location_Bean();
				//bean.setId(rs.getInt(1));
				bean.setLocation(rs.getString(1));
				//bean.setDoc_name(rs.getString(3));
				//bean.setSpecialization(rs.getString(4));
				
				details.add(bean);
			}
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return details;
		
		
	}

	/**********************************************************************************************************************/
	
	public boolean registerPatient(Patient_Bean bean)
	   {
		
		//id, patient_name, patient_location, patient_email, patient_mobno, patient_symptom_1, patient_symptom_2, patient_symptom_3, patient_symptom_4, patient_symptom_5
		try
		   {
		     
				    String SQL="insert into tbl_patient(patient_name, patient_location, patient_email, patient_mobno, patient_symptom_1, patient_symptom_2, patient_symptom_3, patient_symptom_4, patient_symptom_5) values(?,?,?,?,?,?,?,?,?)"; 
				
					PreparedStatement pstmt=connection.prepareStatement(SQL);
					pstmt.setString(1, bean.getPatient_name());
					pstmt.setString(2, bean.getPatient_location());
					pstmt.setString(3, bean.getPatient_email());
					pstmt.setString(4, bean.getPatient_mobno());
					pstmt.setString(5, bean.getPatient_symptom1());
					pstmt.setString(6, bean.getPatient_symptom2());
					pstmt.setString(7, bean.getPatient_symptom3());
					pstmt.setString(8, bean.getPatient_symptom4());
					pstmt.setString(9, bean.getPatient_symptom5());
					
					
					int index=pstmt.executeUpdate();
					
					if(index>0)
					{
						resultStatus=Boolean.TRUE;
					}
					else
					{
						resultStatus=Boolean.FALSE;	
					}
					
		   }
				
				catch (SQLException e) 
				  {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
					
		     return resultStatus;
				
		 }
	/**********************************************************************************************************************/
	public boolean deletePatient(int id) {
		boolean flag=false;
		try{
			
		 String query="delete from tbl_patient where id='"+id+"'";
		 
		 PreparedStatement ps= connection.prepareStatement(query);
		 
		 int index = ps.executeUpdate();
			if(index>0){
			
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	/**********************************************************************************************************************/
	public  ArrayList<Patient_Bean> getAllPatients()
	{
		
	   ResultSet rs=null;
	   
	   ArrayList<Patient_Bean> details = new ArrayList<Patient_Bean>();
	   
       String sql = "Select * from tbl_patient";
		
		try {
			
			Statement stmt=connection.createStatement();
		
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Patient_Bean bean=new Patient_Bean();
				bean.setId(rs.getInt(1));
				bean.setPatient_name(rs.getString(2));
				bean.setPatient_location(rs.getString(3));
				bean.setPatient_email(rs.getString(4));
				bean.setPatient_mobno(rs.getString(5));
				bean.setPatient_symptom1(rs.getString(6));
				bean.setPatient_symptom2(rs.getString(7));
				bean.setPatient_symptom3(rs.getString(8));
				bean.setPatient_symptom4(rs.getString(9));
				bean.setPatient_symptom5(rs.getString(10));
				
				details.add(bean);
			}
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return details;
	}
	/**********************************************************************************************************************/
	public  ArrayList<Disease_Bean> get_Disease_Details()
	{
		
	   ResultSet rs=null;
	   
	   ArrayList<Disease_Bean> details = new ArrayList<Disease_Bean>();
	   
       String sql = "Select * from tbl_disease ORDER BY Symptoms ASC";
		
		try {
			
			Statement stmt=connection.createStatement();
		
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Disease_Bean bean=new Disease_Bean();
				bean.setId(rs.getInt(1));
				bean.setDisease_name(rs.getString(2));
				bean.setSymptoms(rs.getString(3));
				bean.setTreatement(rs.getString(4));
				
				details.add(bean);
			}
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return details;
		
	}
	
	/************************DISTINCT SYMPTOMS*****************************************************************************/
	//id, disease_name, Symptoms, Treatment
	public  ArrayList<Disease_Bean> getAllSymptoms()
	{
		
	   ResultSet rs=null;
	   
	   ArrayList<Disease_Bean> details = new ArrayList<Disease_Bean>();
	   
       String sql = "Select DISTINCT Symptoms from tbl_disease ORDER BY Symptoms ASC";
		
		try {
			
			Statement stmt=connection.createStatement();
		
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Disease_Bean bean=new Disease_Bean();
				/*bean.setId(rs.getInt(1));
				bean.setDisease_name(rs.getString(2));*/
				bean.setSymptoms(rs.getString(1));
				//bean.setTreatement(rs.getString(4));
				
				details.add(bean);
			}
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return details;
		
	}
	/**********************************************************************************************************************/
	//id, disease_name, Symptoms, Treatment
	public  ArrayList<Disease_Bean> getDiseaseName(String patient_symptoms)
	{
		
	   ArrayList<Disease_Bean> list1=new ArrayList<Disease_Bean>();
	   ResultSet rs=null;
	   
       String sql = "Select * from tbl_disease where Symptoms='"+patient_symptoms+"'";
       
       System.out.println("Final Result 1= "+sql);
		
		try {
			
			Statement stmt=connection.createStatement();
		
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Disease_Bean bean=new Disease_Bean();
				bean.setDisease_name(rs.getString(2));
				list1.add(bean);
			}
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return list1;
		
	}
	
	/**********************************************************************************************************************/
	//id, disease_name, Symptoms, Treatment
	public  Disease_Bean getDiseaseTreatement(String final_disease)
	{
		
	   ResultSet rs=null;
	   
	   Disease_Bean bean=new Disease_Bean();
	   
       String sql = "Select * from tbl_disease where disease_name='"+final_disease+"'";
       
       System.out.println("Final Result 1= "+sql);
		
		try {
			
			Statement stmt=connection.createStatement();
		
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				
				bean.setId(rs.getInt(1));
				bean.setDisease_name(rs.getString(2));
				bean.setSymptoms(rs.getString(3));
				bean.setTreatement(rs.getString(4));
				
			}
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return bean;
		
	}
	
	
	/**********************************************************************************************************************/
	
	public  Doc_Location_Bean getDoctorName(String patient_loc)
	{
	
		//id, location, doc_name, specialization
	   ResultSet rs=null;
	   
	   Doc_Location_Bean bean=new Doc_Location_Bean();
	   
       String sql = "Select * from tbl_doc_location where location='"+patient_loc+"'";
		
       System.out.println("Final Result 2= "+sql);
		try {
			
			Statement stmt=connection.createStatement();
		
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				
				bean.setId(rs.getInt(1));
				bean.setLocation(rs.getString(2));
				bean.setDoc_name(rs.getString(3));
				bean.setDoc_contact(rs.getString(4));
				//bean.setSpecialization(rs.getString(4));
				
			}
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return bean;
		
	}
	
	/************************************************************************************/
	//select count(*) as count from tbl_name where type='Raid'
	public  int countTotalSymptoms(String disease)
	{
		
	   ResultSet rs=null;
	   
	   int count=0;
	   
	   Disease_Bean bean=new Disease_Bean();
	   
       String sql = "select count(*) as count from tbl_disease where disease_name='"+disease+"'";
       
		try {
			
			Statement stmt=connection.createStatement();
		
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				
				count++;
			}
			
		 } 
		catch (SQLException e) 
		   {
			
			 e.printStackTrace();
		   }
		return count;
		
	}
	
}
