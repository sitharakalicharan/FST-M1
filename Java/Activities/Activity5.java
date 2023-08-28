package activities;

abstract class Book {
	String title;

	abstract void setTitle(String s);

	String getTitle() {
		return title;
	}

}

class MyBook extends Book {


	@Override
	void setTitle(String s) {
		// TODO Auto-generated method stub
		
		title = s;
	}
	
	

}
public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyBook newNovel = new MyBook();
		newNovel.setTitle("Catch22");
		System.out.println("The title of the book is " + newNovel.getTitle());

	}

}


