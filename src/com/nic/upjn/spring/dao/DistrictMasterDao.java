package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.dto.DistrictMasterDTO;
import com.nic.upjn.spring.entity.MasDistrict;

public interface DistrictMasterDao {
	public List<?> getList(Integer where_condition, String namedQuery);
	public Integer AddDistrict(DistrictMasterDTO districtMasterDTO);
	public boolean checkDistrictAndCode(DistrictMasterDTO districtMasterDTO);
	public Integer EditDistrict(MasDistrict masDistrict);
	public Boolean deleteHeadQuarter(String id);

}
