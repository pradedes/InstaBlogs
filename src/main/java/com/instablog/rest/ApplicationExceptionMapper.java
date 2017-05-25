package com.instablog.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ApplicationExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		System.out.println("ApplicationExceptionMapper.toResponse()");
		return null;
	}

}
