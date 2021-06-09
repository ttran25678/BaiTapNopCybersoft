package cybersoft.java12.oop.quanlynhansu;

import java.util.Scanner;

public interface NhapXuatConsole {

	String nhapGiaTri(String str, Scanner sc, String mess);
	String nhapChuoi(String str, Scanner sc, String mess);
	
	void xuatThongTin();
	void themNhanSu(Scanner sc);
	float themCoPhan(Scanner sc);
}
