/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

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
 * @author Saumitra-PC
 */
@Entity
@Table(name = "PP_PLACEMASTER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PpPlacemaster.findAll", query = "SELECT p FROM PpPlacemaster p"),
		@NamedQuery(name = "PpPlacemaster.findByPpPlacemasterid", query = "SELECT p FROM PpPlacemaster p WHERE p.ppPlacemasterid = :ppPlacemasterid"),
		@NamedQuery(name = "PpPlacemaster.findByPlace", query = "SELECT p FROM PpPlacemaster p WHERE p.place = :place"),
		@NamedQuery(name = "PpPlacemaster.findByPpTowncategorymasterid", query = "SELECT p FROM PpPlacemaster p WHERE p.ppTowncategorymasterid = :ppTowncategorymasterid"),
		@NamedQuery(name = "PpPlacemaster.findByMasDistrictid", query = "SELECT p FROM PpPlacemaster p WHERE p.masDistrictid = :masDistrictid"),
		@NamedQuery(name = "PpPlacemaster.findByZoneCode", query = "SELECT p FROM PpPlacemaster p WHERE p.zoneCode = :zoneCode"),
		@NamedQuery(name = "PpPlacemaster.findByZoneDesc", query = "SELECT p FROM PpPlacemaster p WHERE p.zoneDesc = :zoneDesc") })
public class PpPlacemaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "PP_PLACEMASTERID")
	private Long ppPlacemasterid;
	@Basic(optional = false)
	@Column(name = "PLACE")
	private String place;
	@Column(name = "PP_TOWNCATEGORYMASTERID")
	private Integer ppTowncategorymasterid;
	@Basic(optional = false)
	@Column(name = "MAS_DISTRICTID")
	private int masDistrictid;
	@Column(name = "ZONE_CODE")
	private String zoneCode;
	@Column(name = "ZONE_DESC")
	private String zoneDesc;

	public PpPlacemaster() {
	}

	public PpPlacemaster(Long ppPlacemasterid) {
		this.ppPlacemasterid = ppPlacemasterid;
	}

	public PpPlacemaster(Long ppPlacemasterid, String place, int masDistrictid) {
		this.ppPlacemasterid = ppPlacemasterid;
		this.place = place;
		this.masDistrictid = masDistrictid;
	}

	public Long getPpPlacemasterid() {
		return ppPlacemasterid;
	}

	public void setPpPlacemasterid(Long ppPlacemasterid) {
		this.ppPlacemasterid = ppPlacemasterid;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getPpTowncategorymasterid() {
		return ppTowncategorymasterid;
	}

	public void setPpTowncategorymasterid(Integer ppTowncategorymasterid) {
		this.ppTowncategorymasterid = ppTowncategorymasterid;
	}

	public int getMasDistrictid() {
		return masDistrictid;
	}

	public void setMasDistrictid(int masDistrictid) {
		this.masDistrictid = masDistrictid;
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (ppPlacemasterid != null ? ppPlacemasterid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PpPlacemaster)) {
			return false;
		}
		PpPlacemaster other = (PpPlacemaster) object;
		if ((this.ppPlacemasterid == null && other.ppPlacemasterid != null)
				|| (this.ppPlacemasterid != null && !this.ppPlacemasterid.equals(other.ppPlacemasterid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "nicupjnentityclasses.PpPlacemaster[ ppPlacemasterid=" + ppPlacemasterid + " ]";
	}

}
