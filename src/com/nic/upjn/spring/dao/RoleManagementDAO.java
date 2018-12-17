/******************************** RoleManagementDAO Dao**************************/

/*==========================================================================
 * Description  : RoleManagementDAO is a simple interface standard that contains an abstract method for RoleManagement.   
 * Date			: 01/03/2016 
 * Author		: VIKAS SINGH
 * Review By 	: 
 * Review Date	:  
 *==========================================================================
 *

 /** Interface for RoleManagementDAO **/

/** Package Name **/
package com.nic.upjn.spring.dao;

/** Description of required classes that are used **/
import java.util.List;

import com.nic.upjn.spring.dto.CreateUserDTO;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;
import com.nic.upjn.spring.entity.ViewRmRolesforemployee;

@SuppressWarnings("rawtypes")
public interface RoleManagementDAO {
	

	public List<ViewRmRolesforemployee> loadObject(String ppEmployeemasterid);

	public void deleteFromDB(CreateUserDTO createUserDTO);

	public List<?> selectquery(Integer key, String NamedQuery);

	public boolean createUser(CreateUserDTO createUserDTO);

	public boolean deleteUser(String ppEmployeemasterid);

	public boolean lockUser(PpEmployeemaster ppEmployeemasterlock);

	public boolean unlockUser(String ppEmployeemasterid);

	public boolean setPassword(String[] inParam);

	public boolean changePassword(String[] inParam);

	public List getOldPassword(String ppEmployeemasterid);
	public List getComboList(int where_condtion, String namedQuery);

	public List getComboList(String where_condtion, String namedQuery);

	public List<?> serachOffices(String sQL);

	public void saveNewOfficeRecord(RmOffice rmOffice);

	public void saveBasicRecordNewOffice(PpEmployeemaster ppEmployeemaster);

	public void updateNewOfficeRecord(RmOffice rmOffice);

	public int executeProcedureForAssignOfficeAdmin(CreateUserDTO createUserDTO);

	public int executeProcedureForUpdateAssignOfficeAdmin(
			CreateUserDTO createUserDTO);

	public int addRole(CreateUserDTO createUserDTO);

	public int editRole(CreateUserDTO createUserDTO);

	public int deleteRole(String rmRoleid);

	public List<?> getRoleLinksToAssign(Integer rmOfficeid);

	public int setRoleRights(String rm_RoleID, String strIds);


	public boolean checkExistanceForOffice(String value);


	public boolean checkExistanceLocCode(Long value);
	
	public List getComboList(int[] where_condtion, String namedQuery) ;
	

	
}
