package com.chainsys.springproject.beans;
//multiple factory method in one class
//calendar factory is also called as initiating bean because method in this bean initiating

public class CalendarFactory {
	//the factory method is not static here
public Calendar createCalendar()
{
	//the calendar constructor is default access modifier so can be called here
	//the calendar class and the calendar factory class are both in the same package
	return new Calendar();
}
public Appointments createAppointment()
{
	return new Appointments();
	
}
}
