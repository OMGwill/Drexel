/**
* @author Will Luttmann
* @version 1.0
* cs570 Project 2	Final Draft Code
*
*/
import java.util.ArrayList;

public class User extends Player{

	private int userNum;
	private double currentBet;

	User(int num){
		userNum = num;
		System.out.println("User"+userNum+" created.");
	}

	/**
	* return user number
	* @param null
	* @return userNum
	*
	*/
	public int getUserNum(){
		return userNum;
	}

	/**
	* return current bet
	* @param null
	* @return currentBet
	*
	*/
	public double getCurrentBet(){
		return currentBet;
	}

	/**
	* place bet b and subtract from user's cash
	* @param b
	* @return void
	*
	*/
	public void placeBet(double b){
		currentBet = b;
		setCash(getCash() - currentBet);
	}

}
 	