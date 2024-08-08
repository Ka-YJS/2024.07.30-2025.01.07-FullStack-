package ex02_bike;

public class BikeMain {
	public static void main(String[] args) {
		
		Bike b = new FourWheelBike("윤기");
		b.info();
		b.ride();
		//b.addWheel(); 부모 타입으로는 불가
		
		System.out.println();
		
		FourWheelBike fwb = (FourWheelBike)b;
		fwb.addwheel();
		fwb.info();
		fwb.ride();

	}

}
