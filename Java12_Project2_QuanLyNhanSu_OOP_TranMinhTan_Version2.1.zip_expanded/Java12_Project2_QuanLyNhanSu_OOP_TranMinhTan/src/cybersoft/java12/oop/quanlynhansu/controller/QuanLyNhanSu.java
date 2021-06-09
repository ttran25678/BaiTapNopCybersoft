package cybersoft.java12.oop.quanlynhansu.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import cybersoft.java12.oop.quanlynhansu.CongTy;
import cybersoft.java12.oop.quanlynhansu.GiamDoc;
import cybersoft.java12.oop.quanlynhansu.NhanSu;
import cybersoft.java12.oop.quanlynhansu.NhanVien;
import cybersoft.java12.oop.quanlynhansu.TruongPhong;
import cybersoft.java12.oop.quanlynhansu.view.util.PrintFormat;

public class QuanLyNhanSu {

	/* properties */
	private List<NhanSu> dsNhanSu;
	List<NhanVien> dsNhanVienChuaPhanBo;
	List<NhanVien> dsNhanVien;
	List<TruongPhong> dsTruongPhong;
	List<GiamDoc> dsGiamDoc;
	CongTy congTy;

	/* constructors */
	public QuanLyNhanSu() {
		congTy = new CongTy("ABC Technology", "ABC0010020379", 10000000.0d);
		dsNhanSu = new LinkedList<NhanSu>();

		dsNhanSu.add(new NhanVien("Đàm Vĩnh Hưng", "0977111111", 10, 100));
		dsNhanSu.add(new NhanVien("Phạm Quỳnh Anh", "0977111222", 25.5f, 100));
		dsNhanSu.add(new NhanVien("Vĩnh Thiên Kim", "0977111133", 2, 100));
		dsNhanSu.add(new NhanVien("Châu Gia Kiệt", "0977111999", 30, 100));
		dsNhanSu.add(new NhanVien("Đan Trường", "0977797979", 1, 100));
		dsNhanSu.add(new NhanVien("Duy Mạnh", "0977999999", 0, 100));
		dsNhanSu.add(new NhanVien("Quang Lê", "0999999999", 0.5f, 100));
		dsNhanSu.add(new NhanVien("Cẩm Ly", "0987654321", 1.5f, 100));
		dsNhanSu.add(new NhanVien("Ngọc Sơn", "0969696969", 20, 100));
		dsNhanSu.add(new NhanVien("Phạm Trưởng", "0323456789", 30, 100));
		dsNhanSu.add(new NhanVien("Phan Đình Tùng", "0258444555", 23, 100));

		dsNhanSu.add(new TruongPhong("Mỹ Tâm", "0909113113", 30, 200));
		dsNhanSu.add(new TruongPhong("Lệ Quyên", "0900000113", 20, 200));

		dsNhanSu.add(new GiamDoc("Bằng Kiều", "0909090909", 5, 300, 15));
		dsNhanSu.add(new GiamDoc("Trường Vũ", "0335243670", 20, 300));
	}

	/* methods */
	public void xuatCongTy() {
		congTy.xuatThongTin();
	}
	
	public void nhapCongTy(Scanner sc) {
		congTy.nhapThongTin(sc);
	}
	
	public float tinhTongLuong() {
		float tongLuong = 0;

		for (NhanSu nhanSu : dsNhanSu) {
			tongLuong += nhanSu.tinhLuong();
		}

		return tongLuong;
	}

	public void xuatDanhSachNhanSu() {
		int width = 160;
		// in header
		drawLine(width);
		System.out.printf(PrintFormat.HEADER_FORMAT, "STT", "Mã số", "Họ tên", "Số điện thoại", "Số ngày làm",
				"Lương một ngày", "Lương", "Chức vụ", "Trưởng phòng/Số nhân viên/Cổ phần");
		drawLine(width);
		// in body
		for (int i = 0; i < dsNhanSu.size(); i++) {
			NhanSu ns = dsNhanSu.get(i);
			System.out.printf(PrintFormat.BODY_FORMAT, i + 1, ns.getMaSo(), ns.getHoTen(), ns.getSoDienThoai(),
					ns.getSoNgayLam(), ns.getLuongMotNgay(), ns.tinhLuong(), ns.getChucVu(), ns.getThongTinThem());
		}
		// in bottom
		drawLine(width);
		System.out.printf(PrintFormat.BOTTOM_FORMAT, "Tổng lương", this.tinhTongLuong(), "");
		drawLine(width);
	}

	private void drawLine(int length) {
		for (int i = 0; i < length; i++)
			System.out.print("-");
		System.out.println();
	}

	public boolean phanBoNhanVien(Scanner sc) {
		int width = 42;
		int maTP, maNV;
		
		getDanhSach();
		// cho người dùng phân bổ từng nhân viên
		System.out.println("\n      =====--PHÂN BỔ NHÂN VIÊN--=====\n");
		// xuất danh sách nhân viên
		System.out.println("----------- DANH SÁCH NHÂN VIÊN ----------");
		System.out.printf(PrintFormat.SUB_HEADER_FORMAT, "STT", "Mã số", "Họ tên");
		drawLine(width);

		for (int i = 0; i < dsNhanVienChuaPhanBo.size(); i++) {
			NhanVien nv = dsNhanVienChuaPhanBo.get(i);
			if (nv instanceof NhanVien) {
				xuatDanhSachBODY_SUB(i + 1, nv.getMaSo(), nv.getHoTen());
			}
		}
		drawLine(width);

		NhanVien nv = new NhanVien();
		boolean flag = true;
		int value = -1;
		do {
			maNV = Integer
					.parseInt(nv.nhapGiaTri("", sc, "Nhập mã nhân viên cần phân bổ hoặc Bấm phím 0 nếu muốn thoát: "));
			if (maNV == 0) {
				return false;
			}
			for (int i = 0; i < dsNhanVienChuaPhanBo.size(); i++) {

				if (maNV == dsNhanVienChuaPhanBo.get(i).getMaSo()) {
					value = i;
					flag = false;
				}
			}
			if (flag) {
				System.out.println("---Mã số không có trong danh sách. Xin nhập lại !---");
			}
		} while (flag);
		System.out.println();

		// xuất danh sách trưởng phòng
		System.out.println("--------- DANH SÁCH TRƯỞNG PHÒNG ---------");
		System.out.printf(PrintFormat.SUB_HEADER_FORMAT, "STT", "Mã số", "Họ tên");
		drawLine(width);

		for (int j = 0; j < dsTruongPhong.size(); j++) {
			TruongPhong tp = dsTruongPhong.get(j);
			if (tp instanceof TruongPhong) {
				xuatDanhSachBODY_SUB(j + 1, tp.getMaSo(), tp.getHoTen());
			}
		}
		drawLine(width);

		flag = true;
		do {
			maTP = Integer
					.parseInt(nv.nhapGiaTri("", sc, "Nhập mã trưởng phòng phân bổ HOẶC Bấm phím 0 nếu muốn thoát: "));
			if (maTP == 0) {
				return false;
			}
			for (TruongPhong item : dsTruongPhong) {
				if (maTP == item.getMaSo()) { // có NV phân bổ rồi. giờ có thêm TP. đầy đủ rồi
					item.tangSoNhanVien(); // tăng số lượng NV cho TP
					dsNhanVienChuaPhanBo.get(value).setTruongPhong(item.getMaSo());// đặt mã TP cho NV
					return true;
				}
			}
			if (flag) {
				System.out.println("---Mã số không có trong danh sách. Xin nhập lại !---");
			}
		} while (flag);

		return false;
	}

	public void xuatDanhSachBODY_SUB(int stt, int ms, String name) {
		System.out.printf(PrintFormat.SUB_BODY_FORMAT, stt, ms, name);
	}

	public boolean them(NhanSu nhanSu, Scanner sc) {

		if (nhanSu instanceof NhanVien) {
			nhanSu.themNhanSu(sc);
			nhanSu.getMaSo();
			dsNhanSu.add(nhanSu);
			return true;
		}

		if (nhanSu instanceof TruongPhong) {
			nhanSu.themNhanSu(sc);
			nhanSu.getMaSo();
			dsNhanSu.add(nhanSu);
			return true;
		}

		float cp = 0;
		if (dsNhanSu.size() == 0) {
			cp = 0;
		} else {
			for (NhanSu listNS : dsNhanSu) {
				if (listNS instanceof GiamDoc) {
					cp = cp + ((GiamDoc) listNS).getCoPhan();
				}
			}
		}

		if (nhanSu instanceof GiamDoc) {
			nhanSu.themNhanSu(sc);
			float val;
			do {
				val = 0;
				val = nhanSu.themCoPhan(sc); // nhập cổ phần
				val = val + cp;
				if (val > 100) {
					System.out.println("Tổng số cổ phần của các Giám Đốc không vượt quá 100 !");
				}
			} while (val > 100);

			nhanSu.getMaSo();
			dsNhanSu.add(nhanSu);
			return true;
		}

		return false;
	}

	public void getDanhSach() {
		dsNhanVienChuaPhanBo = new ArrayList<NhanVien>();
		dsTruongPhong = new ArrayList<TruongPhong>();
		dsNhanVien = new ArrayList<NhanVien>();
		dsGiamDoc =  new ArrayList<GiamDoc>();

		// Đưa NV, TP vào danh sách
		for (NhanSu ns : dsNhanSu) {
			if (ns instanceof NhanVien) {
				if (((NhanVien) ns).getTruongPhong() == 0)
					dsNhanVienChuaPhanBo.add((NhanVien) ns);
			}

			if (ns instanceof TruongPhong)
				dsTruongPhong.add((TruongPhong) ns);
			
			if (ns instanceof NhanVien)
				dsNhanVien.add((NhanVien) ns);
			
			if (ns instanceof GiamDoc)
				dsGiamDoc.add((GiamDoc) ns);
		}
	}

	public boolean xoa(Scanner sc) {
		int maSo = Integer.parseInt(nhapVaoGiaTri(sc, "Nhập mã số Nhân Sự cần xóa: "));
		getDanhSach();
		for (NhanSu item : dsNhanSu) {
			if(maSo == item.getMaSo()) {
				
				if(item instanceof NhanVien) {
					if(((NhanVien) item).getTruongPhong() != 0) {
						for(TruongPhong tp : dsTruongPhong) {
							if(tp.getMaSo() == ((NhanVien)item).getTruongPhong()) {
								tp.giamSoNhanVien();
								dsNhanSu.remove(item);
								return true;
							}
						}
					}else {
						dsNhanSu.remove(item);
						return true;
					}
				}
				
				if(item instanceof TruongPhong) { // nếu mã vừa nhập có kiểu là trưởng phòng
					if(((TruongPhong) item).getSoNhanVien() != 0) {
						for(NhanVien nv : dsNhanVien) {
							if(nv.getTruongPhong() == item.getMaSo()) {
								nv.setTruongPhong(0);
							}
						}
						dsNhanSu.remove(item);
						return true;
					}else {
						dsNhanSu.remove(item);
						return true;
					}
				}
				
				if(item instanceof GiamDoc) {
					dsNhanSu.remove(item);
					return true;
				}	
			}
		}

		return false;
	}

	public void timNhanVienLuongCaoNhat() {		
		getDanhSach();
		int index = 0;
		float max = dsNhanVien.get(0).tinhLuong();
		for(int i = 1; i < dsNhanVien.size(); i++) {
			if(dsNhanVien.get(i).tinhLuong() >= max) {
				max = dsNhanVien.get(i).tinhLuong();
				index = i;
			}
		}
		
		System.out.println("\n=================== DANH SÁCH NHÂN VIÊN CÓ LƯƠNG CAO NHẤT ==================");
		System.out.printf(PrintFormat.COLLUMN_5_HEADER_FORMAT, "STT", "Mã số", "Họ tên", "Số ngày làm", "Lương");
		int width = 76;
		drawLine(width);
		max = dsNhanVien.get(index).tinhLuong();
		for (int i = 0; i < dsNhanVien.size(); i++) {
			if(dsNhanVien.get(i).tinhLuong() == dsNhanVien.get(index).tinhLuong()) {
				NhanVien nv = dsNhanVien.get(i);
				System.out.printf(PrintFormat.COLLUMN_5_BODY_FORMAT
						, i+1, nv.getMaSo(), nv.getHoTen(), nv.getSoNgayLam(), nv.tinhLuong());
			}
		}
		drawLine(width);	
	}
	
	public void timTruongPhongCoNhieuNhanVien() {
		
		getDanhSach();
		int index = 0;
		float max = dsTruongPhong.get(0).getSoNhanVien();
		for(int i = 1; i < dsTruongPhong.size(); i++) {
			if(dsTruongPhong.get(i).getSoNhanVien() > max) {
				max = dsTruongPhong.get(i).getSoNhanVien();
				index = i;
			}
		}
		
		int width = 64;
		System.out.println("\n======== DANH SÁCH TRƯỞNG PHÒNG CÓ NHIỀU NHÂN VIÊN NHẤT ========");
		System.out.printf(PrintFormat.COLLUMN_4_HEADER_FORMAT, "STT", "Mã số", "Họ tên", "Số lượng nhân viên");
		drawLine(width);
		max = dsTruongPhong.get(index).getSoNhanVien();
		for(int i = 0; i < dsTruongPhong.size(); i++) {
			if(dsTruongPhong.get(i).getSoNhanVien() == dsTruongPhong.get(index).getSoNhanVien()) {
				TruongPhong tp = dsTruongPhong.get(i);
				System.out.printf(PrintFormat.COLLUMN_4_BODY_FORMAT
						, i+1, tp.getMaSo(), tp.getHoTen(), tp.getSoNhanVien());
			}
		}
		drawLine(width);
	}
	
	public void timGiamDocCoNhieuCoPhan() {

		getDanhSach();
		int index = 0;
		float max = dsGiamDoc.get(0).getCoPhan();
		for(int i = 1; i < dsGiamDoc.size(); i++) {
			if(dsGiamDoc.get(i).getCoPhan() > max) {
				max = dsGiamDoc.get(i).getCoPhan();
				index = i;
			}
		}
		
		int width = 64;
		System.out.println("\n=========== DANH SÁCH GIÁM ĐỐC CÓ NHIỀU CỔ PHẦN NHẤT ===========");
		System.out.printf(PrintFormat.COLLUMN_4_HEADER_FORMAT, "STT", "Mã số", "Họ tên", "Cổ phần");
		drawLine(width);
		max = dsGiamDoc.get(index).getCoPhan();
		for(int i = 0; i < dsGiamDoc.size(); i++) {
			if(dsGiamDoc.get(i).getCoPhan() == dsGiamDoc.get(index).getCoPhan()) {
				GiamDoc gd = dsGiamDoc.get(i);
				System.out.printf(PrintFormat.COLLUMN_4_BODY_FORMAT
						, i+1, gd.getMaSo(), gd.getHoTen(), gd.getCoPhan());
			}
		}
		drawLine(width);
	}
	
	public void tongThuNhapTungGiamDoc() {
		getDanhSach();
		double tongLuong = 0;
		
		int width = 64;
		System.out.println("\n==================== TỔNG THU NHẬP GIÁM ĐỐC ====================");
		System.out.printf(PrintFormat.COLLUMN_4_HEADER_FORMAT, "STT", "Mã số", "Họ tên", "Tổng lương");
		drawLine(width);
		
		for(int i = 0; i < dsGiamDoc.size(); i++) {
			double luong = dsGiamDoc.get(i).tinhLuong();
			double coPhan = dsGiamDoc.get(i).getCoPhan();
			double doanhThu = congTy.getDoanhThuThang();
			double luongTongCongTy = tinhTongLuong();
			if(coPhan != 0) {
				coPhan = coPhan/100;
			}
			tongLuong = luong + coPhan * (doanhThu - luongTongCongTy);
			GiamDoc gd = dsGiamDoc.get(i);
			System.out.printf(PrintFormat.COLLUMN_4_BODY_FORMAT
					, i+1, gd.getMaSo(), gd.getHoTen(), tongLuong);
		}
		drawLine(width);
	}	

	public String nhapVaoChuoi(Scanner sc, String mess) {
		NhanVien nv = new NhanVien();
		return nv.nhapChuoi("", sc, mess);
	}
	
	public String nhapVaoGiaTri(Scanner sc, String mess) {
		NhanVien nv = new NhanVien();
		return nv.nhapGiaTri("", sc, mess);
	}

	public void xepGiamDan() {
		List<NhanSu> list = new ArrayList<NhanSu>();

		do {
			String[] arrString = dsNhanSu.get(0).getHoTen().split("\\s");
			String min = arrString[arrString.length-1];
			int index = 0;
			for(int item = 1; item < dsNhanSu.size(); item++) {
				String[] arr = dsNhanSu.get(item).getHoTen().split("\\s");
				String str = arr[arr.length-1];
				if(str.compareTo(min) > 0) {
					min = arr[arr.length-1];
					index = item;
				}					
			}
			list.add(dsNhanSu.get(index));
			dsNhanSu.remove(index);
		}while(dsNhanSu.size() != 0);

		int width = 160;
		// in header
		System.out.println("\n================================================================== DANH SÁCH NHÂN SỰ GIẢM DẦN ==================================================================");
		System.out.printf(PrintFormat.HEADER_FORMAT, "STT", "Mã số", "Họ tên", "Số điện thoại", "Số ngày làm",
				"Lương một ngày", "Lương", "Chức vụ", "Trưởng phòng/Số nhân viên/Cổ phần");
		drawLine(width);
		// in body
		for (int i = 0; i < list.size(); i++) {
			dsNhanSu.add(list.get(i));
			NhanSu ns = dsNhanSu.get(i);
			System.out.printf(PrintFormat.BODY_FORMAT, i + 1, ns.getMaSo(), ns.getHoTen(), ns.getSoDienThoai(),
					ns.getSoNgayLam(), ns.getLuongMotNgay(), ns.tinhLuong(), ns.getChucVu(), ns.getThongTinThem());
		}
		drawLine(width);
	}
	
	public void xepTangDan() {
		List<NhanSu> list = new ArrayList<NhanSu>();
		
		do {
			String[] arrString = dsNhanSu.get(0).getHoTen().split("\\s");
			String min = arrString[arrString.length-1];
			int index = 0;
			for(int item = 1; item < dsNhanSu.size(); item++) {
				String[] arr = dsNhanSu.get(item).getHoTen().split("\\s");
				String str = arr[arr.length-1];
				if(str.compareTo(min) < 0) {
					min = arr[arr.length-1];
					index = item;
				}					
			}
			list.add(dsNhanSu.get(index));
			dsNhanSu.remove(index);
		}while(dsNhanSu.size() != 0);

		int width = 160;
		// in header
		System.out.println("\n================================================================== DANH SÁCH NHÂN SỰ TĂNG DẦN ==================================================================");
		System.out.printf(PrintFormat.HEADER_FORMAT, "STT", "Mã số", "Họ tên", "Số điện thoại", "Số ngày làm",
				"Lương một ngày", "Lương", "Chức vụ", "Trưởng phòng/Số nhân viên/Cổ phần");
		drawLine(width);
		// in body
		for (int i = 0; i < list.size(); i++) {
			dsNhanSu.add(list.get(i));
			NhanSu ns = dsNhanSu.get(i);
			System.out.printf(PrintFormat.BODY_FORMAT, i + 1, ns.getMaSo(), ns.getHoTen(), ns.getSoDienThoai(),
					ns.getSoNgayLam(), ns.getLuongMotNgay(), ns.tinhLuong(), ns.getChucVu(), ns.getThongTinThem());
		}
		drawLine(width);
	}
}
