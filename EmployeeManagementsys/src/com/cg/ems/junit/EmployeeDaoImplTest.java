package com.cg.ems.junit;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmployeeDaoImp;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeDaoImplTest {

	
	static EmployeeDao empdao=null;
	@BeforeClass
	public static void setUp()
	{
		empdao=new EmployeeDaoImp();
		
	}
	
	@Test
	public void addEmpTest() throws EmployeeException{
		
		Assert.assertEquals(111,empdao.addEmployee(new Employee(111,"aaa",1111.0F,LocalDate.now())));
	}
}
