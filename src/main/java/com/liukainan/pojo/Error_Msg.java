package com.liukainan.pojo;

public class Error_Msg {
	
	private Integer eid;
	private String error_msg;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
	public Error_Msg(Integer eid, String error_msg) {
		super();
		this.eid = eid;
		this.error_msg = error_msg;
	}
	public Error_Msg() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Error_Msg [eid=" + eid + ", error_msg=" + error_msg + "]";
	}
}
