package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import program.memberDBnarrow;
import program.memberDBsave;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertMem extends JFrame implements ActionListener 
 {
	JFrame jf;
	private JPanel contentPane;
	JPanel p;
	JTextField  tfId, tfNick;
	JPasswordField  pfPwd;
	JButton btnInsert, btnCancel;
	Color c = new Color(240, 93, 95);

	public InsertMem() {
		jf=new JFrame();contentPane=new JPanel();
		
		jf.setTitle("ȸ������");
		jf.getContentPane().add(contentPane);
		
		JLabel bId = new JLabel("���̵� : ");
		bId.setForeground(Color.WHITE);
		bId.setFont(new Font("����", Font.BOLD, 18));
		tfId = new JTextField(10); 
		bId.setBounds(127, 264, 107, 58);
		tfId.setBounds(220, 277, 221, 34);
		contentPane.add(bId);
		contentPane.add(tfId);
		
		
		//jf.setLayout(gb);
		
		contentPane.setLayout(null);
		contentPane.setBackground(c);

	     
	      //��й�ȣ
	      JLabel bPwd = new JLabel("��й�ȣ : ");
	      bPwd.setForeground(Color.WHITE);
	      bPwd.setFont(new Font("����", Font.BOLD, 18));
	      pfPwd = new JPasswordField(10);
	      bPwd.setBounds(106, 331, 107, 58);
	      pfPwd.setBounds(220, 342, 221, 37);
	      contentPane.add(bPwd);
	      contentPane.add(pfPwd);

	     
	      //�̸�
	      JLabel bName = new JLabel("�г��� :");
	      bName.setFont(new Font("����", Font.BOLD, 18));
	      bName.setForeground(Color.WHITE);
	      tfNick = new JTextField(10);
	      bName.setBounds(127, 399, 107, 58);
	      tfNick.setBounds(220, 410, 221, 37);
	      contentPane.add(bName);
	      contentPane.add(tfNick);
	      
	      JLabel label = new JLabel("\uB97C \uBD80\uD0C1\uD574!\r\n");
	      label.setFont(new Font("����", Font.BOLD, 21));
	      label.setForeground(Color.WHITE);
	      label.setBounds(276, 52, 119, 48);
	      contentPane.add(label);
	      
	      JLabel label_1 = new JLabel("\uB0C9\uC7A5\uACE0\r\n");
	      label_1.setFont(new Font("����", Font.BOLD, 21));
	      label_1.setForeground(Color.ORANGE);
	      label_1.setBounds(202, 59, 77, 34);
	      contentPane.add(label_1);
	      
	      JLabel label_2 = new JLabel("\uD68C\uC6D0\uAC00\uC785\r\n");
	      label_2.setFont(new Font("����", Font.BOLD, 21));
	      label_2.setForeground(Color.WHITE);
	      label_2.setBounds(244, 101, 120, 38);
	      contentPane.add(label_2);

	        
	      //��ư
	      //JPanel pButton = new JPanel();
	      btnInsert = new JButton("����");
	      btnCancel=new JButton("���");
	      btnInsert.setBounds(93, 507, 173, 34);
	      btnCancel.setBounds(316, 507, 173, 34);
	      contentPane.add(btnInsert);
	      contentPane.add(btnCancel);
	      
	      btnInsert.addActionListener(this);
	      btnCancel.addActionListener(this);
	      
	      jf.setSize(600, 800);
	      jf.setVisible(true);
	      jf.setResizable(false);
	}
	
	 
	 private void viewDate(memberDBsave vMem){
		 String id=vMem.getId();
		 String pwd=vMem.getPass();
		 String nick=vMem.getNick();
		 
		 //ȭ�鼼��
		 tfId.setText(id);
		 tfId.setEditable(false);
		 pfPwd.setText(""); //��й�ȣ�� �Ⱥ����ش�.
	     tfNick.setText(nick);
	
	 }
	 
	public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnInsert){
				insertMember();
				System.out.println("insertMember() ����");
				
			}else if(e.getSource()==btnCancel){
				jf.dispose();
			}
			
		}
	
	 private void insertMember(){
	        
	        //ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
	        memberDBsave dto = getViewData();
	        memberDBnarrow dao = new memberDBnarrow();       
	        boolean ok = dao.insertMember(dto);
	       
	        if(ok){
	        	
	            JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�.");
	            jf.dispose();
	           
	        }else{
	           
	            JOptionPane.showMessageDialog(this, "������ ���������� ó������ �ʾҽ��ϴ�.");
	        }   
	    }//insertMember
	    
	    public memberDBsave getViewData(){
	    	memberDBsave dto = new memberDBsave();
	    	
	    	String id=tfId.getText();
	    	String pwd = pfPwd.getText();
	    	String nick=tfNick.getText();
	    	
	    	dto.setId(id);
	        dto.setPass(pwd);
	        dto.setNick(nick);
	        
	        return dto;
	    }
	    

	    public static void main(String[] args) {
	       
	        new InsertMem();
	    }


}


