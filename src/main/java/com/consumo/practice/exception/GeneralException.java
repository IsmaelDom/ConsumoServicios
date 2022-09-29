package com.consumo.practice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final int codeError;
	
	public GeneralException(String errorMessage, int codeError) {
        super(errorMessage);
        this.codeError = codeError;
    }
	
}
