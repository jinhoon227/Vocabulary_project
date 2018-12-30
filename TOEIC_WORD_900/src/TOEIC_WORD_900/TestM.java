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

public class TestM extends JFrame {

   private JPanel TestmPane;
   static TestM testm_f=new TestM();
   /**
    * Launch the application.
    */
   

   /**
    * Create the frame.
    */
   public TestM() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 600, 400);
      TestmPane = new JPanel();
      TestmPane.setBackground(Color.WHITE);
      TestmPane.setForeground(Color.BLACK);
      TestmPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(TestmPane);
      TestmPane.setLayout(null);
      
      Button button = new Button("Unit Test");
      button.setFont(new Font("Dialog", Font.BOLD, 15));
      button.setForeground(new Color(139, 0, 0));
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Main.playSound(1.0f, false);
            testm_f.setVisible(false);
            word_test_1.test1_f.setVisible(true);
         }
      });
      button.setBackground(Color.WHITE);
      button.setBounds(418, 140, 108, 25);
      TestmPane.add(button);
      
      Button button_1 = new Button("Wrong Test");
      button_1.setFont(new Font("Dialog", Font.BOLD, 15));
      button_1.setForeground(new Color(139, 0, 0));
      button_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Main.playSound(1.0f, false);
            testm_f.setVisible(false);
            word_test_2.test2_f.setVisible(true);
      
         }
      });
      button_1.setBackground(Color.WHITE);
      button_1.setBounds(418, 194, 108, 25);
      TestmPane.add(button_1);
      
      Button button_2 = new Button("Main Menu");
      button_2.setFont(new Font("Dialog", Font.BOLD, 15));
      button_2.setForeground(new Color(139, 0, 0));
      button_2.setBackground(Color.WHITE);
      button_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Main.playSound(1.0f, false);
            testm_f.setVisible(false);
            Menu.menu_f.setVisible(true);
         }
      });
      button_2.setBounds(418, 248, 108, 25);
      TestmPane.add(button_2);
      
      JLabel label = new JLabel("TOEIC 900");
      label.setForeground(new Color(139, 0, 0));
      label.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 50));
      label.setBounds(25, 36, 276, 91);
      TestmPane.add(label);
      
      JLabel lblNewLabel = new JLabel("New label");
      lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rkdal\\Desktop\\\uBC30\uACBD2.jpg"));
      lblNewLabel.setBounds(0, 0, 595, 364);
      TestmPane.add(lblNewLabel);
   }

}