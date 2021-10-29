package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.ultis.ScannerUltis;

public class Program {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			CandidateFunction candidateFunction = new CandidateFunction();
			System.out.println("-------| Mời bạn chọn chức năng |------");
			String leftAlignFormat = "| %-36s |%n";
			System.out.format("+--------------------------------------+%n");
			System.out.format("|              Choose please           |%n");
			System.out.format("+--------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Register ");
			System.out.format(leftAlignFormat, "2. Login ");
			System.out.format(leftAlignFormat, "3. Exit ");
			System.out.format("+--------------------------------------+%n");
			System.out.println("Mời bạn chọn chức năng: ");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				candidateFunction.getRegister();
				break;
			case 2:
				candidateFunction.getLogin();
				break;
			case 3:
				return;
			default:
				System.out.println("Không có lựa chọn này. Mời bạn nhập lại: ");
				break;
			}
		}
	}
}
