package javaCore22Exercises;

import java.util.Scanner;

public class Exercise2BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n = sc.nextInt();
		int numb = n, temp = n;
		int s = 0;
		int count = 0;
		
		while(numb > 0) {
			count++;
			numb /= 10;
		}
		
		int[] arr = new int[count];
		
		for(int i = 0; i < count; i++) {
			arr[i] = temp % 10;
			temp /= 10;
			s += arr[i]*Math.pow(2, i);
		}
		
		System.out.printf("%d he thap phan la: %d",n, s);
		sc.close();
		
	}

}
