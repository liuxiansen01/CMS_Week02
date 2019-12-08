package com.liukainan.pojo;

public class Books {
	
	private Integer bid;
	private String bname;
	private Integer sales;
	private String phone;
	private Integer type_id;
	
	private Integer tid;
	private String tname;
	
	public Books(String bname, Integer sales, String phone, Integer type_id) {
		super();
		this.bname = bname;
		this.sales = sales;
		this.phone = phone;
		this.type_id = type_id;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Books(Integer bid, String bname, Integer sales, String phone, Integer type_id, Integer tid, String tname) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.sales = sales;
		this.phone = phone;
		this.type_id = type_id;
		this.tid = tid;
		this.tname = tname;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Books [bid=" + bid + ", bname=" + bname + ", sales=" + sales + ", phone=" + phone + ", type_id="
				+ type_id + ", tid=" + tid + ", tname=" + tname + "]";
	}
}
