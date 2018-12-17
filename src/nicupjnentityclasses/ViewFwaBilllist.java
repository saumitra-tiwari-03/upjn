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
@Table(name = "VIEW_FWA_BILLLIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewFwaBilllist.findAll", query = "SELECT v FROM ViewFwaBilllist v") })
public class ViewFwaBilllist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Lob
	@Column(name = "BILLNAME")
	private Object billname;
	@Lob
	@Column(name = "BILLDATE")
	private Object billdate;
	@Lob
	@Column(name = "BILLAMOUNT")
	private Object billamount;
	@Lob
	@Column(name = "CASHAMOUNT")
	private Object cashamount;
	@Lob
	@Column(name = "BANKAMOUNT")
	private Object bankamount;
	@Lob
	@Column(name = "BILLNO")
	private Object billno;
	@Lob
	@Column(name = "BILLMONTH")
	private Object billmonth;
	@Lob
	@Column(name = "RM_OFFICEID")
	private Object rmOfficeid;
	@Lob
	@Column(name = "BILLID")
	private Object billid;
	@Lob
	@Column(name = "TABLENAME")
	private Object tablename;
	@Lob
	@Column(name = "PRIMARYKEY")
	private Object primarykey;
	@Lob
	@Column(name = "FIELDNAMETOBEUPDATED")
	private Object fieldnametobeupdated;
	@Lob
	@Column(name = "FIELDVALUETOBEUPDATED")
	private Object fieldvaluetobeupdated;
	@Lob
	@Column(name = "BILLNOFIELDNAME")
	private Object billnofieldname;
	@Lob
	@Column(name = "BILLTYPE")
	private Object billtype;
	@Lob
	@Column(name = "ISLOCKED")
	private Object islocked;
	@Lob
	@Column(name = "FWA_TRANSACTION_BOOKID")
	private Object fwaTransactionBookid;
	@Lob
	@Column(name = "BANK_AC_NO")
	private Object bankAcNo;
	@Lob
	@Column(name = "AC_CODE")
	private Object acCode;

	public ViewFwaBilllist() {
	}

	public Object getBillname() {
		return billname;
	}

	public void setBillname(Object billname) {
		this.billname = billname;
	}

	public Object getBilldate() {
		return billdate;
	}

	public void setBilldate(Object billdate) {
		this.billdate = billdate;
	}

	public Object getBillamount() {
		return billamount;
	}

	public void setBillamount(Object billamount) {
		this.billamount = billamount;
	}

	public Object getCashamount() {
		return cashamount;
	}

	public void setCashamount(Object cashamount) {
		this.cashamount = cashamount;
	}

	public Object getBankamount() {
		return bankamount;
	}

	public void setBankamount(Object bankamount) {
		this.bankamount = bankamount;
	}

	public Object getBillno() {
		return billno;
	}

	public void setBillno(Object billno) {
		this.billno = billno;
	}

	public Object getBillmonth() {
		return billmonth;
	}

	public void setBillmonth(Object billmonth) {
		this.billmonth = billmonth;
	}

	public Object getRmOfficeid() {
		return rmOfficeid;
	}

	public void setRmOfficeid(Object rmOfficeid) {
		this.rmOfficeid = rmOfficeid;
	}

	public Object getBillid() {
		return billid;
	}

	public void setBillid(Object billid) {
		this.billid = billid;
	}

	public Object getTablename() {
		return tablename;
	}

	public void setTablename(Object tablename) {
		this.tablename = tablename;
	}

	public Object getPrimarykey() {
		return primarykey;
	}

	public void setPrimarykey(Object primarykey) {
		this.primarykey = primarykey;
	}

	public Object getFieldnametobeupdated() {
		return fieldnametobeupdated;
	}

	public void setFieldnametobeupdated(Object fieldnametobeupdated) {
		this.fieldnametobeupdated = fieldnametobeupdated;
	}

	public Object getFieldvaluetobeupdated() {
		return fieldvaluetobeupdated;
	}

	public void setFieldvaluetobeupdated(Object fieldvaluetobeupdated) {
		this.fieldvaluetobeupdated = fieldvaluetobeupdated;
	}

	public Object getBillnofieldname() {
		return billnofieldname;
	}

	public void setBillnofieldname(Object billnofieldname) {
		this.billnofieldname = billnofieldname;
	}

	public Object getBilltype() {
		return billtype;
	}

	public void setBilltype(Object billtype) {
		this.billtype = billtype;
	}

	public Object getIslocked() {
		return islocked;
	}

	public void setIslocked(Object islocked) {
		this.islocked = islocked;
	}

	public Object getFwaTransactionBookid() {
		return fwaTransactionBookid;
	}

	public void setFwaTransactionBookid(Object fwaTransactionBookid) {
		this.fwaTransactionBookid = fwaTransactionBookid;
	}

	public Object getBankAcNo() {
		return bankAcNo;
	}

	public void setBankAcNo(Object bankAcNo) {
		this.bankAcNo = bankAcNo;
	}

	public Object getAcCode() {
		return acCode;
	}

	public void setAcCode(Object acCode) {
		this.acCode = acCode;
	}

}
