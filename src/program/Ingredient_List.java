package program;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Ingredient_List extends JFrame implements MouseListener, ActionListener {

	Vector v;
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
	JPanel pbtn;
	JButton btnInsert;

	public Ingredient_List() {
		super("재료관리 프로그램");
		IngredientDAO dao = new IngredientDAO();
		v = dao.getIngredientList();
		System.out.println("v=" + v);
		cols = getColumn();

		model = new DefaultTableModel(v, cols);
		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);

		pbtn = new JPanel();
		btnInsert = new JButton("재료추가");
		pbtn.add(btnInsert);
		add(pbtn, BorderLayout.NORTH);

		jTable.addMouseListener(this); // 리스너 등록
		btnInsert.addActionListener(this); // 재료추가버튼 리스너 등록

		setSize(600, 200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 현재창 닫기.
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end 생성자

	// JTable의 컬럼
	public Vector getColumn() {
		Vector col = new Vector();
		col.add("번호");
		col.add("이름");
		col.add("들어간년");
		col.add("들어간달");
		col.add("들어간날");
		col.add("유통기한년");
		col.add("유통기한달");
		col.add("유통기한날");

		return col;
	}// getColumn

	// Jtable 내용 갱신 메서드
	public void jTableRefresh() {

		IngredientDAO dao = new IngredientDAO();
		DefaultTableModel model = new DefaultTableModel(dao.getIngredientList(), getColumn());
		jTable.setModel(model);

	}

	public static void main(String[] args) {
		new Ingredient_List();
	}// main

	@Override
	public void mouseClicked(MouseEvent e) {
		// mouseClicked 만 사용
		int r = jTable.getSelectedRow();
		String id = (String) jTable.getValueAt(r, 0);
		// System.out.println("id="+id);
		IngredientProc mem = new IngredientProc(id, this); // 아이디를 인자로 수정창 생성

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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼을 클릭하면
		if (e.getSource() == btnInsert) {
			new IngredientProc(this);

			// 테스트
			/*IngredientDAO dao = new IngredientDAO();
			try {

				dao.userSelectAll(model);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			model.fireTableDataChanged();
			jTable.updateUI();
			jTable.requestFocusInWindow();*/

		}

	}

}
