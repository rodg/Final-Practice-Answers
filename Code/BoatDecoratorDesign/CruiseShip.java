package BoatDecoratorDesign;

public class CruiseShip implements Boat { // big boat
	private int maxCap = 200;
	
	public int topSpeed() {
		return 20;
	}

	public int maxCapacity() {
		return maxCap;
	}
}