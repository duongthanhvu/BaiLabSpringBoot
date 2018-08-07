
package com.fpoly.lab6.entity;

import java.math.BigDecimal;

public class Product {

	private int id;
	private String tenSP;
	private int soLuong;
	private BigDecimal gia;
	
	public Product() {
		super();
	}

	public Product(int id, String tenSP, int soLuong, BigDecimal gia) {
		super();
		this.id = id;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public BigDecimal getGia() {
		return gia;
	}
	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}
	
}
