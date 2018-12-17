package com.nic.upjn.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nic.upjn.miscellaneous.CalenderUtils;
import com.nic.upjn.spring.Service.ReportManagerService;
import com.nic.upjn.spring.dto.DeductionLoanScheduleDTO;
import com.nic.upjn.spring.entity.DeductionLoanScheduleEntity;
import com.nic.upjn.spring.entity.PpRegistermaster;
import com.nic.upjn.spring.entity.PpSchedulemaster;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.ViewPayGetscheduleheadlist;

@SuppressWarnings({ "unchecked", "unused" })
@Controller
public class DeductionLoanScheduleController {

	@Autowired
	ReportManagerService reportManagerService;

	@RequestMapping("/DeductionLoanSchedule.do")
	public ModelAndView dedLoanScheduleReportForm(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView target = new ModelAndView("deductionLoanScheduleReportForm");

		List<PpRegistermaster> registerlist = (List<PpRegistermaster>) reportManagerService.getList(null,
				"PpRegistermaster.findAll");

		List<PpSchedulemaster> scheduleList = (List<PpSchedulemaster>) reportManagerService.getList(null,
				"PpSchedulemaster.findAll");

		List<?> months = CalenderUtils.populateMonth();
		List<?> years = CalenderUtils.populateYear();

		target.addObject("months", months);
		target.addObject("years", years);
		target.addObject("registerList", registerlist);
		target.addObject("scheduleList", scheduleList);

		HttpSession session = request.getSession();

		target.addObject("employee_name", (String) session.getAttribute("employeename"));
		target.addObject("designation_", (String) session.getAttribute("designation"));

		return target;
	}

	@RequestMapping(value = "/DeductionScheduleReport", method = RequestMethod.POST)
	public ModelAndView DeductionScheduleReport(
			@ModelAttribute("deductionLoanScheduleDTO") DeductionLoanScheduleDTO deductionLoanScheduleDTO,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("DeductionScheduleReport");
		String scheduleName = null;
		String registerName = null;

		HttpSession session = request.getSession();
		Integer rmOfficeid = (Integer) session.getAttribute("rmOfficeid");
		String temp_monthName = CalenderUtils.getMonth(deductionLoanScheduleDTO.getMonthName());
		List<DeductionLoanScheduleEntity> scheduleList = (List<DeductionLoanScheduleEntity>) reportManagerService
				.getEmployeeScheduleList(deductionLoanScheduleDTO.getMonthName(),
						deductionLoanScheduleDTO.getYearName(), deductionLoanScheduleDTO.getPp_ScheduleMasterID(),
						deductionLoanScheduleDTO.getPp_RegisterMasterID(), rmOfficeid);

		List<PpSchedulemaster> scheduleNameList = (List<PpSchedulemaster>) reportManagerService.getList(
				deductionLoanScheduleDTO.getPp_ScheduleMasterID(), "PpSchedulemaster.findByPpSchedulemasterid");
		for (PpSchedulemaster ppSchedulemaster : scheduleNameList) {
			scheduleName = ppSchedulemaster.getSchedulename();
			modelAndView.addObject("scheduleName", ppSchedulemaster.getSchedulename());
		}

		List<PpRegistermaster> RegisterNameList = (List<PpRegistermaster>) reportManagerService.getList(
				deductionLoanScheduleDTO.getPp_RegisterMasterID(), "PpRegistermaster.findByPpRegistermasterid");
		for (PpRegistermaster ppRegistermaster : RegisterNameList) {
			registerName = ppRegistermaster.getRegistername();
			modelAndView.addObject("registerName", ppRegistermaster.getRegistername());
		}

		List<ViewPayGetscheduleheadlist> scheduleHeadList = (List<ViewPayGetscheduleheadlist>) reportManagerService
				.getList(deductionLoanScheduleDTO.getPp_ScheduleMasterID(),
						"ViewPayGetscheduleheadlist.findByPpSchedulemasterid");

		boolean isGPF = reportManagerService.isGPFSchedule(deductionLoanScheduleDTO.getPp_ScheduleMasterID(),
				scheduleName);

		if (isGPF) {
			request.setAttribute("visible", "1");
		} else {
			request.setAttribute("visible", "0");
		}
		boolean isNPS = reportManagerService.isNPSSchedule(deductionLoanScheduleDTO.getPp_ScheduleMasterID(),
				scheduleName);
		if (deductionLoanScheduleDTO.getPp_ScheduleMasterID().equals("16")) {
			request.setAttribute("regvis", "1");
		} else {
			request.setAttribute("regvis", "0");
		}

		modelAndView.addObject("registerName", registerName);
		modelAndView.addObject("scheduleName", scheduleName);
		modelAndView.addObject("monthName", temp_monthName);
		modelAndView.addObject("yearName", deductionLoanScheduleDTO.getYearName());
		modelAndView.addObject("scheduleHeadList", scheduleHeadList);
		request.setAttribute("pp_ScheduleMasterID", deductionLoanScheduleDTO.getPp_ScheduleMasterID());
		prepareReportData(scheduleList, modelAndView, request);

		request.setAttribute("scheduleHeadList", scheduleHeadList);

		modelAndView.addObject("scheduleHeadList", scheduleHeadList);
		List<RmOffice> officeListName = (List<RmOffice>) reportManagerService.getList(rmOfficeid + "",
				"RmOffice.findByRmOfficeid");
		for (RmOffice rmOffice : officeListName) {

			modelAndView.addObject("officeName", rmOffice.getOfficename());
		}

		modelAndView.addObject("employee_name", (String) session.getAttribute("employeename"));
				modelAndView.addObject("designation_", (String) session.getAttribute("designation"));

		return modelAndView;

	}

	private void prepareReportData(List<DeductionLoanScheduleEntity> scheduleList, ModelAndView modelAndView,
			HttpServletRequest request) {

		ListIterator listIterator = scheduleList.listIterator();
		String pp_ScheduleMasterID = request.getParameter("pp_ScheduleMasterID");
		String prevEmployee = "";
		ArrayList employeeList = new ArrayList();
		ArrayList employeeNameList = new ArrayList();
		ArrayList employeePANNOList = new ArrayList();
		ArrayList employeeGPFAcNoList = new ArrayList();
		ArrayList employeeValueList = new ArrayList();
		ArrayList employeeRegisterList = new ArrayList();
		ArrayList employeeNetPayList = new ArrayList();
		HashMap employeeNameMap = new HashMap();
		HashMap employeeGPFAcNoMap = new HashMap();
		HashMap employeeValueMap = new HashMap();
		HashMap employeeRegisterMap = new HashMap();
		HashMap employeePANNoMap = new HashMap();
		HashMap employeeNetPayMap = new HashMap();
		try {
			String employeeCode;
			String headId;
			String headType;
			String amount;
			for (; listIterator.hasNext(); System.out.println(
					(new StringBuilder()).append("--------Values:  ").append(employeeCode).append("@").append(headType)
							.append("@").append(headId).append("----------").append(amount).toString())) {
				DeductionLoanScheduleEntity deductionLoanScheduleEntity = (DeductionLoanScheduleEntity) listIterator
						.next();
				employeeCode = deductionLoanScheduleEntity.getEmployeeCode();
				String employeeName = deductionLoanScheduleEntity.getEmployeeName();
				String gPFACNO = deductionLoanScheduleEntity.getgPFACNO();

				headId = deductionLoanScheduleEntity.getTran_TypeID();
				headType = deductionLoanScheduleEntity.getHeadType();
				amount = deductionLoanScheduleEntity.getAmount();
				String headName = deductionLoanScheduleEntity.getHeadName();
				String register = deductionLoanScheduleEntity.getPp_RegisterMasterID();
				String panNo = deductionLoanScheduleEntity.getPanNo();
				System.out.println("panNo" + panNo);
				// String netpay = deductionLoanScheduleEntity.getNetPay();
				if (!prevEmployee.equals(employeeCode)) {
					employeeList.add(employeeCode);
					prevEmployee = employeeCode;
					employeeNameMap.put(employeeCode, employeeName);
					employeeGPFAcNoMap.put(employeeCode, gPFACNO);
					employeeRegisterMap.put(employeeCode, register);
					employeePANNoMap.put(employeeCode, panNo);
					// employeeNetPayMap.put(employeeCode, netpay);
					System.out.println((new StringBuilder()).append("==================").append(employeeCode)
							.append("===========").append(employeeName).append("==============").append(gPFACNO)
							.toString());
				}
				employeeValueMap.put((new StringBuilder()).append(employeeCode).append("@").append(headType).append("@")
						.append(headId).toString(), amount);
			}

			employeeNameList.add(employeeNameMap);
			employeeGPFAcNoList.add(employeeGPFAcNoMap);
			employeeRegisterList.add(employeeRegisterMap);
			employeeValueList.add(employeeValueMap);
			employeePANNOList.add(employeePANNoMap);
			employeeNetPayList.add(employeeNetPayMap);
			request.setAttribute("employeeList", employeeList);
			modelAndView.addObject("employeeList", employeeList);

			request.setAttribute("employeeNameMap", employeeNameMap);
			request.setAttribute("employeeGPFAcNoMap", employeeGPFAcNoMap);
			request.setAttribute("employeeRegisterMap", employeeRegisterMap);
			request.setAttribute("employeeValueMap", employeeValueMap);
			request.setAttribute("employeePANNoMap", employeePANNoMap);
			request.setAttribute("pp_ScheduleMasterID", pp_ScheduleMasterID);

			if (pp_ScheduleMasterID == null ? "7" == null : pp_ScheduleMasterID.equals("7"))

			{
				System.out.println("pp_ScheduleMasterID" + pp_ScheduleMasterID);

				modelAndView.addObject("employeeNetPayMap", employeeNetPayMap);
			}
		}

		catch (Exception e) {
			System.out.println(
					(new StringBuilder()).append("error inside createPDF method of action ").append(e).toString());
		}

	}

}
