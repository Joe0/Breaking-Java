package com.joepritzel.breakingj;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReturnTypeTest {

	@Test
	public void checkByteOutsideMaxBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final byte actual = rt.returnByteThatIsInt(Integer.MAX_VALUE);

		// Assert
		assertEquals(Integer.MAX_VALUE, actual);
	}

	@Test
	public void checkByteOutsideMinBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final byte actual = rt.returnByteThatIsInt(Integer.MIN_VALUE);

		// Assert
		assertEquals(Integer.MIN_VALUE, actual);
	}

	@Test
	public void checkByteInBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final byte actual = rt.returnByteThatIsInt(Byte.MAX_VALUE);

		// Assert
		assertEquals(Byte.MAX_VALUE, actual);
	}

	@Test
	public void checkCharOutsideMaxBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final char actual = rt.returnCharThatIsInt(Integer.MAX_VALUE);

		// Assert
		assertEquals(Integer.MAX_VALUE, actual);
	}

	@Test
	public void checkCharOutsideMinBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final char actual = rt.returnCharThatIsInt(Integer.MIN_VALUE);

		// Assert
		assertEquals(Integer.MIN_VALUE, actual);
	}

	@Test
	public void checkCharInBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final char actual = rt.returnCharThatIsInt(Byte.MAX_VALUE);

		// Assert
		assertEquals(Byte.MAX_VALUE, actual);
	}

	@Test
	public void checkShortOutsideMaxBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final short actual = rt.returnShortThatIsInt(Integer.MAX_VALUE);

		// Assert
		assertEquals(Integer.MAX_VALUE, actual);
	}

	@Test
	public void checkShortOutsideMinBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final short actual = rt.returnShortThatIsInt(Integer.MIN_VALUE);

		// Assert
		assertEquals(Integer.MIN_VALUE, actual);
	}

	@Test
	public void checkShortInBounds() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final short actual = rt.returnShortThatIsInt(Byte.MAX_VALUE);

		// Assert
		assertEquals(Byte.MAX_VALUE, actual);
	}

	@Test
	public void checkBooleanStoreNonZeroInt() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final boolean actualBoolean = rt.returnBooleanThatIsInt(Integer.MAX_VALUE);
		final int actual = rt.returnIntFromBoolean(actualBoolean);

		// Assert
		assertEquals(true, actualBoolean);
		assertEquals(Integer.MAX_VALUE, actual);
	}

	@Test
	public void checkBooleanStoreZeroInt() throws Exception {
		// Arrange
		final ReturnType rt = new ReturnType();

		// Act
		final boolean actualBoolean = rt.returnBooleanThatIsInt(0);
		final int actual = rt.returnIntFromBoolean(actualBoolean);

		// Assert
		assertEquals(false, actualBoolean);
		assertEquals(0, actual);
	}

}
