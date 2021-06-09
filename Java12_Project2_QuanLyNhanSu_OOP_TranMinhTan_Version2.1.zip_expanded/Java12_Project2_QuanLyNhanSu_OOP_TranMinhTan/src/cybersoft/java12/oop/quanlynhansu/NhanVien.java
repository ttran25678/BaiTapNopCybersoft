package cybersoft.java12.oop.quanlynhansu;

import java.util.Scanner;

public class NhanVien extends NhanSu{
	/* properties */
	private int truongPhong;

	/* constructors */
	public NhanVien(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay) {
		super(hoTen, soDienThoai, soNgayLam, luongMotNgay);
	}

	public NhanVien() {
		super();
	}

	/* getters/setters */
	public int getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(int truongPhong) {
		this.truongPhong = truongPhong;
	}

	/* methods */
	@Override
	public String getChucVu() {
		return "Nhân viên";
	}

	@Override
	public String getThongTinThem() {
		// TODO Auto-generated method stub
		return String.valueOf(this.truongPhong);
	}
	
	@Override
	public void themNhanSu(Scanner sc) {
		// TODO Auto-generated method stub
		super.themNhanSu(sc);
		luongMotNgay = 100;
	}
	
	@Override
	public void xuatThongTin() {
		// TODO Auto-generated method stub
		super.xuatThongTin();
		System.out.printf("Lương: %.2f", this.tinhLuong());
	}
}

