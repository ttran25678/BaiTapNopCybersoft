package cybersoft.java12.oop.quanlynhansu;

import java.util.Scanner;

public class GiamDoc extends NhanSu {
	/* properties */
	private float coPhan;

	/* constructors */
	public GiamDoc(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay) {
		super(hoTen, soDienThoai, soNgayLam, luongMotNgay);
	}
	
	public GiamDoc(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay, float coPhan) {
		super(hoTen, soDienThoai, soNgayLam, luongMotNgay);
		this.coPhan = coPhan;
	}

	public GiamDoc() {
		super();
	}

	/* getters/setters */
	public float getCoPhan() {
		return this.coPhan;
	}

	public void setCoPhan(float coPhan) {
		this.coPhan = coPhan;
	}

	/* methods */
	@Override
	public String getChucVu() {
		// TODO Auto-generated method stub
		return "Giám đốc";
	}

	@Override
	public String getThongTinThem() {
		// TODO Auto-generated method stub
		return String.valueOf(this.coPhan);
	}

//	@Override
//	public void nhapThongTin(Scanner sc) {
//		// TODO Auto-generated method stub
//		super.nhapThongTin(sc);
//		System.out.println("Nhap co pphan: ");
//		this.coPhan = sc.nextFloat();
//	}

	@Override
	public void themNhanSu(Scanner sc) {
		// TODO Auto-generated method stub
		super.themNhanSu(sc);
		luongMotNgay = 300;
	}

	@Override
	public float themCoPhan(Scanner sc) {
		// TODO Auto-generated method stub
		do {
			this.coPhan = Float.parseFloat(nhapGiaTri("", sc, "Nhập số cổ phần: "));
			if (this.coPhan < 0 || this.coPhan > 100) {
				System.out.println("SAI. Số cổ phần lớn nhất là 100 phần trăm !");
			}
		} while (this.coPhan < 0 || this.coPhan > 100);

		return this.coPhan;
	}

}
