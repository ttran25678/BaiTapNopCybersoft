package javaCore22Exercises;

import java.util.Scanner;

public class Exercise6ReverseString {

	public static void main(String[] args) {
		// TODO in đảo ngược chuỗi
		
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.printf("Please enter the string: ");
		s = sc.nextLine();
		char[] c = s.toCharArray();
		System.out.printf("String after reverse is: ");
		for(int i = c.length-1; i >= 0; i--) {
			System.out.print(c[i]);
		}
		sc.close();

	}

}
