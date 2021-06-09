package javaCore22Exercises;

import java.util.Scanner;

public class Exercise9DuplicateCheck {
	
	public static boolean check(int num1, int num2) {
		
		int dv1,dv2,chuc1 = -1,chuc2 = -2;
		if(num1 > 9) {
			dv1 = num1 % 10;
			num1 /= 10;
			chuc1 = num1;
		}else {
			dv1 = num1;
		}
		
		if(num2 > 9) {
			dv2 = num2 % 10;
			num2 /= 10;
			chuc2 = num2;
		}else {
			dv2 = num2;
		}
		
		if((dv1 - dv2 == 0 || dv1 - chuc2 == 0) || (chuc1 - dv2 == 0 || chuc1 - chuc2 == 0)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers: ");
		System.out.print("Number one: ");
		int num1 = sc.nextInt();
		System.out.print("Number two: ");
		int num2 = sc.nextInt();
		System.out.println(check(num1, num2));
		
		
		

		
		sc.close();
	}

}
