package javaCore22Exercises;

import java.util.Scanner;

public class Exercise10Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.print("Input n > 0: ");
			n = sc.nextInt();
			if(n <=0)
				System.out.print("Try again! ");
		}while(n <= 0);
		
		int s = n;
	
		for(int i = 1; i <= n-1; i++) {
			s += i;
		}
	
		System.out.printf("The sum from 1 to %d is:  %d", n, s);
		sc.close();
	}

}
