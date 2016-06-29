/*
 * Author: Teemu Matvejeff
 */

package ui;

import java.util.HashMap;
import java.util.Scanner;

import service.FizzBuzzPrint;

// A basic textual user interface for the application.
public class UserInterface {

	HashMap<String, String> choices;
	
	public UserInterface() {
		choices = new HashMap<String, String>();
				
		choices.put("1", "1");
		choices.put("2", "2");
		choices.put("3", "3");
		choices.put("4", "4");
	}
	
	public void checkInput() {
		FizzBuzzPrint fizzBuzzPrint = new FizzBuzzPrint();
		Scanner scanner = new Scanner(System.in);
		String answer = "";
		
		while (choices.get(answer) == null) {
			
			directions();
			answer = scanner.nextLine();

			if (answer.equals("1")) {
				System.out.println("STAGE 1 LISTING!\n");
				fizzBuzzPrint.fizzBuzzRhyme(1);

			} else if (answer.equals("2")) {
				System.out.println("STAGE 2 LISTING!\n");
				fizzBuzzPrint.fizzBuzzRhyme(2);

			} else if (answer.equals("3")) {
				System.out.println("STAGE 1 LISTING!\n");
				fizzBuzzPrint.fizzBuzzRhyme(1);

				System.out.println("\nSTAGE 2 LISTING!\n");
				fizzBuzzPrint.fizzBuzzRhyme(2);

			} else if (answer.equals("4")) {
				break;
				
			} else {
				System.out.println("You didn't give valid answer. Try again!");
				System.out.println("******************************************\n");
			}
		}
		
		scanner.close();
		
		System.out.println("Application run has ended!");
		
	}
	
	public void directions() {
		System.out.println("Do you want to print stage 1 solution, stage 2 solution or both?");
		System.out.println("If you want stage 1, input number '1' and press enter.");
		System.out.println("If you want stage 2, input number '2' and press enter.");
		System.out.println("If you want both, input number '3' and press enter.");
		System.out.println("If you want to exit, input number '4' and press enter.");
	}
}
