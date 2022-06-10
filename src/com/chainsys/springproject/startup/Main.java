package com.chainsys.springproject.startup;

import com.chainsys.springproject.test.TestAnnotationConfig;
import com.chainsys.springproject.test.TestCar;
import com.chainsys.springproject.test.TestClassPathXml;
import com.chainsys.springproject.test.TestXmlBeanFactory;

public class Main {

	public static void main(String[] args) {
		TestClassPathXml.testAutowire();
	}
}
