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

 

public class RankingGraph extends JFrame {
	private JPanel graph1;
	private int logCnt=1;
	private JLabel titleField;
	private JLabel unitField;
	private JLabel ratioField;
	private JLabel ansRatioExp;
	private JLabel scoreField;
	private JLabel rankField;
	private int unit=1;
	private int cnt=0;
	public static File file;
	public static FileReader filereader;
	public static BufferedReader bufReader;
	static RankingGraph rank1_f=new RankingGraph();
	int moveX=60;
	int moveY=80;
	int getLogCnt() {
		return logCnt;
	}
	
	public RankingGraph() {
		rankField = new JLabel();
		unitField = new JLabel();
		titleField = new JLabel();
		ansRatioExp = new JLabel();
		scoreField = new JLabel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 427);
		graph1= new JPanel();
		graph1.setForeground(Color.BLACK);
		graph1.setBackground(Color.WHITE);
		graph1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(graph1);
		graph1.setLayout(null);
		
		AdvanceReq advanceReq= new AdvanceReq();
		int nowChap=advanceReq.getNowChap(Main.userInfo.getId());
	
		//모든 유저 점수 환산해서 저장하기
	    LoginReq loginReq=new LoginReq();
	    AdvanceUserArray aua = loginReq.getAllUser();
	    for(int i=0;i<aua.getCnt();i++) {
	    	int sumU=0;
	    	String otherUser=aua.getUserInfo(i).getId();
	    	System.out.println("id: "+otherUser);
	    	int userChap=advanceReq.getNowChap(otherUser);
	    	for(int j=1;j<=userChap ;j++) {
	    		sumU+=advanceReq.getAnsRatio(otherUser, j);
	    	}
	    	System.out.println("sco: "+sumU);
	    	aua.getUserInfo(i).setUnit(userChap);
	    	aua.getUserInfo(i).setScore(sumU);
	    }
	    //정렬
	    aua.rankSort();
	    
	    
		int summ = 0;
		for(int i=1;i<=nowChap;i++) {
			summ+=advanceReq.getAnsRatio(Main.userInfo.getId(), i);
		}
		Main.userInfo.setScore(summ);
		ansRatioExp.setFont(ansRatioExp.getFont().deriveFont(12.0f));
		ansRatioExp.setText("점수: "+(Main.userInfo.getScore()+""));
		ansRatioExp.setBounds(400,70,150,50);
		graph1.add(ansRatioExp);
		
		titleField.setFont(titleField.getFont().deriveFont(20.0f));
		titleField.setText("Ranking");
		titleField.setBounds(300,20,150,50);
		graph1.add(titleField);
		
		int topRank=aua.getCnt()<10 ? aua.getCnt() : 10;
		String userRank="아쉽게도 등수에 못들었습니다!";
		 for(int i=0;i<topRank;i++) {
			if(aua.getUserInfo(i).getId().equals(Main.userInfo.getId())) {
				userRank="<"+((i+1)+"")+">등 입니다!!!";
			}
			ratioField = new JLabel();
			scoreField = new JLabel();
			ratioField.setText(((i+1)+"")+"등 "+aua.getUserInfo(i).getName()+" ");
			scoreField.setText(aua.getUserInfo(i).getScore()+"점");
			
			ratioField.setBounds(70+moveX, (int)((i+3)*(25f))+moveY, 125, 20);
			scoreField.setBounds(170+moveX, (int)((i+3)*(25f))+moveY, 55, 20);
			graph1.add(ratioField);
			graph1.add(scoreField);
		 }

		 rankField.setFont(rankField.getFont().deriveFont(16.0f));
		 rankField.setText(userRank);
		 rankField.setBounds(400,80,150,100);
		graph1.add(rankField);


	
		
		Button button_2 = new Button("Main Menu");
		button_2.setBackground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				rank1_f.setVisible(false);
				Menu.menu_f.setVisible(true);
			}
		});
		button_2.setBounds(224+moveX,244+moveY, 87, 25);
		graph1.add(button_2);
		
		

	}
	
} 

	



	
	

