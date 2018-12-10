package BoatDecoratorDesign;

public abstract class BoatDecorator implements Boat{
	protected Boat b;
	
	public BoatDecorator(Boat b) {
		this.b = b;
	}
	
	public abstract int maxCapacity();
	public abstract int topSpeed();
	

}
