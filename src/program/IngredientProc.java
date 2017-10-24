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
	JButton btnInsert, btnCancel, btnUpdate, btnDelete; // 가입, 취소, 수정 , 탈퇴 버튼

	GridBagLayout gb;
	GridBagConstraints gbc;
	Ingredient_List iList;

	public IngredientProc() { // 가입용 생성자

		createUI(); // UI작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);

	}// 생성자

	public IngredientProc(Ingredient_List iList) { // 가입용 생성자

		createUI(); // UI작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		this.iList = iList;

	}// 생성자

	public IngredientProc(String id, Ingredient_List iList) { // 수정/삭제용 생성자
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.iList = iList;

		System.out.println("id=" + id);

		IngredientDAO dao = new IngredientDAO();
		IngredientDTO vMem = dao.getIngredientDTO(id);
		viewData(vMem);

	}// id를 가지고 생성

	// IngredientDTO 의 재료 정보를 가지고 화면에 셋팅해주는 메소드
	private void viewData(IngredientDTO vMem) {

		String num = vMem.getNum();
		String name = vMem.getName();
		String inputyear = vMem.getInputyear();
		String inputmonth = vMem.getInputmonth();
		String inputday = vMem.getInputday();
		String outyear = vMem.getOutyear();
		String outmonth = vMem.getOutmonth();
		String outday = vMem.getOutday();

		// 화면에 세팅
		name1.setText(name);
		inputyear1.setSelectedItem(inputyear);
		inputmonth1.setSelectedItem(inputmonth);
		inputday1.setSelectedItem(inputday);
		outyear1.setSelectedItem(outyear);
		outmonth1.setSelectedItem(outmonth);
		outday1.setSelectedItem(outday);
	}// viewData

	private void createUI() {

		this.setTitle("재료정보");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		// 이름
		JLabel bName = new JLabel("이름 : ");
		name1 = new JTextField(20);
		gbAdd(bName, 0, 1, 1, 1);
		gbAdd(name1, 1, 1, 3, 1);

		// 들어온년
		JLabel bYear = new JLabel("들어온 년 :");
		inputyear1 = new JComboBox(year);
		JPanel pYear = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pYear.add(inputyear1);
		gbAdd(bYear, 0, 2, 1, 1);
		gbAdd(inputyear1, 1, 2, 3, 1);

		// 들어온달
		JLabel bMonth = new JLabel("들어온 달 :");
		inputmonth1 = new JComboBox(month);
		JPanel pMonth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pMonth.add(inputmonth1);
		gbAdd(bMonth, 0, 3, 1, 1);
		gbAdd(inputmonth1, 1, 3, 3, 1);

		// 들어온일
		JLabel bDay = new JLabel("들어온 일: ");
		inputday1 = new JComboBox(day);
		JPanel pDay = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pDay.add(inputday1);
		gbAdd(bDay, 0, 4, 1, 1);
		gbAdd(inputday1, 1, 4, 3, 1);

		// 유통기한년
		JLabel bOyear = new JLabel("유통기한 년 :");
		outyear1 = new JComboBox(year);
		JPanel pOyear = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pOyear.add(outyear1);
		gbAdd(bOyear, 0, 5, 1, 1);
		gbAdd(outyear1, 1, 5, 3, 1);

		// 유통기한달
		JLabel bOutmonth = new JLabel("유통기한 달 : ");
		outmonth1 = new JComboBox(month);
		JPanel pOutmonth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pOutmonth.add(outmonth1);
		gbAdd(bOutmonth, 0, 6, 1, 1);
		gbAdd(outmonth1, 1, 6, 3, 1);

		// 유통기한 일
		JLabel bOutday = new JLabel("유통기한 일 : ");
		outday1 = new JComboBox(day);
		JPanel pOutday = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pOutday.add(outday1);
		gbAdd(bOutday, 0, 7, 1, 1);
		gbAdd(outday1, 1, 7, 3, 1);

		// 버튼
		JPanel pButton = new JPanel();
		btnInsert = new JButton("추가");
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("삭제");
		btnCancel = new JButton("취소");
		pButton.add(btnInsert);
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnCancel);
		gbAdd(pButton, 0, 10, 4, 1);

		// 버튼 이벤트 준비
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnCancel.addActionListener(this);
		btnDelete.addActionListener(this);

		setSize(350, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 현재창 닫기.

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
			System.out.println("insertMember() 호출 종료");
		} else if (ae.getSource() == btnCancel) {
			this.dispose(); // 현재창만 닫기
		} else if (ae.getSource() == btnUpdate) {
			UpdateIngredient();
		} else if (ae.getSource() == btnDelete) {
			int x = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);

			if (x == JOptionPane.OK_OPTION) {
				deleteIngredient();
			} else {
				JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
			}
		}

		// jTable내용 갱신 메소드 호출
		iList.jTableRefresh();

	}// actionPerformed

	//재료 삭제
	private void deleteIngredient() {
		String name = name1.getText();
		if (name.length() == 0) { // 길이가 0이면

			JOptionPane.showMessageDialog(this, "재료이름을 꼭 입력하세요!");
			return; // 메소드 끝
		}
		System.out.println(iList);
		IngredientDAO dao = new IngredientDAO();
		boolean ok = dao.deleteIngredient(name);

		if (ok) {
			JOptionPane.showMessageDialog(this, "삭제완료");
			dispose();

		} else {
			JOptionPane.showMessageDialog(this, "삭제실패");

		}

	}// deleteMember

	private void UpdateIngredient() {

		// 1. 화면의 정보를 얻는다.
		IngredientDTO dto = getViewData();
		// 2. 그정보로 DB를 수정
		IngredientDAO dao = new IngredientDAO();
		boolean ok = dao.updateIngredient(dto);

		if (ok) {
			JOptionPane.showMessageDialog(this, "수정되었습니다.");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요");
		}
	}

	private void insertIngredient() {

		// 화면에서 사용자가 입력한 내용을 얻는다.
		IngredientDTO dto = getViewData();
		IngredientDAO dao = new IngredientDAO();
		boolean ok = dao.insertIngredeint(dto);

		if (ok) {

			JOptionPane.showMessageDialog(this, "재료 추가가 완료되었습니다.");
			dispose();

		} else {

			JOptionPane.showMessageDialog(this, "재료추가가 정상적으로 처리되지 않았습니다.");
		}

	}// insertMember

	public IngredientDTO getViewData() {

		// 화면에서 사용자가 입력한 내용을 얻는다.
		IngredientDTO dto = new IngredientDTO();
		String name = name1.getText();
		String inputyear = (String) inputyear1.getSelectedItem();
		String inputmonth = (String) inputmonth1.getSelectedItem();
		String inputday = (String) inputday1.getSelectedItem();
		String outyear = (String) outyear1.getSelectedItem();
		String outmonth = (String) outmonth1.getSelectedItem();
		String outday = (String) outday1.getSelectedItem();

		// dto에 담는다.
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
