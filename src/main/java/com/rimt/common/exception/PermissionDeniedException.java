package com.rimt.common.exception;

import javax.transaction.SystemException;

public class PermissionDeniedException extends SystemException {

    public PermissionDeniedException(String message) {
        super(message);
    }
    
}