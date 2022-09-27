package com.consumo.practice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int codeError;
	
	public GeneralException(String errorMessage, int codeError) {
        super(errorMessage);
        this.codeError = codeError;
    }
	
	public int getCodigoError() {
        return 0;
    }
}
