package com.alipay.commons;

import java.sql.Timestamp;

/**
 * ���������Ĺ���ģ�� cwf
 */
public class PublicUtil {
	
		/**
		 * ����˵����ȡ��ǰ����(��ʽ 20030801)
		 * 
		 */
		public static String getStrNowDate() {
			java.util.Date tdate = new java.util.Date();
			String nowtime = new Timestamp(tdate.getTime()).toString();
			nowtime = nowtime.substring(0, 10);
			String nowYear = nowtime.substring(0, 4);
			String nowMonth = nowtime.substring(5, 7);
			String nowDay = nowtime.substring(8, 10);
			String nowdate = nowYear + nowMonth + nowDay;
			return nowdate;

		}

		/**
		 * ����˵����ȡ��ǰ���� (��ʽ 2003-08-01)
		 * 
		 */
		public static String getNowDate() {
			java.util.Date tdate = new java.util.Date();
			String nowtime = new Timestamp(tdate.getTime()).toString();
			nowtime = nowtime.substring(0, 10);
			return nowtime;
		}
}
