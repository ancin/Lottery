package com.alipay.test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DynamicProxyImpl implements DynamicProxy{

	public void log(String logString) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date())+"-----"+logString);
	}

}
