package beans;

public class QuestionBean {
	
	private String questionId;
	private String text;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private int correct;
	private int role1;
	private int role2;
	private int role3;
	private int role4;
	private int role5;
	private int role6;
	private int role7;
	private int role8;
	private int role9;
	private int pattern;
	private String owner;
	
	public QuestionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionBean(String questionId, String text, String choice1, String choice2, String choice3, String choice4,
			int correct, int role1, int role2, int role3, int role4, int role5, int role6, int role7, int role8,
			int role9, int pattern, String owner) {
		super();
		this.questionId = questionId;
		this.text = text;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.correct = correct;
		this.role1 = role1;
		this.role2 = role2;
		this.role3 = role3;
		this.role4 = role4;
		this.role5 = role5;
		this.role6 = role6;
		this.role7 = role7;
		this.role8 = role8;
		this.role9 = role9;
		this.pattern = pattern;
		this.owner = owner;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getChoice4() {
		return choice4;
	}

	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public int getRole1() {
		return role1;
	}

	public void setRole1(int role1) {
		this.role1 = role1;
	}

	public int getRole2() {
		return role2;
	}

	public void setRole2(int role2) {
		this.role2 = role2;
	}

	public int getRole3() {
		return role3;
	}

	public void setRole3(int role3) {
		this.role3 = role3;
	}

	public int getRole4() {
		return role4;
	}

	public void setRole4(int role4) {
		this.role4 = role4;
	}

	public int getRole5() {
		return role5;
	}

	public void setRole5(int role5) {
		this.role5 = role5;
	}

	public int getRole6() {
		return role6;
	}

	public void setRole6(int role6) {
		this.role6 = role6;
	}

	public int getRole7() {
		return role7;
	}

	public void setRole7(int role7) {
		this.role7 = role7;
	}

	public int getRole8() {
		return role8;
	}

	public void setRole8(int role8) {
		this.role8 = role8;
	}

	public int getRole9() {
		return role9;
	}

	public void setRole9(int role9) {
		this.role9 = role9;
	}

	public int getPattern() {
		return pattern;
	}

	public void setPattern(int pattern) {
		this.pattern = pattern;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	

}
