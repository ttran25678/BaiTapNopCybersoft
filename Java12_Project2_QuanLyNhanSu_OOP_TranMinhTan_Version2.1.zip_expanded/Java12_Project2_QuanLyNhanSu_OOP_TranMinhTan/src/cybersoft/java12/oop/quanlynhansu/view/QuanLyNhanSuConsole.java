package cybersoft.java12.oop.quanlynhansu.view;

import java.util.Scanner;

import cybersoft.java12.oop.quanlynhansu.GiamDoc;
import cybersoft.java12.oop.quanlynhansu.NhanSu;
import cybersoft.java12.oop.quanlynhansu.NhanVien;
import cybersoft.java12.oop.quanlynhansu.TruongPhong;
import cybersoft.java12.oop.quanlynhansu.controller.QuanLyNhanSu;

public class QuanLyNhanSuConsole {

	/* properties */
	private QuanLyNhanSu quanLyNhanSu;

	/* constructors */
	public QuanLyNhanSuConsole() {
		quanLyNhanSu = new QuanLyNhanSu();
	}

	public void start() {

		// main program
		Scanner sc = new Scanner(System.in);
		int choice = -1;

		boolean flag = true;
		while (flag) {
			quanLyNhanSu.xuatCongTy();
			quanLyNhanSu.xuatDanhSachNhanSu();
			// show menu
			showMenu();

			do {
				choice = Integer.parseInt(nhapGiaTri("", sc, "Mời bạn chọn chức năng: "));
				if (choice < 0 || choice > 12) {
					System.out.println("SAI. Vui lòng nhập từ 0 đến 12. [0:12]");
				} else {
					break;
				}
			} while (choice < 0 || choice > 12);
			processOption(choice, sc);
			if (choice == 0) {
				flag = false;
			} else {
				System.out.println("\t---BẤM 1 PHÍM BẤT KỲ ĐỂ TIẾP TỤC--- ");
				sc.nextLine();
			}
		}

		sc.close();
	}

	public void showMenu() {
		System.out.println("========--MENU--========");
		System.out.println("1. Nhập thông tin công ty.");
		System.out.println("2. Phân bổ nhân viên.");
		System.out.println("3. Thêm nhân sự.");
		System.out.println("4. Xóa nhân sự.");
		System.out.println("5. Xuất danh sách nhân sự.");
		System.out.println("6. Xuất tổng lương công ty.");
		System.out.println("7. Tìm nhân viên có lương cao nhất.");
		System.out.println("8. Tìm trưởng phòng có số lượng nhân viên cao nhất.");
		System.out.println("9. Sắp xếp danh sách nhân sự theo alphabet.");
		System.out.println("10. Sắp xếp danh sách nhân sự theo lương.");
		System.out.println("11. Tìm giám đốc có số lượng cổ phần nhiều nhất.");
		System.out.println("12. Tính và xuất tổng thu nhập của từng giám đốc.");
		System.out.println("0. Thoát.");
		System.out.print("Lựa chọn: ");
	}
	
	public void subMenu() {
		System.out.println("------------------------");
		System.out.println("|1. Thêm Nhân viên     |");
		System.out.println("|2. Thêm Trưởng Phòng  |");
		System.out.println("|3. Thêm Giám Đốc      |");
		System.out.println("------------------------");
	}

	public void processOption(int choice, Scanner sc) {
		switch (choice) {
		case 1: {
			quanLyNhanSu.nhapCongTy(sc);
			System.out.println();
			break;
		}
		case 2: {
			if(quanLyNhanSu.phanBoNhanVien(sc)) {
				System.out.println("Thêm thành công !");
			}else {
				System.out.println("Thêm thất bại !");
			}
			System.out.println();
			break;
		}
		case 3: {
			subProcessOption(sc);
			System.out.println();
			break;
		}
		case 4: {
			if(quanLyNhanSu.xoa(sc)) {
				System.out.println("Xoá thành công !");
			}else {
				System.out.println("Xóa thất bại !");
			}
			System.out.println();
			break;
		}
		case 5: {
			quanLyNhanSu.xuatDanhSachNhanSu();
			System.out.println();
			break;
		}
		case 6: {
			System.out.println("\nTổng lương toàn công ty: " + quanLyNhanSu.tinhTongLuong());
			System.out.println();
			break;
		}
		case 7: {
			quanLyNhanSu.timNhanVienLuongCaoNhat();
			System.out.println();
			break;
		}
		case 8: {
			quanLyNhanSu.timTruongPhongCoNhieuNhanVien();
			System.out.println();
			break;
		}
		case 9: {
			quanLyNhanSu.xepTangDan();
			System.out.println();
			break;
		}
		case 10: {
			quanLyNhanSu.xepGiamDan();
			System.out.println();
			break;
		}
		case 11: {
			quanLyNhanSu.timGiamDocCoNhieuCoPhan();
			System.out.println();
			break;
		}
		case 12: {
			quanLyNhanSu.tongThuNhapTungGiamDoc();
			System.out.println();
			break;
		}
		default:
			System.out.println("========== TẠM BIỆT. HẸN GĂP LẠI ! =============");
			break;

		}
	}

	public void subProcessOption(Scanner sc) {
		while (true) {
			subMenu();
			int choice_sub;
			do {
				choice_sub = Integer.parseInt(nhapGiaTri("", sc, "Vui lòng chọn: "));
				if (choice_sub < 1 || choice_sub > 4) {
					System.out.println("SAI.Vui lòng chọn 1,2 hoặc 3 !");
				}
			} while (choice_sub < 1 || choice_sub > 4);
			switch (choice_sub) {
			case 1: {
				NhanSu nv = new NhanVien(); 
				if(quanLyNhanSu.them(nv, sc)) {
					System.out.println("\nThêm thành công !");
				}else {
					System.out.println("\nThêm thất bại !");
				}
				System.out.println();
				break;
			}
			case 2: {
				NhanSu tp = new TruongPhong();
				if(quanLyNhanSu.them(tp, sc)) {
					System.out.println("\nThêm thành công !");
				}else {
					System.out.println("\nThêm thất bại !");
				}
				System.out.println();
				break;
			}
			default:
				NhanSu gd = new GiamDoc();
				if(quanLyNhanSu.them(gd, sc)) {
					System.out.println("\nThêm thành công !");
				}else {
					System.out.println("\nThêm thất bại !");
				}
				System.out.println();
				break;
			}

			break;
		}
	}

	/* Business */
	// Kiểm tra là số
	public static boolean kiemTraLaSo(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	// nhập chuỗi và kiểm tra là số
	public static String nhapGiaTri(String str, Scanner sc, String mess) {

		while (true) {
			System.out.print(mess);
			str = sc.nextLine();

			if (kiemTraLaSo(str)) { // KT có phải là số hay k
				double thapPhan = Double.parseDouble(str); // ép kiểu đưa về kiểu int
				int soNguyen = (int) thapPhan;
				if (soNguyen == thapPhan) { // chỉ nhận kiểu int. chấp nhận 1.0, 2.0...
					break;
				} else {
					System.out.println("SAI. Xin nhập lại !");
				}
			} else {
				System.out.println("SAI. Xin nhập lại !");
			}
		}

		return str;
	}

}
