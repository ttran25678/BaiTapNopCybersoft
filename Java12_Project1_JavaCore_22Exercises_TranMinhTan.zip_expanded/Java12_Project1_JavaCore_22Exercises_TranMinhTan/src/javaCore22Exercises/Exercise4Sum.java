package javaCore22Exercises;

import java.util.Scanner;

public class Exercise4Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Viết chương trình cho phép nhập vào một số tự nhiên và 
//		in ra tổng các chữ số của số tự nhiên đó

		System.out.print("Nhap n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = n;
		int s = 0;
		
		// check temp
		if(temp < 0)
			temp *= -1;
		
		while(temp > 0) {
			s += temp % 10;
			temp /= 10;
		}
		System.out.printf("The sum of the numbers of %d is %d ", n, s);
		sc.close();
	}

}
