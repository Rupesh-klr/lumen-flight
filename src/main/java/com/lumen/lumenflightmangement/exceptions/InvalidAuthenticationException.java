package com.lumen.lumenflightmangement.exceptions;

public class InvalidAuthenticationException extends RuntimeException{
	/**
	 * Constructs a new runtime exception with {@code null} as its
	 * detail message.  The cause is not initialized, and may subsequently be
	 * initialized by a call to {@link #initCause}.
	 */
	public InvalidAuthenticationException(String message) {
		super(message);
	}
}
