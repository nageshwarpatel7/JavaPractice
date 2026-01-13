package assignment3;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMap_Full {
	 public static void main(String[] args) {

	        // ================================
	        // 1. Constructor: HashMap()
	        // ================================
	        HashMap<Integer, String> map1 = new HashMap<>();

	        map1.put(101, "Java");                 // put()
	        map1.put(102, "Python");
	        map1.put(103, "C++");
	        System.out.println("Map1: " + map1);

	        // putIfAbsent()
	        map1.putIfAbsent(104, "DSA");
	        map1.putIfAbsent(101, "AI"); // will not replace
	        System.out.println("After putIfAbsent(): " + map1);

	        // ================================
	        // 2. Constructor: HashMap(int)
	        // ================================
	        HashMap<Integer, String> map2 = new HashMap<>(10);
	        map2.put(201, "Spring");
	        map2.put(202, "Hibernate");
	        System.out.println("\nMap2: " + map2);

	        // ================================
	        // 3. Constructor: HashMap(int, float)
	        // ================================
	        HashMap<Integer, String> map3 = new HashMap<>(5, 0.75f);
	        map3.put(301, "HTML");
	        map3.put(302, "CSS");
	        System.out.println("\nMap3: " + map3);

	        // ================================
	        // 4. Constructor: HashMap(Map)
	        // ================================
	        HashMap<Integer, String> map4 = new HashMap<>(map1);
	        System.out.println("\nMap4 (Copied from Map1): " + map4);

	        // ================================
	        // Methods Demonstration
	        // ================================

	        // get()
	        System.out.println("\nGet key 102: " + map4.get(102));

	        // getOrDefault()
	        System.out.println("Get key 999: " + map4.getOrDefault(999, "Not Found"));

	        // containsKey()
	        System.out.println("Contains key 101? " + map4.containsKey(101));

	        // containsValue()
	        System.out.println("Contains value Java? " + map4.containsValue("Java"));

	        // size()
	        System.out.println("Size of map: " + map4.size());

	        // isEmpty()
	        System.out.println("Is map empty? " + map4.isEmpty());

	        // keySet()
	        System.out.println("Keys: " + map4.keySet());

	        // values()
	        System.out.println("Values: " + map4.values());

	        // entrySet()
	        System.out.println("\nKey-Value Pairs:");
	        for (Entry<Integer, String> entry : map4.entrySet()) {
	            System.out.println(entry.getKey() + " => " + entry.getValue());
	        }

	        // replace()
	        map4.replace(103, "Machine Learning");
	        System.out.println("\nAfter replace(): " + map4);

	        // remove(key)
	        map4.remove(104);
	        System.out.println("After remove(key): " + map4);

	        // remove(key, value)
	        map4.remove(102, "Python");
	        System.out.println("After remove(key, value): " + map4);

	        // clear()
	        map4.clear();
	        System.out.println("\nAfter clear(): " + map4);
	        System.out.println("Is map empty now? " + map4.isEmpty());
	    }
}