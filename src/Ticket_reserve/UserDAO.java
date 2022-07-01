package Ticket_reserve;

import java.util.Scanner;

public class UserDAO {
	Scanner scan = new Scanner(System.in);
	int userCount = 0;
	User userList[] = null;
	String log = "";

	boolean login() {
		boolean check = false;
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		int pw = scan.nextInt();

		// log check
		if (logincheck(id, pw)) {
			check = true;
		}
		return check;
	}

	boolean logincheck(String id, int pw) {
		boolean check = false;
		for (int i = 0; i < userCount; i++) {
			if (id.equals(userList[i].id) && pw == userList[i].pw) {
				log = userList[i].id;
				check = true;
			}
		}
		return check;
	}

	void join() {
		System.out.print("아이디 입력 : ");
		String id = scan.nextLine();
		if (idcheck(id)) {
			System.out.println("중복된 아이디 입니다.");
		} else {
			System.out.print("비밀번호 입력 : ");
			int pw = scan.nextInt();
			userList = new User[userCount + 1];
			userList[userCount] = new User();
			userList[userCount].id = id;
			userList[userCount].pw = pw;
			userCount++;
		}
	}

	boolean idcheck(String id) {
		boolean check = false;

		for (int i = 0; i < userCount; i++) {
			if (id.equals(userList[i].id)) {
				check = true;
			}
		}

		return check;
	}

	void printUser() {
		for (int i = 0; i < userCount; i++) {
			System.out.println(userList[i].id + " " + userList[i].pw);
		}
	}
}
