//Write a small program that has 3 numeric variables
//and averages them then print out the answer

import java.util.Scanner;

public class Averages {
	 public static void main(String []args){
	 	Scanner scnr = new Scanner(System.in);

	 	int num1;
	 	int num2;
	 	int num3;
	 	double avg;

	 	System.out.println("Type 3 integers separated by spaces: ");

	 	num1 = scnr.nextInt();
	 	num2 = scnr.nextInt();
	 	num3 = scnr.nextInt();

	 	avg = (num1 + num2 +num3) / 3;

	 	System.out.println("The average of your 3 numbers is " + avg);

	 }
}



