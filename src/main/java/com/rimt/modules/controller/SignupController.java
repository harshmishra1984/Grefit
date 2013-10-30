package com.rimt.modules.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rimt.common.util.Helper;
import com.rimt.core.AccountUtil;
import com.rimt.dataaccess.entities.A;
import com.rimt.dataaccess.entities.B;
import com.rimt.dataaccess.entities.Builders;
import com.rimt.dataaccess.entities.City;
import com.rimt.dataaccess.entities.Country;
import com.rimt.dataaccess.entities.Organization;
import com.rimt.dataaccess.entities.Roles;
import com.rimt.dataaccess.entities.State;
import com.rimt.dataaccess.entities.UserAccount;
import com.rimt.dataaccess.entities.UserExperties;
import com.rimt.dataaccess.entities.UserFellow;
import com.rimt.dataaccess.entities.UserOrganizationAddressDetails;
import com.rimt.form.OrganizationForm;
import com.rimt.form.ProfessionalExpertiesForm;
import com.rimt.form.SignUp;
import com.rimt.modules.service.DataService;
import com.rimt.modules.service.SignupService;

@Controller
public class SignupController {
	
	 @Resource
	 protected SignupService signupService;
	 
	 @Resource
	 protected DataService dataService;
	 
	 @Autowired
	 protected AuthenticationManager authenticationManager;
	
	 
	 @RequestMapping(value="/signup", method = RequestMethod.GET)  
	 public ModelAndView signup(ModelMap model) {
		 return new ModelAndView("signup", "signup", new SignUp());
	 } 
	 
	 @RequestMapping(value="/signup", method = RequestMethod.POST)
	 public String signupSubmit(@ModelAttribute("signup")
	 						SignUp signup, ModelMap model,HttpServletRequest request ) {  
		 
		// HttpSession session = request.getSession();
		 int userType = signup.getUserType();
		 Roles role = dataService.getRole(1L); // to do later
		 
		 UserAccount user = Helper.signupFormToUserAccount(signup, role);
		 long stateId = Helper.conevrtStringToLong(signup.getState());
		 Organization org = null; 
		 if(userType == 1){
			 org = new Organization();
			 org = Helper.signupFormToOrganization(signup);
			 user.getOrganizations().add(org);
		 }
		 signupService.saveUser(user);
		 if(userType == 1){
			 UserOrganizationAddressDetails orgDetails= new UserOrganizationAddressDetails();
			 orgDetails.setState(state(stateId));
			 orgDetails.setCountry(country(Helper.conevrtStringToLong(signup.getCountry())));
			 orgDetails.setOrganization(org);
			 orgDetails.setContactNumber(signup.getMobileNumber());
			 dataService.saveEntity(orgDetails);
		 }
		 model.addAttribute("user", user);
		 authenticateUserAndSetSession(user, request);
		 AccountUtil.setCurrentAccount(user);
		 //session.setAttribute("user", user);
		 model.addAttribute("builders",  dataService.getAllBuilders());
		 model.addAttribute("experties",  dataService.getAllExperties());
		 model.addAttribute("professionalExpertiesform", new ProfessionalExpertiesForm());
		 
		 return "signup_first"; 
	 } 
	 
	@SuppressWarnings("unused")
	private void authenticateUserAndSetSession(final UserAccount user, final HttpServletRequest request)
		{
		    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
		            user.getEmail(), user.getPassword());

		    // generate session if one doesn't exist
		    request.getSession();

		    token.setDetails(new WebAuthenticationDetails(request));
		    Authentication authenticatedUser = authenticationManager.authenticate(token);

		    SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		    request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
		}

	 
	 @RequestMapping(value="/test", method = RequestMethod.GET)
	 public String test(ModelMap model ) { 
		 
		 A a= new A("A");
		 B b = new B("B");
		 
		 a.getBs().add(b);
		 signupService.saveA(a);
		 
		 return "signup";
	 }
	 
	 @RequestMapping(value="/signup_first" , method = RequestMethod.POST)  
	 public String signupProfessionalExperties(@ModelAttribute("professionalExpertiesform")
		 ProfessionalExpertiesForm professionalExperties, BindingResult result, ModelMap model,HttpServletRequest request) {  
		 
		/* HttpSession session = request.getSession();
		 UserAccount user = (UserAccount)session.getAttribute("user");*/
		 UserAccount user = AccountUtil.currentAccount();
		 
		 UserAccount account = dataService.getEntity(user.getId(), UserAccount.class);
		 Builders builder1 = dataService.getBuilders(Helper.conevrtStringToLong(professionalExperties.getBuilder1()));
		 
		 Builders builder2 = dataService.getBuilders(Helper.conevrtStringToLong(professionalExperties.getBuilder2()));
		 
		 Builders builder3 = dataService.getBuilders(Helper.conevrtStringToLong(professionalExperties.getBuilder3()));
		 account.getBuilders().add(builder1) ; 
		 account.getBuilders().add(builder2) ;
		 account.getBuilders().add(builder3) ;
		 UserExperties experties1 = dataService.getUserExperties(Helper.conevrtStringToLong(professionalExperties.getExperties1()));
		 UserExperties experties2 = dataService.getUserExperties(Helper.conevrtStringToLong(professionalExperties.getExperties2()));
		 UserExperties experties3 = dataService.getUserExperties(Helper.conevrtStringToLong(professionalExperties.getExperties3()));
		 
		 account.getUserExperties().add(experties1);
		 account.getUserExperties().add(experties2);
		 account.getUserExperties().add(experties3);
		 
		 signupService.saveUser(account);
		
		 model.addAttribute("organizations", account.getOrganizations());

		 model.addAttribute("cities", dataService.getAllCities());
		 model.addAttribute("orgForm", new OrganizationForm());
		 
		 return "signup_second"; 
	 } 
	 
	 @RequestMapping(value="/signup_second" , method = RequestMethod.POST)  
	 public String signUpOrganizationdetails(@ModelAttribute("orgForm")
	 	OrganizationForm orgForm, ModelMap model ,HttpServletRequest request) {
		Organization org = dataService.gerOrganization(orgForm.getId());
		//HttpSession session = request.getSession();
		//UserAccount user = (UserAccount)session.getAttribute("user");
		UserAccount user = AccountUtil.currentAccount();
		UserAccount account = dataService.getEntity(user.getId(), UserAccount.class);
		org = Helper.organizationFormToOrganization(orgForm, org,
				 city(Helper.conevrtStringToLong(orgForm.getCity())));
		account.getOrganizations().add(org);
		signupService.saveOrganization(org);
		return "signup_third";
	 }
	 
	 @RequestMapping(value="/signup_third" , method = RequestMethod.POST)  
	 public String signUpForFellowsInvite(ModelMap model,HttpServletRequest request) {
		 String [] fellowEmails = request.getParameterValues("fellow_email");
		// HttpSession session = request.getSession();
		 //UserAccount user = (UserAccount)session.getAttribute("user");
		 UserAccount user = AccountUtil.currentAccount();
		 UserAccount account = dataService.getEntity(user.getId(), UserAccount.class);
		 UserFellow userfellow = null;
		 for(String email : fellowEmails){
			 account.getFellows();
			 userfellow = new UserFellow();
			 userfellow.setFellowEmail(email);
			 userfellow.setUserAccount(account);
			 account.getFellows().add(userfellow);
		 }
		 signupService.saveUser(account);
		 return "redirect:/home";
	 }
	 
	 
	 
	 @RequestMapping(value="/signup_skip_this_step", method = RequestMethod.GET)  
	 public String skipThisStep(ModelMap model, HttpServletRequest request) { 
		 int step =  Integer.parseInt(request.getParameter("step"));
		 if (step == 2){
			return "signup_second" ;
		 }
		 if(step == 4){
			 return "signup_forth" ; 
		 }
		 return "home";
	 } 
	 
    @ModelAttribute("states")
    public List<State> getStates() {
        return dataService.getAllStates();
    }
    
    @ModelAttribute("country")
    public Country getCountry() {
        return dataService.getCountry(1L);
    }
    
    private City city(long cityId){
    	return dataService.getCity(cityId);
    }
    
    private Country country(long id){
    	return dataService.getCountry(id);
    }
    
    private State state(long id){
    	return dataService.getState(id);
    	
    }
    
   
    
    
    
	

}
