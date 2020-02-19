package com.tts.password.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tts.password.model.Staff;
import com.tts.password.service.StaffService;

@Controller
public class StaffController {

	private static final Logger logger = Logger.getLogger(StaffController.class);

	public StaffController() {
		System.out.println("StaffController()");
	}
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping(value= "/")
	public ModelAndView homeStaff(ModelAndView model) throws IOException{
		List<Staff> listStaff= staffService.getAllStaff();
		model.addObject("listStaff", listStaff);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value="/saveStaff", method = RequestMethod.POST)
	public ModelAndView saveStaff(@ModelAttribute Staff staff) {
		if(staff.getId() == 0) {
			staffService.addStaff(staff);
		}else {
			staffService.updateStaff(staff);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/newStaff", method= RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Staff staff = new Staff();
		model.addObject("staff",staff);
		model.setViewName("StaffForm");
		return model;
	}
	
	@RequestMapping(value = "/deleteStaff", method= RequestMethod.GET)
	public ModelAndView deleteStaff(HttpServletRequest request) {
		int staffId= Integer.parseInt(request.getParameter("id"));
		staffService.deleteStaff(staffId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editStaff", method=RequestMethod.GET)
	public ModelAndView editStaff(HttpServletRequest request) {
		int staffId = Integer.parseInt(request.getParameter("id"));
		Staff staff = staffService.getStaffById(staffId);
		System.out.println(staff.getPassword());
		ModelAndView model = new ModelAndView("StaffForm");
		model.addObject("staff", staff);
		return model;
	}
	
}
