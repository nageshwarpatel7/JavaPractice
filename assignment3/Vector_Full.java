package assignment3;

import java.util.Vector;

public class Vector_Full {
	 public static void main(String[] args) {

	        // ================================
	        // 1. Constructor: Vector()
	        // ================================
	        Vector<String> v1 = new Vector<>();

	        v1.add("Java");                 // add()
	        v1.add("Python");
	        v1.add("C++");
	        System.out.println("Vector v1: " + v1);

	        // addElement()
	        v1.addElement("DSA");
	        System.out.println("After addElement(): " + v1);

	        // add(index, element)
	        v1.add(1, "AI");
	        System.out.println("After add at index: " + v1);

	        // ================================
	        // 2. Constructor: Vector(int)
	        // ================================
	        Vector<String> v2 = new Vector<>(5);
	        v2.add("Spring");
	        v2.add("Hibernate");
	        System.out.println("\nVector v2: " + v2);

	        // ================================
	        // 3. Constructor: Vector(int, int)
	        // ================================
	        Vector<String> v3 = new Vector<>(3, 2);
	        v3.add("HTML");
	        v3.add("CSS");
	        v3.add("JavaScript");
	        System.out.println("\nVector v3: " + v3);
	        System.out.println("Capacity of v3: " + v3.capacity());

	        // ================================
	        // 4. Constructor: Vector(Collection)
	        // ================================
	        Vector<String> v4 = new Vector<>(v1);
	        System.out.println("\nVector v4 (Copied from v1): " + v4);

	        // ================================
	        // Methods Demonstration
	        // ================================

	        // addAll()
	        v4.addAll(v2);
	        System.out.println("\nAfter addAll(): " + v4);

	        // get()
	        System.out.println("Element at index 2: " + v4.get(2));

	        // set()
	        v4.set(2, "Machine Learning");
	        System.out.println("After set(): " + v4);

	        // remove(object)
	        v4.remove("C++");
	        System.out.println("After remove(object): " + v4);

	        // remove(index)
	        v4.remove(0);
	        System.out.println("After remove(index): " + v4);

	        // contains()
	        System.out.println("Contains Java? " + v4.contains("Java"));

	        // size()
	        System.out.println("Size of vector: " + v4.size());

	        // capacity()
	        System.out.println("Capacity of vector: " + v4.capacity());

	        // isEmpty()
	        System.out.println("Is vector empty? " + v4.isEmpty());

	        // indexOf()
	        System.out.println("Index of Java: " + v4.indexOf("Java"));

	        // lastIndexOf()
	        v4.add("Java");
	        System.out.println("Last index of Java: " + v4.lastIndexOf("Java"));

	        // clear()
	        v4.clear();
	        System.out.println("\nAfter clear(): " + v4);
	        System.out.println("Is vector empty now? " + v4.isEmpty());
	    }
}