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
@Table(name = "FIN_PROGRAM")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FinProgram.findAll", query = "SELECT f FROM FinProgram f"),
		@NamedQuery(name = "FinProgram.findByFinProgramid", query = "SELECT f FROM FinProgram f WHERE f.finProgramid = :finProgramid"),
		@NamedQuery(name = "FinProgram.findByWorkGroup", query = "SELECT f FROM FinProgram f WHERE f.workGroup = :workGroup"),
		@NamedQuery(name = "FinProgram.findByProgrammeName", query = "SELECT f FROM FinProgram f WHERE f.programmeName = :programmeName"),
		@NamedQuery(name = "FinProgram.findByWorkType", query = "SELECT f FROM FinProgram f WHERE f.workType = :workType"),
		@NamedQuery(name = "FinProgram.findByNewCodes", query = "SELECT f FROM FinProgram f WHERE f.newCodes = :newCodes"),
		@NamedQuery(name = "FinProgram.findByExistingCode", query = "SELECT f FROM FinProgram f WHERE f.existingCode = :existingCode"),
		@NamedQuery(name = "FinProgram.findByProgrammeName1", query = "SELECT f FROM FinProgram f WHERE f.programmeName1 = :programmeName1") })
public class FinProgram implements Serializable {
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
	@Column(name = "PROGRAMME_NAME1")
	private String programmeName1;

	public FinProgram() {
	}

	public FinProgram(BigDecimal finProgramid) {
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

	public String getProgrammeName1() {
		return programmeName1;
	}

	public void setProgrammeName1(String programmeName1) {
		this.programmeName1 = programmeName1;
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
		if (!(object instanceof FinProgram)) {
			return false;
		}
		FinProgram other = (FinProgram) object;
		if ((this.finProgramid == null && other.finProgramid != null)
				|| (this.finProgramid != null && !this.finProgramid.equals(other.finProgramid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.FinProgram[ finProgramid=" + finProgramid + " ]";
	}

}
