package TOEIC_WORD_900;

public class UserInfo implements Comparable<UserInfo> {
	private String name;
	private String id;
	private String pass;
	private int score;
	private int nowUnit;
	
	//add sort by hun
	public int compareTo(UserInfo other){
        return other.getScore() - this.score;                                                    
    }
	
	UserInfo(String id, String pass){
		this.id=id;
		this.pass=pass;
	}
	
	UserInfo(String id, String pass, String name){
		this.id=id;
		this.pass=pass;
		this.name=name;
		this.nowUnit=0;
		this.score=0;
	}
	
	UserInfo(UserInfo uf){
		this.id=uf.id;
		this.pass=uf.pass;
		this.name=uf.name;
	}
	
	UserInfo(){
		this.id="none";
		this.pass="none";
		this.name="none";
	}
	
	void setName(String uName) {
		this.name=uName;
	}
	
	String getName() {
		return this.name;
	}
	
	String getId() {
		return this.id;
	}
	
	int getScore() {
		return this.score;
	}
	
	void setScore(int sco) {
		this.score=sco;
	}
	
	void setUnit(int n) {
		this.nowUnit=n;
	}
	
	int getUnit() {
		return this.nowUnit;
	}
}
