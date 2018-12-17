package com.nic.upjn.spring.Service;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.nic.upjn.spring.dao.UpdatePayDetailDAO;
import com.nic.upjn.spring.dto.Alw_ForPayCategoryDTO;
import com.nic.upjn.spring.dto.PayAllowanceComponentsDTO;
import com.nic.upjn.spring.dto.PayAlw_MasterDTO;
import com.nic.upjn.spring.dto.RuleMasterDTO;
import com.nic.upjn.spring.entity.PpRulemaster;

public class AllowancesManager{

	public String pp_EmployeeMasterID;
	public String pp_PayAlw_MasterID;
	public String[] componentID;
	public String pp_PayAlw_Value;
	public String pp_RuleMasterID;
	public String sys_RuleCategoryID;
	public String pp_EmploymentSubTypeID;
	public String dateOfEffect;
	public boolean isTownCatBased;
	public boolean isSubTypeBased;
	public String stopAlwFlag;
	public String payAlwName;
    public String b_pay;
       
	

    UpdatePayDetailDAO dao;
    public PayAlw_MasterDTO dto = null;
	
	public Hashtable townCategoryID = null;

	
	public AllowancesManager(String pp_EmployeeMasterID,Hashtable townCategoryID,String pp_EmploymentSubTypeID,String dateOfEffect,String b_pay,UpdatePayDetailDAO updatePayDetailDAO){
		this.pp_EmployeeMasterID = pp_EmployeeMasterID;
		this.townCategoryID = townCategoryID;
		this.pp_EmploymentSubTypeID = pp_EmploymentSubTypeID;
		this.dateOfEffect = dateOfEffect;
                this.b_pay=b_pay;
		dao = updatePayDetailDAO;
	}
	
	
	
	public void getRuleMasterAndSetValues(Alw_ForPayCategoryDTO alwDTO,UpdatePayDetailDAO updatePayDetailDAO)
	{
		try{
			this.pp_PayAlw_MasterID = alwDTO.getPp_PayAlwMasterID()+"";
			dao = updatePayDetailDAO;
			this.pp_RuleMasterID = alwDTO.getPp_RuleMasterID();
			//System.out.println("RULEMASTERID for PAYALWID "+pp_PayAlw_MasterID+" is : "+	this.pp_RuleMasterID);
			this.sys_RuleCategoryID = alwDTO.getSys_RuleCategoryID();
			this.isSubTypeBased = dao.isSubTypeBased(alwDTO.getSys_RuleCategoryID());	
			this.setComponentID(pp_PayAlw_MasterID);
			this.stopAlwFlag =  alwDTO.getStop_Alw_Flag();
			this.payAlwName = alwDTO.getHeadName();
			}
		catch(Exception e){
			System.out.println("Exception Raised in getRuleMasterAndSetValues" + e.toString());
		}		
	}



	public void setComponentID( String pp_PayAlwMasterID) throws Exception{

		List list = null;
		
		
		
		BigDecimal pp_PayAlw_MasterId=null;
		Iterator<BigDecimal> itr;
		
		int counter = 0;
		PayAllowanceComponentsDTO pdto = new PayAllowanceComponentsDTO();
		try{
			
			list = dao.getComponentID(pp_PayAlwMasterID);
			
			this.componentID = new String[list.size()];
			
			
	        itr = list.iterator();
			while (itr.hasNext()) {
			
				
				pp_PayAlw_MasterId = (BigDecimal)itr.next();	
				pdto.setPp_PayAlw_MasterId(pp_PayAlw_MasterId+"");
				this.componentID[counter] = pdto.getPp_PayAlw_MasterId()+"";
				counter++;
			}
		}catch(Exception e){
			System.out.println("Exception Raised in " + e.toString());
			
		}
	}
	
	public String[] getComponentID(){
		return this.componentID;
	}
	
	
	public String getPayProcessValue(List<Alw_ForPayCategoryDTO> alwDTOList, UpdatePayDetailDAO updatePayDetailDAO){ //, String pp_EmployeeMasterID){
            
	String payValue = "0" ;
        String  basicPay="0";
       
        int count=0;
        String[] str = this.getComponentID();
        
        String value = "";
        
		
		double total = 0;
		
		AllowancesManager aman = new AllowancesManager(this.pp_EmployeeMasterID,this.townCategoryID,this.pp_EmploymentSubTypeID,this.dateOfEffect,this.b_pay,updatePayDetailDAO);
		try
		{
               if(str.length > 0){				
				
				for(int i = 0 ; i < str.length ; i++){
                                    
					
				
					boolean flag = false;
					for(Alw_ForPayCategoryDTO alwDTO : alwDTOList)
					{
						if(alwDTO.getPp_PayAlwMasterID().toString().equals(str[i])){
							if (alwDTO.getIsCalculated().equals("1")) // if sub component is alreadycalculated
							{
							payValue = alwDTO.getPayValue();
                                                        
                                                        
                                                        							} 
							
                            else {
								
							//	System.out.println(str[i]+" value iss");
								
								aman.getRuleMasterAndSetValues(str[i]);//, this.dateOfEffect, this.townCategoryID,pp_EmployeeMasterID);
								aman.stopAlwFlag =  alwDTO.getStop_Alw_Flag();
								aman.pp_EmploymentSubTypeID = this.pp_EmploymentSubTypeID;
							    payValue = aman.getPayProcessValue(alwDTOList,updatePayDetailDAO); //,pp_EmployeeMasterID);   //recursively calling of the method;
								System.out.println(payValue +"iss");
								System.out.println(alwDTO.getPp_PayAlwMasterID()+", pay value:"+alwDTO.getPayValue()+", iscalculated"+alwDTO.getIsCalculated()+" Before");
								alwDTO.setPayValue(payValue);
								alwDTO.setIsCalculated("1");
								System.out.println(alwDTO.getPp_PayAlwMasterID()+", pay value:"+alwDTO.getPayValue()+", iscalculated"+alwDTO.getIsCalculated()+" After");
							}
							break;
						}
					}
					
					total = total + Double.parseDouble(payValue);
                    System.out.println("++++++++++++"+total+"++++++++++++");
					
					
                                       
				} // end of for loop
				
				payValue = ""+((long)Math.round(total));
				
				
				
				if(this.stopAlwFlag.equals("0")){
					System.out.println(" abhinav Iske andar aya : "+this.pp_PayAlw_MasterID+" , "+total+", "+this.sys_RuleCategoryID);
                                                                                                                                                                                                                                                                                                                                               
			                 
                                        //String payAlwName = empPayDetailDAO.getNPSvalue(employeeID);
                                        System.out.println("payValue"+payValue);
                                        System.out.println("b_pay"+this.b_pay);
					if(this.sys_RuleCategoryID.equals("0")){
						value = payValue;
					}else if(this.sys_RuleCategoryID.equals("1")){
						value =  dao.getInputPayRangeAndPercentBased(payValue, this.pp_RuleMasterID, this.townCategoryID, payAlwName);
					}else if( this.sys_RuleCategoryID.equals("2")){
                                            System.out.println("condition basic pay"+basicPay);
						value = dao.getInputPayRangeAndFlatValueBased(payValue, this.pp_RuleMasterID, this.townCategoryID, payAlwName,this.b_pay);
					}else if(this.sys_RuleCategoryID.equals("3")){
						value = dao.getInputEmpCategoryAndPayPercentBased(payValue, this.pp_EmploymentSubTypeID, this.pp_RuleMasterID, this.townCategoryID, payAlwName);
					}else if(this.sys_RuleCategoryID.equals("4")){
						value = dao.getEmpCategoryAndFlatValueBased(this.pp_EmploymentSubTypeID, this.pp_RuleMasterID, this.townCategoryID, payAlwName);
					}else if(this.sys_RuleCategoryID.equals("5")){
						value = dao.getFlatForAll( this.pp_RuleMasterID, this.townCategoryID, payAlwName);
					}
                                        System.out.println("abhiav  hra calucualted  value "+value+"this.townCategoryID"+this.townCategoryID);
					payValue = value;
				}else{
					payValue = "0";
				}
				
               }
               else
               {
            	   if(this.stopAlwFlag.equals("0")){   
   					
   					if( this.sys_RuleCategoryID.equals("2")){
   						payValue = dao.getInputPayRangeAndFlatValueBased(payValue, this.pp_RuleMasterID, this.townCategoryID, payAlwName,basicPay);
   					}else if(this.sys_RuleCategoryID.equals("4")){
   						System.out.println("YYY-"+this.pp_EmploymentSubTypeID+", "+ this.pp_RuleMasterID+", "+this.townCategoryID+", "+ payAlwName);
   						payValue = dao.getEmpCategoryAndFlatValueBased(this.pp_EmploymentSubTypeID, this.pp_RuleMasterID, this.townCategoryID, payAlwName);
   						
   					}else if(this.sys_RuleCategoryID.equals("5")){
   						
   						payValue = dao.getFlatForAll( this.pp_RuleMasterID, this.townCategoryID, payAlwName);
   					}
   					
   					}  
   					else {
   						payValue="0"; 
   					} 
               }
               
               
               
			
		}
		
		catch(Exception e)
		{
			System.out.println("Exception Raised in getPayProcessValue " + e.toString());
		}
		finally{
            try
    {
      
                System.out.println("++++++++hi abhinav++++++this.pp_RuleMasterID"+this.pp_RuleMasterID);
                System.out.println("++++++++hi abhinav++++++this.this.pp_EmployeeMasterID"+this.pp_EmployeeMasterID);
	            payAlwName = dao.getNPSvalue(this.pp_EmployeeMasterID,this.pp_RuleMasterID);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
		}
		return payValue;
}

	
	                    
	
	
	



	public void getRuleMasterAndSetValues(String pp_PayAlwMasterID){ //, String dateOfEffect, Hashtable townCategoryID,String pp_EmployeeMasterID){
		
		dto = new PayAlw_MasterDTO();
		List <PpRulemaster>list = null;
		
		this.pp_PayAlw_MasterID = pp_PayAlwMasterID;
		RuleMasterDTO rdto = new RuleMasterDTO();
		this.payAlwName = dao.getPayAlwName(this.pp_PayAlw_MasterID);
		
		this.stopAlwFlag=dao.getStop_Alw_Flag(pp_EmployeeMasterID, this.pp_PayAlw_MasterID);
		
		try{
			
			list = dao.getRuleMaster(pp_PayAlwMasterID, dateOfEffect);
			
			for(PpRulemaster ppRulemaster : list)
			{
				this.pp_RuleMasterID = rdto.getPp_RuleMasterID();
				this.sys_RuleCategoryID = rdto.getSys_RuleCategoryID();
				this.isSubTypeBased = dao.isSubTypeBased(rdto.getSys_RuleCategoryID());	
				this.setComponentID(pp_PayAlwMasterID);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
	
	
                
		
				
					
					
			
		



	



	