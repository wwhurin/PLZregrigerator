package gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Canvas;
import java.awt.Label;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPasswordField;
import javax.swing.DropMode;

@SuppressWarnings("serial")
public class first extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	JFrame jf;
	public JPanel contentPane;
	ImageIcon icon;
	ImageIcon back;
	public static JScrollPane scrollPane;
	Color c = new Color(240, 93, 95);
	
	private JLabel idt;
	private JTextField id;

	private JTextField textField_1;
	private JButton login;
	private JLabel pssT;
	private JPasswordField pass;
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	String url="jdbc:mysql://localhost:3306/refrigerator?user=root&password=1234&useUnicode=true&characterEncoding=euc_kr";

	
	Member_List mList;
	
	
	
	//DB 연결 
		 public Connection getConn(){
			Connection con=null;
		
		//드라이버 로드
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("드라이버 로드 성공");
				
				//커넥션 생성
				con=DriverManager.getConnection(url);
				System.out.println("데이터베이스 접속 성공!");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return con;
		}
	
	
	public first() {
		jf=new JFrame("냉장고를 부탁해! 로그인");
		contentPane=new JPanel();
		
		//jf.setLayout(gb);
		
		contentPane.setLayout(null);
		contentPane.setBackground(c);
		
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
		jf.getContentPane().add(contentPane);
       /* jf.getContentPane().add(contentPane);
		contentPane.setBackground(c);*/
	
		ImageIcon b_ic  = new ImageIcon("logo.png");
		Image icc = b_ic.getImage();
		Image logo = icc.getScaledInstance(600, 280, Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(logo);
		
		
		//JLabel Jlogo = new JLabel(ic);*/
		//Jlogo.setBounds(585, 475, 591, 100);
		//contentPane.add(Jlogo);
		
		JLabel logoL=new JLabel(ic);
		logoL.setBounds(10, 10, 600, 280);
		contentPane.add(logoL);
		
		idt = new JLabel("ID");
		idt.setFont(new Font("나눔스퀘어 Bold", Font.BOLD, 21));
		idt.setForeground(Color.WHITE);
		idt.setBounds(161, 374, 38, 21);
		contentPane.add(idt);
		
		//contentPane.add(idT);
		
		id = new JTextField();
		//id.setDropMode(DropMode.ON);
		id.setToolTipText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694");
		id.setBounds(204, 361, 252, 47);contentPane.add(id);
		id.setColumns(10);
		
		pssT = new JLabel("PASSWORD");
		pssT.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 22));
		pssT.setForeground(Color.WHITE);
		pssT.setBounds(64, 442, 123, 38);
		contentPane.add(pssT);
		
		pass = new JPasswordField();
		pass.setColumns(10);
		pass.setBounds(204, 438, 252, 47);
		contentPane.add(pass);
	
		login = new JButton("로그인");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("눌림");
				loginMember();
				System.out.println("호출종료");
			}
		});
		login.setBounds(204, 528, 252, 47);
		contentPane.add(login);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertMem();
			}
		});
		btnNewButton.setBounds(204, 610, 252, 47);
		contentPane.add(btnNewButton);
		
		
	     //JLabel lbImage1  = new JLabel(ic);
		 
	     //contentPane.add(lbImage1);
	     
		 jf.setSize(600, 800);
		 jf.setVisible(true);
		 jf.setResizable(false);

	}
	
	String ID; 
	String PASS;
	private JTextField textField;
	private JLabel lblId;
	
	public void getlogin(){
		ID = id.getText();
		PASS = pass.getText();

	}
	


	public void loginMember() {
		// TODO Auto-generated method stub
		getlogin();
		
		 Connection con = null;       //연결
	     PreparedStatement ps = null; //명령
	     ResultSet rs = null;         //결과

	     try{
	    	 con=getConn();
	    	 String sql = "select * from member where id='"+ID+"' and '"+PASS+"';";
	    	 ps=con.prepareStatement(sql);
	    	 System.out.println(sql);
	    	 //ps.setString(1, id);
	    	 
	    	 rs = ps.executeQuery();
	    	 
	    	 if(rs.next()){
	    		 System.out.println("맞다.");
	    	
	    		 new MainMenu();
	    		 jf.setVisible(false);
	    	 
	    	 }
	    	 else{
	    		 System.out.println("틀림.");
	    	 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     
	    // return dto;  
	}
	
	
	 public static void main(String[] args) {
	       
	        new first();
	    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
