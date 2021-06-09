package javaCore22Exercises;

import java.util.Scanner;

public class Exercise11Logarit {

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
		
		int count = 0;
		if(n < 2) {
			count = 0;
		}else {
			
			do {
				n /= 2;
				count++;
			}while(n > 1);
		}
		
		
		System.out.println(--count);
		sc.close();
	}

}
