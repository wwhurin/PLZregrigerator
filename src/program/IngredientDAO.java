package program;

import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

//import project.Member_List;

//DB 처리
public class IngredientDAO {
	String driverName = "org.gjt.mm.mysql.Driver"; // 드라이버 이름 지정
	String dbURL="jdbc:mysql://localhost:3306/refrigerator?user=root&password=1234&useUnicode=true&characterEncoding=euc_kr";

	private static final String USER = "root"; // DB ID
	private static final String PASS = "1234"; // DB 패스워드
	Ingredient_List iList;

	public IngredientDAO() {

	}

	public IngredientDAO(Ingredient_List mList) {
		this.iList = iList;
		System.out.println("DAO=>" + iList);
	}

	// DB연결
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
	public IngredientDTO getIngredientDTO(String num) {

		IngredientDTO dto = new IngredientDTO();

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과

		try {

			con = getConn();
			String sql = "select * from food where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, num);

			rs = ps.executeQuery();

			if (rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setInputyear(rs.getString("inputyear"));
				dto.setInputmonth(rs.getString("inputmonth"));
				dto.setInputday(rs.getString("inputday"));
				dto.setOutyear(rs.getString("outyear"));
				dto.setOutmonth(rs.getString("outmonth"));
				dto.setOutday(rs.getString("outday"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	
	public Vector getIngredientList() {

		Vector data = new Vector(); // Jtable에 값을 쉽게 넣는 방법 1. 2차원배열 2. Vector 에
									// vector추가

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과

		try {

			con = getConn();
			String sql = "select * from food order by num asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				String inputyear = rs.getString("inputyear");
				String inputmonth = rs.getString("inputmonth");
				String inputday = rs.getString("inputday");
				String outyear = rs.getString("outyear");
				String outmonth = rs.getString("outmonth");
				String outday = rs.getString("outday");

				Vector row = new Vector();
				row.add(num);
				row.add(name);
				row.add(inputyear);
				row.add(inputmonth);
				row.add(inputday);
				row.add(outyear);
				row.add(outmonth);
				row.add(outday);

				data.add(row);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}// getMemberList()

	
	public boolean insertIngredeint(IngredientDTO dto) {

		boolean ok = false;

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령

		try {

			con = getConn();
			String sql = "insert into food(" + "num,name,inputyear,inputmonth,inputday,outyear," + "outmonth,outday) "
					+ "values(?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getNum());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getInputyear());
			ps.setString(4, dto.getInputmonth());
			ps.setString(5, dto.getInputday());
			ps.setString(6, dto.getOutyear());
			ps.setString(7, dto.getOutmonth());
			ps.setString(8, dto.getOutday());
			int r = ps.executeUpdate(); // 실행 -> 저장

			if (r > 0) {
				System.out.println("추가 성공");
				ok = true;
			} else {
				System.out.println("추가 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}// insertMmeber

	
	public boolean updateIngredient(IngredientDTO vMem) {
		System.out.println("dto=" + vMem.toString());
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = getConn();
			String sql = "update food set '', name=?, inputyear=?, inputmonth=?, inputday=?, outyear=?"
					+ ", outmonth=?,outday=?";

			ps = con.prepareStatement(sql);
			//ps.setString(1, vMem.getNum());
			ps.setString(1, vMem.getName());
			ps.setString(2, vMem.getInputyear());
			ps.setString(3, vMem.getInputmonth());
			ps.setString(4, vMem.getInputday());
			ps.setString(5, vMem.getOutyear());
			ps.setString(6, vMem.getOutmonth());
			ps.setString(7, vMem.getOutday());

			int r = ps.executeUpdate(); // 실행 -> 수정
			// 1~n: 성공 , 0 : 실패

			if (r > 0)
				ok = true; // 수정이 성공되면 ok값을 true로 변경

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	 /* 재료정보 삭제*/
	public boolean deleteIngredient(String name) {

		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConn();
			String sql = "delete from food where name=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			int r = ps.executeUpdate(); // 실행 -> 삭제

			if (r > 0)
				ok = true; // 삭제됨;

		} catch (Exception e) {
			System.out.println(e + "-> 오류발생");
		}
		return ok;
	}

	// DB데이터 다시 불러오기 throws ClassNotFoundException */
	public void userSelectAll(DefaultTableModel model) throws ClassNotFoundException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();
			String sql = "select * from food order by num asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			// DefaultTableModel에 있는 데이터 지우기
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8) };

				model.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> userSelectAll fail");
		} finally {

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