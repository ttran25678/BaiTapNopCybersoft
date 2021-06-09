package cybersoft.java12.oop.quanlynhansu;

import java.util.Scanner;

public class TruongPhong extends NhanSu{
	/* properties */
	private int soNhanVien;
	
	/* constructors */
	public TruongPhong() {
		super();
	}
	
	public TruongPhong(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay) {
		super(hoTen, soDienThoai, soNgayLam, luongMotNgay);
	}

	/* getters/setters */
	public int getSoNhanVien() {
		return this.soNhanVien;
	}
	
	

	/* methods */
	@Override
	public float tinhLuong() {
		return super.tinhLuong() + soNhanVien * 100;
	}

	@Override
	public String getChucVu() {
		// TODO Auto-generated method stub
		return "Trưởng phòng";
	}
	
	@Override
	public String getThongTinThem() {
		// TODO Auto-generated method stub
		return String.valueOf(this.soNhanVien);
	}

	public void tangSoNhanVien() {
		this.soNhanVien++;
	}
	
	public void giamSoNhanVien() {
		this.soNhanVien--;
	}
	
	@Override
	public void themNhanSu(Scanner sc) {
		// TODO Auto-generated method stub
		super.themNhanSu(sc);
		luongMotNgay = 200;
	}

}
