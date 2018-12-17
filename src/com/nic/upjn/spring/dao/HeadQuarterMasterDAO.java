package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.entity.PpPlacemaster;

public interface HeadQuarterMasterDAO {

	List getList(String condition, String namedQuery);

	List checkExistanceOfPlaceName(String place, Integer masDistrictid);

	int AddPlace(PpPlacemaster placemaster);

	Boolean deleteHeadQuarter(String ppPlacemasterid);

	int editPlace(PpPlacemaster placemaster);

}
