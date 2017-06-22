package com.instablog.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.instablog.api.exception.AuthorizationFailedException;
import com.instablog.api.exception.DuplicateUserIdException;
import com.instablog.api.exception.NoBlogFoundException;
import com.instablog.api.exception.NoUserIdFoundException;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
        if (exception instanceof NoBlogFoundException) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else if (exception instanceof DuplicateUserIdException){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else if (exception instanceof AuthorizationFailedException) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else if (exception instanceof NoUserIdFoundException) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
	}

}
