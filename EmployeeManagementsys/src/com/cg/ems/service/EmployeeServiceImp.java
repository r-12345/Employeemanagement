

package com.cg.ems.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.regex.Pattern;

import com.cg.ems.dao.EmployeeDaoImp;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeServiceImp implements EmployeeService {

EmployeeDao empDao = null;
public EmployeeServiceImp()
{
    empDao = new EmployeeDaoImp();
}
    @Override
    public int addEmployee(Employee ee) throws EmployeeException {
        
        return empDao.addEmployee(ee);
    }

    @Override
    public HashSet<Employee> fetchAllEmp() {
                return empDao.fetchAllEmp();
    }

    @Override
    public Employee getEmpById(int empId) {
        // TODO Auto-generated method stub
        return empDao.getEmpById(empId);
    }

    @Override
    public HashSet<Employee> searchEmpByName(String name) {
        
        return empDao.searchEmpByName(name);
    }

    @Override
    public int deleteEmp(int empId) {
        // TODO Auto-generated method stub
    	return empDao.deleteEmp(empId); 
    }

    @Override
    public Employee updateEmp(int empId, String newName, float newSal) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean validateDigit(String num) throws EmployeeException {
        
        String digitPattern = "[0-9]+";
                if(Pattern.matches(digitPattern, num))
                {
                    return true;
                }
                else
                {
                    throw new EmployeeException("Invalid Input" + "Only Digits are allowed ex. 4567");
                }
    
    }

    @Override
    public boolean validateName(String name) throws EmployeeException {
        
        String namePattern = "[A-Z][a-z]+";
        if(Pattern.matches(namePattern, name))
        {
            return true;
        }
        else
        {
            throw new EmployeeException("Invalid Input" 
        + "only charcters are allowed and should start " 
                    + "with capital ex. Abhinav");
        }
    }
	@Override
	public Employee updateEmp(int empId, float newSal) {
		// TODO Auto-generated method stub
		return empDao.updateEmp(empId, newSal);
	}
	@Override
	public LocalDate convertFromStrToLocalDate(String dtStr) {
		// TODO Auto-generated method stub
		DateTimeFormatter myFormat=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date=LocalDate.parse(dtStr, myFormat);
		return date;
	}

	

}




