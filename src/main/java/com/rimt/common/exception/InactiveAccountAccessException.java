package com.rimt.common.exception;

import org.springframework.security.access.AccessDeniedException;

public class InactiveAccountAccessException extends AccessDeniedException {
	private static final long serialVersionUID = 1L;

	public InactiveAccountAccessException(String message) {
        super(message);
    }
}
