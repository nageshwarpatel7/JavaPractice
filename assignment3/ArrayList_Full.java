package assignment3;

import java.util.*;

public class ArrayList_Full {
	 public static void main(String[] args) {

	        // ================================
	        // 1. Constructor: ArrayList()
	        // ================================
	        ArrayList<String> list1 = new ArrayList<>();

	        list1.add("Java");                 // add()
	        list1.add("Python");
	        list1.add("C++");
	        System.out.println("List1: " + list1);

	        // add(index, element)
	        list1.add(1, "DSA");
	        System.out.println("After add at index: " + list1);

	        // ================================
	        // 2. Constructor: ArrayList(int)
	        // ================================
	        ArrayList<String> list2 = new ArrayList<>(5);
	        list2.add("Spring");
	        list2.add("Hibernate");
	        System.out.println("\nList2: " + list2);

	        // ================================
	        // 3. Constructor: ArrayList(Collection)
	        // ================================
	        ArrayList<String> list3 = new ArrayList<>(list1);
	        System.out.println("\nList3 (Copied from List1): " + list3);

	        // ================================
	        // Methods Demonstration
	        // ================================

	        // addAll()
	        list3.addAll(list2);
	        System.out.println("\nAfter addAll(): " + list3);

	        // get()
	        System.out.println("Element at index 2: " + list3.get(2));

	        // set()
	        list3.set(2, "Machine Learning");
	        System.out.println("After set(): " + list3);

	        // remove(object)
	        list3.remove("C++");
	        System.out.println("After remove(object): " + list3);

	        // remove(index)
	        list3.remove(0);
	        System.out.println("After remove(index): " + list3);

	        // contains()
	        System.out.println("Contains Java? " + list3.contains("Java"));

	        // size()
	        System.out.println("Size of list: " + list3.size());

	        // isEmpty()
	        System.out.println("Is list empty? " + list3.isEmpty());

	        // indexOf()
	        System.out.println("Index of Java: " + list3.indexOf("Java"));

	        // lastIndexOf()
	        list3.add("Java");
	        System.out.println("Last index of Java: " + list3.lastIndexOf("Java"));

	        // iterator()
	        System.out.println("\nUsing Iterator:");
	        Iterator<String> itr = list3.iterator();
	        while (itr.hasNext()) {
	            System.out.println(itr.next());
	        }

	        // toArray()
	        Object[] arr = list3.toArray();
	        System.out.println("\nArray Elements:");
	        for (Object obj : arr) {
	            System.out.println(obj);
	        }

	        // clear()
	        list3.clear();
	        System.out.println("\nAfter clear(), list3: " + list3);
	        System.out.println("Is list3 empty? " + list3.isEmpty());
	    }
}