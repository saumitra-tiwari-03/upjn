package com.nic.upjn.spring.Service;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.upjn.spring.dao.HeadQuarterMasterDAO;
import com.nic.upjn.spring.dto.HeadQuarterMasterDTO;
import com.nic.upjn.spring.entity.PpPlacemaster;

@Service("HeadQuarterMasterService")
public class HeadQuarterMasterServiceImple implements HeadQuarterMasterService{

	@Autowired
	HeadQuarterMasterDAO dao;

	@Override
	public List getList(String condition, String namedQuery) {
		List list = null;
		
		list = dao.getList(condition,namedQuery);
		
		return list;
	}

	@Override
	public boolean checkExistanceOfPlaceName(HeadQuarterMasterDTO dto) {
       
		List list = null;
		Boolean result = false;
		
		list = dao.checkExistanceOfPlaceName(dto.getPlace(),dto.getMasDistrictid());
		
		if(list.size() > 0){
			result = true;
		}
		
		return result;
	}

	@Override
	public int AddPlace(PpPlacemaster placemaster) {

		int insert = dao.AddPlace(placemaster);
		
		return insert;
	}

	@Override
	public boolean deleteHeadQuarter(String ppPlacemasterid) {
		Boolean result = false;
		
		  result = dao.deleteHeadQuarter(ppPlacemasterid);
		
		return result;
	}

	@Override
	public PpPlacemaster getPlaceInfo(String ppPlacemasterid) {
         List list = null;
		
		list = dao.getList(ppPlacemasterid,"PpPlacemaster.findByPpPlacemasterid");
		
		PpPlacemaster ppPlacemaster = new PpPlacemaster();
		
		// iterating through the list
					Iterator iterator = list.listIterator();
					while (iterator.hasNext()) {

						// retrieving DTO from the List
						ppPlacemaster = (PpPlacemaster) iterator.next();
					} // end While

		
		return ppPlacemaster;
	}

	@Override
	public int editPlace(PpPlacemaster placemaster) {
         int insert = dao.editPlace(placemaster);
		
		return insert;
	}
	
}
