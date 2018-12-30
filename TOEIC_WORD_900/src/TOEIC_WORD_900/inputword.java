package TOEIC_WORD_900;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class inputword {
	public static File file;
	public static FileReader filereader;
	public static BufferedReader bufReader;
	public static File file2;
	public static FileReader filereader2;
	public static BufferedReader bufReader2;
	
	public static String ReadNextword(BufferedReader reader)  {
	    
	    String line= "";
	    
	    try {
	       line=reader.readLine();
	       if(line!=null) {
	          return line;
	             
	       }
	    } catch (IOException e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	    }
	    return null;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		file = new File("word.txt");
		file2 = new File("mean.txt");
		try {
			filereader=new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			filereader2=new FileReader(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufReader=new BufferedReader(filereader);
		bufReader2=new BufferedReader(filereader2);
		String word_line,mean_line;
		int cnt=0,unit=1;
		word_line=ReadNextword(bufReader);
		mean_line=ReadNextword(bufReader2);
		while(word_line!=null&&mean_line!=null) {
			if(cnt==30) {
				cnt=0;
				unit++;
			}
			System.out.println(word_line+" "+mean_line);
			cnt++;
			wordDAO.insert(unit, word_line, mean_line);
			word_line=ReadNextword(bufReader);
			mean_line=ReadNextword(bufReader2);
		}
		System.out.println("³¡");
	}

}
