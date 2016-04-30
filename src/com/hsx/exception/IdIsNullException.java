package com.hsx.exception;

/**
 * 为传入ID为参数时的方法，判断其ID为空的异常处理
 * @author hsx
 *
 */
public class IdIsNullException extends Exception {

	public IdIsNullException() {
	}

	public IdIsNullException(String message) {
		super(message);
	}

	public IdIsNullException(Throwable cause) {
		super(cause);
	}

	public IdIsNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public IdIsNullException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
