package com.cg.ems.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;

import com.cg.ems.dto.Employee;

public class CollectionUtil {


	    private static HashSet<Employee> empSet = new HashSet<Employee>();
	    
	    static
	    {
	        empSet.add(new Employee(112081,"Abhinav",5000.0f,LocalDate.of(2014,Month.MARCH,04)));
	        empSet.add(new Employee(112082,"Ajay",4000.0f,LocalDate.of(2015,Month.APRIL,05)));
	        empSet.add(new Employee(112083,"Atul",5900.0f,LocalDate.of(2015,Month.JUNE,06)));
	        empSet.add(new Employee(112084,"Anuj",6000.0f,LocalDate.of(2015,Month.JULY,07)));
	        empSet.add(new Employee(112085,"YAsh",8900.0f,LocalDate.of(2015,Month.AUGUST,01)));  
	    }
	    
	    public static void addEmp(Employee emp)
	    {
	        empSet.add(emp);
	    }
	    
	    public static void removeEmp(Employee emp)
	    {
	        empSet.remove(emp);
	    }
	    
	    
	    public static HashSet<Employee> getAllEmp()
	    {
	        return empSet;
	    }

		
		public static HashSet<Employee> fetchAllEmp() 
		{
			return empSet;
		}
	    
		public static HashSet<Employee> getEmpById(int empId)
		{
			return empSet;
		}
	   
	   public static HashSet<Employee> searchEmpByName(String name)
	   {
		   return empSet;
	   }
	    
	    
	

}
