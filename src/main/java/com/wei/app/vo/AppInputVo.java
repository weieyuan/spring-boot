package com.wei.app.vo;

public class AppInputVo {

	private String name;

	private String alias;

	public AppInputVo() {

	}

	public AppInputVo(String name, String alias) {
		this.name = name;
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
