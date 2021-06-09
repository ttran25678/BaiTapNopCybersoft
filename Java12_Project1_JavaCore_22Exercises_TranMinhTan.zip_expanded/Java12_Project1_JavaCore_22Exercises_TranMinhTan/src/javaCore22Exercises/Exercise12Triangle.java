package javaCore22Exercises;

import java.util.Scanner;

public class Exercise12Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.print("Input n[1:9]: ");
			 n = sc.nextInt();
			if(n < 1 || n > 9)
				System.out.print("Try again! ");
		}while(n < 1 || n > 9);
		
		for(int i = 1; i <= n; i++ ) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		sc.close();
	}

}
