package com.chainsys.springproject.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.config.BeanPostProcessor; // refer Aop

public class InitDisposeBean implements DisposableBean,InitializingBean{
	private String city;
	private long pinCode;
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	// called after setters
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet method called");
	}
	// similar to destroy-method
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy method called");
	}
	
	public InitDisposeBean() {
		System.out.println("InitDisposeBean object created "+ hashCode());
	}
	// after constructor
	public void setUp() {
		System.out.println("starting InitDisposeBean...");
	}
	public void close() {
		System.out.println("closing InitDisposeBean...");
	}
	public void print() {
		System.out.println("Print called in InitDisposeBean");
	}
}