package com.javaex.phone;

import java.util.List;

public class PhoneAppV {

	public static void main(String[] args) {

		List<PersonVo> pList;		
		PhoneDao phoneDao = new PhoneDao();
		PhoneView view = new PhoneView();

		view.showTitle();

		boolean run = true;
		while (run) {
			int menuNum = view.showMenu();

			switch (menuNum) {
			case 1:
				pList = phoneDao.personSelect();
				view.showList(pList);
				
				break;

			case 2:
				PersonVo person = view.showAdd();
				phoneDao.personInsert(person);
				
				break;

			case 3:
				PersonVo edit = view.showEdit();
				phoneDao.personUpdate(edit);
				
				break;

			case 4:
				int index = view.showRemove();
				phoneDao.personDelete(index);
				
				break;

			case 5:
				String keyword = view.showSearch();
				pList = phoneDao.personSearch(keyword);
				view.showSearchResult(pList);
				
				break;

			case 6:
				run = false;
				break;

			default:
				view.showEtc();
				break;
				
			} // switch
		} // while

		view.showEnd();
	}

}
