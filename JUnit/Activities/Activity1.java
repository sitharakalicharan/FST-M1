package activities;



import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Activity1 {
	
	static ArrayList<String> list;
	
	@BeforeAll
	static void setUp() throws Exception{
		
		list = new ArrayList<String>();
		
		list.add("alpha");
		list.add("beta");
		
	}
	
	@Test
	@Order(1)
	public void insertTest() {
		System.out.println("insertTest");
		
		assertEquals(2, list.size(), "Wrong size");
		list.add("gamma");
		assertEquals(3, list.size(), "Wrong size");
		
		assertEquals("alpha", list.get(0), "Wrong item");
		assertEquals("beta", list.get(1), "Wrong item");
		assertEquals("gamma", list.get(2), "Wrong item");
	}
	
	@Test
	@Order(2)
	public void replaceTest() {
		System.out.println("replaceTest");
		list.set(1, "omega");
		
		assertEquals(3, list.size(), "Wrong size");
		assertEquals("alpha", list.get(0), "Wrong item");
		assertEquals("omega", list.get(1), "wrong item");
		
		
	}
	
	

}
