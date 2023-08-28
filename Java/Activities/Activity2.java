package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] array1 = {10, 77, 10, 54, -11, 10};
		int actual_sum =0;
		int expected_sum= 30;
		int num_to_find = 10;
		
		for(int i=0; i<array1.length; i++) {
			
			if(array1[i]==num_to_find) {
				actual_sum = actual_sum+array1[i];
			}
		}
		
		System.out.println("The actual sum is "+actual_sum);
		System.out.println("The result is "+ (actual_sum==expected_sum));

	}
	
	
}
