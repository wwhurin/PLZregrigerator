package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class submenu extends JFrame {

	private JPanel contentPane;
	Color c = new Color(240, 93, 95);

	public submenu() {
		super("요리 상세 정보");
		contentPane=new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(c);
		
		getContentPane().add(contentPane);
		
		JLabel foodNAme = new JLabel("FOOD NAME");
		foodNAme.setBounds(201, 78, 78, 21);
		contentPane.add(foodNAme);
		
		
		
		
		setResizable(false);
		setSize(500, 500);
		setVisible(true);
	}
}
