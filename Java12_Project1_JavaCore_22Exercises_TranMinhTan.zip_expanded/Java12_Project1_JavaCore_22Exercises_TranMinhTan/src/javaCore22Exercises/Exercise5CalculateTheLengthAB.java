package javaCore22Exercises;

import java.util.Scanner;

public class Exercise5CalculateTheLengthAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter coordinates A(x1, y1)");
		System.out.print("Enter x1: ");
		float x1 = sc.nextFloat();		
		System.out.print("Enter y1: ");
		float y1 = sc.nextFloat();
		
		System.out.println("Enter coordinates B(x2, y2)");
		System.out.print("Enter x2: ");
		float x2 = sc.nextFloat();		
		System.out.print("Enter y2: ");
		float y2 = sc.nextFloat();
		
		System.out.println("The length of line segment AB = "+Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2)));
		sc.close();
	}

}
