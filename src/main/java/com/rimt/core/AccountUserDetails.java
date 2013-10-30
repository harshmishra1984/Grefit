package com.rimt.core;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;

import com.rimt.dataaccess.entities.RolesType;
import com.rimt.dataaccess.entities.UserAccount;

import static java.util.Arrays.asList;

public class AccountUserDetails extends User {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private UserAccount userAccount;
	
	public AccountUserDetails(UserAccount user) {
        super(StringUtils.defaultString(user.getEmail()), user.getPassword(), true, true, true, true, asList(new GrantedAuthority[]{new GrantedAuthorityImpl(RolesType.getName(user.getRole().getRoleType().getTypeId()))}));
        this.userId = user.getId();
        this.userAccount = user;
    }

    public Long getId() {
        return userId;
    }

    public Long getUserAccountId() {
        return userId;
    }

    public UserAccount getUser() {
        return userAccount;
    }
	

}
