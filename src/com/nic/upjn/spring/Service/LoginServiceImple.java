/******************************** LOGIN SERVICEIMPLEMENTATION **************************/
/*==========================================================================
 * Description : LoginServiceImplentation class contains the service of userAuthentication
 * Date:18/01/2016
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

package com.nic.upjn.spring.Service;

import java.math.BigInteger;/** Big Integer: It is a wrapper class of INT DATA TYPE.**/
import java.security.MessageDigest;/** Message Digest : It is used for ENCRIPTION and DECRIPTION purpose **/
import java.security.NoSuchAlgorithmException;/** NosuchAlgorithmException: Used for throwing exceptions when algorithm is not found. **/
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; /**  automatically made the object and set the object into the private variable  **/
import org.springframework.stereotype.Service; /** @Service Annotation used for making a service class   **/
import org.springframework.transaction.annotation.Propagation; /** PROPOGATION: Automatically manages the transactions **/
import org.springframework.transaction.annotation.Transactional;/**Annotation.Transactional : Used for managing the objects of session and session Factory.**/







import com.nic.upjn.security.EncryptionService;
import com.nic.upjn.spring.dao.LoginDao;
import com.nic.upjn.spring.entity.ViewRmGetlinkstoassign;
import com.nic.upjn.spring.entity.ViewRmGettopinfo;

/**LoginDao : It is a user define interface containing abstract method named checkLogin.**/

/**
 * @Transactional annotation automatically manages the HIBERNATE transaction
 **/

@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImple implements LoginService {

	
	/**
	 * automatically made the object and set the object into the private
	 * variable
	 **/

	@Autowired
	private LoginDao loginDao;

	boolean isValid = false;
	public static HashMap<String, String> hm ;

	/** This method is used for userAuthentication of application user **/


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean userAuthentication(String employeecode, String password,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(20 * 60);

         hm = new HashMap<String, String>();
		if (employeecode != null && password != null) {

			String Password = md5(password);
			String encPassword = "";
			String employeename = null;
			String designation = null ;

			EncryptionService encryptionService = EncryptionService
					.getInstance();
			encPassword = encryptionService.encrypt(Password);

			if (employeecode.equalsIgnoreCase("ADMIN")
					&& encPassword.equalsIgnoreCase(loginDao.getAdminpassword(
							"admin", "Admin.findByAdminname"))) {

				System.out.println("Admin login");
				hm.put("ppEmployeemasterid", "0");
				hm.put("isCompleted", "1");
				session.setAttribute("ppEmployeemasterid", "0");
				session.setAttribute("employeecode", "admin");

			}
			
			else if(employeecode.equalsIgnoreCase("ADMIN")
					&& !(encPassword.equalsIgnoreCase(loginDao.getAdminpassword(
							"admin", "Admin.findByAdminname")))){
				
				System.out.println(isValid);
				isValid = false;
				//System.out.println(isValid);
			}

			else if (employeecode.equalsIgnoreCase("SBADM")
					&& encPassword.equalsIgnoreCase(loginDao.getAdminpassword(
							"sbadm", "Admin.findByAdminname"))) {

				System.out.println("SBADM login");
				hm.put("ppEmployeemasterid", "1");
				hm.put("isCompleted", "1");
				session.setAttribute("ppEmployeemasterid", "1");
				session.setAttribute("employeecode", "sbadm");
			}

			else if (employeecode.equalsIgnoreCase("CEZONE36")
					&& encPassword.equalsIgnoreCase(loginDao.getAdminpassword(
							"cezone36", "Admin.findByAdminname"))) {

				System.out.println("CEZONE36 login");
				hm.put("ppEmployeemasterid", "2");
				hm.put("isCompleted", "1");
				session.setAttribute("ppEmployeemasterid", "2");
				session.setAttribute("employeecode", "cezone36");
			}

			else {
				hm = loginDao.checkLogin(employeecode, encPassword);
				
				if(hm.get("ppEmployeemasterid")!=null)
				{
					isValid = true;
					List<ViewRmGettopinfo> list = (List<ViewRmGettopinfo>)getList(employeecode, "ViewRmGettopinfo.findByEmployeecode");
					for(ViewRmGettopinfo viewRmGettopinfo : list)
					{
						employeename = viewRmGettopinfo.getEmployeename();
				      
						 designation  = viewRmGettopinfo.getDesignation();
					}
	                System.out.println(employeecode+"  -------  "+designation+"size of list - " + list.size());
					session.setAttribute("employeename", employeename);
					session.setAttribute("designation", designation);
					session.setAttribute("ppEmployeemasterid", hm.get("ppEmployeemasterid"));
					session.setAttribute("rmOfficeid", Integer.parseInt(hm.get("rm_OfficeID")));	
					session.setAttribute("employeecode", employeecode);	
				}
				
			}
		}
		if (hm.get("isCompleted").toString().equals("1")) {
			isValid = true;
		}
		return isValid;
	}

	/** This method is used for encryption of password (MD5) **/

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

	public static LoginServiceImple getInstance() {

		return new LoginServiceImple();
	}

	@Override
	public String getLinksForTree(String ppEmployeemasterid) {
		
		

		String innerHtml="";
		
		int curLevel=0;
		int prevLevel=0;
		String[] inParam = new String[2];
		boolean isShown=true;
		
		List<ViewRmGetlinkstoassign> list = (List<ViewRmGetlinkstoassign>)loginDao
				.getRoleLinksToAssign(Integer.parseInt(ppEmployeemasterid));
		
		System.out.println("New Debug----1");
		if (list != null) {
            System.out.println("New Debug----2");
			innerHtml=innerHtml+"<script language='javascript'>"+
			"var TREE_ITEMS = [";
			int listSize=list.size();
			int j=0;

			for(int i=0;i<listSize;i++){
			
				ViewRmGetlinkstoassign dto = (ViewRmGetlinkstoassign) list.get(i);
						
				
				
				inParam[0] = ppEmployeemasterid;	
				inParam[1] = dto.getRmMenuitemid()+"";

				if(isShown) {
					
					if (i>0) {
						
						int k=i-j;
						if (k>0){
						
							ViewRmGetlinkstoassign dtoPrev = (ViewRmGetlinkstoassign) list.get(k-1);
						curLevel = Integer.parseInt(dto.getLinklevel()+"");
						prevLevel = Integer.parseInt(dtoPrev.getLinklevel()+"");
						
						if (curLevel == prevLevel) {

							innerHtml=innerHtml+"],";
						} else if (curLevel<prevLevel) {

							innerHtml=innerHtml+"],\n";
							for (int ii=0;ii<prevLevel-curLevel;ii++)	{
								
								innerHtml=innerHtml+"],\n";

							} 
							
						} else {

							innerHtml=innerHtml+",";

						} // end if-else
					} // end if 
					
				}

					if(dto.getQuerystring() != null) {
		                 
						if (dto.getLinks() != null)	{
							
							innerHtml=innerHtml+"['"+dto.getMenuname().trim()+"','"+dto.getLinks()+"'";

						} else {
						
							innerHtml=innerHtml+"['"+dto.getMenuname().trim()+"',null";
						} // end nested if
						
					} else {

						if (dto.getLinks() != null)	{
	                       
							innerHtml=innerHtml+"['"+dto.getMenuname().trim()+"','"+dto.getLinks()+"'";
						} else {
						
							innerHtml=innerHtml+"['"+dto.getMenuname().trim()+"',null";

						}// end nested if

					} // end nested if

					j=0;

				} else {

					j++;
					//System.out.println("In else "+j);
				}

			} // end nested if

		} // end if
			
		innerHtml=innerHtml+"],";
		for (int i=0;i<curLevel-2;i++) {
		
			innerHtml=innerHtml+"],";
		} // end for
		innerHtml=innerHtml+"]\n];";		
		
		innerHtml=innerHtml+"new tree (TREE_ITEMS, tree_tpl);\n</script>";

		//System.out.println("innerHtml = " + innerHtml);

		return innerHtml;
	 
 }

	@Override
	public List getList(String where_condtion, String namedQuery) {
		
		List list;

		list = loginDao.getComboList(where_condtion, namedQuery);

		return list;
	}
	}


