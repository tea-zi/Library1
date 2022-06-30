package Ticket_reserve;

import java.util.Scanner;

public class SeatDAO {
	Scanner scan = new Scanner(System.in);
	Seat seatList[] = new Seat[10];
	int seatCount = 0;
	int size = seatList.length;

	void init() {
		for (int i = 0; i < size; i++) {
			seatList[i].number = i + 1;
		}
	}

	void printSeat() {
		for (int i = 0; i < seatList.length; i++) {
			if (seatList[i].check == true) {
				System.out.println("[O]");
			} else {
				System.out.println("[X]");
			}
		}
	}

	void ticketing(String log) {
		printSeat();
		System.out.println("좌석 번호 : ");
		int sel = scan.nextInt();

		if (sel < 1 || sel > size) {
			return;
		}

		sel--;
		if (seatList[sel].check == false) {
			seatList[sel].userId = log;
			seatList[sel].check = true;
			System.out.println("예매완료");
		} else {
			System.out.println("예매불가");
		}

	}
}
