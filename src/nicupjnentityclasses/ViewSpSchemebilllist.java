/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_SP_SCHEMEBILLLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewSpSchemebilllist.findAll", query = "SELECT v FROM ViewSpSchemebilllist v") })
public class ViewSpSchemebilllist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Lob
	@Column(name = "SP_SCHEMEMASTERID")
	private Object spSchememasterid;
	@Lob
	@Column(name = "SCHEME")
	private Object scheme;
	@Lob
	@Column(name = "SCHEMENAME")
	private Object schemename;
	@Lob
	@Column(name = "AMOUNT")
	private Object amount;
	@Lob
	@Column(name = "REFERENCEDATE")
	private Object referencedate;
	@Lob
	@Column(name = "BILLTYPE")
	private Object billtype;
	@Lob
	@Column(name = "REFERENCETABLEID")
	private Object referencetableid;
	@Lob
	@Column(name = "UNIQUEIDENTIFIER")
	private Object uniqueidentifier;

	public ViewSpSchemebilllist() {
	}

	public Object getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(Object spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public Object getScheme() {
		return scheme;
	}

	public void setScheme(Object scheme) {
		this.scheme = scheme;
	}

	public Object getSchemename() {
		return schemename;
	}

	public void setSchemename(Object schemename) {
		this.schemename = schemename;
	}

	public Object getAmount() {
		return amount;
	}

	public void setAmount(Object amount) {
		this.amount = amount;
	}

	public Object getReferencedate() {
		return referencedate;
	}

	public void setReferencedate(Object referencedate) {
		this.referencedate = referencedate;
	}

	public Object getBilltype() {
		return billtype;
	}

	public void setBilltype(Object billtype) {
		this.billtype = billtype;
	}

	public Object getReferencetableid() {
		return referencetableid;
	}

	public void setReferencetableid(Object referencetableid) {
		this.referencetableid = referencetableid;
	}

	public Object getUniqueidentifier() {
		return uniqueidentifier;
	}

	public void setUniqueidentifier(Object uniqueidentifier) {
		this.uniqueidentifier = uniqueidentifier;
	}

}
