package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneView {

	// 필드
	private Scanner sc;

	// 생성자
	public PhoneView() {
		this.sc = new Scanner(System.in);
	}

	// 메소드 일반
	// start-end
	public void showTitle() {
		System.out.println("************************************");
		System.out.println("*          전화번호 관리 프로그램         *");
		System.out.println("************************************");
	}

	public int showMenu() {
		System.out.println("");
		System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
		System.out.println("----------------------------------------");
		System.out.print(">메뉴번호: ");
		int menuNum = sc.nextInt();
		sc.nextLine();

		return menuNum;
	}

	public void showEtc() {
		System.out.println("[다시 입력해주세요.]");
	}

	public void showEnd() {
		System.out.println("");
		System.out.println("************************************");
		System.out.println("*              감사합니다             *");
		System.out.println("************************************");

		sc.close();
	}

	// switch-case
	public void showList(List<PersonVo> pList) {
		System.out.println("<1.리스트>");
		printList(pList);
	}

	public PersonVo showAdd() {
		System.out.println("<2.등록>");
		System.out.print("이름 > ");
		String name = sc.nextLine();

		System.out.print("휴대전화 > ");
		String hp = sc.nextLine();

		System.out.print("회사번호 > ");
		String company = sc.nextLine();

		PersonVo person = new PersonVo(name, hp, company);
		return person;
	}

	public PersonVo showEdit() {
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
		return edit;
	}

	public int showRemove() {
		System.out.println("<4.삭제>");
		System.out.print(">번호: ");
		int index = sc.nextInt();

		return index;
	}
	
	public String showSearch() {
		System.out.println("<5.검색>");
		System.out.print("검색어 > ");
		String keyword = sc.nextLine();
		
		return keyword;
	}
	
	public void showSearchResult(List<PersonVo> pList) {
		printList(pList);
	}

	// 기능
	private void printList(List<PersonVo> pList) {
		for (int i = 0; i < pList.size(); i++) {
			PersonVo vo = pList.get(i);
			System.out.println(
					vo.getPersonId() + "." + "\t" + vo.getName() + "\t" + vo.getHp() + "\t" + vo.getCompany() + "\t");
		}
	}
}
