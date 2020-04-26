//Will Luttmann
//cs570 ClassMeeting3 Exercise #1

import java.util.Scanner;

public class OneLoopAverage{
	public static void main(String [] args){
		Scanner scnr = new Scanner(System.in);
		int counter =0;
		double sum =0;
		double average = 0;

		System.out.println("Enter numbers to average, q to finish (ex. 1 2 3 q)");

		while (scnr.hasNextDouble()){
			sum += scnr.nextDouble();
			counter++;
		}

		System.out.println("Sum = " + sum);
		System.out.println("Number count = " + counter);

		average = sum/counter;

		System.out.println("The average is " + average);

	}
}
