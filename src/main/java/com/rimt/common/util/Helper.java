package com.rimt.common.util;

import com.rimt.common.UserAccountStatus;
import com.rimt.dataaccess.entities.City;
import com.rimt.dataaccess.entities.Organization;
import com.rimt.dataaccess.entities.Roles;
import com.rimt.dataaccess.entities.RolesType;
import com.rimt.dataaccess.entities.UserAccount;
import com.rimt.dataaccess.entities.UserOrganizationAddressDetails;
import com.rimt.form.OrganizationForm;
import com.rimt.form.SignUp;

public class Helper {
	
	
	public static UserAccount signupFormToUserAccount(SignUp signupForm, Roles role){
		UserAccount userAccount = new UserAccount();
		userAccount.setFirstName(signupForm.getFirstName());
		userAccount.setLastName(signupForm.getLastName());
		userAccount.setEmail(signupForm.getEmail());
		userAccount.setPassword(signupForm.getPassword());
		userAccount.setPhoneNumber(signupForm.getMobileNumber());
		userAccount.setStatus(UserAccountStatus.ACTIVE);
		//Roles roles = new Roles("Super User", RolesType.ROLE_SUPERUSER);
		userAccount.setRole(role);
		return userAccount;
	}
	
	public static Organization signupFormToOrganization(SignUp signupForm){
		Organization org = new Organization();
		org.setName(signupForm.getOrganizationName());
		org.setLicenceNumber(signupForm.getLicenceNumber());
		
		return org;
	}
	
	public static Organization organizationFormToOrganization(OrganizationForm orgForm, Organization org, City city){
		UserOrganizationAddressDetails orgDetails  = null;
		if (org == null) {
			org = new Organization();
			orgDetails = new UserOrganizationAddressDetails();
		} else{
			orgDetails = (UserOrganizationAddressDetails)org.getOrgAddrList().toArray()[0];
		}
		org.setName(orgForm.getName());
		org.setLicenceNumber(orgForm.getLicence());
		org.setType(orgForm.getType());
		orgDetails.setAddress(orgForm.getLocation());
		orgDetails.setCity(city);
		orgDetails.setContactNumber(orgForm.getContact());
		
		org.getOrgAddrList().add(orgDetails);

		return org;
	}
	
	public static Long conevrtStringToLong(String str){
		return Long.parseLong(str);
	}

}
