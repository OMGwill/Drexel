/**
* @author Will Luttmann
* @version 1.0
* cs570 Project 2	Final Draft Code
*
*/
import java.util.ArrayList;

public class Dealer extends Player{

	private Deck deck;
	private Card cardDelt = null;

	Dealer(Deck d){
		deck = d;
	}



	/**
	* deals card to player p
	* @param p
	* @return void
	*
	*/
	public void deal(Player p){
		System.out.println("dealing...");
			cardDelt= deck.dealCard();
			//cardDelt.showCard();
			p.setHand(cardDelt);
	}

	/**
	* discards player p card
	* @param p
	* @return void
	*
	*/
	public void discardCard(Player p){
			System.out.print("discarding...");
				cardDelt=p.discard();
				deck.discard(cardDelt);
				cardDelt.showCard();
			System.out.println();
			
	}


}
 	