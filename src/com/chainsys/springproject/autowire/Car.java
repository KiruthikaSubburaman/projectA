package com.chainsys.springproject.autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

// import javax.annotation.Resources;  // @Resources not working.

public class Car {
    @Autowired
     private Engine petrolEngine;
    @Autowired(required=false)
     private Wheel alloy;
     public Car() {
            System.out.println("Car object created : " + hashCode());
        }
        public void start() {
              System.out.println("Start AnnotationLc...");
          }
          public void stop() {
              System.out.println("Stoped AnnotationLc...");
          }
          public void begin() {
              petrolEngine.start();
          }
          public void move() {
              alloy.move();
          }
}
@Component("SportsCar")
class SportsCar extends Car{
    public SportsCar() {
        System.out.println("Sports Car created" + hashCode());
    }
}
@Component("SuvCar")
class SuvCar extends Car{
    public SuvCar() {
        System.out.println("Suv Car created" + hashCode());
    }
}