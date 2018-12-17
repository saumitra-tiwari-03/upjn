/******************************** EmployeeAppointmentServiceImple Class **************************/

/*==========================================================================
 * Description : EmployeeAppointmentServiceImple class contains the database operation for the Employee Appointment. 
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

package com.nic.upjn.spring.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nic.upjn.spring.dao.EmployeeAppointmentDao;
import com.nic.upjn.spring.dto.EmployeePostingDTO;
import com.nic.upjn.spring.entity.PpEmployeeappointmentdetail;
import com.nic.upjn.spring.entity.PpEmployeedetail;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpEmployeepaydetail;
import com.nic.upjn.spring.entity.PpEmployeepersonaldetail;
import com.nic.upjn.spring.entity.PpPostingdetail;

/** Description of required classes that are used **/
@SuppressWarnings({ "rawtypes" })

@Service("employeeAppointmentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeAppointmentServiceImple implements EmployeeAppointmentService {

	@Autowired
	private EmployeeAppointmentDao employeeAppointmentDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	/** This method is calling DAO for inserting records **/
	public void addEmployeeAppointment(ArrayList<Object> entity, Long long1, String string) {

		Iterator<Object> iterator = entity.iterator();

		while (iterator.hasNext()) {
			employeeAppointmentDao.addEmployeeAppointment(iterator.next(), long1, string);

		}

	}

	public List<PpEmployeemaster> listEmployeess() {
		return employeeAppointmentDao.listEmployeess();
	}

	public PpEmployeemaster getEmployeeAppointment(int ppEmployeemasterid) {
		return employeeAppointmentDao.getEmployee(ppEmployeemasterid);
	}

	public void deleteEmployee(PpEmployeemaster ppEmployeemaster) {
		employeeAppointmentDao.deleteEmployeeAppointment(ppEmployeemaster);
	}

	/**
	 * method for populating the record on the basis of single String where
	 * condition
	 **/
	public List getList(String where_condtion, String namedQuery) {

		List list;

		list = employeeAppointmentDao.getComboList(where_condtion, namedQuery);

		return list;

	}

	/** method for populating the combo where the condition is Integer Array **/
	@Override
	public List getOfficeCombo(int[] where_condtion, String namedQuery) {
		List list;

		list = employeeAppointmentDao.getComboList(where_condtion, namedQuery);
		return list;
	}

	/** This method convert list into DTO object **/
	public Object convListToDTO(List list) {

		Object retDTO = null;
		try {

			ListIterator iterator = list.listIterator();
			while (iterator.hasNext()) {

				retDTO = iterator.next();
			}

		} catch (Exception e) {
		}

		return retDTO;

	}

	/** method for populating the combo on basis of Integer Value **/

	@Override
	public List getList(int where_condtion, String namedQuery) {

		List list;

		list = employeeAppointmentDao.getComboList(where_condtion, namedQuery);

		return list;

	}

	/** Called procedure for Employee Posting **/
	public int executeProcedure(EmployeePostingDTO employeePostingDTO) {
		int result;

		result = employeeAppointmentDao.executeProcedure(employeePostingDTO);

		return result;

	}

	/** Called Procedure for Add Joining Details for New Employee **/
	public int executeProcedureForADDJOININGDETAIL(EmployeePostingDTO employeePostingDTO) {
		int result;

		result = employeeAppointmentDao.executeProcedureForADDJOININGDETAIL(employeePostingDTO);

		return result;

	}

	/** Update Employee Posting Details On the Basis of Pp_PostingDetailID **/

	public int updatePostingDetailsInfo(PpPostingdetail ppPostingdetail, PpEmployeemaster ppEmployeemaster){
	int a=	employeeAppointmentDao.updatePostingDetailsInfo(ppPostingdetail,  ppEmployeemaster);

		return a;
	}

	@Override
	public boolean deletePostingDetail(String ppPostingdetailid, String ppEmployeemasterid, String postingagainst) {
		boolean result;

		result = employeeAppointmentDao.deletePostingDetails(ppPostingdetailid, ppEmployeemasterid, postingagainst);

		return result;

	}

	@Override
	public List<PpEmployeemaster> listofempcodes(String namedquery) {
		List list = null;

		list = employeeAppointmentDao.listofempcodes(namedquery);

		return list;
	}

	@Override
	public Boolean checkEmployeecodeExistance(String employeecode, String ppEmployeemasterid, String method) {
		boolean isExists = false;
		String _employeecode = "";
		List list = null;
		PpEmployeemaster ppEmployeemaster = new PpEmployeemaster();

		if (method.equals("add")) {

			isExists = employeeAppointmentDao.checkEmployeecodeExistance(employeecode);
		} 
		else if (method.equals("edit")) {

			list = employeeAppointmentDao.getEmployeeMaster(ppEmployeemasterid,
					"PpEmployeemaster.findByPpEmployeemasterid");
			if (list != null) {
				if (list.size() > 0) {

					ppEmployeemaster = (PpEmployeemaster) list.get(0);
					_employeecode = ppEmployeemaster.getEmployeecode();

					if (!_employeecode.equals(employeecode)) {
						isExists = employeeAppointmentDao.checkEmployeecodeExistance(employeecode);

					}

				}
			}

		}
		return isExists;
	}

	@Override
	public Boolean insertNewEmployeeintoDB(PpEmployeemaster ppEmployeemaster,
			PpEmployeepersonaldetail ppEmployeepersonaldetail, PpEmployeeappointmentdetail ppEmployeeappointmentdetail,
			PpEmployeedetail ppEmployeedetail, PpEmployeepaydetail ppEmployeepaydetail) {
		
		boolean isComplete = false;
		
		try{
			isComplete = employeeAppointmentDao.insertNewEmployeeintoDB(ppEmployeemaster,ppEmployeepersonaldetail,ppEmployeeappointmentdetail,ppEmployeedetail,ppEmployeepaydetail);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return isComplete;
		
	}

	@Override
	public Boolean editAppointment(PpEmployeemaster ppEmployeemaster, PpEmployeepersonaldetail ppEmployeepersonaldetail,
			PpEmployeeappointmentdetail ppEmployeeappointmentdetail, PpEmployeedetail ppEmployeedetail,
			PpEmployeepaydetail ppEmployeepaydetail) {
		
		boolean iscomplete ;
		
		iscomplete = employeeAppointmentDao.editAppointment(ppEmployeemaster,ppEmployeepersonaldetail,ppEmployeeappointmentdetail,ppEmployeedetail,ppEmployeepaydetail);
		
		return iscomplete;
	}

}
