package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> data = new ArrayList<Integer>();
		Random random = new Random();
		
		System.out.println("Please enter the intgers");
		
		while(scan.hasNextInt()) {
			data.add(scan.nextInt());
		}
		
		Integer nums[]= data.toArray(new Integer[0]);
		
		int index = random.nextInt(nums.length);
		System.out.println("The generated index is "+index);
		System.out.println("The value of the array at the generated index "+nums[index]);
		
		scan.close();
	}

}
