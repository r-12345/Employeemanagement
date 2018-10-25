
package com.cg.ems.dao;

import java.util.HashSet;
import java.util.Iterator;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.dao.CollectionUtil;

public class EmployeeDaoImp implements EmployeeDao {
    
    @Override
    public int addEmployee(Employee ee) throws EmployeeException {
        // TODO Auto-generated method stub
        CollectionUtil.addEmp(ee);
        return ee.getEmpId();
    }
    
    @Override
    public HashSet<Employee> fetchAllEmp() {
        // TODO Auto-generated method stub
        return CollectionUtil.getAllEmp();
    }

    public Employee getEmpById(int empId)
    {   
        
        HashSet<Employee> empSet=CollectionUtil.getAllEmp();
        Iterator<Employee> it=empSet.iterator();
                while(it.hasNext())
        {
            Employee e=it.next();
            if(e.getEmpId()==empId)
            {
            	System.out.println(e.getEmpId()+"\t\t"+e.getEmpName()+"\t\t"+e.getEmpSal());
            
            }
        }
        
        return null;
        
    }


    @Override
    public HashSet<Employee> searchEmpByName(String name) {
    	
    	
        // TODO Auto-generated method stub
    	  HashSet<Employee> empSet=CollectionUtil.getAllEmp();
          Iterator<Employee> it=empSet.iterator();
                  while(it.hasNext())
          {
              Employee e=it.next();
              if(name.equals(e.getEmpName())){
            	  System.out.println(e.getEmpId()+"\t\t"+e.getEmpName()+"\t\t"+e.getEmpSal()); 
              }
              }
              
    	
    	
        return null;
    }

    @Override
    public int deleteEmp(int empId) {
        // TODO Auto-generated method stub
    	HashSet<Employee> empSet=CollectionUtil.getAllEmp();
        Iterator<Employee> it=empSet.iterator();
                while(it.hasNext())
        {
            Employee e=it.next();
            if(e.getEmpId()==empId)
            {
            	it.remove();
            
            }
        }
        return 0;
    }

    @Override
    public Employee updateEmp(int empId, float newSal) {
        // TODO Auto-generated method stub
    	HashSet<Employee> empSet=CollectionUtil.getAllEmp();
        Iterator<Employee> it=empSet.iterator();
        Employee e1=null;
                while(it.hasNext())
        {
            Employee e=it.next();
            if(e.getEmpId()==empId)
            {
            	e1=new Employee(e.getEmpId(),e.getEmpName(),newSal, e.getEmpDOJ());
            	empSet.add(e1);
            	it.remove();
            
            }
        }
        return e1;
    }

}




