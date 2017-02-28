package example.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreeterComponentTest {

	@Test
	public void testSaysHello() {
		String result = new GreeterComponent().sayHello("Bob");
		assertEquals("Hello Bob", result);
	}

}
