package TOEIC_WORD_900;

public class word_unit {
	public String[] word = new String[30];
	public String[] mean = new String[30];
	private int cnt=0;
	public int Unit;
	public word_unit() {
		// TODO Auto-generated constructor stub
	}
	public word_unit(int unit) {
		// TODO Auto-generated constructor stub
		Unit=unit;
	}
	public void get_DTO(wordDTO DTO) {
		word[cnt]=DTO.getword();
		mean[cnt]=DTO.getmean();
		cnt++;
	}
}
