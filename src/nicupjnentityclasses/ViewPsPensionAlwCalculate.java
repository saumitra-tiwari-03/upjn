/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicupjnentityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saumitra-PC
 */
@Entity
@Table(name = "VIEW_PS_PENSION_ALW_CALCULATE")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ViewPsPensionAlwCalculate.findAll", query = "SELECT v FROM ViewPsPensionAlwCalculate v"),
		@NamedQuery(name = "ViewPsPensionAlwCalculate.findByPercentvalue", query = "SELECT v FROM ViewPsPensionAlwCalculate v WHERE v.percentvalue = :percentvalue"),
		@NamedQuery(name = "ViewPsPensionAlwCalculate.findByDateofeffect", query = "SELECT v FROM ViewPsPensionAlwCalculate v WHERE v.dateofeffect = :dateofeffect") })
public class ViewPsPensionAlwCalculate implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "PERCENTVALUE")
	private BigDecimal percentvalue;
	@Basic(optional = false)
	@Column(name = "DATEOFEFFECT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofeffect;

	public ViewPsPensionAlwCalculate() {
	}

	public BigDecimal getPercentvalue() {
		return percentvalue;
	}

	public void setPercentvalue(BigDecimal percentvalue) {
		this.percentvalue = percentvalue;
	}

	public Date getDateofeffect() {
		return dateofeffect;
	}

	public void setDateofeffect(Date dateofeffect) {
		this.dateofeffect = dateofeffect;
	}

}
