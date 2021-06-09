package cybersoft.java12.oop.quanlynhansu;

import java.util.Scanner;

public abstract class NhanSu implements NhapXuatConsole{
	/* properties */
	private int maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected float soNgayLam;
	protected float luongMotNgay;

	private static int STT = 1;

	/* constructors */
	public NhanSu() {
		this.maSo = STT++;
	}

	public NhanSu(String hoTen, String soDienThoai, float soNgayLam, float luongMotNgay) {
		this.maSo = STT++;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLam = soNgayLam;
		this.luongMotNgay = luongMotNgay;
	}

	/* getters/setters */
	public int getMaSo() {
		return this.maSo;
	}
	
	public String getHoTen() {
		return hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public float getSoNgayLam() {
		return soNgayLam;
	}

	public float getLuongMotNgay() {
		return luongMotNgay;
	}

	/* methods */
	public float tinhLuong() {
		return soNgayLam * luongMotNgay;
	}

	@Override
	public void xuatThongTin() {
		System.out.printf("Mã số: %d\n", maSo);
		System.out.printf("Họ tên: %s\n", hoTen);
		System.out.printf("Chức vụ: %s\n", getChucVu());
		System.out.printf("Số điện thoại: %s\n", soDienThoai);
		System.out.printf("Số ngày làm: %f\n", soNgayLam);
		System.out.printf("Lương một ngày: %.0f\n", luongMotNgay);
	}

	public abstract String getChucVu();

	public abstract String getThongTinThem();
	
	@Override
	public void themNhanSu(Scanner sc) {
		// TODO Auto-generated method stub
		hoTen = nhapChuoi("", sc, "Nhập họ tên: ");
		do {
			soDienThoai = nhapChuoi("", sc, "Nhập số điện thoại: ");
			if(soDienThoai.length() > 10 || soDienThoai.length() < 10 || !(soDienThoai.startsWith("0"))) {
				System.out.println("SAI. Số điện thoại đúng 10 số và bắt đầu bằng số 0 !");
			}
		}while(soDienThoai.length() > 10 || soDienThoai.length() < 10 || !(soDienThoai.startsWith("0")));
		do {
			soNgayLam = Float.parseFloat(nhapGiaTri("", sc, "Nhập số ngày làm (nữa ngày = 0.5): "));
			if(soNgayLam < 0 || soNgayLam > 30 || soNgayLam % 0.5 != 0) {
				System.out.println("SAI. Số ngày làm có thể nhập 0,  0.5,  1,  1.5,... đến 30 ngày [0:30] !");
			}
		}while(soNgayLam < 0 || soNgayLam > 30 || soNgayLam % 0.5 != 0);
	}
	
	@Override
	public float themCoPhan(Scanner sc) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*Business*/
	public boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	@Override
	public String nhapChuoi(String str, Scanner sc, String mess) {
		while (true) {
			System.out.printf(mess);
			str = sc.nextLine();
			if (str == null || str.isEmpty()) {
				System.out.println("SAI. Không được để trống !");
			} else {
				return str;
			}
		}
	}
	
	@Override
	public String nhapGiaTri(String str, Scanner sc, String mess) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.printf(mess);
			str = sc.nextLine();
			if (str.isBlank() || str.isEmpty()) {
				System.out.println("SAI. Không được để trống !");
			} else if (isNumeric(str)) {
				break;
			} else {
				System.out.println("NHAP SAI!");
			}
		}
		return str;
		
	}
	
}
