/******************************** DTO TO CREATE USER **************************/
/*==========================================================================
 * Description	 : Bean class having properties of User JSP Pages.
 * Date			 : 
 * Author		 : VIKAS SINGH
 * Review By     : 
 * Review Date   :  
 *==========================================================================
 */

package com.nic.upjn.spring.dto;



/** This is a simple bean class having properties of User JSP Pages including its Getter and Setter methods**/

public class CreateUserDTO {

	
	/** rmloginroleID property */
	private String rmloginroleID;

	/** rmroleID property */ 
	private String rmRoleid;

	/**	Roles Array	*/
 	private String[] roles;

	/** password property */ 
	 private String password;

	/** conPassword property */ 
 	
 	 
 	/** ppEmployeemasterid property */ 
 	private String ppEmployeemasterid;
 	private String officelevel;
 	
 	private String officename;
 	private String officeaddress;
 	private Integer rmOfficeid;
 	private String districtname;
 
 	
 	private String masOfficelevelid;
 	
 	private String masDistrictid;
 	
 	
	private String fax;
 	private String phno2;
 	private String phno1;
 	private Long ppPlacemasterid;
 	private Long locCode;
 	private Integer PARENTOFFICEID;
 	private String Confirmpassword;
 	private String rolename;
 	private String [] rmMenuitemid;
 	private String officeNameID;
 	

	

	
	public String getOfficeNameID() {
		return officeNameID;
	}

	public void setOfficeNameID(String officeNameID) {
		this.officeNameID = officeNameID;
	}

	public String[] getRmMenuitemid() {
		return rmMenuitemid;
	}

	public void setRmMenuitemid(String[] rmMenuitemid) {
		this.rmMenuitemid = rmMenuitemid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getConfirmpassword() {
		return Confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		Confirmpassword = confirmpassword;
	}

	public Integer getPARENTOFFICEID() {
		return PARENTOFFICEID;
	}

	public void setPARENTOFFICEID(Integer pARENTOFFICEID) {
		PARENTOFFICEID = pARENTOFFICEID;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPhno2() {
		return phno2;
	}

	public void setPhno2(String phno2) {
		this.phno2 = phno2;
	}

	public String getPhno1() {
		return phno1;
	}

	public void setPhno1(String phno1) {
		this.phno1 = phno1;
	}

	public Long getPpPlacemasterid() {
		return ppPlacemasterid;
	}

	public void setPpPlacemasterid(Long ppPlacemasterid) {
		this.ppPlacemasterid = ppPlacemasterid;
	}

	public Long getLocCode() {
		return locCode;
	}

	public void setLocCode(Long locCode) {
		this.locCode = locCode;
	}

	public String getMasOfficelevelid() {
		return masOfficelevelid;
	}

	public void setMasOfficelevelid(String masOfficelevelid) {
		this.masOfficelevelid = masOfficelevelid;
	}

	public String getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(String masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public String getOfficelevel() {
		return officelevel;
	}

	public void setOfficelevel(String officelevel) {
		this.officelevel = officelevel;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getOfficeaddress() {
		return officeaddress;
	}

	public void setOfficeaddress(String officeaddress) {
		this.officeaddress = officeaddress;
	}

	public Integer getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Integer rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	

	public String getRmloginroleID() {
		return rmloginroleID;
	}

	public void setRmloginroleID(String rmloginroleID) {
		this.rmloginroleID = rmloginroleID;
	}

	
	
	public String getRmRoleid() {
		return rmRoleid;
	}

	public void setRmRoleid(String rmRoleid) {
		this.rmRoleid = rmRoleid;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

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




}
