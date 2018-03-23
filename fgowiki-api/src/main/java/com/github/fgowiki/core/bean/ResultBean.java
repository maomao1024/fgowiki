package com.github.fgowiki.core.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int NO_LOGIN = -1;

	public static final int SUCCESS = 0;

	public static final int FAIL = 1;

	public static final int NO_PERMISSION = 2;

	private String msg = "success";

	private int code = SUCCESS;

	private T data;

	private int pageNum;
	private long toatlSize;

	public ResultBean() {
		super();
	}

	public ResultBean(T data) {
		super();
		this.data = data;
	}

	public ResultBean(T data, String msg) {
		super();
		this.data = data;
		this.msg = msg;
	}

	public ResultBean(T data, String msg, int code) {
		super();
		this.data = data;
		this.msg = msg;
		this.code = code;
	}

	public ResultBean(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = FAIL;
	}
}