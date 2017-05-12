package com.instablog.api.exception;

@SuppressWarnings("serial")
public class NoBlogFoundException extends BloggingException {

	public NoBlogFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoBlogFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoBlogFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoBlogFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoBlogFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
