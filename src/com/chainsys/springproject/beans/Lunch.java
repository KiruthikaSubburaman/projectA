package com.chainsys.springproject.beans;

public class Lunch {
    public Starters entree;
    public MainCourse mainfood;
    public Dessert sweet;

//Constructor based dependency injection
    public Lunch(Starters s, MainCourse m, Dessert d) {
        System.out.println("Lunch is ready");
        entree = s;
        mainfood = m;
        sweet = d;
    }
    public void serve() {
        System.out.println(entree.name);
        System.out.println(mainfood.name);
        System.out.println(sweet.name);
    }
}
/*
 * Lunch
 * Starters,Chicken,Soup,Vegroll
 * MainCourse, SouthIndian,NorthIndian,Chinese
 * Desert,Icecream,Sweets,Cakes
 */