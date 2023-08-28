package activities;

interface BicycleParts{
	public int gears= 0;
	public int speed = 0;
		
}

interface BicycleOperations{
	public void applyBrake(int decrement);
	public void speedUp(int increment);
	
}

class Bicycle implements BicycleParts, BicycleOperations{

	public int currentSpeed;
	public int gears;

	public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }
	@Override
	public void applyBrake(int decrement) {
		// TODO Auto-generated method stub
		
		currentSpeed = currentSpeed - decrement;
		
	}

	@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		currentSpeed = currentSpeed + increment;
	}
	
	public void bicycleDesc() {
		System.out.println("The gear is "+gears);
		System.out.println("The current speed is "+currentSpeed);
	}

}

class MountainBike extends Bicycle{
	
	public int seatHeight;

	public MountainBike(int gears, int currentSpeed, int seatHeight) {
		super(gears, currentSpeed);
		this.seatHeight= seatHeight;
		
	}
	
	public void setHeight(int seatHeight) {
		this.seatHeight = seatHeight;
	}
	
	@Override
	public void bicycleDesc() {
		System.out.println("The gear is "+gears);
		System.out.println("The current speed is "+currentSpeed);
		System.out.println("The seat height is "+seatHeight);
	}
	

}

public class Activity7 {
	
	public static void main(String[] args) {
		
		MountainBike bike = new MountainBike(2, 20, 4);
		bike.bicycleDesc();
		bike.speedUp(30);
		bike.applyBrake(10);
		System.out.println("The current speed is "+bike.currentSpeed);
		
	}

}

