package Ticket_reserve;

import java.util.Scanner;

public class TicketController {
	UserDAO ud = new UserDAO();
	SeatDAO sd = new SeatDAO();

	void run() {
		Scanner scan = new Scanner(System.in);
		sd.init();

		while (true) {
			System.out.println("[1.�α���][2.ȸ������][0.����]");
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
			System.out.println("[1.����][2.���][3.����Ȯ��][0.�α׾ƿ�]");
			int sel = scan.nextInt();

			if (sel == 1) {// ����
				sd.ticketing(ud.log);
			} else if (sel == 2) { // �������
				sd.cancell(ud.log);
			} else if (sel == 3) { // ����Ȯ��
				sd.confirmation();
			} else if (sel == 0) { // �α׾ƿ�
				break;
			}
		}
	}
}
