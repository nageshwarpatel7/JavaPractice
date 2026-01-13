package assignment1;

import java.util.*;
import practice.PracticePackage;

class Parent{
	int a;
	Parent(int a){
		this.a = a;
	}
	void show() {
		System.out.println("This is parent class");
	}
}
interface Vehicle1{
	void engine();
}
interface Vehicle extends Vehicle1{
	void start();
	void display();
	
}
class Car implements Vehicle{
	public void start() {
		System.out.println("Car is starting");
	}
	public void display() {
		System.out.println("Diplay");
	}
	public void engine() {
		System.out.println("Engine is staring");
	}
}
class Bike implements Vehicle{ 

	public void start() {
		System.out.println("Bike is starting");
	}
	public void display() {
		System.out.println("Diplay");
	}
	public void engine() {
		System.out.println("Engine is staring");
	}
}

public class OOPsPractice {
	public static void main(String args[]) {
		Car alto = new Car();
		Bike platine = new Bike();
		int x ='a'+0;
		System.out.print(x);
		
	}
}
