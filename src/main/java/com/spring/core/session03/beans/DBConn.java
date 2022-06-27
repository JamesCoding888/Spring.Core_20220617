package com.spring.core.session03.beans;

public class DBConn {
	public void init() {
		System.out.println("開啟資料庫連線");
	}
	
	public void query() {
		System.out.println("查詢資料...");
	}
	
	public void destroy() {
		System.out.println("關閉 off 資料庫連線");
	}
}
