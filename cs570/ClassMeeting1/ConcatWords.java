//Write a small program using String variables that asks the user 3 questions with
//one word answers. print all possible combinations of those 3 words

import java.util.Scanner;

public class ConcatWords {
	 public static void main(String []args){
	 	Scanner scnr = new Scanner(System.in);

	 	String word1;
	 	String word2;
	 	String word3;

	 	System.out.println("Favorite color? ");
	 	word1 = scnr.nextLine();

	 	System.out.println("Youngest sibling name? Use your own name if no siblings? ");
	 	word2 = scnr.nextLine();

	 	System.out.println("Favorite pizza topping? ");
	 	word3 = scnr.nextLine();

	 	System.out.println("\n");
	 	System.out.println("All possible combinations of words:");
	 	System.out.println(word1 + word2 + word3);
	 	System.out.println(word1 + word3 + word2);
	 	System.out.println(word2 + word1 + word3);
	 	System.out.println(word2 + word3 + word1);
	 	System.out.println(word3 + word1 + word2);
	 	System.out.println(word3 + word2 + word1);

	}
}
