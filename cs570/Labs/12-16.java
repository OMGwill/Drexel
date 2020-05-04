import java.util.Scanner;

public class AuthoringAssistant {

	public static void printMenu(){
		System.out.println("MENU");
		System.out.println("c - Number of non-whitespace characters");
		System.out.println("w - Number of words");
		System.out.println("f - Find text");
		System.out.println("r - Replace all !'s");
		System.out.println("s - Shorten spaces");
		System.out.println("q - Quit");
		System.out.println("");
		System.out.println("Choose an option:");
	}

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String userString;
      String menuOption="";

      System.out.println("En ter a sample text:");
      userString = scnr.nextLine();
      System.out.println();

      System.out.println("You entered: " + userString);
      System.out.println();

      do{
      	printMenu();
      	menuOption=scnr.nextLine();

      } while (!menuOption.equalsIgnoreCase("q")); 
      


   }//end main
}//end class
