/******************************** DTO FOR CHANGING PASSWORDS **************************/
/*==========================================================================
 * Description	 : Bean class having properties of User JSP Pages.
 * Date			 : 
 * Author		 : VIKAS SINGH
 * Review By 	 : 
 * Review Date	 :  
 *==========================================================================
 */

package com.nic.upjn.spring.dto;

/** Imports required number of classes that are used in this particular class **/
import java.util.List;

/** This is a simple bean class having properties of User JSP Pages including its Getter and Setter methods**/

@SuppressWarnings("unused")
public class ChangePasswordDTO {

	private String ppEmployeemasterid;
	private String currentpassword;
	private String newpassword;
	private String Confirmpassword;
	private String password;


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(String ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getCurrentpassword() {
		return currentpassword;
	}

	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return Confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.Confirmpassword = confirmpassword;
	}

}
