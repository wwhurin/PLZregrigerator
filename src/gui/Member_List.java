package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import program.memberDBnarrow;

public class Member_List extends JFrame implements MouseListener, ActionListener {
	Vector v;  
    Vector cols;
    DefaultTableModel model;
    JTable jTable;
    JScrollPane pane;
    JPanel pbtn;
    JButton btnInsert;
    
    public Member_List(){
    	super("회원가입");
    	memberDBnarrow dao = new memberDBnarrow();
    	v=dao.getMemberList();
    	System.out.println("v="+v);
    	cols = getColumn();
    	
    	model = new DefaultTableModel(v, cols);
    	
    	jTable = new JTable(model);
        pane = new JScrollPane(jTable);
        add(pane);
       
        pbtn = new JPanel();
        btnInsert = new JButton("회원가입");
        pbtn.add(btnInsert);
        add(pbtn,BorderLayout.NORTH);
       
       
        jTable.addMouseListener(this); //리스너 등록
        btnInsert.addActionListener(this); //회원가입버튼 리스너 등록
       
        setSize(600,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public Vector getColumn(){
    	Vector col = new Vector();
        col.add("아이디");
        col.add("비밀번호");
        col.add("닉네임");
        
        return col;
    }
    
//    public void jTableRefresh(){
//        
//    	memberDBnarrow dao = new memberDBnarrow();
//        DefaultTableModel model= new DefaultTableModel(dao.getMemberList(), getColumn());
//        jTable.setModel(model);    
//       
//    }
    
    public void jTableRefresh() {
		// TODO Auto-generated method stub
		memberDBnarrow dao = new memberDBnarrow();
        DefaultTableModel model= new DefaultTableModel(dao.getMemberList(), getColumn());
        jTable.setModel(model);    
	}

    
    public static void main(String[] args) {
        new Member_List();
    }//main

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 // mouseClicked 만 사용
        int r = jTable.getSelectedRow();
        String id = (String) jTable.getValueAt(r, 0);
        //System.out.println("id="+id);
       // memberplusGUI mem = new memberplusGUI(id,this); //아이디를 인자로 수정창 생성
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInsert ){
            new memberplusGUI(this);
		}
	}

	

}
