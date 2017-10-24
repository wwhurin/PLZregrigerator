package program;

import gui.Member_List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class memberDBnarrow {

	String url="jdbc:mysql://localhost:3306/refrigerator?user=root&password=1234&useUnicode=true&characterEncoding=euc_kr";

	
	Member_List mList;
	
	public memberDBnarrow(){
		
	}
	
	public memberDBnarrow(Member_List mList){
		this.mList=mList;
		System.out.println("DAO=>"+mList);
	}
	
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
	 
	 //한사람 정보 얻어오기 
	 public memberDBsave getMemberDTO(String id){
		 memberDBsave dto = new memberDBsave();
		 Connection con = null;       //연결
	     PreparedStatement ps = null; //명령
	     ResultSet rs = null;         //결과
	     
	     try{
	    	 con=getConn();
	    	 String sql = "select * from member where id=?";
	    	 ps=con.prepareStatement(sql);
	    	 ps.setString(1, id);
	    	 
	    	 rs = ps.executeQuery();
	    	 
	    	 if(rs.next()){
	    		 dto.setId(rs.getString("id"));
	    		 dto.setId(rs.getString("pass"));
	    		 dto.setId(rs.getString("nick"));
	    	 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     
	     return dto;    
	 }
	 
	 //멤버 리스트 출력
	 public Vector getMemberList(){
		 Vector data = new Vector(); //Jtable에 값을 쉽게 넣는 방법 1. 2차원배열   2. Vector 에 vector추가
		
		 Connection con = null; //연결
		 PreparedStatement ps = null; //명령
		 ResultSet rs = null;
		 
		 try{
			  con = getConn();
	            String sql = "select * from member order by nick asc";
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	            
	            while(rs.next()){
	            	String id=rs.getString("id");
	            	String pass=rs.getString("pass");
	            	String nick=rs.getString("nick");
	            	
	            	 Vector row = new Vector();
	                 row.add(id);
	                 row.add(pass);
	                 row.add(nick);	
	                 
	                 data.add(row);
	            }//while
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return data;
	 }
	 
	 //회원 등록
	 public boolean insertMember(memberDBsave dto){
		 boolean ok = false;
		 
		 Connection con=null;
		 PreparedStatement ps = null;
		 
		 try{
			 con=getConn();
			 String sql = "insert into member(id, pass, nick) values(?,?,?)";
			 
			 ps = con.prepareStatement(sql);
			 ps.setString(1, dto.getId());
			 ps.setString(2, dto.getPass());
			 ps.setString(3, dto.getNick());
			 int r=0;
			 
			 if(Integer.parseInt(dto.getId())>=97||Integer.parseInt(dto.getId())<=101){
				 
			 }
			 else {
				r = ps.executeUpdate(); //실행->저장
			 }
			 
			 if(r>0){
				 System.out.println("가입 성공");
				 ok=true;
			 }
			 else
				 System.out.println("가입 실패");
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
		 return ok;
	 }
	 
	  /**DB데이터 다시 불러오기*/   
	    public void userSelectAll(DefaultTableModel model) {
	       
	       
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	       
	        try {
	            con = getConn();
	            String sql = "select * from tb_member order by name asc";
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	           
	            // DefaultTableModel에 있는 데이터 지우기
	            for (int i = 0; i < model.getRowCount();) {
	                model.removeRow(0);
	            }
	 
	            while (rs.next()) {
	                Object data[] = { rs.getString(1), rs.getString(2),
	                        rs.getString(3)};
	 
	                model.addRow(data);                
	            }
	 
	        } catch (SQLException e) {
	            System.out.println(e + "=> userSelectAll fail");
	        } finally{
	           
	            if(rs!=null)
	                try {
	                    rs.close();
	                } catch (SQLException e2) {
	                    // TODO Auto-generated catch block
	                    e2.printStackTrace();
	                }
	            if(ps!=null)
	                try {
	                    ps.close();
	                } catch (SQLException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	            if(con!=null)
	                try {
	                    con.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	        }
	    }
	
}
