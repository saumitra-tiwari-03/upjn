package com.nic.upjn.spring.Service;

import java.util.List;

import com.nic.upjn.spring.dto.EmployeeStatusDTO;
import com.nic.upjn.spring.entity.PpEmployeequalification;
import com.nic.upjn.spring.entity.PpEmployeetraining;
import com.nic.upjn.spring.entity.ViewPpWholeemplist;

public interface ServiceBookService {

	public String createSearchSQL(String _predicate,
			EmployeeStatusDTO employeeStatusDTO);
	
	public String createSearchSQL_ES(String _predicate,
			EmployeeStatusDTO employeeStatusDTO);

	public List<?> getList(String where_condtion, String namedQuery);

	public List<?> getList(int where_condtion, String namedQuery);

	public List<?> getOfficeCombo(int[] where_condtion, String namedQuery);

	public List<?> suspensionEmployeeSearchList(String SQL);

	public int executeProcedureForeditEmployeePersonalDetails(
			EmployeeStatusDTO employeeStatusDTO);
	
	public int executeProcedureForaddEmployeePromotion(EmployeeStatusDTO employeeStatusDTO);
	public void updatePermanencyInformation(Object entity);
	public void saveTrainingInfoEmployee(PpEmployeetraining ppEmployeetraining);
	public List<?> getComboList(String namedQuery);

	public void insertQualificationDetails(
			PpEmployeequalification ppEmployeequalification);

	public List<ViewPpWholeemplist> suspensionEmployeeSearchList_ES(String sQL);

	public List getEmployeeInformation(String employeecode);

	public List<?> getWholeOfficeListing(String rm_OfficeID);
	

}
