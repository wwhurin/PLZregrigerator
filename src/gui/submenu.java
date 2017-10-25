package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class submenu extends JFrame {

	private JPanel contentPane;
	Color c = new Color(240, 93, 95);

	public submenu(ResultSet rs) throws SQLException {
		super("¿ä¸® »ó¼¼ Á¤º¸");
		contentPane=new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(c);
		
		getContentPane().add(contentPane);
		
		JLabel timeL = new JLabel("°É¸®´Â ½Ã°£ : ");
		timeL.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 18));
		timeL.setForeground(Color.WHITE);
		timeL.setBounds(17, 198, 132, 37);
		contentPane.add(timeL);
		
	
		
		JLabel ingreL = new JLabel("ÇÊ¿äÇÑ Àç·á : ");
		ingreL.setForeground(Color.WHITE);
		ingreL.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 18));
		ingreL.setBounds(17, 281, 132, 37);
		contentPane.add(ingreL);
		
		JLabel howL = new JLabel("¿ä¸®¹ý : ");
		howL.setForeground(Color.WHITE);
		howL.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 18));
		howL.setBounds(17, 366, 132, 37);
		contentPane.add(howL);
	
		
		
		if(rs.next()){
			JLabel foodName = new JLabel(rs.getString("menuname")+" ¿ä¸®¹ý");
			foodName.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 21));
			foodName.setBounds(201, 78, 78, 21);
			contentPane.add(foodName);	
			
			JLabel time = new JLabel(rs.getInt("time")+"ºÐ");
			time.setForeground(Color.WHITE);
			time.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 18));
			time.setBounds(127, 198, 132, 37);
			contentPane.add(time);
			
			JLabel ingredient = new JLabel("\uD544\uC694\uD55C \uC7AC\uB8CC : ");
			ingredient.setForeground(Color.WHITE);
			ingredient.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 18));
			ingredient.setBounds(130, 281, 132, 37);
			contentPane.add(ingredient);
			
			JLabel howto = new JLabel(rs.getString("how"));
			howto.setForeground(Color.WHITE);
			howto.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 18));
			howto.setBounds(90, 366, 132, 37);
			contentPane.add(howto);	
			
		}
		
		
		setResizable(false);
		setSize(500, 500);
		setVisible(true);
	}
}
