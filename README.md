Breaking-Java
=============

A project that shows odd things that can be done in Java or at least on the JVM.

To run it, first use the GenerateProjectJar class to create the JAR file to run the tests against.

Do you think the following test could ever pass? Keep in mind the max and min values for a byte.
```Java
@Test
public void checkByteOutsideMaxBounds() throws Exception {
	// Arrange
	final ReturnType rt = new ReturnType();

	// Act
	final byte actual = rt.returnByteThatIsInt(Integer.MAX_VALUE);

	// Assert
	assertEquals(Integer.MAX_VALUE, actual);
}
```
Well, normally it can't pass, because if returnByteThatIsInt's return type was an int, it would need to have a cast in the test. If the return type of returnByteThatIsInt is a byte, then it would typically need to be cast within that method, though if you omit the cast at the bytecode level, the JVM deals with it just fine, seeing it is internally represented as an int.

Within this project, there are many other oddities like this, that you would never think is possible, according to the JLS.