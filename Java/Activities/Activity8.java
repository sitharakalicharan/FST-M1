package activities;


class CustomException extends Exception{

	private String message;
	
	CustomException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Activity8.exceptionTest("This is a sentence");
			Activity8.exceptionTest(null); // Exception is thrown here
            Activity8.exceptionTest("Won't execute");
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	static public void exceptionTest(String str) throws CustomException {
		if(str==null) {
			throw new CustomException("String is empty"); // this initializes the constructor
		}
		else {
			System.out.println(str);
		}
		
	}

}
