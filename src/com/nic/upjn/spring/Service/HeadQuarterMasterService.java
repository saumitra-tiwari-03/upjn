package com.nic.upjn.spring.Service;

import java.util.List;

import com.nic.upjn.spring.dto.HeadQuarterMasterDTO;
import com.nic.upjn.spring.entity.PpPlacemaster;

public interface HeadQuarterMasterService {

	List getList(String condition, String namedQuery);

	boolean checkExistanceOfPlaceName(HeadQuarterMasterDTO dto);

	int AddPlace(PpPlacemaster placemaster);

	boolean deleteHeadQuarter(String ppPlacemasterid);

	PpPlacemaster getPlaceInfo(String ppPlacemasterid);

	int editPlace(PpPlacemaster placemaster);

}
