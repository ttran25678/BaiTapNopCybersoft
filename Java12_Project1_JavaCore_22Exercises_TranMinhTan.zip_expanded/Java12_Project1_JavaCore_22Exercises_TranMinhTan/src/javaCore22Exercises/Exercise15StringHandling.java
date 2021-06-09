package javaCore22Exercises;

import java.util.Scanner;

public class Exercise15StringHandling {

	public static char InKyTu(String str, int idx) {
		char[] ch = str.toCharArray();
		return ch[idx - 1];
	}
	
	public static void checkSubString(String str, String subString) {
		boolean check = str.indexOf(subString) != -1 ? true : false;
		
		if(check) {
			System.out.println("c) CO tim thay substring trong String");
		}else {
			System.out.println("c) KHONG tim thay substring trong String");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Nhap chuoi: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.printf("a) Do dai chuoi: %s\n", str.length());
		
		
		int idx;
		
		do {
			System.out.print("Nhap vi tri (index >= 0): ");
			idx = sc.nextInt();
			if(idx < 0)
				System.out.print("Nhap sai! ");
		}while(idx < 0);
		
		System.out.printf("b) Ky tu (char) tai vi tri index = %d la: %c\n",idx, InKyTu(str, idx));
		checkSubString(str, "abcdef");
		
		
		sc.close();
	}

}
