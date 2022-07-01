package Ticket_reserve;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class UserDAO {
	Scanner scan = new Scanner(System.in);
	int userCount = 0;
	User userList[] = null;
	String fileName = "src/Ticket_reserve/userData.txt";
	String log = "";

	boolean login() {
		boolean check = false;
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		int pw = scan.nextInt();
		scan.nextLine();
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
			scan.nextLine();
			User temp[] = userList;
			userList = new User[userCount + 1];
			for (int i = 0; i < userCount; i++) {
				userList[i] = temp[i];

			}
			userList[userCount] = new User();
			userList[userCount].id = id;
			userList[userCount].pw = pw;
			userCount++;
			save();
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

	void save() {
		String data = getData();
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	String getData() {
		String data = "";
		for (int i = 0; i < userCount; i++) {
			data += userList[i].id;
			data += ",";
			data += userList[i].pw;
			data += "\n";

		}
		System.out.println(data);
		data = data.substring(0, data.length() - 1);
		return data;
	}

	void load() {
		String data = "";
		try {
			FileReader fr = new FileReader(fileName);
			while (true) {
				int read = fr.read();
				if (read != -1) {
					data += (char) read;
				} else {
					break;
				}
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		String token[] = data.split("\n");
		userCount = token.length;
		userList = new User[userCount];
		for (int i = 0; i < userCount; i++) {
			String[] token2 = token[i].split(",");
			userList[i] = new User();
			userList[i].id = token2[0];
			userList[i].pw = Integer.parseInt(token2[1]);

		}
	}
}
