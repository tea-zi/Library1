package Ticket_reserve;

import java.util.Scanner;

public class UserDAO {
	Scanner scan = new Scanner(System.in);
	User userList[] = new User[100];
	String log = "";
	int userCount = 0;

	boolean login() {
		boolean check = false;
		System.out.print("���̵� �Է� : ");
		String id = scan.next();
		System.out.print("��й�ȣ �Է� : ");
		int pw = scan.nextInt();
		// log check
		log = logincheck(id, pw);
		if (log.equals("")) {
			check = true;
		}
		return check;
	}

	String logincheck(String id, int pw) {
		String log = "";
		for (int i = 0; i < userCount; i++) {
			if (id.equals(userList[i].id) && pw == userList[i].pw) {
				log = userList[i].id;
			}
		}
		return log;
	}

	void join() {
		System.out.print("���̵� �Է� : ");
		String id = scan.nextLine();
		if (idcheck(id)) {
			System.out.println("��й�ȣ �Է� : ");
			int pw = scan.nextInt();
			userList[userCount].id = id;
			userList[userCount].pw = pw;
			userCount++;
		} else {
			System.out.println("�ߺ��� ���̵� �Դϴ�.");
		}
	}

	boolean idcheck(String id) {
		boolean check = false;

		for (int i = 0; i < userList.length; i++) {
			if (id.equals(userList[i].id)) {
				check = true;
			}
		}

		return check;
	}
}
