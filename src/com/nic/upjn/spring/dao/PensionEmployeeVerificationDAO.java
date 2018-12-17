package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.dto.PensionEmployeeVerificationDTO;

public interface PensionEmployeeVerificationDAO {

	List getList(String condition, String query);

	List employeeList();
	
	List employeeInfo(String employeecode);



	boolean insertPensionerDetails(PensionEmployeeVerificationDTO dto);

	

}
