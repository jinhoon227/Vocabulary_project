package TOEIC_WORD_900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AdvanceUserArray {



	ArrayList<UserInfo> list = new ArrayList<UserInfo>();

	
	AdvanceUserArray() {
		
	}
		
	public UserInfo getUserInfo(int o) {
		return list.get(o);
	}
	
	public void setUserInfo(UserInfo uif) {
		list.add(uif);
	}
	
	public int getCnt() {
		return this.list.size();
	}
	
	public void rankSort() {
		Collections.sort(list);
	}
}
