package com.nic.upjn.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VIEW_HEADNAME")
@XmlRootElement
public class ViewHeadName implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "HEADID")
	private long headID;
	@Column(name = "HEADTYPE")
	private String headType;
	@Column(name = "HEADNAME")
	private String headName;
	@Column(name = "PRINT_ORDER")
	private long printorder;
	
	
	public long getHeadID() {
		return headID;
	}
	public void setHeadID(long headID) {
		this.headID = headID;
	}
	public String getHeadType() {
		return headType;
	}
	public void setHeadType(String headType) {
		this.headType = headType;
	}
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public long getPrintorder() {
		return printorder;
	}
	public void setPrintorder(long printorder) {
		this.printorder = printorder;
	}
	
	
	

}
