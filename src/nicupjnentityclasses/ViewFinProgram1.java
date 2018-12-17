/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_FIN_PROGRAM1")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewFinProgram1.findAll", query = "SELECT v FROM ViewFinProgram1 v"),
		@NamedQuery(name = "ViewFinProgram1.findByFinProgramid", query = "SELECT v FROM ViewFinProgram1 v WHERE v.finProgramid = :finProgramid"),
		@NamedQuery(name = "ViewFinProgram1.findByWorkGroup", query = "SELECT v FROM ViewFinProgram1 v WHERE v.workGroup = :workGroup"),
		@NamedQuery(name = "ViewFinProgram1.findByProgrammeName", query = "SELECT v FROM ViewFinProgram1 v WHERE v.programmeName = :programmeName"),
		@NamedQuery(name = "ViewFinProgram1.findByWorkType", query = "SELECT v FROM ViewFinProgram1 v WHERE v.workType = :workType"),
		@NamedQuery(name = "ViewFinProgram1.findByNewCodes", query = "SELECT v FROM ViewFinProgram1 v WHERE v.newCodes = :newCodes"),
		@NamedQuery(name = "ViewFinProgram1.findByExistingCode", query = "SELECT v FROM ViewFinProgram1 v WHERE v.existingCode = :existingCode") })
public class ViewFinProgram1 implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "FIN_PROGRAMID")
	private BigDecimal finProgramid;
	@Column(name = "WORK_GROUP")
	private String workGroup;
	@Column(name = "PROGRAMME_NAME")
	private String programmeName;
	@Column(name = "WORK_TYPE")
	private String workType;
	@Column(name = "NEW_CODES")
	private String newCodes;
	@Column(name = "EXISTING_CODE")
	private String existingCode;

	public ViewFinProgram1() {
	}

	public ViewFinProgram1(BigDecimal finProgramid) {
		this.finProgramid = finProgramid;
	}

	public BigDecimal getFinProgramid() {
		return finProgramid;
	}

	public void setFinProgramid(BigDecimal finProgramid) {
		this.finProgramid = finProgramid;
	}

	public String getWorkGroup() {
		return workGroup;
	}

	public void setWorkGroup(String workGroup) {
		this.workGroup = workGroup;
	}

	public String getProgrammeName() {
		return programmeName;
	}

	public void setProgrammeName(String programmeName) {
		this.programmeName = programmeName;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getNewCodes() {
		return newCodes;
	}

	public void setNewCodes(String newCodes) {
		this.newCodes = newCodes;
	}

	public String getExistingCode() {
		return existingCode;
	}

	public void setExistingCode(String existingCode) {
		this.existingCode = existingCode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (finProgramid != null ? finProgramid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ViewFinProgram1)) {
			return false;
		}
		ViewFinProgram1 other = (ViewFinProgram1) object;
		if ((this.finProgramid == null && other.finProgramid != null)
				|| (this.finProgramid != null && !this.finProgramid.equals(other.finProgramid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.ViewFinProgram1[ finProgramid=" + finProgramid + " ]";
	}

}
