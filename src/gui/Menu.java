package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import program.menulist;
import java.awt.Font;

public class Menu extends JFrame {
	public JPanel contentPane;
	Color c = new Color(240, 93, 95);
	
	
	public Menu() {
		super("음식 레시피 추천");
		contentPane=new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(c);
		
		JLabel title = new JLabel("FOOD RECIFI");
		title.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 18));
		title.setForeground(Color.WHITE);
		title.setBounds(196, 27, 132, 87); 
		contentPane.add(title);
		
		getContentPane().add(contentPane);

	}
}
