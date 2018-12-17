/******************************** ServiceStatusImplementation Class **************************/

/*==========================================================================
 * Description : ServiceStatusImplementation class contains the database operation for the Service Status. 
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */


package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nic.upjn.spring.dao.ServiceStatusDao;
import com.nic.upjn.spring.dto.RelieveELDTO;
import com.nic.upjn.spring.dto.RelieveEmployeeDTO;
import com.nic.upjn.spring.dto.SearchEmployeeDTO;
import com.nic.upjn.spring.dto.ServiceStatusDTO;
import com.nic.upjn.spring.entity.PpCurrentstatus;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpTerminationdetail;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;

/** Description of required classes that are used **/


@Service("serviceStatusService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ServiceStatusImplementation implements ServiceStatusService {

	@Autowired
	private ServiceStatusDao serviceStatusDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public String createSearchSQL(String _predicate,Object obj, Integer rmofficeid){

		System.out.println("the value of predicate in method createSearchSQl :"
				+ _predicate);
	
		String preSQL = "SELECT * FROM VIEW_EMPLOYEE_SEARCH ";
		String predicate = "";
		String sQL = "";
		String employeecode = null;
		String firstname = null;
		String lastname = null;
		String pp_designationmasterID = null;
		String mas_employmentsubtypeID = null;
		
		if(obj instanceof ServiceStatusDTO){ 
			ServiceStatusDTO serviceStatusDTO = (ServiceStatusDTO)obj;
			
			 employeecode = serviceStatusDTO.getEmployeecode();
			 firstname = serviceStatusDTO.getFirstname();
			 lastname = serviceStatusDTO.getLastname();
			 pp_designationmasterID = serviceStatusDTO.getPpDesignationmasterid().toString();
			 mas_employmentsubtypeID = serviceStatusDTO.getMasEmploymentsubtypeid();
		}

		if (employeecode != null
				&& !(employeecode.trim().equals(""))) {

			predicate = predicate
					+ " lower(EMPLOYEECODE) LIKE '"
					+ (employeecode).toLowerCase()
							.trim() + "%' AND ";
		}
		if (firstname != null
				&& !(firstname.trim().equals(""))) {

			predicate = predicate + " lower(FIRSTNAME) LIKE '"
					+ (firstname).toLowerCase().trim()
					+ "%' AND ";
		}
		if (lastname != null
				&& !(lastname.trim().equals(""))) {

			predicate = predicate + " lower(LASTNAME) LIKE '"
					+ (lastname).toLowerCase().trim()
					+ "%' AND ";
		}
		if (pp_designationmasterID != null
				&& !pp_designationmasterID.trim()
						.equals("-1")) {

			predicate = predicate + " PP_DESIGNATIONMASTERID ='"
					+ pp_designationmasterID + "' AND ";
		}
		if (mas_employmentsubtypeID != null
				&& !mas_employmentsubtypeID.trim()
						.equals("-1")) {

			predicate = predicate + " mas_EmploymentSubTypeID = '"
					+ mas_employmentsubtypeID + "' AND ";
		}
		if (rmofficeid != null) {
			if (!rmofficeid.toString().trim().equals("")) {

				/** The rm_office id should be changed from static(314) to dynamic ***/
			
				predicate = predicate + " rm_OfficeID = '" + rmofficeid + "' AND ";
			}
		}

		if (predicate.endsWith(" AND ")) {

			int len = predicate.length();
			predicate = predicate.substring(0, len - 4);
		}

		if (predicate == "") {

			sQL = preSQL;

			if (!(_predicate.equals(""))) {

				sQL = sQL + " WHERE " + _predicate;
			}

		} else {

			sQL = preSQL + " WHERE " + predicate;

			if (!(_predicate.equals(""))) {

				sQL = sQL + " AND " + _predicate;
			}
		}

		return sQL;
	}

	@Override
	public List<?> getList(int where_condtion, String namedQuery) {

		List<?> list;

		list = serviceStatusDao.getComboList(where_condtion, namedQuery);

		return list;

	}

	/** Populating Combo when Condition dataType is String **/
  public List<?> getList(String where_condtion, String namedQuery) {

		List<?> list;

		list = serviceStatusDao.getComboList(where_condtion, namedQuery);

		return list;

	}

 /** Populating Combo when Condition dataType is Integer Array **/
	@Override
	public List<?> getOfficeCombo(int[] where_condtion, String namedQuery) {
		List<?> list;

		list = serviceStatusDao.getComboList(where_condtion, namedQuery);
		return list;
	}

	
 /** Get Employee Search List for suspension Employee **/
    @SuppressWarnings("unchecked")
	@Override
	public List<?> suspensionEmployeeSearchList(String SQL) {

		List<?> employeeSearchList = null;
		employeeSearchList = (List<ViewEmployeeSearch>) serviceStatusDao
				.suspensionEmployeeSearchList(SQL);

		return employeeSearchList;

	}
	/** Executing procedure for ProcPpValidateEmpGetInfo for getting EmployeeInfo **/

	public String[] ProcPpValidateEmpGetInfo(String employeecode,
			String Rm_OfficeId, String root, String method_Type) {
		String employeeInfo[] = serviceStatusDao.ProcPpValidateEmpGetInfo(
				employeecode, Rm_OfficeId, root, method_Type);
		return employeeInfo;

	}

   /** Executing procedure for AddSuspensionDetail  **/
    public int executeProcedureForAddSuspensionDetail(
			ServiceStatusDTO serviceStatusDTO) {
		int result = serviceStatusDao
				.executeProcedureForAddSuspensionDetail(serviceStatusDTO);
		return result;

	}

    /** Executing procedure for TerminationDetail  **/
    public int executeProcedureForAddTerminationDetail(
			ServiceStatusDTO serviceStatusDTO) {
		int result = serviceStatusDao
				.executeProcedureForAddTerminationDetail(serviceStatusDTO);
		return result;
	}

    /** Executing procedure for SuspentionDetails **/
    public int executeProcedureForReinstateSuspentionDetails(
			ServiceStatusDTO serviceStatusDTO) {
		int result = serviceStatusDao
				.executeProcedureForReinstateSuspentionDetails(serviceStatusDTO);
		return result;
	}

    /** Executing procedure for AddDeputationDetail **/
     public int executeProcedureForAddDeputationDetail(
			ServiceStatusDTO serviceStatusDTO) {
		int result = serviceStatusDao
				.executeProcedureForAddDeputationDetail(serviceStatusDTO);
		return result;
	}

     /** Executing procedure for AddResumeAfterDeputationRecord **/
    public int executeProcedureForAddResumeAfterDeputationRecord(
			ServiceStatusDTO serviceStatusDTO) {
		int result = serviceStatusDao
				.executeProcedureForAddResumeAfterDeputationRecord(serviceStatusDTO);
		return result;
	}
   
    /** Executing procedure for AddaddRelieveFromService **/
    public int executeProcedureForaddRelieveFromService(
			ServiceStatusDTO serviceStatusDTO) {
		int result = serviceStatusDao
				.executeProcedureForaddRelieveFromService(serviceStatusDTO);
		return result;
	}

    /** Executing procedure for deleteSuspensionDetail **/
    public int executeProcedureFordeleteSuspensionDetail(
			ServiceStatusDTO serviceStatusDTO) {
		int result = serviceStatusDao
				.executeProcedureFordeleteSuspensionDetail(serviceStatusDTO);
		return result;

	}

    /** updateInformation of employee **/
    public void updateInformation(Object entity) {
		serviceStatusDao.updateInformation(entity);
	}

    /** updateInformation of DeputationRecord **/
    public void updatereliveDeputationRecord(Object entity) {
		serviceStatusDao.updatereliveDeputationRecord(entity);
	}

	@Override
	public boolean insertReinstateTermDetail(PpTerminationdetail ppterminationdetail, PpCurrentstatus ppCurrentstatus,
			PpEmployeemaster ppEmployeemaster) {
		boolean result = false;
		
		result = serviceStatusDao.insertReinstateTermDetail(ppterminationdetail,ppCurrentstatus,ppEmployeemaster);
				
		return result;
	}

	@Override
	public boolean updateterminationdetails(PpTerminationdetail ppTerminationdetail) {
boolean result = false;
		
		result = serviceStatusDao.updateterminationdetails(ppTerminationdetail);
				
		return result;
	}

	@Override
	public boolean deleteterminationdetails(String ppTerminationdetailid, String ppEmployeemasterid) {
boolean result = false;
		
		result = serviceStatusDao.deleteterminationdetails(ppTerminationdetailid,ppEmployeemasterid);
				
		return result;
	}

	@Override
	public boolean execProc_Dele_Deputation(String ppDeputationdetailid, String ppEmployeemasterid,
			String ppNoduesdetailid) {
boolean result = false;
		
		result = serviceStatusDao.execProc_Dele_Deputation(ppDeputationdetailid,ppEmployeemasterid,ppNoduesdetailid);
				
		return result;
	}

}
