package com.project.algo;

import java.util.ArrayList;

public class CheckValueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<String> list1=new ArrayList<String>();
		
		ArrayList<String> list2=new ArrayList<String>();
		
		/*float f1=0.4f;
		float f2=0.25f;
		float f3=0.25f;
		
		if(f1>f2)
		{
			System.out.println("f1 is big dan f2");
		}
		else
		{
			System.out.println("f2 is big dan f1");
		}
		*/
		
		list1.add("ABC");
		
		list2.add("Smallpox");
		
		if(list1.retainAll(list2))
		   {
			 System.out.println("Matched Disease Name= "+list1.retainAll(list2));
		   }
		
	  for(int i=0; i<list1.size();i++)
	  {
			 
		if(list2.contains(list1.get(0).toString()))
		{
			   System.out.println("Matched Disease Name= "+list1.get(0).toString());
		}
	  }
	}

}
