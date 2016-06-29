/*
 * Author: Teemu Matvejeff
 */

package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import service.FizzBuzzPrint;
import service.FizzBuzzService;
import ui.UserInterface;


public class FizzBuzzTest {

	private FizzBuzzPrint fizzBuzzPrint;
	private FizzBuzzService fizzBuzzService;
	private UserInterface userInterface;
	private ByteArrayOutputStream outContent;

	
	@Before
	public void setUpBeforeClass() throws Exception {
		fizzBuzzPrint = new FizzBuzzPrint();
		fizzBuzzService = new FizzBuzzService();
		userInterface = new UserInterface();
		
		outContent = new ByteArrayOutputStream();
	}

	@Test
	public void fizzBuzzPrintConstructorWorks() {
		assertNotNull("FizzBuzz-constructor doesn't work", fizzBuzzPrint);
	}
	
	@Test
	public void fizzBuzzServiceConstructorWorks() {
		assertNotNull("FizzBuzzService-constructor doesn't work", fizzBuzzService);
	}
	
	@Test
	public void userInterfaceConstructorWorks() {
		assertNotNull("UserInterface-constructor doesn't work", userInterface);
	}
	
	@Test
	public void correctNumbers() {
		int number_of_indices = fizzBuzzPrint.getNumbers().length;
		
		assertEquals("There is either too many or too few indices", 100, number_of_indices);
	}
	
	@Test
	public void checkRandomIndex() {
		int index = (int) Math.ceil(Math.random()*100);
		int value = fizzBuzzPrint.getNumbers()[index];
		
		assertEquals("Index is always supposed to be value-1.", value, index+1);
	}

	@Test
	public void doesContainNumber_1() {
		boolean contains;
		
		contains = fizzBuzzService.doesContainNumber(3, 3);
		
		assertEquals("3 contains 3.", true, contains);
	}
	
	@Test
	public void doesContainNumber_2() {
		boolean contains;
		
		contains = fizzBuzzService.doesContainNumber(6, 3);
		
		assertEquals("6 doesn't contain number 3", false, contains);
	}
	
	@Test
	public void doesContainNumber_3() {
		boolean contains;
		
		contains = fizzBuzzService.doesContainNumber(25, 5);
		
		assertEquals("25 contains number 5", true, contains);
	}
	
	@Test
	public void doesContainNumber_4() {
		boolean contains;
		
		contains = fizzBuzzService.doesContainNumber(99, 5);
		
		assertEquals("99 doesn't contain 5", false, contains);
	}
	
	@Test
	public void fizzTest_1() {
		int stage = 1;
				
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(3, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible with 3.", "Fizz", s);
	}
	
	@Test
	public void fizzTest_2() {
		int stage = 1;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(13, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number isn't divisible by either 3 or 5.", "13", s);
	}
	
	
	@Test
	public void fizzTest_3() {
		int stage = 2;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(13, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number isn't divisible by either 3 or 5, but contains 3.", "Fizz", s);
	}
	
	@Test
	public void fizzTest_4() {
		int stage = 1;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(6, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible with 3.", "Fizz", s);
	}
	
	@Test
	public void fizzTest_5() {
		int stage = 2;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(6, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible with 3 but doesn't contain or be divisible by number 5.", "Fizz", s);
	}
	
	@Test
	public void buzzTest_1() {
		int stage = 1;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(5, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible by 5.", "Buzz", s);
	}
	
	@Test
	public void buzzTest_2() {
		int stage = 2;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(5, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible by 5 and has number 5 in it (but doesn't contain or be divisible by 3).", "Buzz", s);
	}
	
	@Test
	public void buzzTest_3() {
		int stage = 1;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(85, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible by 5.", "Buzz", s);
	}
	
	@Test
	public void buzzTest_4() {
		int stage = 2;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(85, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible by 5 (but doesn't contain or be divisible by 3).", "Buzz", s);
	}
	
	@Test
	public void buzzTest_5() {
		int stage = 1;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(95, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible by 5 but not 3.", "Buzz", s);
	}
	
	@Test
	public void buzzTest_6() {
		int stage = 1;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(65, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible by 5 but not 3.", "Buzz", s);
	}
	
	@Test
	public void fizzBuzzTest_1() {
		int stage = 1;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(53, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number isn't divisible by either both 3 or 5", "53", s);
	}
	
	@Test
	public void fizzBuzzTest_2() {
		int stage = 2;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(53, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number isn't divisible by either both 3 or 5 but contains both numbers", "FizzBuzz", s);
	}
	
	@Test
	public void fizzBuzzTest_3() {
		int stage = 1;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(15, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible by both 3 and 5", "FizzBuzz", s);
	}
	
	@Test
	public void fizzBuzzTest_4() {
		int stage = 2;
		System.setOut(new PrintStream(outContent));
		
		fizzBuzzPrint.printMessage(60, stage);
		String s = outContent.toString();
		s = s.replace("\n", "").replace("\r", "");
		
		assertEquals("Number is divisible by both 3 and 5", "FizzBuzz", s);
	}
}
