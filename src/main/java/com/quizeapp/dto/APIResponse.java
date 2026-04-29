package com.quizeapp.dto;

import java.util.Date;

public class APIResponse<T> {

	private String message;
	
	private String Status;
	
	private Date timeStamp;

	 private int statusCode;
	 
	 private T data; 
	 
	public int getStatusCode() {
		return statusCode;
	}

	 public void setStatusCode(int statusCode) {
		 this.statusCode = statusCode;
	 }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
	

}
