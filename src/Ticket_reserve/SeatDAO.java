package Ticket_reserve;

import java.util.Scanner;

public class SeatDAO {
	Scanner scan = new Scanner(System.in);
	Seat seatList[] = new Seat[10];
	int seatCount = 0;
	int size = seatList.length;

	void init() {
		for (int i = 0; i < size; i++) {
			seatList[i] = new Seat();
			seatList[i].number = i + 1;
			seatList[i].check = false;
			seatList[i].userId = "";
		}
	}

	void printSeat() {
		for (int i = 0; i < seatList.length; i++) {
			System.out.print("[" + seatList[i].number + "]");
		}
		System.out.println();
		for (int i = 0; i < seatList.length; i++) {
			if (seatList[i].check == true) {
				System.out.print("[O]");
			} else {
				System.out.print("[X]");
			}
		}
		System.out.println();
	}

	void ticketing(String log) {
		printSeat();
		System.out.print("좌석 번호 : ");
		int sel = scan.nextInt();

		if (sel < 1 || sel > size) {
			return;
		}

		sel--;
		if (seatList[sel].check == false) {
			seatList[sel].userId = log;
			seatList[sel].check = true;
			System.out.println("예매완료");
			printSeat();
		} else {
			System.out.println("예매불가");
		}

	}

	void cancell(String log) {
		int cnt = 0;
		int sel[] = null;
		for (int i = 0; i < seatList.length; i++) {
			if (seatList[i].userId.equals(log)) {
				if (cnt == 0) {
					sel = new int[1];
				} else if (cnt > 0) {
					int temp[] = sel;
					sel = new int[cnt + 1];
					for (int j = 0; j < cnt; j++) {
						sel[j] = temp[j];
					}
				}
				sel[cnt] = seatList[i].number;
				cnt++;
			}
		}
		select(sel);
		printSeat();
	}

	void select(int[] sel) {
		for (int i = 0; i < sel.length; i++) {
			System.out.print("[" + sel[i] + "]");
		}
		System.out.print("\n좌석선택 : ");
		int s = scan.nextInt();
		boolean check = false;
		for (int i = 0; i < sel.length; i++) {
			if (sel[i] == s) {
				check = true;
			}
		}

		if (check == true) {
			seatList[s - 1].check = false;
			seatList[s - 1].userId = "";
		}
	}

	void confirmation() {
		for (int i = 0; i < seatList.length; i++) {
			System.out.println("[" + seatList[i].number + " | " + seatList[i].userId + "]");
		}
	}
}
