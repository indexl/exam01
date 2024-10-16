package exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exam2.dto.Member;
import exam2.util.Util;

public class Main {

	static int lastMemberId;
	static List<Member> members;

	static {
		lastMemberId = 0;
		members = new ArrayList<>();
	}

	public static void main(String[] args) {

		System.out.println("프로그램 시작!");
		Scanner sc = new Scanner(System.in);
		makeTestDate();

		while (true) {
			System.out.println("명령어: ");
			String cmd = sc.nextLine();

			if (cmd.equals("exit")) {
				break;
			}

			if (cmd.equals("member join")) {

				String loginId = null;
				String loginPw = null;
				String name = null;

				while (true) {
					System.out.println("아이디: ");
					loginId = sc.nextLine();

					if (loginId.length() == 0) {
						System.out.println("아이디는 필수 입력입니다.");
						continue;
					}

					boolean loginDupl = false;
					for (Member member : members) {
						if (member.getLoginId().equals(loginId)) {
							loginDupl = true;
							continue;
						}
					}
					if (loginDupl) {
						System.out.printf("[%s] 아이디가 중복 되었습니다.", loginId);
						continue;
					}
					break;
				}

				while (true) {
					System.out.println("비밀번호: ");
					loginPw = sc.nextLine();

					if (loginPw.length() == 0) {
						System.out.println("비밀번호는 필수 입력입니다.");
						continue;
					}
					if (loginPw.equals(login)) {

						System.out.println("비밀번호 확인: ");
						String loginPwCk = sc.nextLine();
						

					}
					System.out.println("이름: ");
					name = sc.nextLine();

					if (name.length() == 0) {
						System.out.println("이름은 필수 입력입니다.");
						continue;
					}
				}

			} else if (cmd.startsWith("member list")) {

				List<Member> printMembers = members;
				
				String keyword = cmd.substring("member list".length()).trim();
				
				if(keyword.length()>0) {
			
					printMembers = new ArrayList<>();
					
					for(Member member : members) {
						if(member.getLoginId().contains(keyword)) {
							
							printMembers.add(member);
						}
						
					}
					System.out.println("번호  |  날짜  |  아이디  |  이름");
					for(int i = printMembers.size()-1; i>=0; i--) {
						Member member = printMembers.get(i);
						System.out.printf("%d  |  %s  |  %s  |  s\n",member.getClass(),Util.getDateStr(), member.getLoginPw(), member.getName());
			
					}	
				}		
			}
			sc.close();
			System.out.println("프로그램 종료");
		}
	}
	

	private static void makeTestDate() {
		System.out.println("테스트용 데이터 3생성");
		for (int i = 1; i <= 3; i++) {
			members.add(new Member(lastMemberId, "", "test1" + i, "test2" + i, "유저1" + i));
		}
	}
}
