/******************************** RoleManagementServiceImple Class **************************/

/*==========================================================================
 * Description 	: RoleManagementServiceImple class contains  operation for the Role Management. 
 * Date			: 01/03/2016 
 * Author		: VIKAS SINGH
 * Review By 	: 
 * Review Date	:  
 *==========================================================================
 */

/** Package Name **/
package com.nic.upjn.spring.Service;

/** Description of required classes that are used **/
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nic.upjn.security.EncryptionService;
import com.nic.upjn.spring.dao.RoleManagementDAO;
import com.nic.upjn.spring.dto.ChangePasswordDTO;
import com.nic.upjn.spring.dto.CreateUserDTO;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.ViewRmRolesforemployee;
@SuppressWarnings({"unchecked", "unused"})
@Service("roleManagementService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RoleManagementServiceImple implements RoleManagementService {

	@Autowired
	RoleManagementDAO roleManagementDAO;

	/** method for Retrieving List of Employees **/
	public List<?> selectquery(Integer key, String NamedQuery) {

		List<?> list;
		list = roleManagementDAO.selectquery(key, NamedQuery);
		return list;
	}

	/** Method for Creating New User **/
	public boolean createUser(CreateUserDTO createUserDTO) {

		boolean result = false;
		String password = md5(createUserDTO.getPassword());
		
		String encPassword = "";

		System.out.println(password);

		EncryptionService encryptionService = EncryptionService.getInstance();
		try {
			encPassword = encryptionService.encrypt(password);

			System.out.println(encPassword);

			if (encPassword.equals("")) {

			} else {
				createUserDTO.setPassword(encPassword);
			}

			result = roleManagementDAO.createUser(createUserDTO);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}

	/** Method for Deleting Password of User **/
	public boolean deleteUser(String ppEmployeemasterid) {

		boolean result = false;

		result = roleManagementDAO.deleteUser(ppEmployeemasterid);

		return result;

	}

	/** Method to Lock the Password of User **/
	@Override
	public boolean lockUser(PpEmployeemaster ppEmployeemasterlock) {

		boolean result = false;

		result = roleManagementDAO.lockUser(ppEmployeemasterlock);

		return result;
	}

	/** Method to Unlock the Password of User **/
	@Override
	public boolean unlockUser(String ppEmployeemasterid) {

		boolean result = false;

		result = roleManagementDAO.unlockUser(ppEmployeemasterid);

		return result;
	}

	/** Method for Changing the Password of User **/
	@Override
	public boolean changepassword(String ppEmployeemasterid, String newpassword) {

		boolean isComplete = false;
		String inParam[] = new String[2];
		inParam[0] = ppEmployeemasterid;
		String encPassword = "";

		try {

			EncryptionService encryptionService = EncryptionService
					.getInstance();
			encPassword = encryptionService.encrypt(md5(newpassword));
			if (encPassword.equals("")) {
				return false;
			} else {
				inParam[1] = encPassword;
				isComplete = roleManagementDAO.changePassword(inParam);
				return isComplete;
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}
		return isComplete;
	}

	@Override
	public boolean getOldPassword(String ppEmployeemasterid,
			String currentpassword) {

		@SuppressWarnings("rawtypes")
		List list = null;
		ChangePasswordDTO dto = null;
		boolean isValid = false;
		String curPassword = null;
		

		try {
			if (ppEmployeemasterid.equals("0")) {
				list = roleManagementDAO.getOldPassword(ppEmployeemasterid);

				System.out.println("listSize() = " + list.size());

				if (list != null && list.size() > 0) {
					dto = (ChangePasswordDTO) list.get(1);
				}
			}
			else
			{
				List <PpEmployeemaster>list1  = roleManagementDAO.getOldPassword(ppEmployeemasterid);
				for(PpEmployeemaster ppEmployeemaster : list1)
				{
					curPassword = ppEmployeemaster.getPassword();
				}
				
			}
			
			if (ppEmployeemasterid.equals("0")) {
				 curPassword = dto.getPassword();
			} 
			
		

			System.out.println(curPassword);

			EncryptionService encryptionService = EncryptionService
					.getInstance();
			String encpassword = encryptionService.encrypt(md5(currentpassword));

			if (encpassword.equals("")) {
				return false;
			}

			currentpassword = encpassword;

			if (curPassword != null && curPassword.equals(currentpassword)) {
				isValid = true;
			}

		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return isValid;

  }

	/** method for populating the combo on basis of  Integer Value **/
	
    @Override
	public List getList(int where_condtion, String namedQuery) {
		List list;

		list = roleManagementDAO.getComboList(where_condtion, namedQuery);

		return list;
	}

	/** method for populating the combo on basis of  String Value **/
    
	@Override
	public List getList(String where_condtion, String namedQuery) {
		List list;
		list = roleManagementDAO.getComboList(where_condtion, namedQuery);
		return list;
	}

	@Override
	public String createSearchSQL(String _predicate, CreateUserDTO createUserDTO) {
    String preSQL="SELECT * FROM rmOffice_view ";
		
		String predicate="";
		String sQL="";
		
		
if (!(createUserDTO.getOfficename().trim().equals(""))){
			
			predicate=predicate+" OFFICENAME LIKE '%"+createUserDTO.getOfficename()+"%' AND ";
		}
		if (!(createUserDTO.getMasOfficelevelid().trim().equals(""))&&(createUserDTO.getMasDistrictid().trim().equals(""))){

			predicate=predicate+" OFFICELEVEL LIKE '%"+createUserDTO.getOfficelevel()+"%' OR ";
		} 
		
		if (!(createUserDTO.getMasDistrictid().trim().equals(""))&&(createUserDTO.getMasOfficelevelid().trim().equals(""))){
		
			predicate=predicate+" DISTRICTNAME LIKE '%"+createUserDTO.getDistrictname()+"%' OR ";
		}
		if (!(createUserDTO.getMasDistrictid().trim().equals(""))&&!(createUserDTO.getMasOfficelevelid().trim().equals(""))){
			
				predicate=predicate+" OFFICELEVEL LIKE '%"+createUserDTO.getOfficelevel()+"%' AND  DISTRICTNAME LIKE '%"+createUserDTO.getDistrictname()+"%' OR ";
		}
			
		if (predicate.endsWith(" OR ")){

			int len = predicate.length();
			predicate = predicate.substring(0,len-3);
		}

		if (predicate.endsWith(" AND ")){

			int len = predicate.length();
			predicate = predicate.substring(0,len-4);
		}

		if (predicate==""){

			sQL = preSQL;

		}else{
			
			sQL = preSQL + " WHERE " + predicate;

		}
		
		return sQL;
	}			   
	

	@Override
	public List<?> serachOffices(String sQL) {
		List<?> SearchOfficeInfoList = null;
		SearchOfficeInfoList = (List<?>)roleManagementDAO
				.serachOffices(sQL);

		return SearchOfficeInfoList;
		
	}

	@Override
	public List getComboList(int where_condition, String namedQuery) {
		List list;

		list = roleManagementDAO.getComboList(where_condition, namedQuery);
		return list;
	
	}

	@Override
	public void saveNewOfficeRecord(RmOffice rmOffice) {
		roleManagementDAO.saveNewOfficeRecord(rmOffice);
		
	}

	@Override
	public void saveBasicRecordNewOffice(PpEmployeemaster ppEmployeemaster) {
		roleManagementDAO.saveBasicRecordNewOffice(ppEmployeemaster);
	}

	@Override
	public void updateNewOfficeRecord(RmOffice rmOffice) {
		roleManagementDAO.updateNewOfficeRecord(rmOffice);
	}

	@Override
	public int executeProcedureForAssignOfficeAdmin(CreateUserDTO createUserDTO) {
	    int result = roleManagementDAO.executeProcedureForAssignOfficeAdmin(createUserDTO);
		return result;
	}

	@Override
	public int executeProcedureForUpdateAssignOfficeAdmin(
			CreateUserDTO createUserDTO) {
		 int result = roleManagementDAO.executeProcedureForUpdateAssignOfficeAdmin(createUserDTO);
			return result;
		
	}

	@Override
	public int addRole(CreateUserDTO createUserDTO) {
	
		 int result = roleManagementDAO.addRole(createUserDTO);
			return result;
	}

	@Override
	public int editRole(CreateUserDTO createUserDTO) {
		 int result = roleManagementDAO.editRole(createUserDTO);
			return result;
	}

	@Override
	public int deleteRole(String rmRoleid) {
		 int result = roleManagementDAO.deleteRole(rmRoleid);
			return result;
	}

	@Override
	public List<?> getRoleLinksToAssign(Integer rmOfficeid) {
		List<?> result = roleManagementDAO.getRoleLinksToAssign(rmOfficeid);
		return result;
	}

	@Override
	public int setRoleRights(CreateUserDTO createUserDTO) {
		String rm_RoleID = createUserDTO.getRmRoleid();
		String[] menuID = createUserDTO.getRmMenuitemid();
		
		String strIds="";
		
		System.out.println("Manager Step1");
		for (int i=0;i<menuID.length;i++ ){
			strIds+=menuID[i]+"|";
		}
		
		System.out.println("Manager Step2");
		
		strIds=strIds.substring(0,strIds.length()-1);
		System.out.println("Ids"+strIds);
		System.out.println("Manager Role ID"+rm_RoleID);
        		
		int result = roleManagementDAO.setRoleRights(rm_RoleID,strIds);		
		return result;
	}
	
	public static String md5(String input) {
		String md5 = null;
		if (null == input) {
			return null;
		}
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes(), 0, input.length());
			md5 = (new BigInteger(1, digest.digest())).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
	
	public boolean checkExistanceForOffice(String value)
	{
		
		
		return roleManagementDAO.checkExistanceForOffice(value);
		
	}
	
	public boolean checkExistanceLocCode(Long value)
	{
		
		
		return roleManagementDAO.checkExistanceLocCode(value);
		
	}
	
	
	
	public List getComboList(int[] where_condtion, String namedQuery) {
		return roleManagementDAO.getComboList(where_condtion,namedQuery);
		
	}
	
	

public List<ViewRmRolesforemployee> loadObject(String ppEmployeemasterid)
	{
		return roleManagementDAO.loadObject(ppEmployeemasterid);
	}

	@Override
	public void deleteFromDB(CreateUserDTO createUserDTO) {
	     roleManagementDAO.deleteFromDB(createUserDTO);
	}




}
