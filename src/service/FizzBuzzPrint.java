/*
 * Author: Teemu Matvejeff
 */

package service;

// Class for printing FizzBuzz-messages
public class FizzBuzzPrint {

	private int[] numbers;
	private FizzBuzzService fizzBuzzService;

	public FizzBuzzPrint() {
		numbers = new int[100];
		fizzBuzzService = new FizzBuzzService();
		numbers = fizzBuzzService.setTable(numbers);
	}

	public int[] getNumbers() {
		return numbers;
	}

	// Print whole FizzBuzz-rhyme
	public void fizzBuzzRhyme(int stage) {
		for (int number : numbers) {
			printMessage(number, stage);
		}
	}

	// Print one part of FizzBuzz-rhyme.
	public void printMessage(int number, int stage) {
		boolean fizz = false;
		boolean buzz = false;
		
		if(stage == 1) {
			fizz = fizzBuzzService.isFizzStage_1(number);
			buzz = fizzBuzzService.isBuzzStage_1(number);
		} else if (stage == 2) {
			fizz = fizzBuzzService.isFizzStage_2(number);
			buzz = fizzBuzzService.isBuzzStage_2(number);
		}
		
		if (fizz && !buzz) {
			System.out.println("Fizz");
		} else if (!fizz && buzz) {
			System.out.println("Buzz");
		} else if (fizz && buzz) {
			System.out.println("FizzBuzz");
		} else {
			System.out.println(number);
		}
	}
}
