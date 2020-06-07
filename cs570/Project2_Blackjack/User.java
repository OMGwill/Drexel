import java.util.ArrayList;

public class User extends Player{

	private int userNum;
	private double currentBet;

	User(int num){
		userNum = num;
		System.out.println("User"+userNum+" created.");
	}

	public int getUserNum(){
		return userNum;
	}

	public double getCurrentBet(){
		return currentBet;
	}

	public void placeBet(double b){
		currentBet = b;
		setCash(getCash() - currentBet);
	}


}
 	