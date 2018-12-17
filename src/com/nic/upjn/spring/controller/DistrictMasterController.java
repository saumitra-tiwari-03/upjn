package com.nic.upjn.spring.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.spring.Service.DistrictMasterService;
import com.nic.upjn.spring.dto.DistrictMasterDTO;
import com.nic.upjn.spring.entity.MasDistrict;
import com.nic.upjn.spring.entity.MasState;

@Controller
public class DistrictMasterController {

	@Autowired
	DistrictMasterService districtMasterService;

	@RequestMapping("/ManageDistrict.do")
	public ModelAndView begin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("districtmaster");
		HashMap<Integer, String> stateMap = new HashMap<Integer, String>();

		List<?> list = districtMasterService.getList(null, "MasState.findAll");

		List<?> list1 = districtMasterService.getList(null, "MasDistrict.findAll");

		for (Object object : list) {
			if (object instanceof MasState) {
				MasState masState = (MasState) object;
				stateMap.put(Integer.parseInt("" + masState.getMasStateid()), masState.getStatename().toString());

			}
		}

		modelAndView.addObject("stateMap", stateMap);
		modelAndView.addObject("districtList", list1);
		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	@RequestMapping(value = "/insertNewDistrict", method = RequestMethod.POST)
	public ModelAndView insertNewDistrict(@ModelAttribute("districtMasterDTO") DistrictMasterDTO districtMasterDTO,
			HttpServletRequest request, HttpServletResponse response) {

		HashMap<Integer, String> stateMap = new HashMap<Integer, String>();
		ModelAndView modelAndView = new ModelAndView("districtmaster");

		Integer district_Id = null;
		List<?> list = districtMasterService.getList(null, "MasState.findAll");
		
		for (Object object : list) {
			if (object instanceof MasState) {
				MasState masState = (MasState) object;
				stateMap.put(Integer.parseInt("" + masState.getMasStateid()), masState.getStatename().toString());

			}
		}

		modelAndView.addObject("stateMap", stateMap);
		modelAndView.addObject("stateList", list);

		boolean isExistanceError = this.checkExistance(districtMasterDTO);
		if (!isExistanceError) {
			district_Id = districtMasterService.AddDistrict(districtMasterDTO);
			if (district_Id != null) {
				modelAndView.addObject("mes", "New District added successfully");
			}
		} else {
			modelAndView.addObject("error", "ambiguity occurs in District ");
		}

		List<?> list1 = districtMasterService.getList(null, "MasDistrict.findAll");
		modelAndView.addObject("districtList", list1);
		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	@RequestMapping("/EditDistrictMaster")
	public ModelAndView EditDistrictMasterDetails(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("districtmaster");
		HashMap<Integer, String> stateMap = new HashMap<Integer, String>();

		try {

			String id = request.getParameter("masDistrictid");
			Integer districtid = Integer.parseInt(id);

			List<?> list2 = districtMasterService.getList(districtid, "MasDistrict.findByMasDistrictid");

			List<?> list = districtMasterService.getList(null, "MasState.findAll");

			List<?> list1 = districtMasterService.getList(null, "MasDistrict.findAll");

			for (Object object : list) {
				if (object instanceof MasState) {
					MasState masState = (MasState) object;
					stateMap.put(Integer.parseInt("" + masState.getMasStateid()), masState.getStatename().toString());

				}
			}

			modelAndView.addObject("stateMap", stateMap);
			modelAndView.addObject("districtList", list1);
			modelAndView.addObject("districtdetails", list2);
		} catch (Exception e) {

			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	@RequestMapping("/editDistrict")
	public ModelAndView editDistrictMaster(@ModelAttribute("districtMasterDTO") DistrictMasterDTO districtMasterDTO,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("districtmaster");
		HashMap<Integer, String> stateMap = new HashMap<Integer, String>();
		List<?> list1 = null;
		MasDistrict masDistrict = new MasDistrict();

		try {

			boolean isExistanceError = this.checkExistance(districtMasterDTO);
			if (!isExistanceError) {
				masDistrict.setCensusdistrictcode(districtMasterDTO.getCensusDistrictCode());
				masDistrict.setDistrictname(districtMasterDTO.getDistrictName());
				masDistrict.setMAS_STATEID(districtMasterDTO.getMas_StateID());
				masDistrict.setMasDistrictid(districtMasterDTO.getMas_DistrictID());
				masDistrict.setZoneCode(null);
				masDistrict.setZoneDesc(null);

				Integer result = districtMasterService.EditDistrict(masDistrict);
				if (result != null) {
					modelAndView.addObject("mes", " District Edited successfully");
				} else {
					modelAndView.addObject("error", "Error ");
				}
			}
			List<?> list = districtMasterService.getList(null, "MasState.findAll");
			list1 = districtMasterService.getList(null, "MasDistrict.findAll");

			for (Object object : list) {
				if (object instanceof MasState) {
					MasState masState = (MasState) object;
					stateMap.put(Integer.parseInt("" + masState.getMasStateid()), masState.getStatename().toString());

				}
			}

			modelAndView.addObject("stateMap", stateMap);
			modelAndView.addObject("districtList", list1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	@RequestMapping("/DeleteDistrictMaster")
	public ModelAndView DeleteDistrictMaster(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("districtmaster");
		HashMap<Integer, String> stateMap = new HashMap<Integer, String>();

		try {

			String id = request.getParameter("masDistrictid");
			Integer districtid = Integer.parseInt(id);

			boolean result = districtMasterService.deleteHeadQuarter(id);

			if (result == true) {
				modelAndView.addObject("mes", "District Deleted");
			} else {
				modelAndView.addObject("error", "Error");
			}

			List<?> list = districtMasterService.getList(null, "MasState.findAll");

			List<?> list1 = districtMasterService.getList(null, "MasDistrict.findAll");

			for (Object object : list) {
				if (object instanceof MasState) {
					MasState masState = (MasState) object;
					stateMap.put(Integer.parseInt("" + masState.getMasStateid()), masState.getStatename().toString());

				}
			}

			modelAndView.addObject("stateMap", stateMap);
			modelAndView.addObject("districtList", list1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
		modelAndView.addObject("designation_", (String) session.getAttribute("designation"));
		return modelAndView;

	}

	private boolean checkExistance(DistrictMasterDTO districtMasterDTO) {

		boolean isCensusCodeAndNamet = false;
		boolean isExistanceError = false;

		isCensusCodeAndNamet = districtMasterService.checkDistrictAndCode(districtMasterDTO);

		if (isCensusCodeAndNamet) {
			isExistanceError = true;
		} else {
			isExistanceError = false;
		}

		return isExistanceError;

	}

}
