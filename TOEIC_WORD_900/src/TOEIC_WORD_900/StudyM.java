package TOEIC_WORD_900;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class StudyM extends JFrame {

	private JPanel StudymPane;
	static StudyM studym_f=new StudyM();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public StudyM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		StudymPane = new JPanel();
		StudymPane.setBackground(Color.WHITE);
		StudymPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(StudymPane);
		StudymPane.setLayout(null);
		
		Button button = new Button("One by One");
		button.setFont(new Font("Dialog", Font.BOLD, 13));
		button.setForeground(new Color(139, 0, 0));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				studym_f.setVisible(false);
				word_study_1.study1_f.setVisible(true);
				
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(418, 140, 108, 25);
		StudymPane.add(button);
		
		Button button_1 = new Button("Scroll");
		button_1.setFont(new Font("Dialog", Font.BOLD, 13));
		button_1.setForeground(new Color(139, 0, 0));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				studym_f.setVisible(false);
				word_study_2.study2_f.setVisible(true);
			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(418, 194, 108, 25);
		StudymPane.add(button_1);
		
		Button button_2 = new Button("Wrong answer");
		button_2.setForeground(new Color(139, 0, 0));
		button_2.setFont(new Font("Dialog", Font.BOLD, 13));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				studym_f.setVisible(false);
				word_study_3.study3_f.setVisible(true);
			}
		});
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(418, 248, 108, 25);
		StudymPane.add(button_2);
		
		Button button_3 = new Button("Main Menu");
		button_3.setFont(new Font("Dialog", Font.BOLD, 13));
		button_3.setForeground(new Color(139, 0, 0));
		button_3.setBackground(Color.WHITE);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				studym_f.setVisible(false);
				Menu.menu_f.setVisible(true);
			}
		});
		button_3.setBounds(418, 293, 108, 25);
		StudymPane.add(button_3);
		
		JLabel label_1 = new JLabel("TOEIC 900");
		label_1.setForeground(new Color(139, 0, 0));
		label_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 50));
		label_1.setBounds(25, 36, 276, 91);
		StudymPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\rkdal\\Desktop\\\uBC30\uACBD2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 593, 366);
		StudymPane.add(lblNewLabel_1);
	}
}
