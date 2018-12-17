/******************************** USER DTO **************************/
/*==========================================================================
 * Description : Bean class having properties of User JSP Pages.
 * Date: 18/01/2016 
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

package com.nic.upjn.spring.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;





/** This is a simple bean class having properties of User JSP Pages including its Getter and Setter methods**/

public class UserDTO {
	
/** Properties of JSP **/
private String employeecode;


@NotEmpty
private String password;


/** Getter and setter methods **/


public String getPassword() {
	return password;
}

public String getEmployeecode() {
	return employeecode;
}

public void setEmployeecode(String employeecode) {
	this.employeecode = employeecode;
}

public void setPassword(String password) {
	this.password = password;
}



}
