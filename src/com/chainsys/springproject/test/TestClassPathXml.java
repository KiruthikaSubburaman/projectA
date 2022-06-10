package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext;//parent
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;//child
import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.autowire.Car;
import com.chainsys.springproject.autowire.CarServices;
import com.chainsys.springproject.beans.Actor;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.ScoreBoard;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.lifecycle.InitDisposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;

public class TestClassPathXml {
	public static void testA() {
		Employee emp = new Employee();
		emp.setId(101);
		emp.setName("kiruthika");
		emp.print();
	}

	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Car.xml");
		// Employee emp = ac.getBean(Employee.class);
		Employee emp = (Employee) ac.getBean("emp");
		emp.setId(102);
		emp.setName("sweta");
		emp.print();
	}

	public static void testLazyInit() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = ac.getBean(Employee.class);
		Customer c = ac.getBean(Customer.class);
		// lazyinit=true for customer.An object is created now(firstcall to getBean()
		// method for Customer.class
		Employee emp2 = ac.getBean(Employee.class);
		Customer empalias = ac.getBean(Customer.class);
		System.out.println(emp.hashCode());
		System.out.println(emp2.hashCode());
		System.out.println(c.hashCode());
		System.out.println(empalias.hashCode());
	}

	public static void testProtoType() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Actor hero = ac.getBean(Actor.class);
		Actor heroin = ac.getBean(Actor.class);
		Actor comedian = ac.getBean(Actor.class);
		Actor friends = ac.getBean(Actor.class);
		System.out.println(hero.hashCode());
		System.out.println(heroin.hashCode());
		System.out.println(comedian.hashCode());
		System.out.println(friends.hashCode());
	}

	public static void testBeanWithConstructor() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	}

	public static void testFactoryMethod() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ScoreBoard sb1 = ac.getBean("sb1", ScoreBoard.class);
		sb1.targetScore = 183;
		System.out.println(sb1.targetScore);
		ScoreBoard sb2 = ac.getBean("sb2", ScoreBoard.class);
		System.out.println(sb2.targetScore);
	}

	public static void testCalendarFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calendar today = ac.getBean(Calendar.class);
		today.day = 9;
		today.month = "june";
		today.year = 2022;
		System.out.println(+today.day + "/" + today.month + "/" + today.year);
//		System.out.println(today.month);
//		System.out.println(today.year);
	}

	public static void testLunchFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml");
		Lunch nvsilunch = ac.getBean("nvsilunch", Lunch.class);
		Lunch vsilunch = ac.getBean("vsilunch", Lunch.class);
		Lunch nilunch = ac.getBean("nilunch", Lunch.class);
		Lunch chlunch = ac.getBean("chlunch", Lunch.class);
		System.out.println("-----");
		nvsilunch.serve();
		System.out.println("-----");
		vsilunch.serve();
		System.out.println("-----");
		nilunch.serve();
		System.out.println("-----");
		chlunch.serve();
	}
	public static void testSetterDi() {
		ApplicationContext ac1= new ClassPathXmlApplicationContext("beans.xml");
		Employee emp=ac1.getBean("emp2",Employee.class);
		emp.print();
	}
	public static void testLifeCycle() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		LifeCycleBean life= ac1.getBean(LifeCycleBean.class); 
		life.print(); 
		life=null;
	//	System.gc();
		ac1.close();
		ac1=null;
		}
	public static void testInitDestroyBean() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml"); 
		InitDisposeBean init=ac1.getBean(InitDisposeBean.class); 
		init.print();
	}
	public static void testAnnotationLc() {
    	ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
    	AnnotationLc ann=ac1.getBean(AnnotationLc.class);
    	ann.print();
    	ann=null;
    	ac1.close();
    }
	public static void testAutowire() {
        ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Autowire.xml");
        Car car=ac1.getBean(Car.class);
        car.move();
        car = null;
        ac1.close();
    }
	public static void testAutowireQualifier() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Autowire.xml"); 
		CarServices cs = ac1.getBean(CarServices.class); 
		cs.startTrip();
	}
}


