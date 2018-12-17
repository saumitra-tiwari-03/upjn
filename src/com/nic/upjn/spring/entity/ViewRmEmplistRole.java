/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author NICSI
 */
@Entity
@Table(name = "VIEW_RM_EMPLIST_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewRmEmplistRole.findAll", query = "SELECT v FROM ViewRmEmplistRole v"),
    @NamedQuery(name = "ViewRmEmplistRole.findByPpEmployeemasterid", query = "SELECT v FROM ViewRmEmplistRole v WHERE v.ppEmployeemasterid = :ppEmployeemasterid"),
    @NamedQuery(name = "ViewRmEmplistRole.findByEmployeecode", query = "SELECT v FROM ViewRmEmplistRole v WHERE v.employeecode = :employeecode"),
    @NamedQuery(name = "ViewRmEmplistRole.findByEmployeename", query = "SELECT v FROM ViewRmEmplistRole v WHERE v.employeename = :employeename"),
    @NamedQuery(name = "ViewRmEmplistRole.findByRmOfficeid", query = "SELECT v FROM ViewRmEmplistRole v WHERE v.rmOfficeid = :rmOfficeid"),
    @NamedQuery(name = "ViewRmEmplistRole.find", query = " FROM ViewRmEmplistRole WHERE rmOfficeid = ? order by ppEmployeemasterid DESC")
})
public class ViewRmEmplistRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PP_EMPLOYEEMASTERID")
    private long ppEmployeemasterid;
    @Basic(optional = false)
    @Column(name = "EMPLOYEECODE")
    private String employeecode;
    @Column(name = "EMPLOYEENAME")
    private String employeename;
    @Column(name = "RM_OFFICEID")
    private Integer rmOfficeid;

    public ViewRmEmplistRole() {
    }

    public long getPpEmployeemasterid() {
        return ppEmployeemasterid;
    }

    public void setPpEmployeemasterid(long ppEmployeemasterid) {
        this.ppEmployeemasterid = ppEmployeemasterid;
    }

    public String getEmployeecode() {
        return employeecode;
    }

    public void setEmployeecode(String employeecode) {
        this.employeecode = employeecode;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public Integer getRmOfficeid() {
        return rmOfficeid;
    }

    public void setRmOfficeid(Integer rmOfficeid) {
        this.rmOfficeid = rmOfficeid;
    }
    
}
