
/******************************** ServiceStatusDao DAO **************************/

/*==========================================================================
 * Description : ServiceStatusDao is a simple interface standard that contains an abstract method for Service Status.   
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 *


 /** Interface for ServiceStatusDao **/
package com.nic.upjn.spring.dao;


import java.util.List;

import com.nic.upjn.spring.dto.ServiceStatusDTO;
import com.nic.upjn.spring.entity.PpCurrentstatus;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpTerminationdetail;

public interface ServiceStatusDao {

	List<?> getComboList(int where_condition, String namedQuery);

	List<?> getComboList(String where_condition, String namedQuery);

	List<?> getComboList(int[] where_condtion, String namedQuery);

	List<?> suspensionEmployeeSearchList(String SQL);

	public String[] ProcPpValidateEmpGetInfo(String employeecode,
			String Rm_OfficeId, String root, String method_Type);

	public int executeProcedureForAddSuspensionDetail(
			ServiceStatusDTO serviceStatusDTO);

	public int executeProcedureForAddTerminationDetail(
			ServiceStatusDTO serviceStatusDTO);

	public int executeProcedureForReinstateSuspentionDetails(
			ServiceStatusDTO serviceStatusDTO);

	public int executeProcedureForAddDeputationDetail(
			ServiceStatusDTO serviceStatusDTO);

	public int executeProcedureForAddResumeAfterDeputationRecord(
			ServiceStatusDTO serviceStatusDTO);

	public int executeProcedureForaddRelieveFromService(
			ServiceStatusDTO serviceStatusDTO);

	public int executeProcedureFordeleteSuspensionDetail(
			ServiceStatusDTO serviceStatusDTO);

	public void updateInformation(Object entity);

	public void updatereliveDeputationRecord(Object entity);

	public boolean insertReinstateTermDetail(PpTerminationdetail ppterminationdetail, PpCurrentstatus ppCurrentstatus,
			PpEmployeemaster ppEmployeemaster);

	boolean updateterminationdetails(PpTerminationdetail ppTerminationdetail);

	public boolean deleteterminationdetails(String ppTerminationdetailid, String employeecode);

	boolean execProc_Dele_Deputation(String ppDeputationdetailid, String ppEmployeemasterid, String ppNoduesdetailid);

}
