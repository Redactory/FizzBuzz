/*
 * Author: Teemu Matvejeff
 */

package service;

// Class, that offers services for actual funtionality (printing FizzBuzz-message)
public class FizzBuzzService {

	public FizzBuzzService() {
		
	}
	
	// Initialize the number table.
	public int[] setTable(int[] numbers) {
		for (int i = 1; i < 101; i++) {
			numbers[i - 1] = i;
		}

		return numbers;
	}
	
	// Method for checking if number has wanted number in it
	public boolean doesContainNumber(int number, int wanted_number) {
		String string_number = Integer.toString(number);
		String string_wanted = Integer.toString(wanted_number);
		
		if (string_number.contains(string_wanted)) {
			return true;
		} else {
			return false;
		}
	}
	
	// Test if number is Fizz at stage 1.
	public boolean isFizzStage_1(int number) {		
		if (number % 3 == 0) {
			return true;
		} else {
			return false;
		}
		
		
	}	
	
	// Test if number is Buzz at stage 1.
	public boolean isBuzzStage_1(int number) {
		if (number % 5 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// Test if number is Fizz at stage 2.
	public boolean isFizzStage_2(int number) {
		if (number % 3 == 0 || doesContainNumber(number, 3)) {
			return true;
		} else {
			return false;
		}
		
		
	}	
	
	// Test if number is Buzz at stage 2.
	public boolean isBuzzStage_2(int number) {
		if (number % 5 == 0 || doesContainNumber(number, 5)) {
			return true;
		} else {
			return false;
		}
	}
}
