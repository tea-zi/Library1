package Ticket_reserve;

import java.util.Scanner;

public class TicketController {
	UserDAO ud = new UserDAO();
	SeatDAO sd = new SeatDAO();

	void run() {
		Scanner scan = new Scanner(System.in);

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
			}
		}
	}

	void menu() {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("[1.����][2.���][3.����Ȯ��][0.�α׾ƿ�]");
			int sel = scan.nextInt();

			if (sel == 1) {
				sd.ticketing(ud.log);
			} else if (sel == 2) {

			} else if (sel == 3) {

			} else if (sel == 0) {
				break;
			}
		}
	}
}
