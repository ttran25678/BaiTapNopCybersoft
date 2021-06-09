package cybersoft.java12.oop.quanlynhansu;

import java.util.Scanner;

public class CongTy {

	/* properties */
	private String ten;
	private String maSoThue;
	private double doanhThuThang;

	/* Constructor */
	public String getTen() {
		return this.ten;
	}
	
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMaSoThue() {
		return this.maSoThue;
	}
	
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	
	public double getDoanhThuThang() {
		return this.doanhThuThang;
	}
	
	public void setDoanhThuThang(double doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}
	
	public CongTy() {
		// empty
	}
	
	public CongTy(String ten, String maSoThue, double doanhThuThang) {
		super();
		this.ten = ten;
		this.maSoThue = maSoThue;
		this.doanhThuThang = doanhThuThang;
	}

	public void nhapThongTin(Scanner sc) {
		this.ten = ktRong(sc, "", "Nhập tên công ty: ");
		this.maSoThue = ktRong(sc, "", "Nhập mã số thuế: ");

		while (true) { // kiểm tra bắt buộc nhập số
			String str = ktRong(sc, "", "Nhập doanh thu: ");
			if (isNumeric(str)) { // input nhập vào là số
				this.doanhThuThang = Double.parseDouble(str);
				break;
			} else {
				System.out.println("SAI. Doanh thu kieu DOUBLE. Nhap lai !");
			}
		}
	}

	public void xuatThongTin() {
		System.out.printf("Tên công ty: %s\nMã số thuế: %s\nDoanh thu: %.2f\n", ten, maSoThue, doanhThuThang);
	}

	// business
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public String ktRong(Scanner sc, String str, String mess) {
		do {
			System.out.printf(mess);
			str = sc.nextLine();
			if (str.isBlank() || str.isEmpty()) {
				System.out.println("Không được bỏ trống !");
			}
		} while (str.isBlank() || str.isEmpty());

		return str;
	}
}
