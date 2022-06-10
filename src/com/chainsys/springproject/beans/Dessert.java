package com.chainsys.springproject.beans;

public abstract class Dessert {
	public String name;

}

class Icecream extends Dessert {
	public Icecream() {
		name="Chocolate";
	}
}

class Sweets extends Dessert {
	public Sweets() {
		name="Rasagulla";
	}
}

class Cakes extends Dessert {
	public Cakes() {
		name="RussianVelvet";
	}
	public Cakes(String name) {
		this.name=name;
	}
	}
