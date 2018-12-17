/******************************** EmployeeAppointmentService **************************/

/*==========================================================================
 * Description : EmployeeAppointmentService is a simple interface standard that contains an abstract method  for New Employee Appointment.   
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 *


 /** Interface for EmployeeAppointmentService **/

package com.nic.upjn.spring.Service;

import java.util.ArrayList;
import java.util.List;

import com.nic.upjn.spring.dto.EmployeePostingDTO;
import com.nic.upjn.spring.entity.*;
@SuppressWarnings("rawtypes")
public interface EmployeeAppointmentService {

	public void addEmployeeAppointment(ArrayList<Object> entity, Long long1,
			String string);

	public List<PpEmployeemaster> listEmployeess();

	public PpEmployeemaster getEmployeeAppointment(int ppEmployeemasterid);

	public void deleteEmployee(PpEmployeemaster ppEmployeemaster);

	public List getList(String where_condtion, String namedQuery);

	public List getList(int where_condtion, String namedQuery);

	public Object convListToDTO(List list);

	public List getOfficeCombo(int[] where_condtion, String namedQuery);

	public int executeProcedure(EmployeePostingDTO employeePostingDTO);

	public int executeProcedureForADDJOININGDETAIL(
			EmployeePostingDTO employeePostingDTO);

	public int updatePostingDetailsInfo(PpPostingdetail ppPostingdetail, PpEmployeemaster ppEmployeemaster);

	public boolean deletePostingDetail(String ppPostingdetailid, String ppEmployeemasterid, String postingagainst);

	public List<PpEmployeemaster> listofempcodes(String namedquery);

	public Boolean checkEmployeecodeExistance(String employeecode, String ppEmployeemasterid, String method);

	public Boolean insertNewEmployeeintoDB(PpEmployeemaster ppEmployeemaster,
			PpEmployeepersonaldetail ppEmployeepersonaldetail, PpEmployeeappointmentdetail ppEmployeeappointmentdetail,
			PpEmployeedetail ppEmployeedetail, PpEmployeepaydetail ppEmployeepaydetail);

	public Boolean editAppointment(PpEmployeemaster ppEmployeemaster, PpEmployeepersonaldetail ppEmployeepersonaldetail,
			PpEmployeeappointmentdetail ppEmployeeappointmentdetail, PpEmployeedetail ppEmployeedetail,
			PpEmployeepaydetail ppEmployeepaydetail);
}