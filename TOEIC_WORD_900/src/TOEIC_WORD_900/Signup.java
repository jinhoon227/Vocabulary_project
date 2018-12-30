package TOEIC_WORD_900;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Signup extends JFrame {

	private JPanel SignupPane;
	private JTextField Naem_Field;
	private JTextField ID_Field;
	private JPasswordField passwordField;
	static Signup signup_f = new Signup();
	/**
	 * Create the frame.
	 */
	public Signup() {
		setTitle("TOEIC_900");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 429);
		SignupPane = new JPanel();
		SignupPane.setBackground(Color.WHITE);
		SignupPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(SignupPane);
		SignupPane.setLayout(null);
		
		JLabel SignupName = new JLabel("NAME :");
		SignupName.setFont(new Font("Dialog", Font.PLAIN, 15));
		SignupName.setBounds(208, 158, 49, 18);
		SignupPane.add(SignupName);
		
		JLabel SignupID = new JLabel("ID :");
		SignupID.setFont(new Font("Dialog", Font.PLAIN, 15));
		SignupID.setBounds(234, 188, 23, 18);
		SignupPane.add(SignupID);
		
		JLabel SignupPwd = new JLabel("Password :");
		SignupPwd.setFont(new Font("Dialog", Font.PLAIN, 15));
		SignupPwd.setBounds(182, 218, 75, 18);
		SignupPane.add(SignupPwd);
		
		Naem_Field = new JTextField();
		Naem_Field.setBounds(271, 155, 116, 24);
		SignupPane.add(Naem_Field);
		Naem_Field.setColumns(10);
		
		ID_Field = new JTextField();
		ID_Field.setBounds(271, 185, 116, 24);
		SignupPane.add(ID_Field);
		ID_Field.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(271, 215, 116, 24);
		SignupPane.add(passwordField);
		
		LoginReq loginReq=new LoginReq();
		Button button = new Button("\uC644\uB8CC");
		button.setForeground(new Color(139, 0, 0));
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = Naem_Field.getText();
				String id = ID_Field.getText();
				String pass = passwordField.getText();
				loginReq.registerUser(name, id, pass);
				Main.playSound(1.0f, false);
				signup_f.setVisible(false);
				Login.login_f.setVisible(true);
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(300, 245, 87, 25);
		SignupPane.add(button);
		
		JLabel lblSignUp = new JLabel("Sign up");
		lblSignUp.setForeground(new Color(139, 0, 0));
		lblSignUp.setFont(new Font("Bodoni MT Black", Font.BOLD, 41));
		lblSignUp.setBounds(174, 64, 220, 46);
		SignupPane.add(lblSignUp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rkdal\\Downloads\\\uB0D0\uB0D0\uB0D0.jpg"));
		lblNewLabel.setBounds(14, 6, 587, 382);
		SignupPane.add(lblNewLabel);
	}

}
