
/******************************** ServiceStatus Service**************************/

/*==========================================================================
 * Description : ServiceStatusService is a simple interface standard that contains an abstract method  for Service Status of Employee.   
 * Date:  
 * Author: VIKASH SINGH
 * Review By : 
 * Review Date:  
 *==========================================================================
 *


 /** Interface for ServiceStatus **/

package com.nic.upjn.spring.Service;

import java.util.List;

import com.nic.upjn.spring.dto.ServiceStatusDTO;
import com.nic.upjn.spring.entity.PpCurrentstatus;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpTerminationdetail;

public interface ServiceStatusService {

	public String createSearchSQL(String _predicate,Object obj, Integer rmofficeid);

	public List<?> getList(String where_condtion, String namedQuery);

	public List<?> getList(int where_condtion, String namedQuery);

	public List<?> getOfficeCombo(int[] where_condtion, String namedQuery);

	public List<?> suspensionEmployeeSearchList(String SQL);

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

	public boolean updateterminationdetails(PpTerminationdetail ppTerminationdetail);

	public boolean deleteterminationdetails(String ppTerminationdetailid, String ppEmployeemasterid);

	public boolean execProc_Dele_Deputation(String ppDeputationdetailid, String ppEmployeemasterid,
			String ppNoduesdetailid);



}
