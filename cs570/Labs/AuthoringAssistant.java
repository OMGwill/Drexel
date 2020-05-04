import java.util.Scanner;
import java.util.regex.Pattern;

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

	public static int  getNumOfNonWSCharacters(String words){
		int count=0;

		for(int i=0;i<words.length();i++){
			if(words.charAt(i) != ' ')
				count++;
		}

		return count;
	}

	public static int getNumOfWords(String words){
		int count=0;

		for(int i=0;i<words.length();i++){
			if(words.charAt(i) == ' ' && words.charAt(i+1) != ' ')
				count++;
		}

		count+=1;

		return count;
	}

	public static int findText(String text, String words){
		 int count = 0;
		 int endSubstring = 0;

		 while(endSubstring!=-1){
		 	endSubstring = words.indexOf(text,endSubstring);

		 	if(endSubstring!=-1){
		 		count++;
		 		endSubstring+=text.length();
		 	}

		 }


		return count;
	}

	public static String replaceExclamation(String words){
		String replaced = "";

		for(int i=0; i<words.length();i++){
			if (words.charAt(i) == '!')
				replaced += ".";
			else
				replaced += words.charAt(i);
		}

		return replaced;
	}

	public static String shortenSpace(String words){
		String deSpaced = "";

		deSpaced = words.replaceAll("\\s+", " ");

		return deSpaced;
	}

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String userString;
      String menuOption="";
      String findWord;

      System.out.println("Enter a sample text:");
      userString = scnr.nextLine();
      //userString = "We'll continue our quest in space.  There will be more shuttle flights and more shuttle crews and,  yes,  more volunteers, more civilians,  more teachers in space.  Nothing ends here;  our hopes and our journeys continue!";
      //userString = "         There are  too  many    spaces    here.     Why?     ";
      System.out.println();

      System.out.println("You entered: " + userString);
      System.out.println();

      do{
      	printMenu();
      	menuOption=scnr.nextLine();

      	if(menuOption.equalsIgnoreCase("c")){
      		System.out.println("Number of non-whitespace characters: " + getNumOfNonWSCharacters(userString));
      		System.out.println();
      	}
      	if(menuOption.equalsIgnoreCase("w")){
      		System.out.println("Number of words: " + getNumOfWords(userString));
      		System.out.println();
      	}
      	if(menuOption.equalsIgnoreCase("f")){
      		System.out.println("Enter a word or phrase to be found:");
      		findWord=scnr.nextLine();
      		System.out.println("\"" + findWord + "\" instances: "+findText(findWord,userString));
      		System.out.println();
      	}
      	if(menuOption.equalsIgnoreCase("r")){
      		System.out.println("Edited text: " + replaceExclamation(userString));
      		System.out.println();
      	}
      	if(menuOption.equalsIgnoreCase("s")){
      		System.out.println("Edited text: " + shortenSpace(userString));
      		System.out.println();
      	}

      } while (!menuOption.equalsIgnoreCase("q")); 
      


   }//end main
}//end class
