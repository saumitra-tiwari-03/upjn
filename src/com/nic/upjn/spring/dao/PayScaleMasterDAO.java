package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.dto.PayScaleMasterDTO;
import com.nic.upjn.spring.entity.PpPayscalemaster;

public interface PayScaleMasterDAO {

	List getlist(String value, String namedQuery);

	boolean insertPayScaleIntoDB(PpPayscalemaster dto);

	List<PpPayscalemaster> getPayScaleList(short sysPaycategoryid);

	boolean editPayScale(PpPayscalemaster ppPayscalemaster);

	Boolean deleteHeadQuarter(String ppPayscalemasterid);
	
}
