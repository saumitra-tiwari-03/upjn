
/******************************** Employee Appointment Dao**************************/

/*==========================================================================
 * Description : EmployeeAppointmentDao is a simple interface standard that contains an abstract method named checkLogin() used for login purpose.   
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 *


 /** Interface for EmployeeAppointmentDao **/
package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.dto.EmployeePostingDTO;
import com.nic.upjn.spring.entity.PpEmployeeappointmentdetail;
import com.nic.upjn.spring.entity.PpEmployeedetail;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.PpEmployeepaydetail;
import com.nic.upjn.spring.entity.PpEmployeepersonaldetail;
import com.nic.upjn.spring.entity.PpPostingdetail;

@SuppressWarnings({ "rawtypes"})
public interface EmployeeAppointmentDao {

	public void addEmployeeAppointment(Object object, Long long1, String string);

	public List<PpEmployeemaster> listEmployeess();

	public PpEmployeemaster getEmployee(int empid);

	public void deleteEmployeeAppointment(PpEmployeemaster ppEmployeemaster);

	public List getComboList(String where_condition, String namedQuery);

	public List getComboList(int where_condition, String namedQuery);

	public List getComboList(int[] where_condtion, String namedQuery);

	public int executeProcedure(EmployeePostingDTO employeePostingDTO);

	public int executeProcedureForADDJOININGDETAIL(
			EmployeePostingDTO employeePostingDTO);

	public int updatePostingDetailsInfo(PpPostingdetail ppPostingdetail, PpEmployeemaster ppEmployeemaster);


	public boolean deletePostingDetails(String ppPostingdetailid, String ppEmployeemasterid,String postingagainst);

	public List listofempcodes(String namedquery);

	public boolean checkEmployeecodeExistance(String employeecode);

	public List getEmployeeMaster(String ppEmployeemasterid,String namedQuery);

	public boolean insertNewEmployeeintoDB(PpEmployeemaster ppEmployeemaster,
			PpEmployeepersonaldetail ppEmployeepersonaldetail, PpEmployeeappointmentdetail ppEmployeeappointmentdetail,
			PpEmployeedetail ppEmployeedetail, PpEmployeepaydetail ppEmployeepaydetail);

	public boolean editAppointment(PpEmployeemaster ppEmployeemaster, PpEmployeepersonaldetail ppEmployeepersonaldetail,
			PpEmployeeappointmentdetail ppEmployeeappointmentdetail, PpEmployeedetail ppEmployeedetail,
			PpEmployeepaydetail ppEmployeepaydetail);

}