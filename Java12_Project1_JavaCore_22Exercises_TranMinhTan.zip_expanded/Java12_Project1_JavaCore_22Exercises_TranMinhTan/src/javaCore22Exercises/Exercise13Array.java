package javaCore22Exercises;

import java.util.LinkedList;

import java.util.Scanner;

public class Exercise13Array {
	
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
	
	public static float GiaTriTrungBinh(int[] arr) {
		
		float s = 0;
		for(int a:arr) {
			s += 1.0*a;
		}
		
		return s /= arr.length;
	}
	
	public static int Max(int[] arr) {
		int max = arr[0];
		
		for(int a:arr) {
			if(a > max)
				max = a;
		}
		return max;
	}
	
	public static int Min(int[] arr) {
		int min = arr[0];
		
		for(int a:arr) {
			if(a < min)
				min = a;
		}
		return min;
	}
	
	public static int AmMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		int count = 0;
		for(int a:arr) {
			if(a < 0) {
				count++;
				if(a > max) {
					max = a;
				}		
			}
		}
		if(count == 0) {
			max = 0;
		}
			
		return max;
	}
	
	
	public static int AmMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		int count = 0;
		for(int a:arr) {
			if(a < 0) {
				count++;
				if(a < min) {
					min = a;
				}		
			}
		}
		if(count == 0) {
			min = 0;
		}
			
		return min;
	}
	
	public static int DuongMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		int count = 0;
		for(int a:arr) {
			if(a >= 0) {
				count++;
				if(a > max) {
					max = a;
				}		
			}
		}
		if(count == 0) {
			max = 0;
		}
			
		return max;
	}
	
	
	public static int DuongMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		int count = 0;
		for(int a:arr) {
			if(a >= 0) {
				count++;
				if(a < min) {
					min = a;
				}		
			}
		}
		if(count == 0) {
			min = 0;
		}
			
		return min;
	}
	
	public static LinkedList<Integer> Chan(int[] arr) {
		LinkedList<Integer> ArrList = new LinkedList<Integer>();
		for(int a:arr) {
			if(a % 2 == 0) {
				ArrList.add(a);
			}
			
		}
		return ArrList;
	}
	
	public static LinkedList<Integer> Le(int[] arr) {
		LinkedList<Integer> ArrList = new LinkedList<Integer>();
		for(int a:arr) {
			if(a % 2 != 0) {
				ArrList.add(a);
			}
			
		}
		return ArrList;
	}
	
	public static void printData(LinkedList<Integer> list) {
		for(int item:list) {
			System.out.print(item+" ");
		}
		System.out.println();
	}
	
	public static int[] Insert(int[] arr, int[] arr1, int idx, int val) {
		
		for(int i = arr.length-1; i >= idx - 1; i--) {
			arr1[i+1] = arr[i];
		}		
		
		arr1[idx-1] = val;
		
		for(int i = idx -2; i >= 0; i--) {
			arr1[i] = arr[i];
		}

		return arr1;
	}
	
	public static int[] Delete(int[] arr1, int[] arr2, int idx) {
		
		int j = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(i == idx - 1) {
				continue;
			}
			arr2[j] = arr1[i];
			j++;
				
		}

		return arr2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		int[] arr;
		int[] arr1;
		int[] arr2;
		
		do {
			System.out.print("Nhap n > 0: ");
			 n = sc.nextInt();
			if(n <=0)
				System.out.print("Nhap sai! ");
		}while(n <= 0);
		arr = new int[n];
		
		NhapMang(arr, sc);
		XuatMang(arr);
		System.out.printf("\na) Gia tri trung binh: %.2f", GiaTriTrungBinh(arr));
		System.out.printf("\nb) Max = %d\n   Min = %d", Max(arr), Min(arr));
		System.out.printf("\nc) Am lon nhat = %d\n   Am nho nhat = %d", AmMax(arr), AmMin(arr));
		System.out.printf("\nd) Duong lon nhat = %d\n   Duong nho nhat = %d", DuongMax(arr), DuongMin(arr));
		System.out.printf("\ne) Chan: ");
		printData(Chan(arr));
		System.out.printf("   Le: ");
		printData(Le(arr));
		
		int idx_ins, idx_del, val_ins;
		
		arr1 = new int[arr.length+1];
		do {
			System.out.printf("Nhap vi tri insert index[1:%d]: ", arr1.length);
			idx_ins = sc.nextInt();
			if(idx_ins < 1 || idx_ins > arr1.length)
				System.out.print("Nhap sai! ");
		}while(idx_ins < 1 || idx_ins > arr1.length);
		
		System.out.print("Nhap value insert: ");
		val_ins = sc.nextInt();
		
		Insert(arr, arr1, idx_ins, val_ins);
		XuatMang(arr1);
		
		arr2 = new int[arr1.length-1];
		do {
			System.out.printf("Nhap vi tri delete index[1:%d]: ", arr1.length);
			idx_del = sc.nextInt();
			if(idx_del < 1 || idx_del > arr1.length)
				System.out.print("Nhap sai! ");
		}while(idx_del < 1 || idx_del > arr1.length);
		
		
		Delete(arr1, arr2, idx_del);
		XuatMang(arr2);
		
		sc.close();
		
	}

}
