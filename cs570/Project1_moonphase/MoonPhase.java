//Will Luttmann
//cs570 Project 1		First Draft Code

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class MoonPhase{

	//************GLOBAL*************
	public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	//seed for know new moon date/time from https://www.space.com/18880-moon-phases.html
	public static final LocalDateTime dateSeed = LocalDateTime.parse("2020-01-24 16:42:00", dateFormat);

	//from https://minkukel.com/en/various/calculating-moon-phase/
	public static final double lunarCycle = 29.53058770576;

	//all possible phases of moon
	public static enum PHASE{
		NEW_MOON,WAXING_CRESCENT,FIRST_QUARTER,WAXING_GIBBOUS,FULL_MOON,WANING_GIBBOUS,THIRD_QUARTER,WANING_CRESCENT,UNKOWN;
	}
	//********END GLOBAL*************

	//**********METHODS**************
	//formats date to humanreadable
	public static String formatDate(LocalDateTime d){
		return d.format(dateFormat);
	}

	//print welcome method
	public static void printWelcome(LocalDateTime d){
		int age = getMoonAge(d);

		System.out.println("Hello! Today is " + formatDate(d));
		System.out.println("The moon age since last New Moon is: " + age);
		System.out.println("The moon's phase is: " + getMoonPhase(age));
	}

	//gets moon age regardless of past/present/future dates
	public static int getMoonAge (LocalDateTime d){
		Duration dateDiff = Duration.between(dateSeed,d);
		long daysDiff = dateDiff.toDays(); 

		if(daysDiff >=0)
			return (int)(daysDiff % lunarCycle);
		else
			return (int)(lunarCycle + (daysDiff % lunarCycle));
	}

	//outputs moonphase according to age
	public static String getMoonPhase(int moonAge){
		switch(moonAge){
			case 0: return PHASE.NEW_MOON.toString();
			case 1: 
			case 2: 
			case 3: 
			case 4:  
			case 5: 
			case 6: return PHASE.WAXING_CRESCENT.toString();
			case 7: return PHASE.FIRST_QUARTER.toString();
			case 8: 
			case 9: 
			case 10: 
			case 11: 
			case 12: 
			case 13: 
			case 14: return PHASE.WAXING_GIBBOUS.toString();
			case 15: return PHASE.FULL_MOON.toString();
			case 16:  
			case 17: 
			case 18: 
			case 19: 
			case 20:
			case 21: return PHASE.WANING_GIBBOUS.toString();
			case 22: return PHASE.THIRD_QUARTER.toString();
			case 23:  
			case 24: 
			case 25: 
			case 26: 
			case 27: 
			case 28: 
			case 29: return PHASE.WANING_CRESCENT.toString();
			default: return PHASE.UNKOWN.toString();
		} 
	}

	//todo:
	//add method to prompt user to input a date
	//add method to return ascii art for each phase
	//add method to return sun sign - param(given date)
	//**if theres time** add method to calculate mo0n sign - param (given date and time)

	//******END METHODS**************

	//start main
	public static void main(String[] args){
		//create date/time object from right now -- testing specific times
		LocalDateTime currDate = LocalDateTime.now();
		LocalDateTime testDateFuture = LocalDateTime.parse("2020-05-04 15:04:00",dateFormat);
		LocalDateTime testDatePast = LocalDateTime.parse("2018-05-04 15:04:00",dateFormat);
		LocalDateTime myBirthday = LocalDateTime.parse("1990-11-05 06:28:00",dateFormat);
		int theMoonAge;
		String theMoonPhase;


		//test compute moon age -- given test dates
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<TEST CASES>>>>>>>>>>>>>>>>>>>>");

		theMoonAge=getMoonAge(currDate);
		theMoonPhase=getMoonPhase(theMoonAge);	
		System.out.println("current moon age: " + theMoonAge + "\nPhase: " + theMoonPhase);
		System.out.println();

		theMoonAge=getMoonAge(testDateFuture);
		theMoonPhase=getMoonPhase(theMoonAge);
		System.out.println("May 4 2020 age: " + theMoonAge + "\nPhase: " + theMoonPhase);
		System.out.println();

		theMoonAge=getMoonAge(testDatePast);
		theMoonPhase=getMoonPhase(theMoonAge);
		System.out.println("May 4 2018 age: " + theMoonAge + "\nPhase: " + theMoonPhase);
		System.out.println();
		
		theMoonAge=getMoonAge(myBirthday);
		theMoonPhase=getMoonPhase(theMoonAge);
		System.out.println("my birthday age: " + theMoonAge + "\nPhase: " + theMoonPhase);
		System.out.println();

		//test lunar calendar from current time
		System.out.println();
		System.out.println();

		System.out.println("<<<<<<<<<<Testing full lunar calendar>>>>>>>>>>>>>");
		for(int i=0;i<32;i++){
			currDate =LocalDateTime.now().plusDays(i);
			theMoonAge=getMoonAge(currDate);
			theMoonPhase=getMoonPhase(theMoonAge);

			System.out.println("Date: " + formatDate(currDate));
			System.out.println("Moon age: " + theMoonAge);
			System.out.println("Moon Phase: " + theMoonPhase);
			System.out.println();


		}

		System.out.println("<<<<<<<<End testing full lunar calendar>>>>>>>>>>>");

		//end compute moon age -- given test dates
		System.out.println("<<<<<<<<<<<<<<<<<<<<<END TEST CASES>>>>>>>>>>>>>>>>>>");
		System.out.println();
		System.out.println();



		//print welcome message
		currDate = LocalDateTime.now();
		printWelcome(currDate);

	}//end main
}//end class