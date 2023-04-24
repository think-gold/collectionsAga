package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Task 1:
//       Stwórz dwa HashSety integerów i zaimplementuj dla nich następujące działania rachunków zbiorów: suma, część wspólna, różnica, suma bez części wspólnej. Wynik działania powinien trafić do trzeciego zbioru.
        System.out.println("TASK 1:");
        // creating new sets: A and B:
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        //adding Integers to set A and set B:
        setA.add(5);
        setA.add(10);
        setA.add(11);
        setA.add(17);

        setB.add(5);
        setB.add(10);
        setB.add(2);
        setB.add(1);
        // creating new set that will be union of set A and B:
        Set<Integer> setABunion = new HashSet<>();

        for (int itemA : setA) {
            setABunion.add(itemA); //adding all elements from set A
        }
        for (int itemB : setB) {
            if (!setA.contains(itemB)) { // Adding elements from set B that are not common with set B
                setABunion.add(itemB);
            }
        }
        System.out.println("Union of set A and set B: " + setABunion);
        //creating new set that will be intersection of set A and B
        Set<Integer> setABintersection = new HashSet<>();

        for (int itemA : setA) {
            if (setB.contains(itemA)) {
                setABintersection.add(itemA); //Adding elements from set A that are common with set B
            }
        }
        System.out.println("Intersection of set A and set B: " + setABintersection);
        // creating new set that is difference of set A and B
        Set<Integer> setABdiff = new HashSet<>();

        for (int itemA : setA) {
            if (!setB.contains(itemA)) {
                setABdiff.add(itemA);//Adding all elements from set A that are NOT common with set B
            }
        }
        System.out.println("Difference of AB: " + setABdiff);
        // creating new set that is difference of set A and B
        Set<Integer> setBAdiff = new HashSet<>();

        for (int itemB : setB) {
            if (!setA.contains(itemB)) {
                setBAdiff.add(itemB);//Adding all elements from set A that are NOT common with set B
            }
        }
        System.out.println("Difference of BA: " + setBAdiff);
        // adding new set that is union of set A and B without intersection of set A and B (union of difference)
        Set<Integer> setABunionofdiff = new HashSet<>();

        for (int itemA : setA) {
            if (!setB.contains(itemA)) {
                setABunionofdiff.add(itemA);//Adding all elements from set A that are NOT common with set B
            }
        }
        for (int itemB : setB) {
            if (!setA.contains(itemB)) {
                setABunionofdiff.add(itemB);//Adding all elements from set A that are NOT common with set B
            }
        }
        System.out.println("Union of difference of set A and B: " + setABunionofdiff);
        System.out.println();

        // Task 2:
// Stwórz dwie HashMapy<String, Integer> (jak w liście zakupów) i zaimplementuj ich sumowanie. Np jedna mapa to Jajka: 3; Mleko: 1, a druga to Jajka: 2; Kiełbasa: 2, wynik to Jajka: 5; Mleko: 1; Kiełbasa: 2
        System.out.println("TASK 2");
        // creating maps for shopping. key: string, value: integer:
        Map<String, Integer> shoppingA = new HashMap<>();
        Map<String, Integer> shoppingB = new HashMap<>();
        // adding elements to map A and map B:
        shoppingA.put("Jajka", 2);
        shoppingA.put("Mleko", 1);

        shoppingB.put("Jajka", 2);
        shoppingB.put("Kiełbasa", 2);
        // creating new map that will be union of map A and B
        Map<String, Integer> shoppingUnionAB = new HashMap<>();

        for (String keyA : shoppingA.keySet()) {        // adding all elements from shopping A
            Integer valueA = shoppingA.get(keyA);
            if (shoppingB.containsKey(keyA)) {          // create new value if key from shoppingA equals key from shoppingB
                Integer valueB = shoppingB.get(keyA);
                Integer valueABunion = valueA + valueB;
                shoppingUnionAB.put(keyA, valueABunion);
            } else {                                    // else keep original value
                shoppingUnionAB.put(keyA, valueA);
            }
        }

        for (String keyB : shoppingB.keySet()) {        // iterating shopping2
            Integer valueB = shoppingB.get(keyB);
            if (!shoppingA.containsKey(keyB)) {         // adding all elements from shoppingB that are not common with shoppingA
                shoppingUnionAB.put(keyB, valueB);
            }
        }

        System.out.println("Union: " + shoppingUnionAB);
        System.out.println();

        // Task 3:
//Zaimplementuj pozostałe działania rachunku zbiorów (część wspólna, różnica, suma bez części wspólnej) dla HashMap z listami zakupów.
        System.out.println("Task 3");

        //creating new map that will be intersection of shoppingA and shoppingB
        Map<String, Integer> shoppingABinter = new HashMap<>();

        for (String keyA : shoppingA.keySet()) {        //iterate over shoppingA keys
            Integer valueA = shoppingA.get(keyA);
            if (shoppingB.containsKey(keyA)) {          // select elements with common key in shopping B
                Integer valueB = shoppingB.get(keyA);
                Integer valueMin = valueA < valueB ? valueA : valueB; // select lesser value (that's common value)
                shoppingABinter.put(keyA, valueMin);    // set key and value for intersection map
            }
        }
        System.out.println("Intersection: " + shoppingABinter);

        // creating new map that will be difference of shopping A and B
        Map<String, Integer> shopingABdiff = new HashMap<>();

        for (String keyA : shoppingA.keySet()) {    // iterating over  keys from shopping A
            Integer valueA = shoppingA.get(keyA);
            if (!shoppingB.containsKey(keyA)) {     // collecting elements that are not common for shoppingA and shoppingB
                shopingABdiff.put(keyA, valueA);    // adding elements to new map
            } else {
                Integer valueB = shoppingB.get(keyA); // if we have common keys we need to subtract valueB from value A
                if (valueA - valueB > 0) {              // result of subtraction needs to be more than 0
                    Integer valueABdiff = valueA - valueB;
                    shopingABdiff.put(keyA, valueABdiff);   //set key with new value
                }
            }
        }
        System.out.println("Difference AB: " + shopingABdiff);

        // creating new map that will be difference of shopping B and A
        Map<String, Integer> shoppingBAdiff = new HashMap<>();

        for (String keyB : shoppingB.keySet()) {
            Integer valueB = shoppingB.get(keyB);
            if (shoppingA.containsKey(keyB)) {
                Integer valueA = shoppingA.get(keyB);
                if (valueB - valueA > 0) {
                    Integer valueBAdiff = valueB - valueA;
                    shoppingBAdiff.put(keyB, valueBAdiff);
                }
            } else {
                shoppingBAdiff.put(keyB, valueB);
            }
        }
        System.out.println("Difference BA: " + shoppingBAdiff);

        // creating new map that will be union of differences of shoppingA and shoppingB
        Map<String, Integer> shoppingABunionOfDiff = new HashMap<>();

        for (String keyA : shoppingA.keySet()) {        // iterating over keys from shoppingA
            if (!shoppingB.containsKey(keyA)) {         // collection all elements from shopping A that are not common with shoppingB
                shoppingABunionOfDiff.put(keyA, shoppingA.get(keyA));   // add elements to new map
            }
        }
        for (String keyB : shoppingB.keySet()) {
            if (!shoppingA.containsKey(keyB)) {
                shoppingABunionOfDiff.put(keyB, shoppingB.get(keyB));
            }
        }
        System.out.println("Union of difference: " + shoppingABunionOfDiff);
    }
}
