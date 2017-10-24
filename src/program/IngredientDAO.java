package program;

import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

//import project.Member_List;

//DB ó��
public class IngredientDAO {
	String driverName = "org.gjt.mm.mysql.Driver"; // ����̹� �̸� ����
	String dbURL="jdbc:mysql://localhost:3306/refrigerator?user=root&password=1234&useUnicode=true&characterEncoding=euc_kr";

	private static final String USER = "root"; // DB ID
	private static final String PASS = "1234"; // DB �н�����
	Ingredient_List iList;

	public IngredientDAO() {

	}

	public IngredientDAO(Ingredient_List mList) {
		this.iList = iList;
		System.out.println("DAO=>" + iList);
	}

	// DB����
	public Connection getConn() {
		Connection con = null;

		try {
			Class.forName(driverName); // 1. ����̹� �ε�
			con = DriverManager.getConnection(dbURL, USER, PASS); // 2. ����̹� ����

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// ������� ���
	public IngredientDTO getIngredientDTO(String num) {

		IngredientDTO dto = new IngredientDTO();

		Connection con = null; // ����
		PreparedStatement ps = null; // ���
		ResultSet rs = null; // ���

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

		Vector data = new Vector(); // Jtable�� ���� ���� �ִ� ��� 1. 2�����迭 2. Vector ��
									// vector�߰�

		Connection con = null; // ����
		PreparedStatement ps = null; // ���
		ResultSet rs = null; // ���

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

		Connection con = null; // ����
		PreparedStatement ps = null; // ���

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
			int r = ps.executeUpdate(); // ���� -> ����

			if (r > 0) {
				System.out.println("�߰� ����");
				ok = true;
			} else {
				System.out.println("�߰� ����");
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

			int r = ps.executeUpdate(); // ���� -> ����
			// 1~n: ���� , 0 : ����

			if (r > 0)
				ok = true; // ������ �����Ǹ� ok���� true�� ����

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	 /* ������� ����*/
	public boolean deleteIngredient(String name) {

		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConn();
			String sql = "delete from food where name=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			int r = ps.executeUpdate(); // ���� -> ����

			if (r > 0)
				ok = true; // ������;

		} catch (Exception e) {
			System.out.println(e + "-> �����߻�");
		}
		return ok;
	}

	// DB������ �ٽ� �ҷ����� throws ClassNotFoundException */
	public void userSelectAll(DefaultTableModel model) throws ClassNotFoundException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();
			String sql = "select * from food order by num asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			// DefaultTableModel�� �ִ� ������ �����
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