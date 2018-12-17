/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Saumitra-PC
 */
@Entity
@Table(name = "MAS_DISTRICT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "MasDistrict.findAll", query = "SELECT m FROM MasDistrict m"),
		@NamedQuery(name = "MasDistrict.findByMasDistrictid", query = "SELECT m FROM MasDistrict m WHERE m.masDistrictid = :masDistrictid"),
		@NamedQuery(name = "MasDistrict.findByDistrictname", query = "SELECT m FROM MasDistrict m WHERE m.districtname = :districtname"),
		@NamedQuery(name = "MasDistrict.findByCensusdistrictcode", query = "SELECT m FROM MasDistrict m WHERE m.censusdistrictcode = :censusdistrictcode"),
		@NamedQuery(name = "MasDistrict.findByZoneCode", query = "SELECT m FROM MasDistrict m WHERE m.zoneCode = :zoneCode"),
		@NamedQuery(name = "MasDistrict.findByZoneDesc", query = "SELECT m FROM MasDistrict m WHERE m.zoneDesc = :zoneDesc") })
public class MasDistrict implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MAS_DISTRICTID")
	private Long masDistrictid;
	@Basic(optional = false)
	@Column(name = "DISTRICTNAME")
	private String districtname;
	@Column(name = "CENSUSDISTRICTCODE")
	private String censusdistrictcode;
	@Column(name = "ZONE_CODE")
	private String zoneCode;
	@Column(name = "ZONE_DESC")
	private String zoneDesc;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "masDistrictid")
	private Collection<Fpr403EntryTable> fpr403EntryTableCollection;
	@JoinColumn(name = "MAS_STATEID", referencedColumnName = "MAS_STATEID")
	@ManyToOne(optional = false)
	private MasState masStateid;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "masDistrictid")
	private Collection<SpSchememaster> spSchememasterCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "masDistrictid")
	private Collection<RmOffice> rmOfficeCollection;

	public MasDistrict() {
	}

	public MasDistrict(Long masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public MasDistrict(Long masDistrictid, String districtname) {
		this.masDistrictid = masDistrictid;
		this.districtname = districtname;
	}

	public Long getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(Long masDistrictid) {
		this.masDistrictid = masDistrictid;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public String getCensusdistrictcode() {
		return censusdistrictcode;
	}

	public void setCensusdistrictcode(String censusdistrictcode) {
		this.censusdistrictcode = censusdistrictcode;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getZoneDesc() {
		return zoneDesc;
	}

	public void setZoneDesc(String zoneDesc) {
		this.zoneDesc = zoneDesc;
	}

	@XmlTransient
	public Collection<Fpr403EntryTable> getFpr403EntryTableCollection() {
		return fpr403EntryTableCollection;
	}

	public void setFpr403EntryTableCollection(Collection<Fpr403EntryTable> fpr403EntryTableCollection) {
		this.fpr403EntryTableCollection = fpr403EntryTableCollection;
	}

	public MasState getMasStateid() {
		return masStateid;
	}

	public void setMasStateid(MasState masStateid) {
		this.masStateid = masStateid;
	}

	@XmlTransient
	public Collection<SpSchememaster> getSpSchememasterCollection() {
		return spSchememasterCollection;
	}

	public void setSpSchememasterCollection(Collection<SpSchememaster> spSchememasterCollection) {
		this.spSchememasterCollection = spSchememasterCollection;
	}

	@XmlTransient
	public Collection<RmOffice> getRmOfficeCollection() {
		return rmOfficeCollection;
	}

	public void setRmOfficeCollection(Collection<RmOffice> rmOfficeCollection) {
		this.rmOfficeCollection = rmOfficeCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (masDistrictid != null ? masDistrictid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MasDistrict)) {
			return false;
		}
		MasDistrict other = (MasDistrict) object;
		if ((this.masDistrictid == null && other.masDistrictid != null)
				|| (this.masDistrictid != null && !this.masDistrictid.equals(other.masDistrictid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.MasDistrict[ masDistrictid=" + masDistrictid + " ]";
	}

}
