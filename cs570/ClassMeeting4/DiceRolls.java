/*
//Class Exercise Program (only one this week, so make it good!)

Write a small program that has methods and excellent documentation.
It will be a simple dice rolling program
The user can enter the type of dice to roll: d4 is a 4 sided die and returns 1, 2, 3, or 4 while d20 is a 20 sided die and returns 1-20 inclusive. If they enter 2d6, they want to roll a d6 twice. 
Gracefully deal with bad input, such as negative numbers or use of letters other than d
Use methods for each die (common die are d4, d6, d8, d10, d12, and d20) OR one method that will work for all dice
Use a recursive method when asked to roll a die multiple times (Extra credit) or a loop for normal credit.
Output the request and the result.
Run a full suite of test cases in main while developing. Comment them out, so we can see how you did it and run them again. 

Example:
2d12
I rolled 2 d12â€™s and the result is 15

*/

import java.util.Scanner;
import java.util.regex.Pattern;


public class DiceRolls{

	//@param userInput (numDice)d(numFaces)
	//@returns if the input is valid, d6, 2d8 5d20 ....
	//@returns false for invalid input -3d5, 0d6, d-99
	public static boolean isValidInput(String userInput){
			if(Pattern.matches("^([1-9]+\\d*)?[d](([2-9])+|([1-9]\\d+))+$", userInput))
			//if(Pattern.matches("^[1-9]?^([1-9]\\d*)?[d][2-9]$([1-9]\\d+)?$", userInput))
				return true;
			else
				return false;

	}

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		String input;

/* start test cases	
		

		input = "3d";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "-3d";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "d";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "0d";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "10d";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "100d";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "-100d";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "d0";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "d-1";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "-d1";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "-d2";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "-d3";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "-d10";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "%d100";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "2d-100";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "4d6-";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "3d-8";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "1d-12";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "d2";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "d3";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "d10";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "d100";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "2d100";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "4d6";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "3d8";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "1d12";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		input = "0d12";
		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

end test cases*/

		System.out.print("Enter dice to roll (use standard dice naming convention): ");
		input = scnr.next();

		while(!isValidInput(input)){
			scnr.nextLine();
			System.out.print("Invaid input. Please type something like 2d6, d20, 3d4: ");
			input=scnr.next();

			System.out.println();
			System.out.println();
		}


		System.out.println("CONTINUE...");
		System.out.println();
		System.out.println();

	}//end main

}//end class