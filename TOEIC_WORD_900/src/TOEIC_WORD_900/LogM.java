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

public class LogM extends JFrame {

	private JPanel LogmPane;
	static LogM logm_f=new LogM();
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public LogM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		LogmPane = new JPanel();
		LogmPane.setBackground(Color.WHITE);
		LogmPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LogmPane);
		LogmPane.setLayout(null);
		
		Button button = new Button("Progress");
		button.setForeground(new Color(139, 0, 0));
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);

				logm_f.setVisible(false);
				AdvanceGraph.adgp1_f.setVisible(true);
			}
		});
		
		JLabel label = new JLabel("TOEIC 900");
		label.setForeground(new Color(139, 0, 0));
		label.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 50));
		label.setBounds(25, 36, 276, 91);
		LogmPane.add(label);
		button.setBackground(Color.WHITE);
		button.setBounds(418, 140, 100, 25);
		LogmPane.add(button);
		
		Button button_1 = new Button("Ranking");
		button_1.setForeground(new Color(139, 0, 0));
		button_1.setFont(new Font("Dialog", Font.BOLD, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				logm_f.setVisible(false);
				RankingGraph.rank1_f.setVisible(true);
			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(418, 194, 100, 25);
		LogmPane.add(button_1);
		
		Button button_2 = new Button("Main Menu");
		button_2.setForeground(new Color(139, 0, 0));
		button_2.setFont(new Font("Dialog", Font.BOLD, 15));
		button_2.setBackground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.playSound(1.0f, false);
				logm_f.setVisible(false);
				Menu.menu_f.setVisible(true);
			}
		});
		button_2.setBounds(418, 248, 100, 25);
		LogmPane.add(button_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\rkdal\\Desktop\\\uBC30\uACBD2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 582, 353);
		LogmPane.add(lblNewLabel_1);
	}

}
