package TOEIC_WORD_900;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Canvas;

public class Menu extends JFrame {

	private JPanel MenuPane;
	ImageIcon icon;
	static Menu menu_f=new Menu();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public Menu() {
		 icon = new ImageIcon("c:\\¹è°æ.jpg");
		 
	        
		setTitle("TOEIC_900");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		MenuPane = new JPanel();
		MenuPane.setBackground(Color.WHITE);
		MenuPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MenuPane);
		MenuPane.setLayout(null);
		
		JLabel label = new JLabel("TOEIC 900");
		label.setForeground(new Color(139, 0, 0));
		label.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 50));
		label.setBounds(25, 39, 276, 91);
		MenuPane.add(label);
		
		Button study_btn = new Button("Study");
		study_btn.setForeground(new Color(139, 0, 0));
		study_btn.setFont(new Font("Dialog", Font.BOLD, 14));
		study_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				menu_f.setVisible(false);
				StudyM.studym_f.setVisible(true);
			}
		});
		study_btn.setBackground(Color.WHITE);
		study_btn.setBounds(418, 140, 87, 25);
		MenuPane.add(study_btn);
		
		Button exam_btn = new Button("Test");
		exam_btn.setForeground(new Color(139, 0, 0));
		exam_btn.setFont(new Font("Dialog", Font.BOLD, 14));
		exam_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				menu_f.setVisible(false);
				TestM.testm_f.setVisible(true);
			}
		});
		exam_btn.setBackground(Color.WHITE);
		exam_btn.setBounds(418, 194, 87, 25);
		MenuPane.add(exam_btn);
		
		Button Log_btn = new Button("Progress");
		Log_btn.setForeground(new Color(139, 0, 0));
		Log_btn.setFont(new Font("Dialog", Font.BOLD, 14));
		Log_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				menu_f.setVisible(false);
				LogM.logm_f.setVisible(true);
			}
		});
		Log_btn.setBackground(Color.WHITE);
		Log_btn.setBounds(418, 248, 87, 25);
		MenuPane.add(Log_btn);
		
		Button exit_btn = new Button("Exit");
		exit_btn.setForeground(new Color(139, 0, 0));
		exit_btn.setFont(new Font("Dialog", Font.BOLD, 14));
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				menu_f.setVisible(false);
				Login.login_f.setVisible(true);
			}
		});
		exit_btn.setBackground(Color.WHITE);
		exit_btn.setBounds(418, 293, 87, 25);
		MenuPane.add(exit_btn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rkdal\\Desktop\\\uBC30\uACBD2.jpg"));
		lblNewLabel.setBounds(0, 0, 594, 367);
		MenuPane.add(lblNewLabel);
	}
}
