package javaCore22Exercises;

import java.util.Random;
import java.util.Scanner;

public class Exercise17GameRandomNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rand = new Random(); // random[0:n)
		int nRand = 1+ rand.nextInt(1000); // rand[1:1000]
		int num;
		System.out.println(nRand);
					
		do {
			System.out.print("Ban doan xem Random so bao nhieu? ");
			num = sc.nextInt();
			if(num != nRand) {
				if(num < nRand)
					System.out.println("Nhap so lon(>) hon! ");
				else if (num > nRand)
					System.out.println("Nhap so nho(<) hon! ");
			}
		}while(num != nRand);
		
		System.out.println("---------------------------------------------");
		System.out.printf("---BAN DA DOAN DUNG (%d). XIN CHUC MUNG !---\n", nRand);
		System.out.println("---------------------------------------------");
		sc.close();
	}

}
