package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
	
	private List<String> passengers;
    @SuppressWarnings("unused")
	private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded; 
    
	
	public Plane(int maxPassengers){
		this.maxPassengers = maxPassengers;
		passengers = new ArrayList<>();
		
	}
	
	public void onboard(String passengers) {
		this.passengers.add(passengers);
	}
	
	public Date takeOff() {
		lastTimeTookOf = new Date();
		return lastTimeTookOf;
	}
	
	public void land() {
		lastTimeLanded= new Date();
		passengers.clear();
	}
	
	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}
	
	public List<String> getPassesngers(){
		return passengers;
	}
	
	
}

public class Activity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Plane plane = new Plane(10);
		plane.onboard("Stoneheart");
		plane.onboard("Bittersteel");
		plane.onboard("Windblown");
		plane.onboard("Kingslayer");
		
		System.out.println("The take off time is "+plane.takeOff());
		
		
		System.out.println("The list of passengers are "+plane.getPassesngers());

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		plane.land();
		System.out.println("The time of landing "+plane.getLastTimeLanded());
		System.out.println("The passengers after landing is "+ plane.getPassesngers());
	}

}
