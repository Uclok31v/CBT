package beans;

public class UserBean {
	
	private String userId;
	private String userName;
	private String password;
	private int administrator;
	private int role1;
	private int role2;
	private int role3;
	private int role4;
	private int role5;
	private int role6;
	private int role7;
	private int role8;
	private int role9;
	private int times;
	private int result;
	private float percentage;
	private String dateTime;
	
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBean(String userId, String userName, String password, int administrator, int role1, int role2, int role3,
			int role4, int role5, int role6, int role7, int role8, int role9, int times, int result, float percentage,
			String dateTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.administrator = administrator;
		this.role1 = role1;
		this.role2 = role2;
		this.role3 = role3;
		this.role4 = role4;
		this.role5 = role5;
		this.role6 = role6;
		this.role7 = role7;
		this.role8 = role8;
		this.role9 = role9;
		this.times = times;
		this.result = result;
		this.percentage = percentage;
		this.dateTime = dateTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdministrator() {
		return administrator;
	}

	public void setAdministrator(int administrator) {
		this.administrator = administrator;
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

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
