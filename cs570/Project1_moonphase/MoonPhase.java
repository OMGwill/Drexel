//Will Luttmann
//cs570 Project 1		First Draft Code

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MoonPhase{

	//all possible phases of moon
	enum PHASE{
		NEW_MOON,WAXING_CRESCENT,FIRST_QUARTER,WAXING_GIBBOUS,FULL_MOON,WANING_GIBBOUS,THIRD_QUARTER,WANING_CRESCENT;
	}

	//print welcome method
	public static void printWelcome(LocalDateTime date){
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		System.out.println("Hello! Today is " + date.format(dateFormat));
	}

	//start main
	public static void main(String[] args){
		//create date/time object from right now
		LocalDateTime currDate = LocalDateTime.now();

		//print welcome message
		printWelcome(currDate);

	}//end main
}//end class