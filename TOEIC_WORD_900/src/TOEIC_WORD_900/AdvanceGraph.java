package TOEIC_WORD_900;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.geom.*;
import java.io.BufferedReader;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

 

public class AdvanceGraph extends JFrame {
	private int logCnt=1;
	private MyPanel graph1;
	private JLabel titleField;
	private JLabel unitField;
	private JLabel ratioField;
	private JLabel ansRatioExp;
	private int unit=1;
	private int cnt=0;
	public static File file;
	public static FileReader filereader;
	public static BufferedReader bufReader;
	static AdvanceGraph adgp1_f=new AdvanceGraph();
	int moveX=60;
	int moveY=80;
	int getLogCnt() {
		return logCnt;
	}
	
	public AdvanceGraph() {
		unitField = new JLabel();
		titleField = new JLabel();
		ansRatioExp = new JLabel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 427);
		graph1= new MyPanel();
		graph1.setForeground(Color.BLACK);
		graph1.setBackground(Color.WHITE);
		graph1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(graph1);
		graph1.setLayout(null);
		
		AdvanceReq advanceReq= new AdvanceReq();
		int nowChap=advanceReq.getNowChap(Main.userInfo.getId());
	
		
		int summ = 0;
		for(int i=1;i<=nowChap;i++) {
			summ+=advanceReq.getAnsRatio(Main.userInfo.getId(), i);
		}
		int ansRat=(int)(summ/nowChap);
		ansRatioExp.setFont(ansRatioExp.getFont().deriveFont(12.0f));
		ansRatioExp.setText("정답률: "+(ansRat+"")+"%");
		ansRatioExp.setBounds(500,70,150,50);
		graph1.add(ansRatioExp);
		
		titleField.setFont(titleField.getFont().deriveFont(20.0f));
		titleField.setText(Main.userInfo.getName()+" 님의 진척도");
		titleField.setBounds(300,20,150,50);
		graph1.add(titleField);
		
		if(logCnt==1)
			makeString();
		
		String ratioLine="";
		 for(int i=30;i<101;i+=10) {
			ratioField = new JLabel();
	
			ratioField.setText(i+"");
			ratioField.setBounds(70+moveX, (int)(250-i*(2.5f))+moveY, 25, 20);
			graph1.add(ratioField);
		 }

	


	
		
		Button button_2 = new Button("Main Menu");
		button_2.setBackground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				adgp1_f.setVisible(false);
				Menu.menu_f.setVisible(true);
			}
		});
		button_2.setBounds(224+moveX,244+moveY, 87, 25);
		graph1.add(button_2);
		
		Button button_3 = new Button("다음");
		button_3.setBackground(Color.WHITE);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				if(logCnt!=3) {
					logCnt++;
					makeString();
					graph1.repaint();
				}
	
			}
		});
		button_3.setBounds(424+moveX, 244+moveY, 87, 25);
		graph1.add(button_3);
		
		
		Button button_4 = new Button("이전");
		button_4.setBackground(Color.WHITE);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				if(logCnt!=1) {
					logCnt--;
					makeString();
					graph1.repaint();
				}	
			}
		});
		button_4.setBounds(24+moveX, 244+moveY, 87, 25);
		graph1.add(button_4);
	
		

	}

	public void makeString() {
		//글씨 채우기1
		System.out.println("logCnt : "+logCnt);
		String unitLine="Unit   ";
		 //시작 챕터 설정
		 int startChap=1;
		 if(logCnt==1) {
			 startChap=1;
		 }else if(logCnt==2) {
			 startChap=11;
		 }else {
			 startChap=21;
		 }
		 for(int i=startChap;i<startChap+10;i++) {
			 if(startChap==1)
				 unitLine+=(i+"")+"       ";
			 else
				 unitLine+=(i+"")+"     ";
		 }
		
		unitField.setText(unitLine);
		unitField.setBounds(70+moveX,200+moveY,350,20);
		graph1.add(unitField);
	}
	

	
} 

class MyPanel extends JPanel{
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		int moveX=60;
		int moveY=80;
		
	    Graphics2D g2=(Graphics2D)g;
	 

		 AdvanceReq advanceReq= new AdvanceReq();
		 int nowChap=advanceReq.getNowChap(Main.userInfo.getId());

		 //선사이의 간격 조절 변수 설정
		 int dd=1;
		 //시작 챕터 설정
		 int startChap=1;

		 if(AdvanceGraph.adgp1_f.getLogCnt()==1) {
			 startChap=1;
		 }else if(AdvanceGraph.adgp1_f.getLogCnt()==2) {
			 startChap=11;
		 }else {
			 startChap=21;
		 }
		 System.out.println(AdvanceGraph.adgp1_f.getLogCnt());
		 
		 //초기 x , y값 및 점과 점사이의 거리
		 final int firstX=100+moveX;
		 final int firstY=-25;
		 final int distX=30;
			 
		 //그래프 밑에 선 그리기
		 g2.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,0));
		 g2.draw(new Line2D.Double(firstX,firstY+225+moveY,firstX+distX*10,firstY+moveY+225));	
		 //그래프 옆에 선 그리기
		 g2.draw(new Line2D.Double(firstX,firstY+225+moveY,firstX,firstY+25+moveY));	
	
		 g2.setStroke(new BasicStroke(3,BasicStroke.CAP_ROUND,0));
		 int tempX;
		 int tempY;
		 int checkOverChap = startChap+9 < nowChap ? startChap+9 : nowChap;
		 if(nowChap>=startChap) {
			 int firans=advanceReq.getAnsRatio(Main.userInfo.getId(), startChap);
			 tempX=firstX;
			 tempY=222-(int)(firstY+firans*2.4)+moveY;
			 g2.fillOval(tempX,tempY, 10, 10);
			
			 for(int i=startChap; i<checkOverChap;i++) {		 				 
				 int ans=advanceReq.getAnsRatio(Main.userInfo.getId(), i+1);
				 int x=firstX+(dd++)*distX;
				 int y=222-(int)(firstY+ans*2.4)+moveY;
				 g2.fillOval(x,y, 10, 10);
				 g2.draw(new Line2D.Double(tempX+5,tempY+5,x+5,y+5));			 
				 tempX=x;	tempY=y;
			 }
		 }
		 
	  
	    //g2.draw(new Line2D.Double(50,200,200,200));
	
	 }
	
}
	



	
	

