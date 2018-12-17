/******************************** ROLE MANAGEMENT SERVICE **************************/

/*==========================================================================
 * Description  : RoleManagementService is a simple interface standard that contains an abstract method  for Role Management operations.   
 * Date			: 01/03/2016 
 * Author		: VIKAS SINGH
 * Review By 	: 
 * Review Date	:  
 *==========================================================================
 *

 /** Interface for RoleManagement **/

/** Package Name **/
package com.nic.upjn.spring.Service;

/** Description of required classes that are used **/
import java.util.List;

import com.nic.upjn.spring.dto.CreateUserDTO;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.RmofficeView;
import com.nic.upjn.spring.entity.ViewRmRolesforemployee;

public interface RoleManagementService {

	public List<?> selectquery(Integer rmOfficeid, String NamedQuery);

	public boolean createUser(CreateUserDTO createUserDTO);

	public boolean deleteUser(String ppEmployeemasterid);

	public boolean lockUser(PpEmployeemaster ppEmployeemasterlock);

	public boolean unlockUser(String ppEmployeemasterid);

	public boolean changepassword(String ppEmployeemasterid, String newpassword);

	public boolean getOldPassword(String ppEmployeemasterid, String currentpassword);
	public List getList(int where_condtion, String namedQuery);

	public List getList(String where_condtion, String namedQuery);

	public String createSearchSQL(String string, CreateUserDTO createUserDTO);

	public List<?> serachOffices(String sQL);
	public List getComboList(int where_condition, String namedQuery);
	public void saveNewOfficeRecord(RmOffice rmOffice);

	public void saveBasicRecordNewOffice(PpEmployeemaster ppEmployeemaster);
	
	
	public List<ViewRmRolesforemployee> loadObject(String ppEmployeemasterid);

	public void deleteFromDB(CreateUserDTO createUserDTO);



	public void updateNewOfficeRecord(RmOffice rmOffice);

	public int executeProcedureForAssignOfficeAdmin(CreateUserDTO createUserDTO);

	public int executeProcedureForUpdateAssignOfficeAdmin(
			CreateUserDTO createUserDTO);

	public int addRole(CreateUserDTO createUserDTO);

	public int editRole(CreateUserDTO createUserDTO);

	public int deleteRole(String rmRoleid);

	

	public List<?>  getRoleLinksToAssign(Integer rmOfficeid);

	public int setRoleRights(CreateUserDTO createUserDTO);
	public boolean checkExistanceForOffice(String value);

	public boolean checkExistanceLocCode(Long locCode);

	
	public List getComboList(int[] where_condtion, String namedQuery) ;

}
