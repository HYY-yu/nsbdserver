package com.feng.bean;

import java.util.List;

public class ResponseBean<T> {

	int code;
	String message;
	List<T> datas;

	public ResponseBean() {

	}

	public ResponseBean(int code, String message, List<T> datas) {
		this.code = code;
		this.message = message;
		this.datas = datas;

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

}
