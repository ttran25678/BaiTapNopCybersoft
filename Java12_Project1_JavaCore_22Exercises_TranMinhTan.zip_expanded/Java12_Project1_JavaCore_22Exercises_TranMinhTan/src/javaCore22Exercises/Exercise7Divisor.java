package javaCore22Exercises;

import java.util.Scanner;

public class Exercise7Divisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n;
		System.out.printf("Please enter n: ");
		n = sc.nextInt();
		System.out.printf("Divisor of %d is:\n", n);
		for(int i = 1; i<= n/2; i++) {
			if(n % i == 0)
				System.out.println(i+" ");
		}
		sc.close();
	}

}
