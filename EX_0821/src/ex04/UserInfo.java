package ex04;

/*  - String id, int pwd를 필드로 갖는다.
    - 필드는 private으로 설정한다.*/

public class UserInfo {
	
	private String id;
	private int pwd;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

}
