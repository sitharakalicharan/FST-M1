package activities;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double seconds = 1000000000;
		
		double earth_seconds = 31557600;
		double mercury_seconds = 0.2408467;
		double venus_seconds = 0.61519726;
		double mars_seconds = 1.8808158;
		double jupiter_seconds = 11.862615;
		double saturn_seconds = 29.447498;
		double uranus_seconds = 84.016846;
		double neptune_seconds = 164.79132;
		
		System.out.println("Earth years "+ seconds/earth_seconds);
		System.out.println("Mercury years "+ seconds/earth_seconds/mercury_seconds);
		System.out.println("Venus years "+ seconds/earth_seconds/venus_seconds);
		System.out.println("Mars years "+ seconds/earth_seconds/mars_seconds);
		System.out.println("Jupiter years "+ seconds/earth_seconds/jupiter_seconds);
		System.out.println("Saturn years "+ seconds/earth_seconds/saturn_seconds);
		System.out.println("Uranus years "+ seconds/earth_seconds/uranus_seconds);
		System.out.println("Neptune years "+ seconds/earth_seconds/neptune_seconds);
		
		
	}

}
