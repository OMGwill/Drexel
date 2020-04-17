//Will Luttmann
//cs570 week2

import java.util.Scanner;

public class Disemvowel {
	 public static void main(String []args){
	 	Scanner scnr = new Scanner(System.in);
	 	String name;
	 	StringBuilder singularName = new StringBuilder();
	 	StringBuilder noVowelName = new StringBuilder();

	 	System.out.print("Enter a name containing vowels: ");
	 	name = scnr.next();

	 	//drops double letters, ignoring first letter
	 	singularName.append(name.charAt(0));
	 	for(int i=1; i < name.length(); i++){
	 		if(Character.toLowerCase(name.charAt(i-1)) != Character.toLowerCase(name.charAt(i))){
	 			singularName.append(name.charAt(i));
	 		}
	 	}

	 	//drops vowels ignoring first letter
	 	noVowelName.append(singularName.charAt(0));
	 	for(int i=1; i < singularName.length(); i++){
	 		if(		singularName.charAt(i) == 'A' ||
	 				singularName.charAt(i) == 'a' ||
	 				singularName.charAt(i) == 'E' ||
	 				singularName.charAt(i) == 'e' ||
	 				singularName.charAt(i) == 'I' ||
	 				singularName.charAt(i) == 'i' ||
	 				singularName.charAt(i) == 'O' ||
	 				singularName.charAt(i) == 'o' ||
	 				singularName.charAt(i) == 'U' ||
	 				singularName.charAt(i) == 'u' ||
	 				singularName.charAt(i) == 'Y' ||
	 				singularName.charAt(i) == 'y' 
	 		){}else{
	 			noVowelName.append(singularName.charAt(i));
	 		}
	 	}

	 	//print disemvoweled name
	 	System.out.println(noVowelName);

	 }
}
