package program;

public class IngredientDTO {

	private String num;
	private String name;
	private String inputyear;
	private String inputmonth;
	private String inputday;
	private String outyear;
	private String outmonth;
	private String outday;

	// 이클립스팁 : Getter/Setter 만들기
	// 우클릭 -> source->Generate Getters And Setters-> [Select AlL] -> [OK]
	public void setNum(String num) {
		this.num = num;
	}

	public String getNum() {
		return num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getInputyear() {
		return inputyear;
	}

	public void setInputyear(String inputyear) {
		this.inputyear = inputyear;
	}

	public String getInputmonth() {
		return inputmonth;
	}

	public void setInputmonth(String inputmonth) {
		this.inputmonth = inputmonth;
	}

	public String getInputday() {
		return inputday;
	}

	public void setInputday(String inputday) {
		this.inputday = inputday;
	}

	public String getOutyear() {
		return outyear;
	}

	public void setOutyear(String outyear) {
		this.outyear = outyear;
	}

	public String getOutmonth() {
		return outmonth;
	}

	public void setOutmonth(String outmonth) {
		this.outmonth = outmonth;
	}

	public String getOutday() {
		return outday;
	}

	public void setOutday(String outday) {
		this.outday = outday;
	}

	// DTO 객체 확인
	// 이클립스팁 : toString() 자동생성: 우클릭 -> source -> Generate toString->[OK]
	@Override
	public String toString() {
		return "MemberDTO [num=" + num + ", name=" + name + ", inputyear=" + inputyear + ", inputmonth=" + inputmonth
				+ ", inputday=" + inputday + ", outyear=" + outyear + ", outmonth=" + outmonth + ", outday=" + outday
				+ "]";
	}
}
