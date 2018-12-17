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
@Table(name = "VIEW_FWA_MONTH_BILL")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ViewFwaMonthBill.findAll", query = "SELECT v FROM ViewFwaMonthBill v") })
public class ViewFwaMonthBill implements Serializable {
	private static final long serialVersionUID = 1L;
	@Lob
	@Column(name = "BILLNAME")
	private Object billname;
	@Lob
	@Column(name = "AC_CODE")
	private Object acCode;
	@Lob
	@Column(name = "BILLDATE")
	private Object billdate;
	@Lob
	@Column(name = "BILLAMOUNT")
	private Object billamount;
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
	@Column(name = "FWA_AC_CODE_MASTERID")
	private Object fwaAcCodeMasterid;
	@Lob
	@Column(name = "SOURCE_TRAN_ID")
	private Object sourceTranId;
	@Lob
	@Column(name = "CRTRANID")
	private Object crtranid;
	@Lob
	@Column(name = "CRAC_CODE")
	private Object cracCode;
	@Lob
	@Column(name = "CRHEAD_NAME")
	private Object crheadName;
	@Lob
	@Column(name = "CRFWA_AC_CODE_MASTERID")
	private Object crfwaAcCodeMasterid;
	@Lob
	@Column(name = "SOURCEAC_CODE")
	private Object sourceacCode;
	@Lob
	@Column(name = "SOURCEHEAD_NAME")
	private Object sourceheadName;
	@Lob
	@Column(name = "SOURCEFWA_AC_CODE_MASTERID")
	private Object sourcefwaAcCodeMasterid;

	public ViewFwaMonthBill() {
	}

	public Object getBillname() {
		return billname;
	}

	public void setBillname(Object billname) {
		this.billname = billname;
	}

	public Object getAcCode() {
		return acCode;
	}

	public void setAcCode(Object acCode) {
		this.acCode = acCode;
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

	public Object getFwaAcCodeMasterid() {
		return fwaAcCodeMasterid;
	}

	public void setFwaAcCodeMasterid(Object fwaAcCodeMasterid) {
		this.fwaAcCodeMasterid = fwaAcCodeMasterid;
	}

	public Object getSourceTranId() {
		return sourceTranId;
	}

	public void setSourceTranId(Object sourceTranId) {
		this.sourceTranId = sourceTranId;
	}

	public Object getCrtranid() {
		return crtranid;
	}

	public void setCrtranid(Object crtranid) {
		this.crtranid = crtranid;
	}

	public Object getCracCode() {
		return cracCode;
	}

	public void setCracCode(Object cracCode) {
		this.cracCode = cracCode;
	}

	public Object getCrheadName() {
		return crheadName;
	}

	public void setCrheadName(Object crheadName) {
		this.crheadName = crheadName;
	}

	public Object getCrfwaAcCodeMasterid() {
		return crfwaAcCodeMasterid;
	}

	public void setCrfwaAcCodeMasterid(Object crfwaAcCodeMasterid) {
		this.crfwaAcCodeMasterid = crfwaAcCodeMasterid;
	}

	public Object getSourceacCode() {
		return sourceacCode;
	}

	public void setSourceacCode(Object sourceacCode) {
		this.sourceacCode = sourceacCode;
	}

	public Object getSourceheadName() {
		return sourceheadName;
	}

	public void setSourceheadName(Object sourceheadName) {
		this.sourceheadName = sourceheadName;
	}

	public Object getSourcefwaAcCodeMasterid() {
		return sourcefwaAcCodeMasterid;
	}

	public void setSourcefwaAcCodeMasterid(Object sourcefwaAcCodeMasterid) {
		this.sourcefwaAcCodeMasterid = sourcefwaAcCodeMasterid;
	}

}
