package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nic.upjn.spring.dao.ServiceBookDao;
import com.nic.upjn.spring.dto.EmployeeStatusDTO;
import com.nic.upjn.spring.entity.PpEmployeequalification;
import com.nic.upjn.spring.entity.PpEmployeetraining;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewPpWholeemplist;
@SuppressWarnings("unchecked")
@Service("serviceBookService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ServiceBookServiceImplementation implements ServiceBookService {

	@Autowired
	private ServiceBookDao serviceBookDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public String createSearchSQL(String _predicate,
			EmployeeStatusDTO employeeStatusDTO) {

		System.out.println("the value of predicate in method createSearchSQl :"
				+ _predicate);
		String preSQL = "SELECT * FROM VIEW_EMPLOYEE_SEARCH "; // EMPLOYEE_INFO_VIEW
																// ";
		String PpDesignationmasterid = employeeStatusDTO
				.getPpDesignationmasterid() + "";

		String predicate = "";
		String sQL = "";

		if (employeeStatusDTO.getEmployeecode() != null
				&& !(employeeStatusDTO.getEmployeecode().trim().equals(""))) {

			predicate = predicate
					+ " lower(EMPLOYEECODE) LIKE '"
					+ (employeeStatusDTO.getEmployeecode()).toLowerCase()
							.trim() + "%' AND ";
		}
		if (employeeStatusDTO.getFirstname() != null
				&& !(employeeStatusDTO.getFirstname().trim().equals(""))) {

			predicate = predicate + " lower(FIRSTNAME) LIKE '"
					+ (employeeStatusDTO.getFirstname()).toLowerCase().trim()
					+ "%' AND ";
		}
		if (employeeStatusDTO.getLastname() != null
				&& !(employeeStatusDTO.getLastname().trim().equals(""))) {

			predicate = predicate + " lower(LASTNAME) LIKE '"
					+ (employeeStatusDTO.getLastname()).toLowerCase().trim()
					+ "%' AND ";
		}
		if (employeeStatusDTO.getPpDesignationmasterid() != null
				&& !PpDesignationmasterid.trim().equals("-1")) {

			predicate = predicate + " PP_DESIGNATIONMASTERID ='"
					+ employeeStatusDTO.getPpDesignationmasterid() + "' AND ";
		}
		if (employeeStatusDTO.getMasEmploymentsubtypeid() != null
				&& !employeeStatusDTO.getMasEmploymentsubtypeid().trim()
						.equals("-1")) {

			predicate = predicate + " mas_EmploymentSubTypeID = '"
					+ employeeStatusDTO.getMasEmploymentsubtypeid() + "' AND ";
		}
		if (employeeStatusDTO.getRmOfficeid() != null) {
			if (!employeeStatusDTO.getRmOfficeid().toString().trim().equals("")) {

				predicate = predicate + " rm_OfficeID = '" + "314" + "' AND ";
			}
		}

		// removing trailing OR

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
	public String createSearchSQL_ES(String _predicate, EmployeeStatusDTO employeeStatusDTO) {
		System.out.println("the value of predicate in method createSearchSQl :"
				+ _predicate);
		String preSQL = "SELECT * FROM VIEW_PP_WHOLEEMPLIST "; // EMPLOYEE_INFO_VIEW
																// ";
		/*String PpDesignationmasterid = employeeStatusDTO
				.getPpDesignationmasterid() + "";*/

		String predicate = "";
		String sQL = "";

		if (employeeStatusDTO.getEmployeecode() != null
				&& !(employeeStatusDTO.getEmployeecode().trim().equals(""))) {

			predicate = predicate
					+ " lower(EMPLOYEECODE) LIKE '"
					+ (employeeStatusDTO.getEmployeecode()).toLowerCase()
							.trim() + "%' AND ";
		}
		if (employeeStatusDTO.getEmployeename() != null
				&& !(employeeStatusDTO.getEmployeename().trim().equals(""))) {

			predicate = predicate + " lower(EMPLOYEENAME) LIKE '"
					+ (employeeStatusDTO.getEmployeename()).toLowerCase().trim()
					+ "%' AND ";
		}
		
		if (employeeStatusDTO.getFathername() != null
				&& !employeeStatusDTO.getFathername().trim().equals("")) {

			predicate = predicate + " lower(FATHERNAME) LIKE '"
					+ (employeeStatusDTO.getFathername()).toLowerCase().trim() + "%' AND ";
		}
		if (employeeStatusDTO.getDateofbirth() != null
				&& !employeeStatusDTO.getDateofbirth().trim()
						.equals("")) {

			predicate = predicate + " DATEOFBIRTH = '"
					+ employeeStatusDTO.getDateofbirth() + "' AND ";
		}
		

		// removing trailing OR

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
	public List<?> getList(String where_condtion, String namedQuery) {

		List<?> list;

		list = serviceBookDao.getComboList(where_condtion, namedQuery);

		return list;
	}
	
	
	public List<?> getComboList(String namedQuery) {
		List<?> list;

		list = serviceBookDao.getComboList(namedQuery);

		return list;
	}

	@Override
	public List<?> getList(int where_condtion, String namedQuery) {
		List<?> list;

		list = serviceBookDao.getComboList(where_condtion, namedQuery);

		return list;
	}

	@Override
	public List<?> getOfficeCombo(int[] where_condtion, String namedQuery) {
		List<?> list;
		list = serviceBookDao.getComboList(where_condtion, namedQuery);
		return list;
	}

	@Override
	public List<?> suspensionEmployeeSearchList(String SQL) {
		List<?> employeeSearchList = null;
		employeeSearchList = (List<ViewEmployeeSearch>) serviceBookDao
				.suspensionEmployeeSearchList(SQL);

		return employeeSearchList;
	}
	
	@Override
	public List<ViewPpWholeemplist> suspensionEmployeeSearchList_ES(String SQL) {
		List<ViewPpWholeemplist> employeeSearchList = null;
		employeeSearchList = (List<ViewPpWholeemplist>) serviceBookDao
				.suspensionEmployeeSearchList_ES(SQL);

		return employeeSearchList;
	}

	public int executeProcedureForeditEmployeePersonalDetails(
			EmployeeStatusDTO employeeStatusDTO) {
		int result = serviceBookDao
				.executeProcedureForeditEmployeePersonalDetails(employeeStatusDTO);
		return result;
	}
	
	
	public int executeProcedureForaddEmployeePromotion(EmployeeStatusDTO employeeStatusDTO)
	{
		int result = serviceBookDao
				.executeProcedureForaddEmployeePromotion(employeeStatusDTO);
		return result;
		
	}
	
	
	public void updatePermanencyInformation(Object entity)
	{
		serviceBookDao.updatePermanencyInformation(entity);
	}
	
	
	public void saveTrainingInfoEmployee(PpEmployeetraining ppEmployeetraining)
	{
		serviceBookDao.saveTrainingInfoEmployee(ppEmployeetraining);
	}

	public void insertQualificationDetails(PpEmployeequalification ppEmployeequalification)
	{
		serviceBookDao.insertQualificationDetails(ppEmployeequalification);
	}
	
	
	public List getEmployeeInformation(String empcode){
	      try{
	           return serviceBookDao.getEmployeeInformationpPayRoll(empcode);
	         }catch (Exception msqle){throw msqle; }
	   }//End Method


	@Override
	public List<?> getWholeOfficeListing(String rm_OfficeID) {
		//  try{
        return serviceBookDao.getWholeOfficeListing(rm_OfficeID);
	
	}


	
}
