
/******************************** ServiceBookDao **************************/

/*==========================================================================
 * Description : ServiceBookDao is a simple interface standard that contains an abstract method for Service Book.   
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 *


 /** Interface for PostingStatusDAO **/
package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.dto.EmployeeStatusDTO;
import com.nic.upjn.spring.entity.PpEmployeequalification;
import com.nic.upjn.spring.entity.PpEmployeetraining;
import com.nic.upjn.spring.entity.ViewPpWholeemplist;

public interface ServiceBookDao {

	List<?> getComboList(int where_condition, String namedQuery);

	List<?> getComboList(String where_condition, String namedQuery);

	List<?> getComboList(int[] where_condtion, String namedQuery);

	List<?> suspensionEmployeeSearchList(String SQL);

	public int executeProcedureForeditEmployeePersonalDetails(
			EmployeeStatusDTO employeeStatusDTO);
	public int executeProcedureForaddEmployeePromotion(EmployeeStatusDTO employeeStatusDTO);
	public void updatePermanencyInformation(Object entity);
	public void saveTrainingInfoEmployee(PpEmployeetraining ppEmployeetraining);
	public List<?> getComboList(String namedQuery);

	void insertQualificationDetails(
			PpEmployeequalification ppEmployeequalification);

	public List<ViewPpWholeemplist> suspensionEmployeeSearchList_ES(String sQL);

	List getEmployeeInformation(String empcode);

	List getEmployeeInformationpPayRoll(String empcode);

	List<?> getWholeOfficeListing(String rm_OfficeID);
	

}
