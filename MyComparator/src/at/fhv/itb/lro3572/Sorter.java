package at.fhv.itb.lro3572;

import java.util.*;

public class Sorter {
	public static <T> void sort(T[] values, MyComparator<T> comp) {
		for (int i = 0; i < values.length - 1; i += 1) {
			int minPos = i;
			for (int j = i; j < values.length; j += 1) {
				if (comp.compare(values[j], values[minPos]) < 0) {
					minPos = j;
				}
			}
			T tmp = values[i];
			values[i] = values[minPos];
			values[minPos] = tmp;
		}
	}
	
	public static void main(String[] args) {
		Person[] persons = {new Person("Sarah", 100), new Person("Lea", 50)};
		Drink[] drinks = {new Drink(20), new Drink(10), new Drink(100), new Drink(50)};
		
		sort(drinks, new MyComparator<Drink>() {

			@Override
			public int compare(Drink o1, Drink o2) {
				return o1.getvC() - o2.getvC();
			}
		});
		
		for(Drink d: drinks) {
			System.out.println(d);
		}
		
		System.out.println();
		
		// eigene Implementierung
		sort(persons, new MyComparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getSalary() - o2.getSalary();
			}
			
		});
		
		for(Person p: persons) {
			System.out.println(p);
		}
		
		
		// API Implementierung
		System.out.println();
		Comparator<Person> cmp = new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				return o2.getSalary() - o1.getSalary();
			}
		};
		Arrays.sort(persons, cmp);
		
		for(Person p: persons) {
			System.out.println(p);
		}
	}
}
