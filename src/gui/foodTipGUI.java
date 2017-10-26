package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class foodTipGUI extends JFrame {

	protected JPanel contentPane;
	Color c = new Color(240, 93, 95);

	public foodTipGUI() {
		super("À½½Ä °ü¸® ÆÁ");
		contentPane=new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(c);
		
		JLabel title = new JLabel("À½½Ä °ü¸® ÆÁ");
		title.setFont(new Font("³ª´®°íµñ ExtraBold", Font.BOLD, 18));
		title.setForeground(Color.WHITE);
		title.setBounds(196, 27, 132, 87); 
		contentPane.add(title);
		
		getContentPane().add(contentPane);
	}

}
