package com.cg.ems.ui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeServiceImp;
import com.cg.ems.service.EmployeeService;

public class TestEmployeeClient {

    static Scanner sc=null;
    static EmployeeService empSer=null;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
sc=new Scanner(System.in);
empSer = new EmployeeServiceImp();
int choice = 0;
while(true)
{
    System.out.println("what do u want to do?");
    System.out.println("1:Add Emp \t 2: Fetch All Emp\n");
    System.out.println("3:Delete Emp \t 4:Search Emp by id");
    System.out.println("5: Search Emp By Name \t 6: Update");
    System.out.println("7: Exit\n");
    System.out.println("Enter Ur Choice");
    
    choice = sc.nextInt();
    switch(choice)
    {
    case 1:addEmp();break;
    case 2:showEmpInfo();break;
    case 3:DeleteEmp();break;
    case 4:getEmpById();break;
    case 5:searchByName();break;
    case 6:updateEmp();
    default:System.exit(0);
    }
 

    }


    }

    private static void updateEmp() {
		// TODO Auto-generated method stub
    	System.out.println("Enter empid");
    	int eid=sc.nextInt();
    	System.out.println("Enter salary");
    	float sal=sc.nextFloat();
    	Employee emp=empSer.updateEmp(eid, sal);
    System.out.println(emp.getEmpId()+emp.getEmpName()+emp.getEmpSal());	
		
	}
	private static void DeleteEmp() {
		// TODO Auto-generated method stub
		 System.out.println("enter emp id");
	        int eid = sc.nextInt();
	       empSer.deleteEmp(eid);
	}
	private static void showEmpInfo() {
    HashSet<Employee> empSet= empSer.fetchAllEmp();
    Iterator<Employee> it = empSet.iterator();
    System.out.println("****************");
    System.out.println("EMP-ID\t\tEMPNAME\t\tEMPSALARY");
    while(it.hasNext())
    {
    Employee ee=it.next();
    System.out.println(ee.getEmpId()+"\t\t"+ee.getEmpName()+"\t\t"+ee.getEmpSal());
    }
    System.out.println("-----------------");
	}
    private static void addEmp() {
        // TODO Auto-generated method stub
        System.out.println("enter emp id");
        String eid = sc.next();
        try
        {
            if(empSer.validateDigit(eid))
            {
                System.out.println("enter emp name");
                String nm = sc.next();
                if(empSer.validateName(nm))
                {
                    System.out.println("enter salary:");
                    float sal = sc.nextFloat();
                    
                    System.out.println("Enter DOJ(dd-MMM-yyyy)");
                    String empDOJStr= sc.next();
                 
                    Employee ee = new Employee(Integer.parseInt(eid),nm,sal,empSer.convertFromStrToLocalDate(empDOJStr));
                    int empId = empSer.addEmployee(ee);
                    System.out.println(empId + "Added Successfully");
                }
            }
        }
        
        
        
        catch(EmployeeException e)
            {
            e.printStackTrace();
            }
       
    }
        private static void getEmpById(){
        	System.out.println("Enter the employee Id");
        	int reqId = sc.nextInt();
        	empSer.getEmpById(reqId);
        	
        }
        
        private static void searchByName(){
        	System.out.println("Enter the employee Id");
        	String name = sc.next();
        	empSer.searchEmpByName(name);
        	
        	
        	System.out.println("Enter ur ch");
     
        }
}



