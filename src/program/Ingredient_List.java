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
		super("������ ���α׷�");
		IngredientDAO dao = new IngredientDAO();
		v = dao.getIngredientList();
		System.out.println("v=" + v);
		cols = getColumn();

		model = new DefaultTableModel(v, cols);
		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);

		pbtn = new JPanel();
		btnInsert = new JButton("����߰�");
		pbtn.add(btnInsert);
		add(pbtn, BorderLayout.NORTH);

		jTable.addMouseListener(this); // ������ ���
		btnInsert.addActionListener(this); // ����߰���ư ������ ���

		setSize(600, 200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // ����â �ݱ�.
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end ������

	// JTable�� �÷�
	public Vector getColumn() {
		Vector col = new Vector();
		col.add("��ȣ");
		col.add("�̸�");
		col.add("����");
		col.add("����");
		col.add("����");
		col.add("������ѳ�");
		col.add("������Ѵ�");
		col.add("������ѳ�");

		return col;
	}// getColumn

	// Jtable ���� ���� �޼���
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
		// mouseClicked �� ���
		int r = jTable.getSelectedRow();
		String id = (String) jTable.getValueAt(r, 0);
		// System.out.println("id="+id);
		IngredientProc mem = new IngredientProc(id, this); // ���̵� ���ڷ� ����â ����

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
		// ��ư�� Ŭ���ϸ�
		if (e.getSource() == btnInsert) {
			new IngredientProc(this);

			// �׽�Ʈ
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
