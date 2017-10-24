package program;

import gui.Menu;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String sql = "select num, name from food;";
			ps = con.prepareStatement(sql);
			//ps.setString(1, num);
			rs = ps.executeQuery();
			
			String sql2= "select num, menuname, ingredient1, ingredient2, ingredient3 from menu;";
			ps = con.prepareStatement(sql2);
			//ps.setString(1, num);
			rs2=ps.executeQuery();
			int cnt=0;
			String prin=" ";
			JButton jb[];
			while (rs.next()) {
				fName=rs.getString("name"); //System.out.println(fName);
				while(rs2.next()){//System.out.println(rs2.getString("ingredient1"));
					for(int i=1; i<=3; i++){
						if(fName.equals(rs2.getString("ingredient"+Integer.toString(i)))){
							System.out.println(fName);
							prin+=rs2.getString("menuname")+"/";
							String number = rs2.getString("num");
							System.out.println(number);
							i=4;
						}
					}
				}
				rs2=ps.executeQuery();
			}
			String[] data = prin.split("/");
			
			jb=new JButton[data.length];
			
			int y =130;
			
			for(int i=0; i<data.length; i++){
				jb[i]=new JButton(data[i]);
				jb[i].setBounds(0, y, 500, 90);
				contentPane.add(jb[i]);
				y*=2;		
			}
			
			
					
//			jl=new JLabel(fName);
//			jl.setBounds(56, 207, 78, 21);
//			contentPane.add(jl);
			
			
			setVisible(true);
			setSize(500, 700);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
