package ex01_super;

public class HybridWaterCar extends HybridCar {

	int waterGauge;

	public HybridWaterCar(int gasGauge, int electricGauge,int waterGauge) {
		super(waterGauge,electricGauge);
		this.waterGauge = waterGauge;
	}
	
	@Override
	public void showCurrentGauge() {
		super.showCurrentGauge();
		System.out.println("물의 양 : "+waterGauge);
	}
	
	}


