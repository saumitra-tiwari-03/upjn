package com.nic.upjn.spring.Service;



import java.util.*;

import com.nic.upjn.spring.dto.PensionEmployeeVerificationDTO;

public interface PensionEmployeeVerificationService {


	List<?> getList(String  condition, String namedQuery);
	List<?> employeeList();
	List<?> employeeInfo(String employeecode);
	boolean insertPensionerDetails(PensionEmployeeVerificationDTO dto);	
}
