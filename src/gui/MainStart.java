package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainStart {
	
	JFrame jf;
	public JPanel contentPane;
	ImageIcon icon;
	ImageIcon back;
	public static JScrollPane scrollPane;
	Color c = new Color(240, 93, 95);
	
	public MainStart() {
		jf=new JFrame("냉장고를 부탁해!");
		contentPane=new JPanel();
//		
//		setBounds(100, 100, 1060, 863);
//		back = new ImageIcon("backcolor.jpg");
//		JPanel contentPane = new JPanel() {
//            public void paintComponent(Graphics g) {      	 
//           	 g.drawImage(back.getImage(), 0, 0, null);
//                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
//                super.paintComponent(g);
//            }
//        };
		
		
		//add(jf);
		//jf.getContentPane().add(contentPane);
        jf.getContentPane().add(contentPane);
		contentPane.setBackground(c);
	
		
		 jf.setSize(1300, 910);
		 jf.setVisible(true);
		 jf.setResizable(false);

	}
}
