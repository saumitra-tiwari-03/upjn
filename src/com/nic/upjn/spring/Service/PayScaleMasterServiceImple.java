package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.upjn.spring.dao.PayScaleMasterDAO;
import com.nic.upjn.spring.dto.PayScaleMasterDTO;
import com.nic.upjn.spring.entity.PpPayscalemaster;

@Service("PayScaleMasterService")
public class PayScaleMasterServiceImple implements PayScaleMasterService {

	@Autowired 
	PayScaleMasterDAO payscalemasterDAO;
	
	@Override
	public List paycategorylist(String value, String namedQuery) {
		List paycategory = null;
		
		try{
			paycategory = payscalemasterDAO.getlist(value,namedQuery);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	return paycategory;
	}

	
	@Override
	public boolean checkExistanceOfPayScale(String payscale) {
           List payscalelist = null;
           boolean result = false;
		
		try{
			payscalelist = payscalemasterDAO.getlist(payscale,"PpPayscalemaster.findByPayscale");
			
			System.out.println("size of payscalelist - "+payscalelist.size());
			
			if(payscalelist.size() > 0){
			     result = true;	
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	return result;
	}


	@Override
	public boolean AddPayScale(PpPayscalemaster dto) {
		 
         boolean result =  false;
		
		try{
			result = payscalemasterDAO.insertPayScaleIntoDB(dto);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public List<PpPayscalemaster> getPayScaleList(short sysPaycategoryid) {
List<PpPayscalemaster> list = null;
		
		list  = payscalemasterDAO.getPayScaleList(sysPaycategoryid);
		
		return list;
	}


	@Override
	public boolean EditPayScale(PpPayscalemaster ppPayscalemaster) {
		 boolean result =  false;
			
			try{
				result = payscalemasterDAO.editPayScale(ppPayscalemaster);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return result;
	}


	@Override
	public boolean deletePayScale(String ppPayscalemasterid) {
		Boolean result = false;
		
		  result = payscalemasterDAO.deleteHeadQuarter(ppPayscalemasterid);
		
		return result;
	}
	

}
