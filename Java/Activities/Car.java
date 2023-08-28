package activities;

public class Car {
	
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	public Car() {
		
		this.tyres= 4;
		this.doors = 4;
		
	}
	
	public void displayCharacteristics() {
		
		System.out.println("The car's color is "+color);
		System.out.println("The car's transmission is "+transmission);
		System.out.println("The car's make is "+make);
		System.out.println("The car's tyres is "+tyres);
		System.out.println("The car's doors is "+doors);

	}
	
	public void accelarate() {
		System.out.println("Car is moving forward.");
	}
	
	public void brake() {
		System.out.println("Car has stopped.");
	}

}