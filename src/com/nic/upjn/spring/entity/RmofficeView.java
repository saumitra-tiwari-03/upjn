package com.nic.upjn.spring.entity;

import java.io.Serializable;

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
 * @author Anuj_Singh
 */
@Entity
@Table(name = "RMOFFICE_VIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RmofficeView.findAll", query = "FROM RmofficeView  order by parentofficeid DESC, officename DESC"),
    @NamedQuery(name = "RmofficeView.findByRmOfficeid", query = "FROM RmofficeView WHERE rmOfficeid = ?"),
    @NamedQuery(name = "RmofficeView.findByOfficelevel", query = "SELECT r FROM RmofficeView r WHERE r.officelevel = :officelevel"),
    @NamedQuery(name = "RmofficeView.findByOfficename", query = "SELECT r FROM RmofficeView r WHERE r.officename = :officename"),
    @NamedQuery(name = "RmofficeView.findByDistrictname", query = "SELECT r FROM RmofficeView r WHERE r.districtname = :districtname"),
    @NamedQuery(name = "RmofficeView.findByOfficeaddress", query = "SELECT r FROM RmofficeView r WHERE r.officeaddress = :officeaddress"),
    @NamedQuery(name = "RmofficeView.findByPhno1", query = "SELECT r FROM RmofficeView r WHERE r.phno1 = :phno1"),
    @NamedQuery(name = "RmofficeView.findByPhno2", query = "SELECT r FROM RmofficeView r WHERE r.phno2 = :phno2"),
    @NamedQuery(name = "RmofficeView.findByFax", query = "SELECT r FROM RmofficeView r WHERE r.fax = :fax"),
    @NamedQuery(name = "RmofficeView.findByPlace", query = "SELECT r FROM RmofficeView r WHERE r.place = :place"),
    @NamedQuery(name = "RmofficeView.findByParentofficeid", query = "SELECT r FROM RmofficeView r WHERE r.parentofficeid = :parentofficeid")})
public class RmofficeView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "RM_OFFICEID")
    @Id
    private int rmOfficeid;
    @Basic(optional = false)
    @Column(name = "OFFICELEVEL")
    private String officelevel;
    @Basic(optional = false)
    @Column(name = "OFFICENAME")
    private String officename;
    @Basic(optional = false)
    @Column(name = "DISTRICTNAME")
    private String districtname;
    @Column(name = "OFFICEADDRESS")
    private String officeaddress;
    @Column(name = "PHNO1")
    private String phno1;
    @Column(name = "PHNO2")
    private String phno2;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "PLACE")
    private String place;
    @Column(name = "PARENTOFFICEID")
    private Integer parentofficeid;

    public RmofficeView() {
    }

    public int getRmOfficeid() {
        return rmOfficeid;
    }

    public void setRmOfficeid(int rmOfficeid) {
        this.rmOfficeid = rmOfficeid;
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

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public String getOfficeaddress() {
        return officeaddress;
    }

    public void setOfficeaddress(String officeaddress) {
        this.officeaddress = officeaddress;
    }

    public String getPhno1() {
        return phno1;
    }

    public void setPhno1(String phno1) {
        this.phno1 = phno1;
    }

    public String getPhno2() {
        return phno2;
    }

    public void setPhno2(String phno2) {
        this.phno2 = phno2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getParentofficeid() {
        return parentofficeid;
    }

    public void setParentofficeid(Integer parentofficeid) {
        this.parentofficeid = parentofficeid;
    }
    
}
