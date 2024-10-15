package ex02_thread;

public class Bank {
	private int money;
	
	public int getMoney() {
		return money;
	}
	
	/*처음입력)
	  public void addMoney(int money) { this.money += money; }
	  -> 오류생김
	 */
	
	/*두번째입력)
	    public synchronized void addMoney(int money) {
		this.money += money;
	}*/
	//세번째 입력)1번실행이 끝난 뒤에 2번을 실행함
	public void addMoney(int money) { this.money += money; }

}
