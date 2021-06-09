package javaCore22Exercises;

import java.util.Scanner;

public class Exercise18SavingsDepositCalculation {

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Khách hàng gửi tiết kiệm ngân hàng GauGau khoản tiền 500 triệu đồng, kỳ hạn
		 * 12 tháng với lãi suất huy động 6.30%.
		 * 
		 * Tổng lãi khách hàng nhận được: 31.500.000 VNĐ Lãi bình quân 1 tháng:
		 * 2,625,000 VNĐ
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		String str_money, str_moneyBuyCar, str_Percent, str_month;

		// nhap tien gui
		while (true) {
			System.out.print("Nhap so tien can gui tiet kien cua Anh: ");
			str_money = sc.nextLine();

			if (isNumeric(str_money)) {
				if (Integer.parseInt(str_money) >= 200)
					break;
				else
					System.out.println("So tien cua Anh it nhat 200 VND !");
			} else {
				System.out.println("So tien khong dung. Xin nhap lai !");
			}
		}
		double mCurrent = Double.parseDouble(str_money);
		
		// nhap tien mua OTO
		while (true) {
			System.out.print("Nhap so tien uoc tinh mua OTO cua Anh: ");
			str_moneyBuyCar = sc.nextLine();

			if (isNumeric(str_moneyBuyCar)) {
				if (Integer.parseInt(str_moneyBuyCar) >= mCurrent)
					break;
				else
					System.out.println("Tien mua OTO cua Anh phai lon hon tien gui tiet kiem!");
			} else {
				System.out.println("So tien khong dung. Xin nhap lai !");
			}
		}
		int mBuyCar = Integer.parseInt(str_moneyBuyCar);

		// nhap thang ky han
		while (true) {
			System.out.print("KY HAN bao nhieu thang?: ");
			str_month = sc.nextLine();

			if (isNumeric(str_month)) {
				if (Integer.parseInt(str_month) >= 0) {
					break;
				} else {
					System.out.println("So thang >= 0");
				}
			} else {

				System.out.println("So Thang khong dung. Xin nhap lai !");
			}
		}
		double mMonth = Double.parseDouble(str_month);

		// % lai
		while (true) {
			System.out.print("Nhap % LAI XUAT muon gui: ");
			str_Percent = sc.nextLine();

			if (isNumeric(str_Percent)) {
				if (Double.parseDouble(str_Percent) > 0) {
					break;
				} else {
					System.out.println("% LAI XUAT phai >0 !");
				} 
			} else {

				System.out.println("So tien khong dung. Xin nhap lai !");
			}
		}
		double mPercent = Double.parseDouble(str_Percent);
		System.out.println(mCurrent);
		int count = 0;
		do {
			mCurrent = mCurrent + mCurrent * mPercent / 100 / mMonth;
			count++;
		} while (mCurrent < mBuyCar);
		
		System.out.println("------------------------------------");
		System.out.printf("\nVoi so tien "+str_money+" gui lai xuat "+str_Percent+" ky han "+str_month+" thang.\n");
		System.out.printf("Thi khoang %d thang Anh moi du %.2f VND de mua OTO", count, mCurrent);
		sc.close();
	}

}
