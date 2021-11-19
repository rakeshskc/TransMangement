package com.skc.transaction.Exception;

public class ServiceException extends Exception {

	private String msg;
	private int code;

	public ServiceException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
