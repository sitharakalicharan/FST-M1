package activities;


import java.util.HashMap;
import java.util.HashSet;


public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		
		map.put(1, "Black");
		map.put(2, "White");
		map.put(3, "Red");
		map.put(4, "Lavender");
		map.put(5, "Green");
		
		System.out.println("The map is "+map);
		
		map.remove(2);
		
		if(map.containsValue("Green")) {
			System.out.println("Green is present in the map ");
		}
		else {
			System.out.println("Green is not present in the map");
		}
		
		
		System.out.println("The new map is "+map);
		System.out.println("The new size of the map is "+map.size());
	}

}
