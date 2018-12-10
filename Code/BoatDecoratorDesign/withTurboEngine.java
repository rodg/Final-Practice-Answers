package BoatDecoratorDesign;

public class withTurboEngine extends BoatDecorator{
	
	public withTurboEngine(Boat b) {
		super(b);
	}
	
	public int maxCapacity() {
		return b.maxCapacity();//big engine less people
	}
	
	public int topSpeed() {
		return b.topSpeed()+10;
	}

}
