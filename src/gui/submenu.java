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
		super("�丮 �� ����");
		contentPane=new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(c);
		
		getContentPane().add(contentPane);
		
		JLabel timeL = new JLabel("�ɸ��� �ð� : ");
		timeL.setFont(new Font("������� ExtraBold", Font.PLAIN, 18));
		timeL.setForeground(Color.WHITE);
		timeL.setBounds(17, 198, 132, 37);
		contentPane.add(timeL);
		
	
		
		JLabel ingreL = new JLabel("�ʿ��� ��� : ");
		ingreL.setForeground(Color.WHITE);
		ingreL.setFont(new Font("������� ExtraBold", Font.PLAIN, 18));
		ingreL.setBounds(17, 281, 132, 37);
		contentPane.add(ingreL);
		
		JLabel howL = new JLabel("�丮�� : ");
		howL.setForeground(Color.WHITE);
		howL.setFont(new Font("������� ExtraBold", Font.PLAIN, 18));
		howL.setBounds(17, 366, 132, 37);
		contentPane.add(howL);
	
		
		
		if(rs.next()){
			JLabel foodName = new JLabel(rs.getString("menuname")+" �丮��");
			foodName.setFont(new Font("������� ExtraBold", Font.PLAIN, 21));
			foodName.setBounds(201, 78, 78, 21);
			contentPane.add(foodName);	
			
			JLabel time = new JLabel(rs.getInt("time")+"��");
			time.setForeground(Color.WHITE);
			time.setFont(new Font("�������", Font.PLAIN, 18));
			time.setBounds(127, 198, 132, 37);
			contentPane.add(time);
			
			JLabel ingredient = new JLabel("\uD544\uC694\uD55C \uC7AC\uB8CC : ");
			ingredient.setForeground(Color.WHITE);
			ingredient.setFont(new Font("�������", Font.PLAIN, 18));
			ingredient.setBounds(130, 281, 132, 37);
			contentPane.add(ingredient);
			
			JLabel howto = new JLabel(rs.getString("how"));
			howto.setForeground(Color.WHITE);
			howto.setFont(new Font("�������", Font.PLAIN, 18));
			howto.setBounds(90, 366, 132, 37);
			contentPane.add(howto);	
			
		}
		
		
		setResizable(false);
		setSize(500, 500);
		setVisible(true);
	}
}
