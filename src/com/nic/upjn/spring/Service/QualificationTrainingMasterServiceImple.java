package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.upjn.spring.dao.QualificationTrainingMasterDAO;
import com.nic.upjn.spring.entity.PpQualificationmaster;
import com.nic.upjn.spring.entity.PpTrainingtypemaster;

@Service("QualificationTrainingMasterService")
public class QualificationTrainingMasterServiceImple implements QualificationTrainingMasterService{
	
	@Autowired
	QualificationTrainingMasterDAO dao;

	@Override
	public int AddQualification(PpQualificationmaster ppQualificationmaster) {
            int insert = dao.AddQualification(ppQualificationmaster);		
		return insert;
	}

	@Override
	public int AddTraining(PpTrainingtypemaster ppTrainingtypemaster) {
		  int insert = dao.AddTraining(ppTrainingtypemaster);		
			return insert;
	}
	
	@Override
	public List getList(String condition, String namedQuery) {
		List list = null;
		
		list = dao.getList(condition,namedQuery);
		
		return list;
	}

	@Override
	public int editQualification(PpQualificationmaster ppQualificationmaster) {
		 int insert = dao.editQualification(ppQualificationmaster);		
			return insert;
	}

	@Override
	public int editTraining(PpTrainingtypemaster ppTrainingtypemaster) {
		 int insert = dao.editTraining(ppTrainingtypemaster);		
			return insert;
	}

	@Override
	public boolean deleteQualification(String ppQualificationmasterid) {
		Boolean result = false;	
		  result = dao.deleteQualification(ppQualificationmasterid);	
		return result;
	}

	@Override
	public boolean deleteTraining(String ppTrainingtypemasterid) {
		Boolean result = false;	
	    result = dao.deleteTraining(ppTrainingtypemasterid);
		return result;
	}

}
