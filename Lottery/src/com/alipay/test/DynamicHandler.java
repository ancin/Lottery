package com.alipay.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicHandler implements InvocationHandler{

	private Object inst;
	
    public DynamicHandler(Object obj) {
		this.inst = obj;
	}
	
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result;
		result = method.invoke(this.inst, args);
		return result;
	}

	
	public static void main(String[] args) {
		DynamicProxy hello = new DynamicProxyImpl();
		
		DynamicHandler handler = new DynamicHandler(hello);
		
		 DynamicProxy proxy = (DynamicProxy) Proxy.newProxyInstance(
				 hello.getClass().getClassLoader(),
				 hello.getClass().getInterfaces(),
                 handler);
		 proxy.log("THis test dynamic log.");
	}
}
