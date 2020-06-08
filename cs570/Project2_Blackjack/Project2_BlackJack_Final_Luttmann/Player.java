/**
* @author Will Luttmann
* @version 1.0
* cs570 Project 2	Final Draft Code
*
*/
import java.util.ArrayList;


public abstract class Player{
	protected double cash;
	protected ArrayList<Card> hand;
	Player(){
		hand = new ArrayList<Card>();
	}

	/**
	* returns player's cash
	* @param null
	* @return cash
	*
	*/
	public double getCash(){
		return cash;
	}

	/**
	* sets cash to value of c
	* @param c
	* @return void
	*
	*/
	public void setCash(double c){
		cash = c;
	}

	/**
	* adds card object to players hand arraylist
	* @param c
	* @return void
	*
	*/
	public void setHand(Card c){
		hand.add(c);
	}

	/**
	* returns the length of the hand arraylist
	* @param null
	* @return hand.size
	*
	*/
	public int getHandSize(){
		return hand.size();
	}

	/**
	* returns the sum of the cards with blackjack rank weights
	* @param null
	* @return sum
	*
	*/
	public int getHandTotal(){
		int sum =0;
		int rank;

		for(Card c : hand){
			rank = c.getRank();

			switch(rank){
				case 0:
					if(sum<=10 )
						sum+=11;
					else
						sum+=1;
					break;
				case 1:
					sum+=2;
					break;
				case 2:
					sum+=3;
					break;
				case 3:
					sum+=4;
					break;
				case 4:
					sum+=5;
					break;
				case 5:
					sum+=6;
					break;
				case 6:
					sum+=7;
					break;
				case 7:
					sum+=8;
					break;
				case 8:
					sum+=9;
					break;
				case 9:
				case 10:
				case 11:
				case 12:
					sum+=10;
					break;
				default:
					sum+=0;
			}
		}

		return sum;
	
	}

	/**
	* prints the cards in hand
	* @param null
	* @return void
	*
	*/
	public void showHand(){
		for(int i =0; i <=  hand.size()-1;i++){
			hand.get(i).showCard();
		}
	}

	/**
	* removes the first card in hand and returns the card object
	* @param null
	* @return hand.get(0)
	*
	*/
	public Card discard(){
		return hand.remove(0);
	}

}