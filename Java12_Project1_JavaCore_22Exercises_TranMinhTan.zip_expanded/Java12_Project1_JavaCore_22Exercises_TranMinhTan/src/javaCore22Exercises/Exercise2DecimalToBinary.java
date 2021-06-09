package javaCore22Exercises;

import java.util.Scanner;

public class Exercise2DecimalToBinary {

	
	
	
	public static void main(String[] args) {
		// TODO chuyển đổi số từ hệ cơ số 10
		//      sang hệ cơ số nhị phân
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n = sc.nextInt();
		int numb = n;
		String s = "";
		do {	
			s += numb % 2;
			numb /= 2;
		}while(numb > 0);
		System.out.printf("%d he nhi phan la: ",n);
		for(int i = s.length()-1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
		sc.close();

	}

}
