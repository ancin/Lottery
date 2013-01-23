package com.alipay.commons;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExceptionInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		 String result = "";
         try {
                 result = invocation.invoke();
         } catch (Exception ex) {
                 ex.printStackTrace();
                 throw new Exception("Error...");
         }
		return result;
	}

}
