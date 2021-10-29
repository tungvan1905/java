package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.presentationlayer.CandidateController;
import com.vti.entity.FresherCandidate.GraduationRank;
import com.vti.ultis.ScannerUltis;

public class CandidateFunction {
	private CandidateController candidateController;

	public CandidateFunction() throws FileNotFoundException, IOException {
		candidateController = new CandidateController();
	}

	public void getRegister() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("-------| Mời bạn chọn chức năng |------");
			String leftAlignFormat = "| %-36s |%n";
			System.out.format("+--------------------------------------+%n");
			System.out.format("|              Choose please           |%n");
			System.out.format("+--------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Register ExperienceCandidate ");
			System.out.format(leftAlignFormat, "2. Register FresherCandidate ");
			System.out.format(leftAlignFormat, "3. Exit ");
			System.out.format("+--------------------------------------+%n");
			System.out.println("Mời bạn chọn chức năng: ");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				getRegisterExpCandidate();
				break;
			case 2:
				getRegisterFreshCandidate();
				break;
			case 3:
				return;
			default:
				System.out.println("Không có lựa chọn này. Mời bạn nhập lại. ");
				break;
			}
		}
	}

	public void getRegisterExpCandidate() throws ClassNotFoundException, SQLException {
		System.out.println("------| Register ExperienceCandidate |------");
		System.out.println("Mời bạn nhập FirstName: ");
		String firstName = ScannerUltis.inputString();
		System.out.println("Mời bạn nhập LastName: ");
		String lastName = ScannerUltis.inputString();
		System.out.println("Mời bạn nhập Phone: ");
		String phone = ScannerUltis.inputPhoneNumber();
		System.out.println("Mời bạn nhập Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập Password: ");
		String password = ScannerUltis.inputPassword();
		System.out.println("Mời bạn nhập ExpInYear: ");
		int expInYear = ScannerUltis.inputIntPositive();
		System.out.println("Mời bạn nhập ProSkill: ");
		String proSkill = ScannerUltis.inputString();
		if (candidateController.createExperienceCandidate(firstName, lastName, phone, email, password, expInYear,
				proSkill)) {
			System.out.println("Tạo thành công. \nTài khoản của bạn là: \nEmail: " + email + "\nPassword: " + password);
			return;
		} else {
			System.out.println("Tạo không thành công. Xin vui lòng kiểm tra lại. ");
			return;
		}
	}

	public void getRegisterFreshCandidate() throws ClassNotFoundException, SQLException {
		System.out.println("------| Register FresherCandidate |------");
		System.out.println("Mời bạn nhập FirstName: ");
		String firstName = ScannerUltis.inputString();
		System.out.println("Mời bạn nhập LastName: ");
		String lastName = ScannerUltis.inputString();
		System.out.println("Mời bạn nhập Phone: ");
		String phone = ScannerUltis.inputPhoneNumber();
		System.out.println("Mời bạn nhập Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập Password: ");
		String password = ScannerUltis.inputPassword();
		System.out.println("Mời bạn nhập GraduationRank: ");
		GraduationRank graduationRank = getGraduationRank();
		if (candidateController.createFresherCandidate(firstName, lastName, phone, email, password, graduationRank)) {
			System.out.println("Tạo thành công. \nTài khoản của bạn là: \nEmail: " + email + "\nPassword: " + password);
			return;
		} else {
			System.out.println("Tạo không thành công. Xin vui lòng kiểm tra lại. ");
			return;
		}
	}

	private GraduationRank getGraduationRank() {
		while (true) {
			String leftAlignFormat = "| %-36s |%n";
			System.out.format("+--------------------------------------+%n");
			System.out.format("|              Choose please           |%n");
			System.out.format("+--------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. EXCELLENCE ");
			System.out.format(leftAlignFormat, "2. GOOD ");
			System.out.format(leftAlignFormat, "3. FAIR ");
			System.out.format(leftAlignFormat, "4. POOR ");
			System.out.format("+--------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				return GraduationRank.EXCELLENCE;
			case 2:
				return GraduationRank.GOOD;
			case 3:
				return GraduationRank.FAIR;
			case 4:
				return GraduationRank.POOR;
			default:
				System.out.println("Không có lựa chọn này. Mời bạn chọn lại: ");
				break;
			}
		}
	}

	public void getLogin() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập Password: ");
		String password = ScannerUltis.inputPassword();
		if (candidateController.isLogin(email, password)) {
			System.out.println("Tài khoản " + email + " đăng nhập thành công. Chúc bạn có một buổi tối vui vẻ. ");
			return;
		} else {
			System.out.println("Đăng nhập thất bại. Xin vui lòng kiểm tra lại. ");
			return;
		}
	}
}
