package com.chainsys.springproject.test;
import com.chainsys.springproject.appconfig.AppConfig;
import org.springframework.context.ApplicationContext;//parent
import org.springframework.context.annotation.AnnotationConfigApplicationContext;//child
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Customer;
public class TestAnnotationConfig {
	public static void testA()
	{
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp=ac.getBean(Employee.class);
		Employee emp1=ac.getBean(Employee.class);
		emp.setId(101);
		emp.setName("Kiru");
		emp.print();
	}
}
