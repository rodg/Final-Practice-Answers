package BoatDecoratorDesign;

public class withBarnacle extends BoatDecorator{

	public withBarnacle(Boat b) {
		super(b);
	}
	
	public int maxCapacity() {
		return b.maxCapacity();
	}

	@Override
	public int topSpeed() {
		return b.topSpeed()-1; //barnacles slow you down
	}

}
