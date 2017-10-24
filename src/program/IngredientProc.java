package program;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import Projects.FoodGUI.MyListener;

import java.awt.event.*;

public class IngredientProc extends JFrame implements ActionListener {

	String[] year = { "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" };
	String month[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	String day[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	JLabel label[] = new JLabel[11];
	JLabel label1, la1, la2, la3;
	JTextField name1;
	JComboBox inputyear1, inputmonth1, inputday1, outyear1, outmonth1, outday1;
	JPasswordField passwd;
	JPanel Foodname, input, output, select, radios;
	JButton b1, b2;
	JRadioButton r1;
	JTextArea content;
	JButton btnInsert, btnCancel, btnUpdate, btnDelete; // ����, ���, ���� , Ż�� ��ư

	GridBagLayout gb;
	GridBagConstraints gbc;
	Ingredient_List iList;

	public IngredientProc() { // ���Կ� ������

		createUI(); // UI�ۼ����ִ� �޼ҵ�
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);

	}// ������

	public IngredientProc(Ingredient_List iList) { // ���Կ� ������

		createUI(); // UI�ۼ����ִ� �޼ҵ�
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		this.iList = iList;

	}// ������

	public IngredientProc(String id, Ingredient_List iList) { // ����/������ ������
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.iList = iList;

		System.out.println("id=" + id);

		IngredientDAO dao = new IngredientDAO();
		IngredientDTO vMem = dao.getIngredientDTO(id);
		viewData(vMem);

	}// id�� ������ ����

	// IngredientDTO �� ��� ������ ������ ȭ�鿡 �������ִ� �޼ҵ�
	private void viewData(IngredientDTO vMem) {

		String num = vMem.getNum();
		String name = vMem.getName();
		String inputyear = vMem.getInputyear();
		String inputmonth = vMem.getInputmonth();
		String inputday = vMem.getInputday();
		String outyear = vMem.getOutyear();
		String outmonth = vMem.getOutmonth();
		String outday = vMem.getOutday();

		// ȭ�鿡 ����
		name1.setText(name);
		inputyear1.setSelectedItem(inputyear);
		inputmonth1.setSelectedItem(inputmonth);
		inputday1.setSelectedItem(inputday);
		outyear1.setSelectedItem(outyear);
		outmonth1.setSelectedItem(outmonth);
		outday1.setSelectedItem(outday);
	}// viewData

	private void createUI() {

		this.setTitle("�������");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		// �̸�
		JLabel bName = new JLabel("�̸� : ");
		name1 = new JTextField(20);
		gbAdd(bName, 0, 1, 1, 1);
		gbAdd(name1, 1, 1, 3, 1);

		// ���³�
		JLabel bYear = new JLabel("���� �� :");
		inputyear1 = new JComboBox(year);
		JPanel pYear = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pYear.add(inputyear1);
		gbAdd(bYear, 0, 2, 1, 1);
		gbAdd(inputyear1, 1, 2, 3, 1);

		// ���´�
		JLabel bMonth = new JLabel("���� �� :");
		inputmonth1 = new JComboBox(month);
		JPanel pMonth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pMonth.add(inputmonth1);
		gbAdd(bMonth, 0, 3, 1, 1);
		gbAdd(inputmonth1, 1, 3, 3, 1);

		// ������
		JLabel bDay = new JLabel("���� ��: ");
		inputday1 = new JComboBox(day);
		JPanel pDay = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pDay.add(inputday1);
		gbAdd(bDay, 0, 4, 1, 1);
		gbAdd(inputday1, 1, 4, 3, 1);

		// ������ѳ�
		JLabel bOyear = new JLabel("������� �� :");
		outyear1 = new JComboBox(year);
		JPanel pOyear = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pOyear.add(outyear1);
		gbAdd(bOyear, 0, 5, 1, 1);
		gbAdd(outyear1, 1, 5, 3, 1);

		// ������Ѵ�
		JLabel bOutmonth = new JLabel("������� �� : ");
		outmonth1 = new JComboBox(month);
		JPanel pOutmonth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pOutmonth.add(outmonth1);
		gbAdd(bOutmonth, 0, 6, 1, 1);
		gbAdd(outmonth1, 1, 6, 3, 1);

		// ������� ��
		JLabel bOutday = new JLabel("������� �� : ");
		outday1 = new JComboBox(day);
		JPanel pOutday = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pOutday.add(outday1);
		gbAdd(bOutday, 0, 7, 1, 1);
		gbAdd(outday1, 1, 7, 3, 1);

		// ��ư
		JPanel pButton = new JPanel();
		btnInsert = new JButton("�߰�");
		btnUpdate = new JButton("����");
		btnDelete = new JButton("����");
		btnCancel = new JButton("���");
		pButton.add(btnInsert);
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnCancel);
		gbAdd(pButton, 0, 10, 4, 1);

		// ��ư �̺�Ʈ �غ�
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnCancel.addActionListener(this);
		btnDelete.addActionListener(this);

		setSize(350, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // ����â �ݱ�.

	}// gbAdd

	public static void main(String[] args) {

		new IngredientProc();
	}

	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c, gbc);
	}// gbAdd

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnInsert) {
			insertIngredient();
			System.out.println("insertMember() ȣ�� ����");
		} else if (ae.getSource() == btnCancel) {
			this.dispose(); // ����â�� �ݱ�
		} else if (ae.getSource() == btnUpdate) {
			UpdateIngredient();
		} else if (ae.getSource() == btnDelete) {
			int x = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);

			if (x == JOptionPane.OK_OPTION) {
				deleteIngredient();
			} else {
				JOptionPane.showMessageDialog(this, "������ ����Ͽ����ϴ�.");
			}
		}

		// jTable���� ���� �޼ҵ� ȣ��
		iList.jTableRefresh();

	}// actionPerformed

	//��� ����
	private void deleteIngredient() {
		String name = name1.getText();
		if (name.length() == 0) { // ���̰� 0�̸�

			JOptionPane.showMessageDialog(this, "����̸��� �� �Է��ϼ���!");
			return; // �޼ҵ� ��
		}
		System.out.println(iList);
		IngredientDAO dao = new IngredientDAO();
		boolean ok = dao.deleteIngredient(name);

		if (ok) {
			JOptionPane.showMessageDialog(this, "�����Ϸ�");
			dispose();

		} else {
			JOptionPane.showMessageDialog(this, "��������");

		}

	}// deleteMember

	private void UpdateIngredient() {

		// 1. ȭ���� ������ ��´�.
		IngredientDTO dto = getViewData();
		// 2. �������� DB�� ����
		IngredientDAO dao = new IngredientDAO();
		boolean ok = dao.updateIngredient(dto);

		if (ok) {
			JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�.");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "��������: ���� Ȯ���ϼ���");
		}
	}

	private void insertIngredient() {

		// ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
		IngredientDTO dto = getViewData();
		IngredientDAO dao = new IngredientDAO();
		boolean ok = dao.insertIngredeint(dto);

		if (ok) {

			JOptionPane.showMessageDialog(this, "��� �߰��� �Ϸ�Ǿ����ϴ�.");
			dispose();

		} else {

			JOptionPane.showMessageDialog(this, "����߰��� ���������� ó������ �ʾҽ��ϴ�.");
		}

	}// insertMember

	public IngredientDTO getViewData() {

		// ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
		IngredientDTO dto = new IngredientDTO();
		String name = name1.getText();
		String inputyear = (String) inputyear1.getSelectedItem();
		String inputmonth = (String) inputmonth1.getSelectedItem();
		String inputday = (String) inputday1.getSelectedItem();
		String outyear = (String) outyear1.getSelectedItem();
		String outmonth = (String) outmonth1.getSelectedItem();
		String outday = (String) outday1.getSelectedItem();

		// dto�� ��´�.
		dto.setName(name);
		dto.setInputyear(inputyear);
		dto.setInputmonth(inputmonth);
		dto.setInputday(inputday);
		dto.setOutyear(outyear);
		dto.setOutmonth(outmonth);
		dto.setOutday(outday);
		return dto;
	}

}// end
