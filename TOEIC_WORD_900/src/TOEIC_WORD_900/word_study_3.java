package TOEIC_WORD_900;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class word_study_3 extends JFrame {

	private JPanel study1;
	private JTextField wordField;
	private int unit=1;
	private int cnt=0;
	public static File file;
	public static FileReader filereader;
	public static BufferedReader bufReader;
	static word_study_3 study3_f=new word_study_3();
	AdvanceReq User=new AdvanceReq();
	String wrong=User.getWrong(Main.userInfo.getName(), unit);
	private word_unit Wrong_Unit=wordDAO.getWrongUnit(unit,wrong);
	/**
	 * Launch the application.
	 */
	
	
		
	public word_study_3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		study1 = new JPanel();
		study1.setForeground(Color.BLACK);
		study1.setBackground(Color.WHITE);
		study1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(study1);
		study1.setLayout(null);
		
		
		Button button = new Button("\uB2E4\uC74C \uB2E8\uC5B4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String line;
				Main.playSound(1.0f, false);
				if(Wrong_Unit.word[cnt]!=null&&wrong!="") {
					line=Wrong_Unit.word[cnt]+"	"+Wrong_Unit.mean[cnt];	
				}
				else {
					line="오답이 없습니다.";
				}
				
				wordField.setText(line);
				cnt++;
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(133, 290, 387, 25);
		study1.add(button);
		
		wordField = new JTextField();
		wordField.setText("Unit "+unit);
		wordField.setBounds(133, 97, 387, 162);
		study1.add(wordField);
		wordField.setColumns(10);
		
		JComboBox Unit = new JComboBox();
		Unit.setModel(new DefaultComboBoxModel(new String[] {"Unit 1", "Unit 2", "Unit 3", "Unit 4", "Unit 5", "Unit 6", "Unit 7", "Unit 8", "Unit 9", "Unit 10", "Unit 11", "Unit 12", "Unit 13", "Unit 14", "Unit 15", "Unit 16", "Unit 17", "Unit 18", "Unit 19", "Unit 20", "Unit 21", "Unit 22", "Unit 23", "Unit 24", "Unit 25", "Unit 26", "Unit 27", "Unit 28", "Unit 29", "Unit 30"}));
		Unit.setBounds(133, 61, 94, 24);
		study1.add(Unit);
		Unit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ev) {
            	Main.playSound(1.0f, false);
            	wordField.setText("");
            	unit=Unit.getSelectedIndex()+1;
            	wrong=wrong=User.getWrong(Main.userInfo.getName(), unit);
            	if(wrong!="") {
            		Wrong_Unit=wordDAO.getWrongUnit(unit,wrong);
            		wordField.setText("Unit "+unit);
            	}
            	else {
            		wordField.setText("Unit "+unit+"에 틀린단어가 없습니다.");
            	}
            	 cnt=0;
            }
		});
		Button button_1 = new Button("\uB098\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				study3_f.setVisible(false);
				StudyM.studym_f.setVisible(true);
			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(433, 61, 87, 25);
		study1.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\rkdal\\Desktop\\\uBC30\uACBD2.jpg"));
		label.setBounds(0, 0, 663, 391);
		study1.add(label);
	}
}
