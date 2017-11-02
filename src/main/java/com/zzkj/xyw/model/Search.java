package com.zzkj.xyw.model;

public class Search {

	private String keyword;

	private String city;

	private String sort;

	@Override
	public String toString() {
		return "Search [keyword=" + keyword + ", city=" + city + ", sort="
				+ sort + "]";
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
