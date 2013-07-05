package jp.hutcraft.addr.service.impl;

import jp.hutcraft.addr.service.AddressBookService;

import org.seasar.extension.unit.S2TestCase;

public class AddressBookServiceImplTest extends S2TestCase {

	private AddressBookService service;
	private MockAccountDao accountDao;
	
	public AddressBookServiceImplTest(String arg0) {
		super(arg0);
	}
	
	protected void setUp() throws Exception {
		include("servicetest.dicon");
	}
	
	public void testRegister() {
		service.register("hoge", "hoge");
		service.register("hello", "world");
		service.register("<>!@#$%^&*()_+{}|:", "loooooooooooooooooooooooooooooooooooooooooooooooooong");
		assertEquals(3, accountDao.accounts.size());
		try {
			service.register("a", "");
			fail("expects IllegalArgumentException");
		} catch(final IllegalArgumentException e) {
			// OK
		}
		try {
			service.register("a", null);
			fail("expects IllegalArgumentException");
		} catch(final IllegalArgumentException e) {
			// OK
		}
		try {
			service.register("", "a");
			fail("expects IllegalArgumentException");
		} catch(final IllegalArgumentException e) {
			// OK
		}
		try {
			service.register(null, "a");
			fail("expects IllegalArgumentException");
		} catch(final IllegalArgumentException e) {
			// OK
		}
	}
	
	public void testIsValid() {
		assertTrue(service.isValid("a", "a"));
		assertTrue(service.isValid("hellllllllllllllllllllo", "woooooooooooooooooooold"));
		assertTrue(service.isValid("hey hey", "hey hey"));
		assertTrue(service.isValid(" hey hey ", " hey hey "));
		assertFalse(service.isValid("a", ""));
		assertFalse(service.isValid("a", " "));
		assertFalse(service.isValid("a", "  "));
		assertFalse(service.isValid("a", null));
		assertFalse(service.isValid("", "a"));
		assertFalse(service.isValid(" ", "a"));
		assertFalse(service.isValid("  ", "a"));
		assertFalse(service.isValid(null, "a"));
	}
	
	public void testFindAll() {
		service.register("orange", "orange");
		service.register("melon", "green");
		service.register("apple", "red");
		service.register("lemon", "yellow");
		service.register("banana", "yellow");
		assertEquals("apple", service.findAll().get(0).getName());
		assertEquals("banana", service.findAll().get(1).getName());
		assertEquals("lemon", service.findAll().get(2).getName());
		assertEquals("melon", service.findAll().get(3).getName());
		assertEquals("orange", service.findAll().get(4).getName());
	}
}
