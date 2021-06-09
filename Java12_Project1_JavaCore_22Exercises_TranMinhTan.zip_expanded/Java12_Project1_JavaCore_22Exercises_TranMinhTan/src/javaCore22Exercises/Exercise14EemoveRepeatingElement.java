package javaCore22Exercises;

import java.util.LinkedList;
import java.util.Scanner;

public class Exercise14EemoveRepeatingElement {

	public static int[] NhapMang(int[] arr, Scanner sc) {
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("Nhap a[%d]: ",i);
			arr[i] = sc.nextInt();
		}
		
		return arr;
	}
	
	
	public static void XuatMang(int[] arr) {
		System.out.printf("Mang la: ");

		for(int a:arr) {
			System.out.printf(a+" ");
		}
		System.out.println();
		
	}
	
	public static LinkedList<Integer> XoaPTLap(int[] arr, LinkedList<Integer> linked) {
		linked.add(arr[0]);
		for(int i = 1; i < arr.length; i++) {
			int count = 0;
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] == arr[i]) {
					count++;
					continue;
				}
			}
			if(count == 0) {
				linked.add(arr[i]);
			}
		}
		
		return linked;
	}
	
	public static void printData(LinkedList<Integer> linked) {
		System.out.print("Mang sau khi loc la: ");
		for(int item:linked) {
			System.out.print(item+" ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		int[] arr;
		LinkedList<Integer> linked = new LinkedList<Integer>();
				
		do {
			System.out.print("Nhap n > 0: ");
			 n = sc.nextInt();
			if(n <=0)
				System.out.print("Nhap sai! ");
		}while(n <= 0);
		arr = new int[n];
		
		NhapMang(arr, sc);
		XuatMang(arr);
		XoaPTLap(arr, linked);
		printData(linked);
		
	}

}
