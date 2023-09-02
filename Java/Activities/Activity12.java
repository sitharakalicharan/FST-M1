package activities;

interface Addable{
	int add(int num1, int num2);
}

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Addable ad1= (a,b) -> (a+b);
		
		Addable ad2= (int a,int b) -> {
		return (a+b);
		};
		
		System.out.println(ad1.add(5, 9));
		
		System.out.println(ad2.add(1, 10));
	}

}
