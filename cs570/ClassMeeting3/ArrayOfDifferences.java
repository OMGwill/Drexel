//Will Luttmann
//cs570 ClassMeeting3 Exercise #2

import java.util.Random;


public class ArrayOfDifferences{
  public static void main(String[] args){
      //taken from class notes
      //2D Arrays of ints
      Random rgen = new Random();
      int size = 10;
      int[][] bactCount = new int[size][size];
      for(int row = 0; row < bactCount.length; row++){//num of rows
        for(int col = 0; col < bactCount[0].length; col++) {//num of cols
          bactCount[row][col] = rgen.nextInt(1000);
        }
      }
      //print the 2D array
      for(int row = 0; row < size; row++){
        for(int col = 0; col < size; col++) {
          System.out.print(bactCount[row][col] + " ");
        }
        System.out.println();
      }

      //find the average of bacteria
      int sum = 0;
      for(int row = 0; row < size; row++){
        for(int col = 0; col < size; col++) {
          sum += bactCount[row][col];
        }
      }
      System.out.println("The average bacterial load in a section is " + (double)sum / (size*size));

      //Exercise #2
      //Extend this part of the program to produce a second
      //2D array of the same size that will store the difference
      //in each cell from the average. Then output it.
      //end class notes

      System.out.println();
      System.out.println();
      System.out.println("The difference for each cell from the average: ");

      double bacAvg = (double)sum / (size*size);

      double[][] avgDiff = new double[size][size];
      for(int row = 0; row < avgDiff.length; row++){//num of rows
        for(int col = 0; col < avgDiff[0].length; col++) {//num of cols
          avgDiff[row][col] =  bactCount[row][col] - bacAvg;
          System.out.printf("%.2f ", avgDiff[row][col]);
        }
        System.out.println();
      }



  }//end main    
}//end class
