/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nic.upjn.spring.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nicsi
 */
@Entity
@Table(name = "MAS_EMPLOYMENTSUBTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MasEmploymentsubtype.findAll", query = "FROM MasEmploymentsubtype order by masEmploymenttypeid,masEmploymentsubtypeid"),
    @NamedQuery(name = "MasEmploymentsubtype.findByMasEmploymentsubtypeid", query = "FROM MasEmploymentsubtype WHERE masEmploymentsubtypeid = ?"),
    @NamedQuery(name = "MasEmploymentsubtype.findByMasEmploymenttypeid", query = "FROM MasEmploymentsubtype WHERE masEmploymenttypeid = ?"),
    @NamedQuery(name = "MasEmploymentsubtype.findByEmploymentsubtype", query = "SELECT m FROM MasEmploymentsubtype m WHERE m.employmentsubtype = :employmentsubtype")})
public class MasEmploymentsubtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   
    @Column(name = "MAS_EMPLOYMENTSUBTYPEID")
    private Integer masEmploymentsubtypeid;
    @Basic(optional = false)

    @Column(name = "EMPLOYMENTSUBTYPE")
    private String employmentsubtype;
    @OneToMany(mappedBy = "masEmploymentsubtypeid")
    private Collection<PpDesignationmaster> ppDesignationmasterCollection;
    @Column(name = "MAS_EMPLOYMENTTYPEID")
    private String masEmploymenttypeid;

    public MasEmploymentsubtype() {
    }

    public MasEmploymentsubtype(Integer masEmploymentsubtypeid) {
        this.masEmploymentsubtypeid = masEmploymentsubtypeid;
    }

    public MasEmploymentsubtype(Integer masEmploymentsubtypeid, String employmentsubtype) {
        this.masEmploymentsubtypeid = masEmploymentsubtypeid;
        this.employmentsubtype = employmentsubtype;
    }

    public Integer getMasEmploymentsubtypeid() {
        return masEmploymentsubtypeid;
    }

    public void setMasEmploymentsubtypeid(Integer masEmploymentsubtypeid) {
        this.masEmploymentsubtypeid = masEmploymentsubtypeid;
    }

    public String getEmploymentsubtype() {
        return employmentsubtype;
    }

    public void setEmploymentsubtype(String employmentsubtype) {
        this.employmentsubtype = employmentsubtype;
    }

    @XmlTransient
    public Collection<PpDesignationmaster> getPpDesignationmasterCollection() {
        return ppDesignationmasterCollection;
    }

    public void setPpDesignationmasterCollection(Collection<PpDesignationmaster> ppDesignationmasterCollection) {
        this.ppDesignationmasterCollection = ppDesignationmasterCollection;
    }

    public String getMasEmploymenttypeid() {
        return masEmploymenttypeid;
    }

    public void setMasEmploymenttypeid(String masEmploymenttypeid) {
        this.masEmploymenttypeid = masEmploymenttypeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (masEmploymentsubtypeid != null ? masEmploymentsubtypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasEmploymentsubtype)) {
            return false;
        }
        MasEmploymentsubtype other = (MasEmploymentsubtype) object;
        if ((this.masEmploymentsubtypeid == null && other.masEmploymentsubtypeid != null) || (this.masEmploymentsubtypeid != null && !this.masEmploymentsubtypeid.equals(other.masEmploymentsubtypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MasEmploymentsubtype[ masEmploymentsubtypeid=" + masEmploymentsubtypeid + " ]";
    }
    
}
