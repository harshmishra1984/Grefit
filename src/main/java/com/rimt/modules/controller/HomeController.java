package com.rimt.modules.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rimt.form.SignUp;
import com.rimt.modules.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String submit(ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
		return "dashboard";
	}
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String submitPost(ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
		return "dashboard";
	}
	
	 @RequestMapping(value="/fail2login", method = RequestMethod.GET)  
	 public String loginerror(ModelMap model) {  
		 model.addAttribute("error", "true");  
		 return "login";  
	 } 

}
