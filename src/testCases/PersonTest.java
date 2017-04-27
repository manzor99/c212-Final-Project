package testCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import market.Product;
import people.Buyer;
import people.Person;

public class PersonTest {

	@Test
	public void testGetIdNumber() {
		Person b = new Buyer(1, "Rocco", "rocco@gmail.com", "password", new ArrayList<Product>());
		assertEquals(1, b.getIdNumber());
	}

	@Test
	public void testSetIdNumber() {
		Person b = new Buyer(1, "Rocco", "rocco@gmail.com", "password", new ArrayList<Product>());
		b.setIdNumber(2);
		assertEquals(2, b.getIdNumber());
	}

	@Test
	public void testGetName() {
		Person b = new Buyer(1, "Rocco", "rocco@gmail.com", "password", new ArrayList<Product>());
		assertEquals("Rocco", b.getName());
	}

	@Test
	public void testSetName() {
		Person b = new Buyer(1, "Rocco", "rocco@gmail.com", "password", new ArrayList<Product>());
		b.setName("Ryan");
		assertEquals("Ryan", b.getName());
	}

	@Test
	public void testGetEmail() {
		Person b = new Buyer(1, "Rocco", "rocco@gmail.com", "password", new ArrayList<Product>());
		assertEquals("rocco@gmail.com", b.getEmail());
	}

	@Test
	public void testSetEmail() {
		Person b = new Buyer(1, "Rocco", "rocco@gmail.com", "password", new ArrayList<Product>());
		b.setEmail("ryan@gmail.com");
		assertEquals("ryan@gmail.com", b.getEmail());
	}

	@Test
	public void testGetPassword() {
		Person b = new Buyer(1, "Rocco", "rocco@gmail.com", "password", new ArrayList<Product>());
		assertEquals("password", b.getPassword());
	}

	@Test
	public void testSetPassword() {
		Person b = new Buyer(1, "Rocco", "rocco@gmail.com", "password", new ArrayList<Product>());
		b.setPassword("newpass");
		assertEquals("newpass", b.getPassword());
	}

	@Test
	public void testAddInventory() {
		Person b = new Buyer(1, "Rocco", "rocco@gmail.com", "password", new ArrayList<Product>());
		b.addInventory(null);
		assertEquals(1, b.getInventory().size());
	}

	@Test
	public void testGetInventory() {
		Person b = new Buyer(1, "Rocco", "rocco@gmail.com", "password", new ArrayList<Product>());
		assertEquals(0, b.getInventory().size());
	}

}
