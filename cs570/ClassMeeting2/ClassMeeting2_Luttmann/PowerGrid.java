//Will Luttmann
//cs570 week2

import java.util.Scanner;

public class PowerGrid {
	 public static void main(String []args){
	 	Scanner scnr = new Scanner(System.in);
	 	int x = -1;
	 	int y = -1;

	 	System.out.println("************************************************************************");
	 	System.out.println("*This program takes 2 positive integers and returns x^y in table format*");
	 	System.out.println("************************************************************************\n\n");
	 	System.out.println("Enter 2 positive integers for table x/y values");

	 	//error check input
	 	if(scnr.hasNextInt()){
		 	x = scnr.nextInt();
		 }if(scnr.hasNextInt()){
			y = scnr.nextInt();
		 }if(x > 0 && y > 0){

		}else{
		 	while(x <= 0 || y <= 0){
		 		System.out.println("Invalid input...\nEnter 2 positive integers for table x/y values");
		 		scnr.nextLine();
		 		if(scnr.hasNextInt()){
				 	x = scnr.nextInt();
				 }if(scnr.hasNextInt()){
				 	y = scnr.nextInt();
				 }if(x > 0 && y > 0){
				 	break;
				 }else{}
		 	}
		 }

		 //begin main code execution
		 for(int i=1;i<=x;i++){
			 	if(i == 1){
			 		System.out.printf("%-20s","");

		 			for(int j=1;j<=y;j++){
		 				System.out.printf("%-20s", "y="+j);
				 	}
				 	System.out.println();
				 	System.out.printf("%-20s","");
					 for(int j=1;j<=y;j++){
		 				System.out.printf("%-20s","____");
				 	}		
				}
		 	for(int j=1;j<=y;j++){
		 		if(j == 1){
		 			System.out.println();
		 			System.out.printf("%-20s", "x="+i+"|");
		 		}
		 		System.out.printf("%-20.0f", Math.pow(i,j));
		 	}
		 }
		 System.out.println("\n\nCheers!!!\n\n");
	 }
}

