package com.userFAQ.userQuerydto;

public class UserQuery {
	private String queryString;
	private int queryId;
	private String queryDate;
	private String queryTime;
	private String category;
	public UserQuery(){
		this("default query",1,"blank","blank","default");
	}
	public UserQuery(String query){
		this(query,1,"blank","blank","default");
	}
	public UserQuery(String queryString, int queryId, String queryDate,String queryTime, String category) {
		this.queryString = queryString;
		this.queryId = queryId;
		this.queryDate = queryDate;
		this.queryTime = queryTime;
		this.category = category;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public int getQueryId() {
		return queryId;
	}
	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}
	public String getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}
	public String getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
