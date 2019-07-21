package beans;

public class AnswerBean {
	
	private int answerId;
	private String dateTime;
	private String userId;
	private String questionId;
	private int answer;
	private int correctness;
	
	public AnswerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerBean(int answerId, String dateTime, String userId, String questionId, int answer, int correctness) {
		super();
		this.answerId = answerId;
		this.dateTime = dateTime;
		this.userId = userId;
		this.questionId = questionId;
		this.answer = answer;
		this.correctness = correctness;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getCorrectness() {
		return correctness;
	}

	public void setCorrectness(int correctness) {
		this.correctness = correctness;
	}

}
