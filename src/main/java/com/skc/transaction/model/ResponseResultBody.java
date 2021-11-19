package com.skc.transaction.model;

import java.util.Map;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResponseResultBody {

	private String status;
	private int statusCode;
	private Map<String, Object> result;
	private String msg;

	public ResponseResultBody(String status, int statusCode, Map<String, Object> result) {

		this.status = status;
		this.statusCode = statusCode;
		this.result = result;
	}

	public ResponseResultBody(String status, int statusCode, Map<String, Object> result, String msg) {
		this(status, statusCode, result);
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

}
