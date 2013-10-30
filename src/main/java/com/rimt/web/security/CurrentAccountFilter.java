package com.rimt.web.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.rimt.common.exception.DeletedAccountAccessException;
import com.rimt.common.exception.InactiveAccountAccessException;
import com.rimt.core.AccountUserDetails;
import com.rimt.dataaccess.entities.UserAccount;
import com.rimt.modules.service.UserService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import static com.rimt.common.UserAccountStatus.DELETED;
import static com.rimt.common.UserAccountStatus.SUSPENDED;
import static com.rimt.core.AccountUtil.setCurrentAccount;

import java.io.IOException;

public class CurrentAccountFilter extends GenericFilterBean {

    private static final Logger logger = LoggerFactory.getLogger(CurrentAccountFilter.class);

    @Resource
    private UserService userService;

    @Resource
    private AuthenticationTrustResolver authenticationTrustResolver;

    @PersistenceContext
    private EntityManager em;

    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!authenticationTrustResolver.isAnonymous(authentication)) {
            AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
            UserAccount account = userService.findById(userDetails.getUserAccountId());

//            String remoteIP = getRemoteIP((HttpServletRequest) request);
//            if (!account.canAccessFrom(remoteIP)) {
//                logger.warn("Request from IP[{}] has been rejected.", remoteIP);
//                clearSession(request);
//                throw new IPAddressRejectedException("IP address rejected.");
//            }

            if (account.getStatus() == SUSPENDED) {
                clearSession(request);
                throw new InactiveAccountAccessException("Suspended account could not access system, please contact to mobileStorm Corp.");
            }

            if (account.getStatus() == DELETED) {
                clearSession(request);
                throw new DeletedAccountAccessException("Deleted account could not access system, please contact to mobileStorm Corp.");
            }
            setCurrentAccount(account);
        }

        try {
            chain.doFilter(request, response);
        } finally {
            setCurrentAccount(null);
        }
    }

    private String getRemoteIP(HttpServletRequest request) {
        String realIP = request.getHeader("X-Real-Ip");
        if (realIP != null) {
            return realIP;
        }

        String ip = request.getRemoteAddr();
        if (ip.startsWith("0:0:0:0:0:0:0:1")) {
            return "127.0.0.1";
        }
        return ip;
    }

    private void clearSession(ServletRequest request) {
        if (request instanceof HttpServletRequest) {
            ((HttpServletRequest)request).getSession().invalidate();
        }
    }
}

