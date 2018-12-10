package BoatDecoratorDesign;

public class BoatFactory {
	public static void main(String[] args) {
		Boat speedBoat = new withBarnacle( new withBarnacle( new withTurboEngine( new SpeedBoat())));
		System.out.println(speedBoat.maxCapacity());
		System.out.println(speedBoat.topSpeed());
	}
}