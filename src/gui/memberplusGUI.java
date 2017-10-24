package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import program.memberDBnarrow;
import program.memberDBsave;

public class memberplusGUI extends JFrame implements ActionListener {
	JPanel p;
	JTextField  tfId, tfNick;
	JPasswordField  pfPwd;
	JButton btnInsert, btnCancel;
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	Member_List mList ;
	
	Color c = new Color(240, 93, 95);
	   
	 public memberplusGUI(){ //가입용 생성자
	       
	   createUI(); // UI작성해주는 메소드
	   
	         
	 }//생성자
	 
	 public memberplusGUI(Member_List mList){//가입용 생성자
		 createUI(); 
		 this.mList=mList;
	 }
	 
	 private void viewDate(memberDBsave vMem){
		 String id=vMem.getId();
		 String pwd=vMem.getPass();
		 String nick=vMem.getNick();
		 
		 //화면세팅
		 tfId.setText(id);
		 tfId.setEditable(false);
		 pfPwd.setText(""); //비밀번호는 안보여준다.
	     tfNick.setText(nick);
	
	 }

	
	
	private void createUI(){

		new InsertMem();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 

	}
	
/*	 private void gbAdd(JComponent c, int x, int y, int w, int h){
	        gbc.gridx = x;
	        gbc.gridy = y;
	        gbc.gridwidth = w;
	        gbc.gridheight = h;(
	        gb.setConstraints(c, gbc);
	        gbc.insets = new Insets(2, 2, 2, 2);
	        add(c, gbc);
	    }//gbAdd
*/	   
	    public static void main(String[] args) {
	       
	        new memberplusGUI();
	    }
	    
	    @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnInsert){
				insertMember();
				System.out.println("insertMember() 종료");
				
			}else if(e.getSource()==btnCancel){
				this.dispose();
			}
			
			 mList.jTableRefresh();
			
		}
	    
	    private void insertMember(){
	        
	        //화면에서 사용자가 입력한 내용을 얻는다.
	        memberDBsave dto = getViewData();
	        memberDBnarrow dao = new memberDBnarrow();       
	        boolean ok = dao.insertMember(dto);
	       
	        if(ok){
	           
	            JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
	            dispose();
	           
	        }else{
	           
	            JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다.");
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

}
