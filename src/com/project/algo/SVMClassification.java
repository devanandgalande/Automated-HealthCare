package com.project.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.project.bean.Disease_Bean;
import com.project.dao.AdminDao;

public class SVMClassification {
	
	public String final_disease=null;
	public static String message="";
	public static int disease_occurance=0;
	
	public static int count=0;
	
	HashMap<String,Integer> disease_occ_list=new HashMap<String,Integer>();
	  
	HashMap<String,Integer> symptoms_cnt_list=new HashMap<String,Integer>();
	
	HashMap<Integer,String> result_map=new HashMap<Integer,String>();
    
    ArrayList<Integer> occ_list=new ArrayList<Integer>();
    
    public static int [] occu_cnt_arr;
    
    public static int [] sympt_cnt_arr;
    
    public static int occ_cnt=1;
    
    AdminDao dao=new AdminDao();

	public String classify (ArrayList<Disease_Bean> list1, ArrayList<Disease_Bean> list2, ArrayList<Disease_Bean> list3, ArrayList<Disease_Bean> list4, ArrayList<Disease_Bean> list5)
	{
		
		//for 5 disease
				if(list1.size()!=0 && list2.size()!=0 && list3.size()!=0 && list4.size()!=0 && list5.size()!=0)
				{
				 
				  
				  for(int i=0; i<list1.size();i++)
				  {
					  System.out.println("Disease Name in list1= "+list1.get(i).getDisease_name());
				  }
				  for(int i=0; i<list2.size();i++)
				  {
					  System.out.println("Disease Name in list2= "+list2.get(i).getDisease_name());
				  }
				  for(int i=0; i<list3.size();i++)
				  {
					  System.out.println("Disease Name in list3= "+list3.get(i).getDisease_name());
				  }
				  for(int i=0; i<list4.size();i++)
				  {
					  System.out.println("Disease Name in list4= "+list4.get(i).getDisease_name());
				  }
				  for(int i=0; i<list5.size();i++)
				  {
					  System.out.println("Disease Name in list5= "+list5.get(i).getDisease_name());
				  }
				  
				  // list1 for loop
				  for(int i=0; i<list1.size();i++)
				    {
					 
					   ArrayList<String> D11=new ArrayList<String>();
					   
					   System.out.println("In list 1 loop= "+list1.get(i).getDisease_name());
					   
					   for(int j=0; j<list2.size();j++)
					   {
					   
					    if(list2.get(j).getDisease_name().equals(list1.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list1.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list1.get(i).getDisease_name());
					    }
					   }
					   
					   for(int j=0; j<list3.size();j++)
					   {
					   
					    if(list3.get(j).getDisease_name().equals(list1.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list1.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list1.get(i).getDisease_name());
					    }
					   }
					   
					   
					   for(int j=0; j<list4.size();j++)
					   {
					   
					    if(list4.get(j).getDisease_name().equals(list1.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list1.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list1.get(i).getDisease_name());
					    }
					   }
					   
					   for(int j=0; j<list5.size();j++)
					   {
					   
					    if(list5.get(j).getDisease_name().equals(list1.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list1.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list1.get(i).getDisease_name());
					    }
					   }
					   
					   if(D11.size()>0)
					   {
					      System.out.println("D11 in 1= "+D11.get(0).toString());
					      disease_occ_list.put(list1.get(i).getDisease_name(), occ_cnt); // means disease name and count (occurrence)
					      System.out.println("Size of disease_occ_list in list1== "+disease_occ_list.size());
					   }
					  else
					   {
						   disease_occ_list.put(list1.get(i).getDisease_name(), 1); // means disease name and count (occurrence)
						   System.out.println("Size of disease_occ_list in list1=> "+disease_occ_list.size());   
					   }
					   D11.clear();
					 
				    }//end list1 for loop
				  
				  occ_cnt=1;
				//list2 for loop
				  for(int i=0; i<list2.size();i++)
				  {
					  ArrayList<String> D11=new ArrayList<String>();
						 
					  System.out.println("In list 2 loop= "+list2.get(i).getDisease_name());
					   
					   for(int j=0; j<list1.size();j++)
					   {
					   
					    if(list1.get(j).getDisease_name().equals(list2.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list2.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list2.get(i).getDisease_name());
					    }
					   }
					   
					   
					   for(int j=0; j<list3.size();j++)
					   {
					   
					    if(list3.get(j).getDisease_name().equals(list2.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list2.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list2.get(i).getDisease_name());
					    }
					   }
					   
					   
					   for(int j=0; j<list4.size();j++)
					   {
					   
					    if(list4.get(j).getDisease_name().equals(list2.get(i).getDisease_name()))
					    {
					      occ_cnt++;	
						  D11.add(list2.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list2.get(i).getDisease_name());
					    }
					   }
					   
					   
					   for(int j=0; j<list5.size();j++)
					   {
					   
					    if(list5.get(j).getDisease_name().equals(list2.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list2.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list2.get(i).getDisease_name());
					    }
					   }
					   
					   
					   if(D11.size()>0)
					   {
					       System.out.println("D11 in 2= "+D11.get(0).toString());
					       disease_occ_list.put(list2.get(i).getDisease_name(), occ_cnt);// means disease name and count (occurrence)
					       System.out.println("Size of sym_2_hm= "+disease_occ_list.size());
					   }
					  else
					   {
						   disease_occ_list.put(list2.get(i).getDisease_name(),1); // means disease name and count (occurrence)
						   System.out.println("Size of disease_occ_list in list2= "+disease_occ_list.size());   
					   }
					   D11.clear();
					 
				  }//end list2 for loop
				  
				  occ_cnt=1;
				//list3 for loop
				  for(int i=0; i<list3.size();i++)
				  {
					  ArrayList<String> D11=new ArrayList<String>();
						 
						
					  for(int j=0; j<list1.size();j++)
					   {
					   
					    if(list1.get(j).getDisease_name().equals(list3.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list3.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list3.get(i).getDisease_name());
					    }
					   }
					  
					  for(int j=0; j<list2.size();j++)
					   {
					   
					    if(list2.get(j).getDisease_name().equals(list3.get(i).getDisease_name()))
					    {
						  occ_cnt++;
						  D11.add(list3.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list3.get(i).getDisease_name());
					    }
					   } 
					  
					  for(int j=0; j<list4.size();j++)
					   {
					   
					    if(list4.get(j).getDisease_name().equals(list3.get(i).getDisease_name()))
					    {
						  occ_cnt++;
						  D11.add(list3.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list3.get(i).getDisease_name());
					    }
					   }
					  
					  for(int j=0; j<list5.size();j++)
					   {
					   
					    if(list5.get(j).getDisease_name().equals(list3.get(i).getDisease_name()))
					    {
						  occ_cnt++;
						  D11.add(list3.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list3.get(i).getDisease_name());
					    }
					   } 
					  
					   
					   if(D11.size()>0)
					   {
					      System.out.println("D11 in 3= "+D11.get(0).toString());
					      disease_occ_list.put(list3.get(i).getDisease_name(), occ_cnt);// means disease name and count (occurrence)
					      System.out.println("Size of sym_3_hm= "+disease_occ_list.size());
					   }
					   else
					   {
						   disease_occ_list.put(list3.get(i).getDisease_name(), 1); // means disease name and count (occurrence)
						   System.out.println("Size of disease_occ_list in list3= "+disease_occ_list.size());   
					   }
					   D11.clear();
					 
				  }//end list3 for loop

			      occ_cnt=1;
				//list4 for loop
				  for(int i=0; i<list4.size();i++)
				  {
					  ArrayList<String> D11=new ArrayList<String>();
						 
						
					  for(int j=0; j<list1.size();j++)
					   {
					   
					    if(list1.get(j).getDisease_name().equals(list4.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list4.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list4.get(i).getDisease_name());
					    }
					   }
					  
					  for(int j=0; j<list2.size();j++)
					   {
					   
					    if(list2.get(j).getDisease_name().equals(list4.get(i).getDisease_name()))
					    {
					      occ_cnt++;
					      D11.add(list4.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list4.get(i).getDisease_name());
					    }
					   }
					  
					  for(int j=0; j<list3.size();j++)
					   {
					   
					    if(list3.get(j).getDisease_name().equals(list4.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list4.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list4.get(i).getDisease_name());
					    }
					   }
					  
					  for(int j=0; j<list5.size();j++)
					   {
					   
					    if(list5.get(j).getDisease_name().equals(list4.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list4.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list4.get(i).getDisease_name());
					    }
					   } 
					  
					   
					   if(D11.size()>0)
					   {
					      System.out.println("D11 in 4= "+D11.get(0).toString());
					      disease_occ_list.put(list4.get(i).getDisease_name(), occ_cnt);// means disease name and count (occurrence)
					      System.out.println("Size of sym_4_hm= "+disease_occ_list.size());
					   }
					  else
					   {
						   disease_occ_list.put(list4.get(i).getDisease_name(), 1); // means disease name and count (occurrence)
						   System.out.println("Size of disease_occ_list in list4= "+disease_occ_list.size());   
					   }
					   D11.clear();
					 
				  }//end list4 for loop
				  occ_cnt=1;
				  //list5 for loop
				  for(int i=0; i<list5.size();i++)
				  {
					  ArrayList<String> D11=new ArrayList<String>();
						 
						 
					  for(int j=0; j<list1.size();j++)
					   {
					   
					    if(list1.get(j).getDisease_name().equals(list5.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list5.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list5.get(i).getDisease_name());
					    }
					   }
					  
					  for(int j=0; j<list2.size();j++)
					   {
					   
					    if(list2.get(j).getDisease_name().equals(list5.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list5.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list5.get(i).getDisease_name());
					    }
					   }
					  
					  for(int j=0; j<list3.size();j++)
					   {
					   
					    if(list3.get(j).getDisease_name().equals(list5.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list5.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list5.get(i).getDisease_name());
					    }
					   }
					  
					  for(int j=0; j<list4.size();j++)
					   {
					   
					    if(list4.get(j).getDisease_name().equals(list5.get(i).getDisease_name()))
					    {
					      occ_cnt++;
						  D11.add(list5.get(i).getDisease_name());
						  System.out.println("Matched Disease Name= "+list5.get(i).getDisease_name());
					    }
					   }
					   
					   if(D11.size()>0)
					   {
					       System.out.println("D11 in 5= "+D11.get(0).toString());
					       disease_occ_list.put(list5.get(i).getDisease_name(), occ_cnt);// means disease name and count (occurrence)
					       System.out.println("Size of sym_5_hm= "+disease_occ_list.size());
					   }
					  else
					   {
						   disease_occ_list.put(list5.get(i).getDisease_name(), 1); // means disease name and count (occurrence)
						   System.out.println("Size of disease_occ_list in list5= "+disease_occ_list.size());   
					   }
					   D11.clear();
					 
				  }//end list5 for loop
				  
				}
				
				/*****************For 4 symptoms calculation*******************************************/
				
				else if(list1.size()!=0 && list2.size()!=0 && list3.size()!=0 && list4.size()!=0 && list5.size()==0)
						{
						 
						  for(int i=0; i<list1.size();i++)
						  {
							  System.out.println("Disease Name in list1= "+list1.get(i).getDisease_name());
						  }
						  for(int i=0; i<list2.size();i++)
						  {
							  System.out.println("Disease Name in list2= "+list2.get(i).getDisease_name());
						  }
						  for(int i=0; i<list3.size();i++)
						  {
							  System.out.println("Disease Name in list3= "+list3.get(i).getDisease_name());
						  }
						  for(int i=0; i<list4.size();i++)
						  {
							  System.out.println("Disease Name in list4= "+list4.get(i).getDisease_name());
						  }
						 
						  // list1 for loop
						  for(int i=0; i<list1.size();i++)
						    {
							 
							   ArrayList<String> D11=new ArrayList<String>();
							   
							   System.out.println("In list 1 loop= "+list1.get(i).getDisease_name());
							   
							   for(int j=0; j<list2.size();j++)
							   {
							   
							    if(list2.get(j).getDisease_name().equals(list1.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list1.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list1.get(i).getDisease_name());
							    }
							   }
							   
							   for(int j=0; j<list3.size();j++)
							   {
							   
							    if(list3.get(j).getDisease_name().equals(list1.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list1.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list1.get(i).getDisease_name());
							    }
							   }
							   
							   
							   for(int j=0; j<list4.size();j++)
							   {
							   
							    if(list4.get(j).getDisease_name().equals(list1.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list1.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list1.get(i).getDisease_name());
							    }
							   }
							   
							   
							   if(D11.size()>0)
							   {
							      System.out.println("D11 in 1= "+D11.get(0).toString());
							      disease_occ_list.put(list1.get(i).getDisease_name(), occ_cnt); // means disease name and count (occurrence)
							      System.out.println("Size of disease_occ_list in list1== "+disease_occ_list.size());
							   }
							  else
							   {
								   disease_occ_list.put(list1.get(i).getDisease_name(), 1); // means disease name and count (occurrence)
								   System.out.println("Size of disease_occ_list in list1=> "+disease_occ_list.size());   
							   }
							   D11.clear();
							 
						    }//end list1 for loop
						  
						  occ_cnt=1;
						//list2 for loop
						  for(int i=0; i<list2.size();i++)
						  {
							  ArrayList<String> D11=new ArrayList<String>();
								 
							  System.out.println("In list 2 loop= "+list2.get(i).getDisease_name());
							   
							   for(int j=0; j<list1.size();j++)
							   {
							   
							    if(list1.get(j).getDisease_name().equals(list2.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list2.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list2.get(i).getDisease_name());
							    }
							   }
							   
							   
							   for(int j=0; j<list3.size();j++)
							   {
							   
							    if(list3.get(j).getDisease_name().equals(list2.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list2.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list2.get(i).getDisease_name());
							    }
							   }
							   
							   
							   for(int j=0; j<list4.size();j++)
							   {
							   
							    if(list4.get(j).getDisease_name().equals(list2.get(i).getDisease_name()))
							    {
							      occ_cnt++;	
								  D11.add(list2.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list2.get(i).getDisease_name());
							    }
							   }
							   
							   
							   if(D11.size()>0)
							   {
							       System.out.println("D11 in 2= "+D11.get(0).toString());
							       disease_occ_list.put(list2.get(i).getDisease_name(), occ_cnt);// means disease name and count (occurrence)
							       System.out.println("Size of sym_2_hm= "+disease_occ_list.size());
							   }
							  else
							   {
								   disease_occ_list.put(list2.get(i).getDisease_name(),1); // means disease name and count (occurrence)
								   System.out.println("Size of disease_occ_list in list2= "+disease_occ_list.size());   
							   }
							   D11.clear();
							 
						  }//end list2 for loop
						  
						  occ_cnt=1;
						//list3 for loop
						  for(int i=0; i<list3.size();i++)
						  {
							  ArrayList<String> D11=new ArrayList<String>();
								 
								
							  for(int j=0; j<list1.size();j++)
							   {
							   
							    if(list1.get(j).getDisease_name().equals(list3.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list3.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list3.get(i).getDisease_name());
							    }
							   }
							  
							  for(int j=0; j<list2.size();j++)
							   {
							   
							    if(list2.get(j).getDisease_name().equals(list3.get(i).getDisease_name()))
							    {
								  occ_cnt++;
								  D11.add(list3.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list3.get(i).getDisease_name());
							    }
							   } 
							  
							  for(int j=0; j<list4.size();j++)
							   {
							   
							    if(list4.get(j).getDisease_name().equals(list3.get(i).getDisease_name()))
							    {
								  occ_cnt++;
								  D11.add(list3.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list3.get(i).getDisease_name());
							    }
							   }
							 
							   if(D11.size()>0)
							   {
							      System.out.println("D11 in 3= "+D11.get(0).toString());
							      disease_occ_list.put(list3.get(i).getDisease_name(), occ_cnt);// means disease name and count (occurrence)
							      System.out.println("Size of sym_3_hm= "+disease_occ_list.size());
							   }
							   else
							   {
								   disease_occ_list.put(list3.get(i).getDisease_name(), 1); // means disease name and count (occurrence)
								   System.out.println("Size of disease_occ_list in list3= "+disease_occ_list.size());   
							   }
							   D11.clear();
							 
						  }//end list3 for loop

					      occ_cnt=1;
						//list4 for loop
						  for(int i=0; i<list4.size();i++)
						  {
							  ArrayList<String> D11=new ArrayList<String>();
								 
								
							  for(int j=0; j<list1.size();j++)
							   {
							   
							    if(list1.get(j).getDisease_name().equals(list4.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list4.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list4.get(i).getDisease_name());
							    }
							   }
							  
							  for(int j=0; j<list2.size();j++)
							   {
							   
							    if(list2.get(j).getDisease_name().equals(list4.get(i).getDisease_name()))
							    {
							      occ_cnt++;
							      D11.add(list4.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list4.get(i).getDisease_name());
							    }
							   }
							  
							  for(int j=0; j<list3.size();j++)
							   {
							   
							    if(list3.get(j).getDisease_name().equals(list4.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list4.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list4.get(i).getDisease_name());
							    }
							   }
							 
							   if(D11.size()>0)
							   {
							      System.out.println("D11 in 4= "+D11.get(0).toString());
							      disease_occ_list.put(list4.get(i).getDisease_name(), occ_cnt);// means disease name and count (occurrence)
							      System.out.println("Size of sym_4_hm= "+disease_occ_list.size());
							   }
							  else
							   {
								   disease_occ_list.put(list4.get(i).getDisease_name(), 1); // means disease name and count (occurrence)
								   System.out.println("Size of disease_occ_list in list4= "+disease_occ_list.size());   
							   }
							   D11.clear();
							 
						  }//end list4 for loop
						 
						}
				
				
				/*****************For 3 symptoms calculation*******************************************/
				
				else if(list1.size()!=0 && list2.size()!=0 && list3.size()!=0 && list4.size()==0 && list5.size()==0)
						{
						 
						  for(int i=0; i<list1.size();i++)
						  {
							  System.out.println("Disease Name in list1= "+list1.get(i).getDisease_name());
						  }
						  for(int i=0; i<list2.size();i++)
						  {
							  System.out.println("Disease Name in list2= "+list2.get(i).getDisease_name());
						  }
						  for(int i=0; i<list3.size();i++)
						  {
							  System.out.println("Disease Name in list3= "+list3.get(i).getDisease_name());
						  }
						 
						  // list1 for loop
						  for(int i=0; i<list1.size();i++)
						    {
							 
							   ArrayList<String> D11=new ArrayList<String>();
							   
							   System.out.println("In list 1 loop= "+list1.get(i).getDisease_name());
							   
							   for(int j=0; j<list2.size();j++)
							   {
							   
							    if(list2.get(j).getDisease_name().equals(list1.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list1.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list1.get(i).getDisease_name());
							    }
							   }
							   
							   for(int j=0; j<list3.size();j++)
							   {
							   
							    if(list3.get(j).getDisease_name().equals(list1.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list1.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list1.get(i).getDisease_name());
							    }
							   }
							   
							   
							   if(D11.size()>0)
							   {
							      System.out.println("D11 in 1= "+D11.get(0).toString());
							      disease_occ_list.put(list1.get(i).getDisease_name(), occ_cnt); // means disease name and count (occurrence)
							      System.out.println("Size of disease_occ_list in list1== "+disease_occ_list.size());
							   }
							  else
							   {
								   disease_occ_list.put(list1.get(i).getDisease_name(), 1); // means disease name and count (occurrence)
								   System.out.println("Size of disease_occ_list in list1=> "+disease_occ_list.size());   
							   }
							   D11.clear();
							 
						    }//end list1 for loop
						  
						  occ_cnt=1;
						//list2 for loop
						  for(int i=0; i<list2.size();i++)
						  {
							  ArrayList<String> D11=new ArrayList<String>();
								 
							  System.out.println("In list 2 loop= "+list2.get(i).getDisease_name());
							   
							   for(int j=0; j<list1.size();j++)
							   {
							   
							    if(list1.get(j).getDisease_name().equals(list2.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list2.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list2.get(i).getDisease_name());
							    }
							   }
							   
							   
							   for(int j=0; j<list3.size();j++)
							   {
							   
							    if(list3.get(j).getDisease_name().equals(list2.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list2.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list2.get(i).getDisease_name());
							    }
							   }
							   
							  
							   if(D11.size()>0)
							   {
							       System.out.println("D11 in 2= "+D11.get(0).toString());
							       disease_occ_list.put(list2.get(i).getDisease_name(), occ_cnt);// means disease name and count (occurrence)
							       System.out.println("Size of sym_2_hm= "+disease_occ_list.size());
							   }
							  else
							   {
								   disease_occ_list.put(list2.get(i).getDisease_name(),1); // means disease name and count (occurrence)
								   System.out.println("Size of disease_occ_list in list2= "+disease_occ_list.size());   
							   }
							   D11.clear();
							 
						  }//end list2 for loop
						  
						  occ_cnt=1;
						//list3 for loop
						  for(int i=0; i<list3.size();i++)
						  {
							  ArrayList<String> D11=new ArrayList<String>();
								 
								
							  for(int j=0; j<list1.size();j++)
							   {
							   
							    if(list1.get(j).getDisease_name().equals(list3.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list3.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list3.get(i).getDisease_name());
							    }
							   }
							  
							  for(int j=0; j<list2.size();j++)
							   {
							   
							    if(list2.get(j).getDisease_name().equals(list3.get(i).getDisease_name()))
							    {
								  occ_cnt++;
								  D11.add(list3.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list3.get(i).getDisease_name());
							    }
							   } 
							  
							   if(D11.size()>0)
							   {
							      System.out.println("D11 in 3= "+D11.get(0).toString());
							      disease_occ_list.put(list3.get(i).getDisease_name(), occ_cnt);// means disease name and count (occurrence)
							      System.out.println("Size of sym_3_hm= "+disease_occ_list.size());
							   }
							   else
							   {
								   disease_occ_list.put(list3.get(i).getDisease_name(), 1); // means disease name and count (occurrence)
								   System.out.println("Size of disease_occ_list in list3= "+disease_occ_list.size());   
							   }
							   D11.clear();
							 
						  }//end list3 for loop

						}
				  
				/*****************For 2 symptoms calculation*******************************************/
				
				else if(list1.size()!=0 && list2.size()!=0 && list3.size()==0 && list4.size()==0 && list5.size()==0)
						{
						 
						  for(int i=0; i<list1.size();i++)
						  {
							  System.out.println("Disease Name in list1= "+list1.get(i).getDisease_name());
						  }
						  for(int i=0; i<list2.size();i++)
						  {
							  System.out.println("Disease Name in list2= "+list2.get(i).getDisease_name());
						  }
						 
						  // list1 for loop
						  for(int i=0; i<list1.size();i++)
						    {
							 
							   ArrayList<String> D11=new ArrayList<String>();
							   
							   System.out.println("In list 1 loop= "+list1.get(i).getDisease_name());
							   
							   for(int j=0; j<list2.size();j++)
							   {
							   
							    if(list2.get(j).getDisease_name().equals(list1.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list1.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list1.get(i).getDisease_name());
							    }
							   }
							   
							   if(D11.size()>0)
							   {
							      System.out.println("D11 in 1= "+D11.get(0).toString());
							      disease_occ_list.put(list1.get(i).getDisease_name(), occ_cnt); // means disease name and count (occurrence)
							      System.out.println("Size of disease_occ_list in list1== "+disease_occ_list.size());
							   }
							  else
							   {
								   disease_occ_list.put(list1.get(i).getDisease_name(), 1); // means disease name and count (occurrence)
								   System.out.println("Size of disease_occ_list in list1=> "+disease_occ_list.size());   
							   }
							   D11.clear();
							 
						    }//end list1 for loop
						  
						  occ_cnt=1;
						//list2 for loop
						  for(int i=0; i<list2.size();i++)
						  {
							  ArrayList<String> D11=new ArrayList<String>();
								 
							  System.out.println("In list 2 loop= "+list2.get(i).getDisease_name());
							   
							   for(int j=0; j<list1.size();j++)
							   {
							   
							    if(list1.get(j).getDisease_name().equals(list2.get(i).getDisease_name()))
							    {
							      occ_cnt++;
								  D11.add(list2.get(i).getDisease_name());
								  System.out.println("Matched Disease Name= "+list2.get(i).getDisease_name());
							    }
							   }
							   
							  
							   if(D11.size()>0)
							   {
							       System.out.println("D11 in 2= "+D11.get(0).toString());
							       disease_occ_list.put(list2.get(i).getDisease_name(), occ_cnt);// means disease name and count (occurrence)
							       System.out.println("Size of sym_2_hm= "+disease_occ_list.size());
							   }
							  else
							   {
								   disease_occ_list.put(list2.get(i).getDisease_name(),1); // means disease name and count (occurrence)
								   System.out.println("Size of disease_occ_list in list2= "+disease_occ_list.size());   
							   }
							   D11.clear();
							 
						  }//end list2 for loop
						  
						}
				
				
				else if(list1.size()!=0 && list2.size()==0  && list3.size()==0 && list4.size()==0 && list5.size()==0)
				{
					 for(int i=0; i<list1.size();i++)
					  {
						 disease_occ_list.put(list1.get(i).getDisease_name(),1); // means disease name and count (occurrence)
						 System.out.println("Size of disease_occ_list in list1= "+disease_occ_list.size());
					  }
					
				}
				/***************Final Calculation******************************/
				
				if(disease_occ_list.size()>0)
				  {
				  
				   for(Map.Entry<String,Integer> m:disease_occ_list.entrySet())
				    {    
					   System.out.println("Value= "+m.getValue().toString()+" Key= "+m.getKey());   
				       
				       int count=dao.countTotalSymptoms(m.getKey().toString());// here key is disease name
				       
				       symptoms_cnt_list.put(m.getKey().toString(), count);
				    } 
				  
				   }
				
				 /**************************************************************/
				 
				  if(disease_occ_list.size()>0)
				  {
					     for(Map.Entry<String,Integer> m:disease_occ_list.entrySet())
					     {    
						  
						  result_map.put(m.getValue(), m.getKey());
					     }
					  
					int maxKey = Collections.max(result_map.keySet());
				    final_disease=result_map.get(maxKey);
				    System.out.println("Value corresponding to "
		                + "maximum Key of Map is: "
		                + result_map.get(maxKey));
				    /**************************************************************/
				   }
				else
				  {
					 message="Kindly Consult Nearby Doctor!!!";
				  }
				
				
				System.out.println("Final Disease Name in SVM Class= "+final_disease);
				return final_disease;
			}
			
			
		

//Method for getting the maximum value
	  public float getMaxValue(float[] inputArray)
	  { 
		float maxValue = inputArray[0]; 
	    for(int i=1;i < inputArray.length;i++)
	    { 
	      if(inputArray[i] > maxValue)
	      { 
	         maxValue = inputArray[i]; 
	      } 
	    } 
	    return maxValue; 
	  }
}