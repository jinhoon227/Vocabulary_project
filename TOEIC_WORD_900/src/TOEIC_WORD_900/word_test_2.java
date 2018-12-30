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
import java.util.Scanner;
import javax.swing.JLabel;

import java.util.Random;
import javax.swing.ImageIcon;
public class word_test_2 extends JFrame {

   private JPanel test2;
   private JTextField wordField;
   private int unit=1;
   private int cnt=0;
   public static File file;
   public static FileReader filereader;
   public static BufferedReader bufReader;

   static word_test_2 test2_f=new word_test_2();
   private JTextField answerField;
   AdvanceReq User=new AdvanceReq();
   String wrong=User.getWrong(Main.userInfo.getName(), unit);
   private word_unit Wrong_Unit=wordDAO.getWrongUnit(unit,wrong);
     
   String answer;
   private int wrongcnt=0;
   private Random rand=new Random();
   private int problem;
   private String Wrong="";
   private float percent;
   private boolean pass=false;
   private boolean was=false;
   private boolean press=true;
   int k=0;
   /**
    * Launch the application.
    */
   
   
      
   public word_test_2() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 671, 427);
      test2 = new JPanel();
      test2.setForeground(Color.BLACK);
      test2.setBackground(Color.WHITE);
      test2.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(test2);
      test2.setLayout(null);
      Scanner scanner=new Scanner(System.in);
      AdvanceReq advanceReq= new AdvanceReq();
     
    while(Wrong_Unit.word[k]!=null)
         k++;
      
      Button button = new Button("\uB2E4\uC74C \uB2E8\uC5B4");
      button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                 was=false;
                 problem=rand.nextInt(2);
                 if(press) {
                    press=false;  
                    answerField.setText("");
             String line;
             Main.playSound(1.0f, false);
             if(cnt>k) {
                line="Unit "+unit+" TEST 종료";            
             }
             else if(Wrong_Unit.word[cnt]==null) {
                line="오답이 없습니다.";
             }
             else {
             if(problem==0) {
                   line=(cnt+1)+".뜻: "+Wrong_Unit.mean[cnt]+"\n";       
                }
                else {
                   line=(cnt+1)+".단어: "+Wrong_Unit.word[cnt]+"\n";
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
      test2.add(button);
      
      wordField = new JTextField();
      wordField.setBounds(133, 112, 387, 95);
      test2.add(wordField);
      wordField.setColumns(10);
      wordField.setText("Unit "+Integer.toString(unit)+" TEST");
      
      JComboBox Unit = new JComboBox();
      Unit.setModel(new DefaultComboBoxModel(new String[] {"Unit 1", "Unit 2", "Unit 3", "Unit 4", "Unit 5", "Unit 6", "Unit 7", "Unit 8", "Unit 9", "Unit 10", "Unit 11", "Unit 12", "Unit 13", "Unit 14", "Unit 15", "Unit 16", "Unit 17", "Unit 18", "Unit 19", "Unit 20", "Unit 21", "Unit 22", "Unit 23", "Unit 24", "Unit 25", "Unit 26", "Unit 27", "Unit 28", "Unit 29", "Unit 30"}));
      Unit.setBounds(133, 61, 94, 24);
      test2.add(Unit);
      Unit.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ev) {
               Main.playSound(1.0f, false);
                answerField.setText("");
                unit=Unit.getSelectedIndex()+1;
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
      Button button_1 = new 
            Button("\uB098\uAC00\uAE30");
      button_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Main.playSound(1.0f, false);
            test2_f.setVisible(false);
            TestM.testm_f.setVisible(true);
         }
      });
      button_1.setBackground(Color.WHITE);
      button_1.setBounds(433, 61, 87, 25);
      test2.add(button_1);
      
      answerField = new JTextField();
      answerField.setBounds(133, 231, 387, 33);
      test2.add(answerField);
      answerField.setColumns(10);
      
      JLabel label = new JLabel("\uBB38\uC81C");
      label.setBounds(133, 98, 57, 15);
      test2.add(label);
      
      JLabel label_1 = new JLabel("\uB2F5");
      label_1.setBounds(133, 217, 57, 15);
      test2.add(label_1);
      
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
                   if(Wrong_Unit.word[cnt-1].equals(answer)) {
                         answerField.setText("맞음");
                         Wrong+="0";
                      }
                      else          {       
                         answerField.setText("틀림");
                         wrongcnt++;
                         Wrong+="1";
                       //  correct.setText(Integer.toString(wrongcnt)+"/30");
                      
                }
                }
                else {
                   String[] mean_answer=Wrong_Unit.mean[cnt-1].split("[|]");
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
                 //        correct.setText(Integer.toString(wrongcnt)+"/"+k);
                   }
                }
             }
             press=true;
             was=true;
         }
      });
      button_2.setBackground(Color.WHITE);
      button_2.setBounds(242, 290, 122, 25);
      test2.add(button_2);
      
      JLabel lblNewLabel = new JLabel("New label");
      lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rkdal\\Desktop\\\uBC30\uACBD2.jpg"));
      lblNewLabel.setBounds(0, 0, 653, 380);
      test2.add(lblNewLabel);
   }
}