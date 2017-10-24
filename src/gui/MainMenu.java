package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

import program.Ingredient_List;
import program.menulist;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainMenu extends JPanel {
	JFrame jf;
	public JPanel contentPane;
	ImageIcon icon;
	ImageIcon back;
	public static JScrollPane scrollPane;
	Color c = new Color(240, 93, 95);
	private JButton menu1;
	private JButton menu2;
	private JButton menu3;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblTip;
	
	public MainMenu() {

			jf=new JFrame("냉장고를 부탁해!");
			contentPane=new JPanel();
			contentPane.setLayout(null);

	        jf.getContentPane().add(contentPane);
			contentPane.setBackground(c);
			
			/*ImageIcon b_ic  = new ImageIcon("refriger.png");
			Image icc = b_ic.getImage();
			Image logo = icc.getScaledInstance(430, 725, Image.SCALE_SMOOTH);
			ImageIcon ic = new ImageIcon(logo);
			*/
			
			ImageIcon ic =rszImg("refriger.png", 430, 725);
			JLabel refriger = new JLabel("New label");
			refriger.setIcon(ic);
			refriger.setBounds(391, 103, 437, 725);
			contentPane.add(refriger);
			
			ImageIcon bt =rszImg("btn.png", 183, 175);
			menu1 = new JButton("");
			menu1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Ingredient_List();
				}
			});
			menu1.setIcon(bt);
			menu1.setBounds(1038, 401, 197, 177);
			menu1.setBorderPainted(false);//버튼 테두리 설정
			menu1.setContentAreaFilled(false);//버튼 영역 배경 표시 설정
			contentPane.add(menu1);
			
			menu2 = new JButton("");
			menu2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//new Menu();
					new menulist();
				}
			});
			
			lblNewLabel = new JLabel("냉장고 관리");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(1085, 477, 103, 21);
			contentPane.add(lblNewLabel);
			menu2.setIcon(bt);
			menu2.setContentAreaFilled(false);
			menu2.setBorderPainted(false);
			menu2.setBounds(863, 522, 197, 177);
			contentPane.add(menu2);
			
			menu3 = new JButton("");
			menu3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			label = new JLabel("\uC624\uB298\uC758 \uC2DD\uB2E8\r\n");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("굴림", Font.PLAIN, 18));
			label.setBounds(917, 598, 103, 21);
			contentPane.add(label);
			menu3.setIcon(bt);
			menu3.setContentAreaFilled(false);
			menu3.setBorderPainted(false);
			menu3.setBounds(1038, 622, 197, 177);
			contentPane.add(menu3);
			
			lblTip = new JLabel("\uC74C\uC2DD\uAD00\uB9AC TIP");
			lblTip.setForeground(Color.WHITE);
			lblTip.setFont(new Font("굴림", Font.PLAIN, 18));
			lblTip.setBounds(1086, 702, 103, 21);
			contentPane.add(lblTip);
		
			
			 jf.setSize(1300, 910);
			 jf.setVisible(true);
			 jf.setResizable(false);

	}
	
	public ImageIcon rszImg(String img, int width, int hight){
		ImageIcon b_ic  = new ImageIcon(img);
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);
		
		return ic;
	}

}
