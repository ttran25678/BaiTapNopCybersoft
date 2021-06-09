package javaCore22Exercises;

import java.util.Scanner;

public class Exercise19Equation {

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public static String inputValues(String str, Scanner sc, String mess) {
		while (true) {
			System.out.printf("Nhap %s: ", mess);
			str = sc.nextLine();

			if (isNumeric(str)) {
				break;
			} else {
				System.out.println("NHAP SAI!");
			}
		}
		return str;
	}

	public static void equation1(double a, double b) {
		if (b == 0) {
			System.out.printf("Co nghiem x = 0", a, b);
		} else {
			System.out.printf("Co nghiem x = %.3f", -b / a);
		}
	}

	public static void equation2(double a, double b, double c) {
		if (b == 0) {
			if (c == 0) {
				equation1(a, b);
			} else {
				System.out.printf("Co nghiem: x1 = %.3f, x2 = %.3f", Math.sqrt(-c / a), -1.0 * Math.sqrt(-c / a));
			}
		} else {
			if (c == 0) {
				System.out.printf("Co nghiem: x1 = 0, x2 = %.3f", -b / a);
			} else {
				double delta = b * b - 4 * a * c;
				if (delta > 0) {
					System.out.printf("Co nghiem: x1 = %.3f, x2 = %.3f", (-b - Math.sqrt(delta)) / (2 * a),
							(-b + Math.sqrt(delta)) / (2 * a));
				} else if (delta == 0) {
					System.out.printf("Co nghiem: x1 = x2 = %.3f", -b / (2 * a));
				} else {
					System.out.println("Vo nghiem");
				}
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str_choice;
		String str_a = "";
		String str_b = "";
		String str_c = "";
		double a, b, c;
		int choice;

		boolean loop = true;
		while (loop) {
			System.out.println("\n\n---------------MENU--------------");
			System.out.println("| 1.  ax + b = 0 (a<>0)         |");
			System.out.println("| 2.  ax^2 + bx + c = 0 (a<>0)  |");
			System.out.println("| 3.  Thoat                     |");
			System.out.println("---------------------------------");

			while (true) {
				System.out.print("Moi ban chon chuc nang: ");
				str_choice = sc.nextLine();

				if (isNumeric(str_choice)) { // KT có phải là số hay k
					double temp = Double.parseDouble(str_choice); // ép kiểu đưa về kiểu int
					choice = (int) temp;
					if (choice == temp) { // chỉ chấp nhận ng dùng nhập 1.0, 2.0, 3.0
						if (choice >= 1 && choice <= 3)
							break;
						else
							System.out.println("SAI! Xin nhap lai !");
					}

				} else {
					System.out.println("SAI! Nhap lua chon 1, 2 hoac 3!");
				}
			}

			switch (choice) {
			case 1: {
				do {
					a = (int) Double.parseDouble(inputValues(str_a, sc, "a"));
					if (a == 0) {
						System.out.println("NHAP SAI. a khac 0!");
					}
				} while (a == 0);
				b = Double.parseDouble(inputValues(str_b, sc, "b"));
				System.out.printf("Phuong trinh %.3fx + %.3f = 0.\n", a, b);
				equation1(a, b);
				break;
			}
			case 2: {
				do {
					a = (int) Double.parseDouble(inputValues(str_a, sc, "a"));
					if (a == 0) {
						System.out.println("NHAP SAI. a khac 0!");
					}
				} while (a == 0);
				b = Double.parseDouble(inputValues(str_b, sc, "b"));
				c = Double.parseDouble(inputValues(str_c, sc, "c"));
				System.out.printf("Phuong trinh %.3fx^2 + %.3fx + %.3f = 0.\n", a, b, c);
				equation2(a, b, c);
				break;
			}
			default:
				loop = false;
				System.out.println("---------CHAO TAM BIET. HEN GAP LAI !----------");
				break;
			}
		}

		sc.close();
	}

}
