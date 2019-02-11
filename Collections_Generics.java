//Christopher Santiago
//Homework 3: Working with generic methods
//01.25.18

import java.util.*;

public class Collections_Generics {

	public static void main(String[] args) {
		//initializes different data type arrays to test generic methods
		String[] colors = {"Red", "Green", "Blue"};
		Integer[] numbers = {1,2,3};
		Double[] circleRadius = {3.0,5.9,2.9};
		
		//prints out the max of each array
		System.out.println("Colors: " + max(colors));
		System.out.println("Numbers: " + max(numbers));
		System.out.println("Circle Radius: " + max(circleRadius));
	}//end of main
	
	public static <E extends Comparable<E>> E max(E[] list) {
		E maxElement = list[0];
		
		//for loop to test max in the list
		for(int i = 0; i < list.length; i++) {
			if(list[i].compareTo(maxElement) > 0) {
				maxElement = list[i];
			}
		}//end of for
		
		return maxElement;
	}//end of max generic method

}//end of homework3
