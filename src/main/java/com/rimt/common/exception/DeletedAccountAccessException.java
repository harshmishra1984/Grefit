package com.rimt.common.exception;

import org.springframework.security.access.AccessDeniedException;

public class DeletedAccountAccessException extends AccessDeniedException {

	private static final long serialVersionUID = 1L;

	public DeletedAccountAccessException(String message) {
        super(message);
    }
}