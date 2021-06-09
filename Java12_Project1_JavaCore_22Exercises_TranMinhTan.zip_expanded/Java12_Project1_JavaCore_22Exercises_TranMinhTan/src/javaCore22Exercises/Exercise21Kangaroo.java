package javaCore22Exercises;

import java.util.Scanner;

public class Exercise21Kangaroo {

	public static void printData(int jump, int s) {
		System.out.printf("Tai lan nhay thu %d\n", jump);
		System.out.printf("VT gap nhau cach vi tri xuat phat cua kan1 khoang: %d\n", s);
		
	}
	
	public static boolean timViTri(int x1, int x2, int v1, int v2) {
		int jump = 0;
		int s0 = x1;
		do{ // nếu chạy hết quãng đường 10000 mà chưa gặp nhau thì sẽ không gặp
			x1 = x1 + v1;
			x2 = x2 + v2;
			jump++;
			if(x1 >= x2) {
				printData(jump, (x1 - s0));
				return true;
			}
		}while(x1 < 10000 || x2 < 10000);
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x1,x2,v1,v2;
		System.out.println("Vi tri thoa 0 <= x1 < x2 < 10000: ");
		boolean loop = true;
		do{
			System.out.print("Nhap vi tri x1: ");
			x1 = sc.nextInt();
			System.out.print("Nhap vi tri x2: ");
			x2 = sc.nextInt();
			if(x1 < 0 || x1 >= 10000){
				System.out.println("X1 SAI. Nhap lai !");
				loop = false;
				continue;
			}else if(x2 < 0 || x2 >= 10000){
				System.out.println("X2 SAI. Nhap lai !");
				loop = false;
				continue;
			}else if(x1 >= x2)
			{
				System.out.println("Vi tri x1 < x2. Nhap lai !");
				loop = false;
				continue;
			}else {
				loop = true;
			}
		}while(!loop);
		
		System.out.println("Van toc thoa 1 <= v1 < v2 <= 10000: ");
		
		do{
			System.out.println("Nhap van toc kangaroo v1: ");
			v1 = sc.nextInt();
			System.out.println("Nhap van toc kangaroo v2: ");
			v2 = sc.nextInt();
			if(v1 < 1 || v1 > 10000){
				System.out.println("V1 SAI. Nhap lai !");
				loop = false;
				continue;
			}else if(v2 < 1 || v2 > 10000){
				System.out.println("V2 SAI. Nhap lai !");
				loop = false;
				continue;
			}else{
				loop = true;
			}
		}while(!loop);
		 
		if(timViTri(x1,x2,v1,v2)) {
			System.out.println("----CO gap nhau!");
		}else {
			System.out.println("----KHONG gap nhau!");
		}
		
		
		
		sc.close();
	}

}
