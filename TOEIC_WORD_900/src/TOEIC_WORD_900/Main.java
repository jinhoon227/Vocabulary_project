package TOEIC_WORD_900;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class Main {
	public static File Audiofile=new File("book_page.wav");
	//11.26 hun -> ���� ���� ����ƽ���� ���� ������ ����
	public static UserInfo userInfo = new UserInfo();
    public static void playSound(float vol, boolean repeat){
        try{
                final Clip clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
                clip.open(AudioSystem.getAudioInputStream(Audiofile));
                clip.addLineListener(new LineListener() {
                        @Override
                        public void update(LineEvent event) {
                                // TODO Auto-generated method stub
                                if(event.getType()==LineEvent.Type.STOP){
                                        //�� �κ��� ������ ȿ������ �޸𸮿� ���� �׿��� ������ ũ���õȴ�
                                        clip.close();
                                }
                        }
                });
                FloatControl volume = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                volume.setValue(vol);
                clip.start();
                if(repeat)
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(Exception e){
                e.printStackTrace();
        }
}
	public Main() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login.login_f.setVisible(true);
		
	}

}
