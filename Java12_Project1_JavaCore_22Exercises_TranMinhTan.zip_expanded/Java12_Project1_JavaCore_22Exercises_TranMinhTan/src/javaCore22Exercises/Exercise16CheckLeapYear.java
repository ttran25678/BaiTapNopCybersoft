package javaCore22Exercises;

import java.util.Scanner;

public class Exercise16CheckLeapYear {
	
	public static boolean checkLeapYear(int year) {
		
		if((year % 4 == 0) && (year % 100 != 0)) {
			return true;
		}else if(year % 400 == 0) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int year;
		do {
			System.out.print("Nhap vao NAM: ");
			year = sc.nextInt();
			if(year < 525) {
				System.out.println("NAM khong nho hon 525, NHAP LAI! ");
			}
		}while(year < 525);
		
		if(checkLeapYear(year)) {
			System.out.printf("%d la nam nhuan", year);
		}else
		{
			System.out.printf("%d khong phai nam nhuan", year);
		}
		
		
		sc.close();
	}

}
