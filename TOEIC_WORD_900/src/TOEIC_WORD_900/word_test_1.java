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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.Scanner;
import javax.swing.JLabel;

import java.util.Random;
import javax.swing.ImageIcon;
public class word_test_1 extends JFrame {

   private JPanel test1;
   private JTextField wordField;
   private int unit=1;
   private int cnt=0;
   public static File file;
   public static FileReader filereader;
   public static BufferedReader bufReader;
   private word_unit Study_Unit=wordDAO.getUnit(unit);
   static word_test_1 test1_f=new word_test_1();
   private JTextField answerField;
     
   String answer;
   private int wrongcnt=0;
   private Random rand=new Random();
   private int problem;
   private JTextField correct;
   private String Wrong="";
   private float percent;
   private boolean pass=false;
   private boolean was=false;
   private boolean press=true;
   /**
    * Launch the application.
    */
   
   
      
   public word_test_1() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 671, 427);
      test1 = new JPanel();
      test1.setForeground(Color.BLACK);
      test1.setBackground(Color.WHITE);
      test1.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(test1);
      test1.setLayout(null);
      Scanner scanner=new Scanner(System.in);
      AdvanceReq advanceReq= new AdvanceReq();
     
    
      
      Button button = new Button("\uB2E4\uC74C \uB2E8\uC5B4");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            String line,mean=null,print=null;
            Main.playSound(1.0f, false);
            was=false;
            problem=rand.nextInt(2);
            if(press) {
               press=false;
               answerField.setText("");
            if(cnt==30) {
            	percent=(30-wrongcnt)*100/30;
               if(percent>=70) {
            	   JOptionPane.showMessageDialog(null, "시험 통과!");
            	   line="시험 통과";
                  pass=true;
                  advanceReq.insertInfo( Main.userInfo.getName(), unit, (int)percent, pass, Wrong);
               }
               else {
            	   JOptionPane.showMessageDialog(null, "다시 하세요.");
            	   line="다시 하세요.";
               }
               
               
            }
            else if(cnt>30) {
            	line="Unit "+unit+" TEST 종료";
            }
            else {
            	
               if(problem==0) {
            	   line=(cnt+1)+".뜻: "+Study_Unit.mean[cnt]+"\n";       
               }
               else {
            	   line=(cnt+1)+".단어: "+Study_Unit.word[cnt]+"\n";
               }
                 cnt++;
                    
               }
            wordField.setText(line); 
               
                
            }
            else {
               answerField.setText("정답확인 하세요");
            }
            
         }
      });
      button.setBackground(Color.WHITE);
      button.setBounds(398, 290, 122, 25);
      test1.add(button);
      
      wordField = new JTextField();
      wordField.setBounds(133, 112, 387, 95);
      test1.add(wordField);
      wordField.setColumns(10);
      wordField.setText("Unit "+Integer.toString(unit)+" TEST");
      
      JComboBox Unit = new JComboBox();
      Unit.setModel(new DefaultComboBoxModel(new String[] {"Unit 1", "Unit 2", "Unit 3", "Unit 4", "Unit 5", "Unit 6", "Unit 7", "Unit 8", "Unit 9", "Unit 10", "Unit 11", "Unit 12", "Unit 13", "Unit 14", "Unit 15", "Unit 16", "Unit 17", "Unit 18", "Unit 19", "Unit 20", "Unit 21", "Unit 22", "Unit 23", "Unit 24", "Unit 25", "Unit 26", "Unit 27", "Unit 28", "Unit 29", "Unit 30"}));
      Unit.setBounds(133, 61, 94, 24);
      test1.add(Unit);
      Unit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ev) {
               Main.playSound(1.0f, false);
                answerField.setText("");
               unit=Unit.getSelectedIndex()+1;
               Study_Unit=wordDAO.getUnit(unit);
               wordField.setText("Unit "+Integer.toString(unit)+" TEST");
                cnt=0;
                wrongcnt=0;
                Wrong="";
            }
      });
      Button button_1 = new 
            Button("\uB098\uAC00\uAE30");
      button_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Main.playSound(1.0f, false);
            test1_f.setVisible(false);
            TestM.testm_f.setVisible(true);
         }
      });
      button_1.setBackground(Color.WHITE);
      button_1.setBounds(433, 61, 87, 25);
      test1.add(button_1);
      
      answerField = new JTextField();
      answerField.setBounds(133, 231, 387, 33);
      test1.add(answerField);
      answerField.setColumns(10);
      
      JLabel label = new JLabel("\uBB38\uC81C");
      label.setBounds(133, 98, 57, 15);
      test1.add(label);
      
      JLabel label_1 = new JLabel("\uB2F5");
      label_1.setBounds(133, 217, 57, 15);
      test1.add(label_1);
      
      Button button_2 = new Button("\uC815\uB2F5\uD655\uC778");
      button_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
             answer=answerField.getText();
             
             if(was) {
                answerField.setText("다음으로 넘어가세요."); 
             }
             else
             {
            	 if(problem==0) {
            		 if(Study_Unit.word[cnt-1].equals(answer)) {
                         answerField.setText("맞음");
                         Wrong+="0";
                      }
                      else          {       
                         answerField.setText("틀림");
                         wrongcnt++;
                         Wrong+="1";
                         correct.setText(Integer.toString(wrongcnt)+"/30");
                      
            	 }
                }
            	 else {
            		 String[] mean_answer=Study_Unit.mean[cnt-1].split("[|]");
            		 int i;
            		 for(i=0;i<mean_answer.length;i++) {
            			 if(mean_answer[i].equals(answer)) {
            				 answerField.setText("맞음");
                             Wrong+="0";
                             break;
            			 }
            		 }
            		 if(i==mean_answer.length) {
            			 answerField.setText("틀림 ");
                         wrongcnt++;
                         Wrong+="1";
                         correct.setText(Integer.toString(wrongcnt)+"/30");
            		 }
            	 }
             }
             press=true;
             was=true;
         }
      });
      button_2.setBackground(Color.WHITE);
      button_2.setBounds(242, 290, 122, 25);
      test1.add(button_2);
      
      correct = new JTextField();
      correct.setBounds(346, 61, 53, 21);
      test1.add(correct);
      correct.setColumns(10);
      correct.setText("0/30");
      
      JLabel label_2 = new JLabel("\uD2C0\uB9B0 \uAC1C\uC218:");
      label_2.setBounds(277, 64, 57, 15);
      test1.add(label_2);
      
      JLabel lblNewLabel = new JLabel("New label");
      lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rkdal\\Desktop\\\uBC30\uACBD2.jpg"));
      lblNewLabel.setBounds(0, 0, 653, 380);
      test1.add(lblNewLabel);
   }
}