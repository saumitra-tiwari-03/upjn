package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.upjn.spring.dao.PensionEmployeeVerificationDAO;
import com.nic.upjn.spring.dto.PensionEmployeeVerificationDTO;

@Service("PensionEmployeeVerificationService")
public class PensionEmployeeVerificationServiceImple implements
		PensionEmployeeVerificationService {
	@Autowired
	private PensionEmployeeVerificationDAO pensionEmployeeVerificationDAO;

	@SuppressWarnings("rawtypes")
	@Override
	public List<?> getList(String condition, String namedQuery) {
		List list = null;
		try {
			list = pensionEmployeeVerificationDAO.getList(condition, namedQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<?> employeeList() {
		List employeeList=null;
		try
		{
			employeeList=pensionEmployeeVerificationDAO.employeeList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return employeeList;
	}
	
	
	@Override
	public List<?> employeeInfo(String employeecode) {
		List employeeInfo=null;
		try
		{
			employeeInfo=pensionEmployeeVerificationDAO.employeeInfo(employeecode);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return employeeInfo;
	}
	
	 @Override
	 public boolean insertPensionerDetails(PensionEmployeeVerificationDTO dto) {
		 
		 boolean isComplete=false;
		 
		 try
		 {
			 isComplete=pensionEmployeeVerificationDAO.insertPensionerDetails(dto);
			 isComplete=true;
			 System.out.println("Employeecode in service class : "+dto.getEmployeecode());
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		return isComplete;
		 
	 }

	
}
