package com.instablog.api.exception;

@SuppressWarnings("serial")
public class DuplicateUserIdException extends BloggingException {

	public DuplicateUserIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DuplicateUserIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DuplicateUserIdException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateUserIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateUserIdException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
