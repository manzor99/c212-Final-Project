package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import market.Product;

public class ProductTest {

	@Test
	public void testGetIDNumber() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		assertEquals(1, p.getIDNumber());
	}

	@Test
	public void testSetIdNumber() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		p.setIdNumber(99);
		assertEquals(99, p.getIDNumber());
	}
	//Product(int idNumber, int sellerId, int quantity, String name, String description, double price)
	@Test
	public void testGetSellerId() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		assertEquals(10, p.getSellerId());
	}

	@Test
	public void testGetQuantity() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		assertEquals(7, p.getQuantity());
	}

	@Test
	public void testSetQuantity() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		p.setQuantity(99);
		assertEquals(99, p.getQuantity());
	}

	@Test
	public void testGetName() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		assertEquals("item", p.getName());
	}

	@Test
	public void testSetName() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		p.setName("Rocco");
		assertEquals("Rocco", p.getName());
	}

	@Test
	public void testGetDescription() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		assertEquals("an item", p.getDescription());
	}

	@Test
	public void testSetDescription() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		p.setDescription("a new description");
		assertEquals("a new description", p.getDescription());
	}

	@Test
	public void testGetPrice() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		assertEquals((int)5.5, (int)p.getPrice());
	}

	@Test
	public void testSetPrice() {
		Product p = new Product(1, 10, 7, "item", "an item", 5.5);
		p.setPrice(10);
		assertEquals(10, (int)p.getPrice());
	}

}
