package com.instablog.api.exception;

@SuppressWarnings("serial")
public class AuthorizationFailedException extends BloggingException {

	public AuthorizationFailedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthorizationFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AuthorizationFailedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AuthorizationFailedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AuthorizationFailedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
