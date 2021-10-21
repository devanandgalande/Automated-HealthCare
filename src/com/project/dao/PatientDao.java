package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.bean.Patient_Bean;
import com.project.db.DBConnect;

public class PatientDao {
	
	Connection connection=DBConnect.getConnection();
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement psmt;
	ResultSet rs;
	
	
	/**********************************************************************************************************************/
	
	public  ArrayList<Patient_Bean> getMyDetails(String email)
	{	
	   ResultSet rs=null;
	   
	   ArrayList<Patient_Bean> details = new ArrayList<Patient_Bean>();
	   
       String sql = "Select * from tbl_patient where patient_email='"+email.toLowerCase()+"' ORDER BY Id DESC LIMIT 1";
		
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

}
