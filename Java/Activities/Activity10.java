package activities;


import java.util.HashSet;


public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HashSet<String> hs = new HashSet<String>();
		hs.add("bangalore");
		hs.add("mysore");
		hs.add("mandya");
		hs.add("Kodagu");
		hs.add("Bidar");
		hs.add("Udupi");
		
		System.out.println("The size os the hashset is "+ hs.size());
		
		
		hs.remove("Udupi");
		if(hs.remove("Tumkur")) {
			System.out.println("Tumkur was removed from the set");
		}
		else {
			System.out.println("Tumkur was not removed from the set");
		}
		
		
		System.out.println("Is bangalore present in the hashset "+hs.contains("bangalore"));
		
		System.out.println("The updated set is: ");
		
		for(String i:hs) {
			System.out.println(i);
		}
		
	}

}
