/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
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
@Table(name = "VIEW_PP_GETNOMINEESHARE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewPpGetnomineeshare.findAll", query = "SELECT v FROM ViewPpGetnomineeshare v"),
		@NamedQuery(name = "ViewPpGetnomineeshare.findByNomineeshare", query = "SELECT v FROM ViewPpGetnomineeshare v WHERE v.nomineeshare = :nomineeshare"),
		@NamedQuery(name = "ViewPpGetnomineeshare.findByNominationtype", query = "SELECT v FROM ViewPpGetnomineeshare v WHERE v.nominationtype = :nominationtype"),
		@NamedQuery(name = "ViewPpGetnomineeshare.findByEmployeeid", query = "SELECT v FROM ViewPpGetnomineeshare v WHERE v.employeeid = :employeeid") })
public class ViewPpGetnomineeshare implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "NOMINEESHARE")
	private BigInteger nomineeshare;
	@Basic(optional = false)
	@Column(name = "NOMINATIONTYPE")
	private short nominationtype;
	@Basic(optional = false)
	@Column(name = "EMPLOYEEID")
	private long employeeid;

	public ViewPpGetnomineeshare() {
	}

	public BigInteger getNomineeshare() {
		return nomineeshare;
	}

	public void setNomineeshare(BigInteger nomineeshare) {
		this.nomineeshare = nomineeshare;
	}

	public short getNominationtype() {
		return nominationtype;
	}

	public void setNominationtype(short nominationtype) {
		this.nominationtype = nominationtype;
	}

	public long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

}
