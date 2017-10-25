package program;

import gui.Menu;
import gui.submenu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class menulist extends Menu {
	
//	public static void main(String ars[]){new menulist();}
	String driverName = "org.gjt.mm.mysql.Driver"; // 드라이버 이름 지정
	String dbURL="jdbc:mysql://localhost:3306/refrigerator?user=root&password=1234&useUnicode=true&characterEncoding=euc_kr";
	
	private static final String USER = "root"; // DB ID
	private static final String PASS = "1234"; // DB 패스워드
	
	String fName;
	
	public Connection getConn() {
		Connection con = null;

		try {
			Class.forName(driverName); // 1. 드라이버 로딩
			con = DriverManager.getConnection(dbURL, USER, PASS); // 2. 드라이버 연결

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// 재료정보 얻기
	public menulist() {
		new Menu();
		
		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과
		ResultSet rs2 = null; // 결과
		
		JLabel jl = null;
		try {
			con = getConn();
			
			
			String sql2= "select num, menuname, ingredient1, ingredient2, ingredient3 from menu;";
			ps = con.prepareStatement(sql2);
			//ps.setString(1, num);
			rs2=ps.executeQuery();
			
			String sql = "select num, name from food;";
			ps = con.prepareStatement(sql);
			//ps.setString(1, num);
			rs = ps.executeQuery();
			
			int cnt=0;
			boolean ck=true;
			int[] number=new int[100];
			String prin=" ";
			JButton jb[];
			
			while(rs2.next()){
				for(int i=1; i<=3; i++){
					while(rs.next()&&ck){
						fName=rs.getString("name");
						if(fName.equals(rs2.getString("ingredient"+Integer.toString(i)))){
							System.out.println(fName);
							prin+=rs2.getString("menuname")+"/";
							number[cnt]=rs2.getInt("num"); System.out.println(number[cnt]);
							cnt++;
							ck=false;
						}
					}
					rs = ps.executeQuery();
				}
				ck=true;
			}

			/*
			while (rs.next()) {
				fName=rs.getString("name"); //System.out.println(fName);
				while(rs2.next()){//System.out.println(rs2.getString("ingredient1"));
					if(ck){
					for(int i=1; i<=3; i++){
						if(fName.equals(rs2.getString("ingredient"+Integer.toString(i)))&&ck){
							//System.out.println(fName);
							System.out.println(fName);
							number[cnt] =rs2.getInt("num");
							System.out.println(number[cnt]); 
//							cnt++;//break;
//							for(int j=0; j<cnt; j++){
//								for(int k=j+1; k>j; k--){
//									if(number[j]==number[k]){
//										++cntck;System.out.println(fName);
//										ck=false;
//									}
//									else ck=true;
//								}
//							}
//							
							//if(ck&&cntck==0){
								prin+=rs2.getString("menuname")+"/";
								ck=false;
								System.out.println(prin);	
							//}
						}
					}
						
					}
					
					ck=true;cntck=0;
				}
				rs2=ps.executeQuery();//ck=true;//cnt=0;
				 cnt=0;
				//for(int k=0; k<100; k++) number[k]=0;
			}
			*/
			
			if(cnt!=0){
				String[] data = prin.split("/");
				
				jb=new JButton[data.length];
				
				int y =130;		
				for(int i=0; i<data.length; i++){
					jb[i]=new JButton(data[i]);
					jb[i].setBounds(0, y, 500, 90);	
					
					String sql3="select * from menu where num="+number[i]+";";	
					
					jb[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								Connection con = getConn();
								PreparedStatement ps=con.prepareStatement(sql3);
								ResultSet rs = rs=ps.executeQuery();
								new submenu(rs);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					
					contentPane.add(jb[i]);
					y+=100;		
				}
			}else{
				System.out.println("매칭되는 음식 없음");
			}
			
			
			
			setResizable(false);
			setVisible(true);
			setSize(500, 700);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
