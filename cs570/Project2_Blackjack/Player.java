import java.util.ArrayList;


public abstract class Player{
	double cash;
	ArrayList<Card> hand = new ArrayList<Card>();

	public double getCash(){
		return cash;
	}

	public void setCash(double c){
		cash = c;
	}

	public abstract int getHandTotal();

	public abstract String showHand();

}