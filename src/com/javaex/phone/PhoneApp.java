package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {

		List<PersonVo> pList;
		PhoneDao phoneDao = new PhoneDao();
		Scanner sc = new Scanner(System.in);

		System.out.println("************************************");
		System.out.println("*          전화번호 관리 프로그램         *");
		System.out.println("************************************");

		boolean run = true;
		while (run) {
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
			System.out.println("----------------------------------------");
			System.out.print(">메뉴번호: ");
			int menuNum = sc.nextInt();
			sc.nextLine();

			switch (menuNum) {

			case 1:
				System.out.println("<1.리스트>");
				
				pList = phoneDao.personSelect();
				for (int i = 0; i < pList.size(); i++) {
					PersonVo vo = pList.get(i);
					System.out.println(vo.getPersonId() + "." + "\t" + vo.getName() + "\t" + vo.getHp() + "\t"
							+ vo.getCompany() + "\t");
				}
				
				break;
				
			case 2:
				System.out.println("<2.등록>");
				System.out.print("이름 > ");
				String name = sc.nextLine();
				
				System.out.print("휴대전화 > ");
				String hp = sc.nextLine();
				
				System.out.print("회사번호 > ");
				String company = sc.nextLine();
				
				PersonVo person = new PersonVo(name, hp, company);
				phoneDao.personInsert(person);
				
				break;
				
			case 3:
				System.out.println("<3.수정>");
				System.out.print("번호 > ");
				int personId = sc.nextInt();
				sc.nextLine();
				
				System.out.print("이름 > ");
				String editName = sc.nextLine();
				
				System.out.print("휴대전화 > ");
				String editHp = sc.nextLine();
				
				System.out.print("회사번호 > ");
				String editCompany = sc.nextLine();
				
				PersonVo edit = new PersonVo(personId, editName, editHp, editCompany);
				phoneDao.personUpdate(edit);
			
				break;
				
			case 4:
				System.out.println("<4.삭제>");
				System.out.print(">번호: ");
				int index = sc.nextInt();
				
				phoneDao.personDelete(index);
			
				break;
				
			case 5:
				System.out.println("<5.검색>");
				System.out.print("검색어 > ");
				String keyword = sc.nextLine();
				
				pList = phoneDao.personSearch(keyword);
				for (int i = 0; i < pList.size(); i++) {
					PersonVo vo = pList.get(i);
					System.out.println(vo.getPersonId() + "." + "\t" + vo.getName() + "\t" + vo.getHp() + "\t"
							+ vo.getCompany() + "\t");
				}
				
				break;
				
			case 6:
				run = false;
				break;
				
			default:
				System.out.println("[다시 입력해주세요.]");
				break;
				
			} // switch
		} // while
		
		System.out.println("");
		System.out.println("************************************");
		System.out.println("*              감사합니다             *");
		System.out.println("************************************");

		sc.close();

	}

}
