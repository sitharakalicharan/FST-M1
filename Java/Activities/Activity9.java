package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<String> myList = new ArrayList<String>();
		myList.add("India");
		myList.add("Bangladesh");
		myList.add("Srilanka");
		myList.add(3,"Thailand");
		myList.add(4, "Laos");
		
		System.out.println("Printing all the names in the list");
		for(String i:myList) {
			
			System.out.println(i);
		}
		
		System.out.println("Third name is "+myList.get(2));
		System.out.println("does Laos exist in the list "+myList.contains("Laos"));
		System.out.println("The size of the list is "+ myList.size());
		
		myList.remove(2);
		System.out.println("The new size of the list is "+ myList.size());
		
		
	}

}
