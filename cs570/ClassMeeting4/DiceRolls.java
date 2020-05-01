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
import java.util.Random;

public class DiceRolls{
	//private random num gen for dice rolls
	private static final Random rgen = new Random();


	//@param userInput (numDice)d(numFaces)
	//@returns if the input is valid, d6, 2d8 5d20 ....
	//@returns false for invalid input -3d5, 0d6, d-99
	public static boolean isValidInput(String userInput){
			if(Pattern.matches("^([1-9]+\\d*)?[d](([2-9])+|([1-9]\\d+))+$", userInput))
				return true;
			else
				return false;

	}

	//@param userInput (numDice)d(numFaces)
	//@returns number of dice to roll
	public static int parseNumDice(String userInput){
		String numDiceStr = "";
		int numDice = 0;

		for(int i=0;i<userInput.length();i++){
			if (userInput.charAt(i)!='d')
				numDiceStr += userInput.charAt(i);
			else 
				break;
		}

		if (numDiceStr.equals(""))
			numDice = 1;
		else
			numDice = Integer.parseInt(numDiceStr);
		
		return numDice;
	}

	//@param userInput (numDice)d(numFaces)
	//@returns number of dice faces
	public static int parseDiceFaces(String userInput){
		String numFacesStrReverse = "";
		String numFacesStr ="";
		int numFaces = 0;

		for(int i=userInput.length()-1;i >= 0;i--){
			if (userInput.charAt(i)!='d')
				numFacesStrReverse += userInput.charAt(i);
			else 
				break;
		}

		for(int i=numFacesStrReverse.length()-1;i >= 0;i--){
			numFacesStr += numFacesStrReverse.charAt(i);
		}

			numFaces = Integer.parseInt(numFacesStr);
		
		return numFaces;
	}


	//@param dice is the number of rolls set in main
	//@param faces is the number of faces of the dice, used to set random number scope
	//@uses private rgen
	//no @return but this method prints to System.out
	public static void genRolls(int dice, int faces){ 
		
		if(dice == 1)
			System.out.print((rgen.nextInt(faces) + 1) + " ");
		else{
			genRolls(dice-1,faces);
			System.out.print((rgen.nextInt(faces) +1) +" ");
		}

	}

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		String input;
		int numDice;
		int numFaces;
		String keepRolling ="y";

// start input test cases	
		

// 		input = "3d";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "-3d";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "d";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "0d";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "10d";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "100d";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "-100d";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "d0";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "d-1";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "-d1";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "-d2";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "-d3";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "-d10";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "%d100";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "2d-100";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "4d6-";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "3d-8";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "1d-12";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "d2";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "d3";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "d10";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "d100";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "2d100";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "4d6";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "3d8";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

// 		input = "1d12";
// 		System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		// input = "0d12";
		// System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		// input = "2e12";
		// System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		// input = "2f12";
		// System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		// input = "2D12";
		// System.out.println("Is "+(input)+" valid: " + isValidInput(input));

		// input = "2d12";
		// System.out.println("Is "+(input)+" valid: " + isValidInput(input));


// end test cases

// parseNumDice test cases
		

// 		System.out.println("Test parseDiceFaces():");
		
// 		input ="d8";
// 		numDice= parseNumDice(input);
// 		System.out.println("numDice = d8: " + numDice);
// 		System.out.println();

// 		input ="1d8";
// 		numDice= parseNumDice(input);
// 		System.out.println("numDice = 1d8: " + numDice);
// 		System.out.println();		

// 		input ="2d8";
// 		numDice= parseNumDice(input);
// 		System.out.println("numDice = 2d8: " + numDice);
// 		System.out.println();

// 		input ="80d8";
// 		numDice= parseNumDice(input);
// 		System.out.println("numDice = 80d8: " + numDice);
// 		System.out.println();

// 		input ="5000d8" ;
// 		numDice= parseNumDice(input);
// 		System.out.println("numDice = 5000d8"  + numDice);
// 		System.out.println();


// end parseNumDice test cases 



//test parseDiceFaces
		// input ="2d2";
		// numFaces= parseDiceFaces(input);
		// System.out.println("numFaces = 2d2: " + numFaces);

		// input ="4d4";
		// numFaces= parseDiceFaces(input);
		// System.out.println("numFaces = 4d4: " + numFaces);

		// input ="5d8";
		// numFaces= parseDiceFaces(input);
		// System.out.println("numFaces = 5d8: " + numFaces);

		// input ="d20";
		// numFaces= parseDiceFaces(input);
		// System.out.println("numFaces = d20: " + numFaces);

		// input ="12d100";
		// numFaces= parseDiceFaces(input);
		// System.out.println("numFaces = 12d100: " + numFaces);

//end test parseDiceFaces


//test genRolls
		// System.out.println("testing 2d6");
		// genRolls(2,6);
		// System.out.println();

		// System.out.println("testing 1d4");
		// genRolls(1,4);
		// System.out.println();

		// System.out.println("testing 5d20");
		// genRolls(5,20);
		// System.out.println();

		// System.out.println("testing 10d20");
		// genRolls(10,20);
		// System.out.println();

		// System.out.println("testing 5d100");
		// genRolls(5,100);
		// System.out.println();

		// System.out.println("testing 50d100");
		// genRolls(50,100);
		// System.out.println();

//end test genRolls


//  actual main

		do{
			//get input from user, specifily ask for input if incorrect
			System.out.print("Enter dice to roll (use standard dice naming convention): ");
			input = scnr.nextLine();

			while(!isValidInput(input)){;
				System.out.print("Invaid input. Please type something like 2d6, d20, 3d4: ");
				input=scnr.nextLine();

				System.out.println();
				System.out.println();
			}

			//set numDice
			numDice = parseNumDice(input); 

			//set numFaces
			numFaces = parseDiceFaces(input);

			//print what the user rolls
			if (numDice == 1)
				System.out.print("You rolled a d" + numFaces +": ");
			else
				System.out.print("You rolled " + numDice +" d"+ numFaces +"'s: ");
			//calls recursive method to execute the dice roll  (method prints to console)
			genRolls(numDice,numFaces);
			System.out.println();
			System.out.println();

			//roll again prompt
			System.out.println("Roll again? y/n");
			keepRolling=scnr.nextLine();

			while (!keepRolling.equalsIgnoreCase("y") && !keepRolling.equalsIgnoreCase("n")){
				System.out.println("Please enter 'y' to keep rolling or 'n' to quit (without quotes)");
				keepRolling=scnr.nextLine();
			}

			System.out.println();
			System.out.println();
			
		}while(keepRolling.equalsIgnoreCase("y"));	
		


// end actual main 

	}//end main

}//end class