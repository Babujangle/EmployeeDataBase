package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourseName;//Employee
	private String fieldName;//id
	private Object fieldValue;//2
	public ResourceNotFoundException(String resourseName, String fieldName, Object fieldValue) {
		super(resourseName+" Not found for "+ fieldName+"with Value: "+fieldValue);
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourseName() {
		return resourseName;
	}
	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}