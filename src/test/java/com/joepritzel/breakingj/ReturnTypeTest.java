package com.joepritzel.breakingj;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReturnTypeTest {

	@Test
	public void checkByteOutsideMaxBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final byte actual = rt.returnInt(Integer.MAX_VALUE);

		// Assert
		assertEquals(Integer.MAX_VALUE, actual);
	}

	@Test
	public void checkByteOutsideMinBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final byte actual = rt.returnInt(Integer.MIN_VALUE);

		// Assert
		assertEquals(Integer.MIN_VALUE, actual);
	}

	@Test
	public void checkByteOutsideInBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final byte actual = rt.returnInt(Byte.MAX_VALUE);

		// Assert
		assertEquals(Byte.MAX_VALUE, actual);
	}

}
