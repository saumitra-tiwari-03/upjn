package com.nic.upjn.spring.dto;

public class ManagePromotionDTO {
	
	
	private String postingorderno;
	private String joindate;
	private String orderdate;
	private String effectivedate;
	private String joinanfn;
	private Character isPromotionForego;
	private Integer ppDesignationmasterid;
	public String getPostingorderno() {
		return postingorderno;
	}
	public void setPostingorderno(String postingorderno) {
		this.postingorderno = postingorderno;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getEffectivedate() {
		return effectivedate;
	}
	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}
	public String getJoinanfn() {
		return joinanfn;
	}
	public void setJoinanfn(String joinanfn) {
		this.joinanfn = joinanfn;
	}
	public Character getIsPromotionForego() {
		return isPromotionForego;
	}
	public void setIsPromotionForego(Character isPromotionForego) {
		this.isPromotionForego = isPromotionForego;
	}
	public Integer getPpDesignationmasterid() {
		return ppDesignationmasterid;
	}
	public void setPpDesignationmasterid(Integer ppDesignationmasterid) {
		this.ppDesignationmasterid = ppDesignationmasterid;
	}

}
