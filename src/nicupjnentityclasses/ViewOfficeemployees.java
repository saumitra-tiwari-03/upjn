/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_OFFICEEMPLOYEES")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewOfficeemployees.findAll", query = "SELECT v FROM ViewOfficeemployees v"),
		@NamedQuery(name = "ViewOfficeemployees.findByLocCode", query = "SELECT v FROM ViewOfficeemployees v WHERE v.locCode = :locCode"),
		@NamedQuery(name = "ViewOfficeemployees.findByEmployeename", query = "SELECT v FROM ViewOfficeemployees v WHERE v.employeename = :employeename") })
public class ViewOfficeemployees implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "LOC_CODE")
	private Long locCode;
	@Column(name = "EMPLOYEENAME")
	private BigInteger employeename;

	public ViewOfficeemployees() {
	}

	public Long getLocCode() {
		return locCode;
	}

	public void setLocCode(Long locCode) {
		this.locCode = locCode;
	}

	public BigInteger getEmployeename() {
		return employeename;
	}

	public void setEmployeename(BigInteger employeename) {
		this.employeename = employeename;
	}

}
