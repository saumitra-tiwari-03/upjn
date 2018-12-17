package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nic.upjn.spring.dao.DistrictMasterDao;
import com.nic.upjn.spring.dto.DistrictMasterDTO;
import com.nic.upjn.spring.entity.MasDistrict;
@Service("districtMasterService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DistrictMasterServiceImpl implements DistrictMasterService {
	
	
	@Autowired
	DistrictMasterDao districtMasterDao;

	public List<?> getList(Integer where_condition, String namedQuery) {

		List<?> list = districtMasterDao.getList(where_condition, namedQuery);

		return list;
	}

	public Integer AddDistrict(DistrictMasterDTO districtMasterDTO) {

		Integer district_ID = districtMasterDao.AddDistrict(districtMasterDTO);
		return district_ID;
	}

	public boolean checkDistrictAndCode(DistrictMasterDTO districtMasterDTO) {

		boolean check = false;
		check = districtMasterDao.checkDistrictAndCode(districtMasterDTO);
		return check;
	}

	@Override
	public Integer EditDistrict(MasDistrict masDistrict) {
		Integer district_ID = districtMasterDao.EditDistrict(masDistrict);
		return district_ID;
	}

	@Override
	public boolean deleteHeadQuarter(String id) {
		Boolean result = false;
		
		  result = districtMasterDao.deleteHeadQuarter(id);
		
		return result;
	}

}
