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
@Table(name = "SP_VIEW_SCHEMECOMPONENTSTATUS")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "SpViewSchemecomponentstatus.findAll", query = "SELECT s FROM SpViewSchemecomponentstatus s") })
public class SpViewSchemecomponentstatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Lob
	@Column(name = "SP_COMPONENTMASTERID")
	private Object spComponentmasterid;
	@Lob
	@Column(name = "SP_SCHEMEMASTERID")
	private Object spSchememasterid;
	@Lob
	@Column(name = "COMPONENT")
	private Object component;
	@Lob
	@Column(name = "COMPLETED")
	private Object completed;
	@Lob
	@Column(name = "INPUTTYPE")
	private Object inputtype;
	@Lob
	@Column(name = "TARGET")
	private Object target;
	@Lob
	@Column(name = "LASTSTATUS")
	private Object laststatus;

	public SpViewSchemecomponentstatus() {
	}

	public Object getSpComponentmasterid() {
		return spComponentmasterid;
	}

	public void setSpComponentmasterid(Object spComponentmasterid) {
		this.spComponentmasterid = spComponentmasterid;
	}

	public Object getSpSchememasterid() {
		return spSchememasterid;
	}

	public void setSpSchememasterid(Object spSchememasterid) {
		this.spSchememasterid = spSchememasterid;
	}

	public Object getComponent() {
		return component;
	}

	public void setComponent(Object component) {
		this.component = component;
	}

	public Object getCompleted() {
		return completed;
	}

	public void setCompleted(Object completed) {
		this.completed = completed;
	}

	public Object getInputtype() {
		return inputtype;
	}

	public void setInputtype(Object inputtype) {
		this.inputtype = inputtype;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object getLaststatus() {
		return laststatus;
	}

	public void setLaststatus(Object laststatus) {
		this.laststatus = laststatus;
	}

}
