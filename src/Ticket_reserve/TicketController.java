package Ticket_reserve;

import java.util.Scanner;

public class TicketController {
	UserDAO ud = new UserDAO();
	SeatDAO sd = new SeatDAO();

	void run() {
		Scanner scan = new Scanner(System.in);
		sd.init();

		while (true) {
			System.out.println("[1.로그인][2.회원가입][0.종료]");
			int sel = scan.nextInt();
			if (sel == 1) {
				if (ud.login()) {
					menu();
				}
			} else if (sel == 2) {
				ud.join();
			} else if (sel == 0) {
				break;
			} else if (sel == 3) {
				ud.load();
				sd.load();
			} else if (sel == 4) {
				System.out.println(ud.userCount);
			}
		}
	}

	void menu() {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("[1.예매][2.취소][3.예매확인][0.로그아웃]");
			int sel = scan.nextInt();

			if (sel == 1) {// 예매
				sd.ticketing(ud.log);
			} else if (sel == 2) { // 예매취소
				sd.cancell(ud.log);
			} else if (sel == 3) { // 예매확인
				sd.confirmation();
			} else if (sel == 0) { // 로그아웃
				break;
			}
		}
	}
}
