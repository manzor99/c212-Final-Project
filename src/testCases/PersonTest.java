package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import people.Person;
import people.Buyer;

public class PersonTest {

	@Test
	public void testGetIdNumber() {
		Buyer person = new Buyer(1, "Rocco", "none@none.net", "notification");
		
		assertEquals(1, person.getIdNumber());
	}

	@Test
	public void testSetIdNumber() {
		Buyer person = new Buyer(1, "Rocco", "none@none.net", "notification");
		person.setIdNumber(7);
		
		assertEquals(7, person.getIdNumber());
	}

	@Test
	public void testGetName() {
		Buyer person = new Buyer(1, "Rocco", "none@none.net", "notification");
		
		assertEquals("Rocco", person.getName());
	}

	@Test
	public void testSetName() {
		Buyer person = new Buyer(1, "Rocco", "none@none.net", "notification");
		person.setName("Ryan");
		
		assertEquals("Ryan", person.getIdNumber());
	}

	@Test
	public void testGetEmail() {
		Buyer person = new Buyer(1, "Rocco", "none@none.net", "notification");
		
		assertEquals("none@none.net", person.getEmail());
	}

	@Test
	public void testSetEmail() {
		Buyer person = new Buyer(1, "Rocco", "none@none.net", "notification");
		person.setEmail("email");
		
		assertEquals("email", person.getEmail());
	}

	@Test
	public void testGetNotification() {
		Buyer person = new Buyer(1, "Rocco", "none@none.net", "notification");
		
		assertEquals("notification", person.getNotification());
	}

	@Test
	public void testSetNotification() {
		Buyer person = new Buyer(1, "Rocco", "none@none.net", "notification");
		person.setNotification("note");
		assertEquals("note", person.getIdNumber());
	}

}
