package com.bookmall.dao.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String sysdate = format.format(date);
		String orderNo = "BM"+sysdate;
		System.out.println(orderNo);
	}

}
