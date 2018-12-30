package TOEIC_WORD_900;

public class testdk {

	public testdk() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		word_unit Unit1=wordDAO.getUnit(1);
		for(int i=0;i<30;i++) {
			System.out.println(Unit1.word[i]+" "+Unit1.mean[i]);
		}
	}

}
