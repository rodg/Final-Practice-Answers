package BoatDecoratorDesign;

class SpeedBoat implements Boat { // small boat
	private int maxCap = 4;
	
	public int topSpeed() {
		return 40;
	}

	public int maxCapacity() {
		return maxCap;
	}
}
