package ex01_super;

public class HybridCar extends Car{
	
	int electricGauge;
	
	public HybridCar(int gasGauge, int electricGauge) {
		super(gasGauge);
		this.electricGauge = electricGauge;
	}
	
	@Override
	public void showCurrentGauge() {
		super.showCurrentGauge();
		System.out.println("전기량 : "+electricGauge);
	}
	


}
