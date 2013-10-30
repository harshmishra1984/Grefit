package com.rimt.core;

import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.rimt.dataaccess.entities.UserAccount;

public final class AccountUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountUtil.class);
	private static final ThreadLocal<UserAccount> accountHolder = new ThreadLocal<UserAccount>();
	
	private AccountUtil() {
		
    }
	
	public static UserAccount currentAccount() {
        return accountHolder.get();
    }

  /*  public static DateTimeZone currentAccountTimeZone() {
    	UserAccount account = currentAccount();
        String timeZone = account.getTimeZone();
        return DateTimeZone.forID(timeZone);
    }*/

    public static void setCurrentAccount(UserAccount account) {
        accountHolder.set(account);
    }

    public static UserAccount currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((AccountUserDetails) authentication.getPrincipal()).getUser();
    }
	
	


}
