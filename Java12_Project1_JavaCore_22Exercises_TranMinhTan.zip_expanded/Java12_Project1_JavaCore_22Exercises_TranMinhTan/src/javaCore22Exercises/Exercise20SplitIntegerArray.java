package javaCore22Exercises;


import java.util.LinkedList;

import java.util.Scanner;

public class Exercise20SplitIntegerArray {

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
	
	public static String inputValues(String str, Scanner sc) {
		while (true) {
			System.out.printf("Nhap n: ");
			str = sc.nextLine();

			if (isNumeric(str)) {
				break;
			} else {
				System.out.println("NHAP SAI!");
			}
		}
		return str;
	}
	
	public static void printData(LinkedList<Integer> linked) {
		for(int item:linked) {
			System.out.print(item+" ");
		}
	}
	
	public static void splitArray(String str) {
		int n = Integer.parseInt(str);
		LinkedList<Integer> chan = new LinkedList<Integer>();
		LinkedList<Integer> le = new LinkedList<Integer>();
		int val;
		while(n > 0) {
			val = n % 10;
			if(val%2==0) {
				chan.add(val);
			}else {
				le.add(val);
			}
			n /= 10;
		}
		System.out.print("Mang chan: ");
		if(chan.isEmpty()) {
			System.out.print(" Khong co PT");
		}else {
			printData(chan);
		}
		
		System.out.print("\nMang le: ");
		if(le.isEmpty()) {
			System.out.print(" Khong co PT");
		}else {
			printData(le);
		}
		
		
	
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str_n = "";
		str_n = inputValues(str_n, sc);
		splitArray(str_n);
		
		sc.close();
	}
}
