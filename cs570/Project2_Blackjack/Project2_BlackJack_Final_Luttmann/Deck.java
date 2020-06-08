/**
* @author Will Luttmann
* @version 1.0
* cs570 Project 2	Final Draft Code
*
*/
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> playableCards = new ArrayList<Card>();
	private ArrayList<Card> discardPile = new ArrayList<Card>();
	private Card card;

	Deck(){
		for(int i=0;i<=3;i++){
			for(int j =0;j<=12;j++){
				playableCards.add(new Card(i,j));
			}
		}
		System.out.println("Deck Created");

		System.out.println("Number of Playable Cards: " + getNumPlayable());

		shuffle();

		System.out.println("Deck ready to play!");
	}

	/**
	* adds discarded cards to playable cards and shuffles playable cards
	* @param null
	* @return void
	*
	*/
	public void shuffle(){
		System.out.println("Deck Shuffling...");
		while(discardPile.size()>0)
			playableCards.add(discardPile.remove(0));
		
		Collections.shuffle(playableCards);
	}

	/**
	* removes top card from playable cards and returns the card object
	* @param null
	* @return card
	*
	*/
	public Card dealCard(){
		card = playableCards.remove(0);
		return card;
	}

	/**
	* returns the number of playable cards
	* @param null
	* @return playableCards.size
	*
	*/
	public int getNumPlayable (){
		return playableCards.size();
	}

	/**
	* adds card object to discard pile
	* @param c
	* @return void
	*
	*/
	public void discard(Card c){
		discardPile.add(c);
	}

	/**
	* testing purposes: prints the length of playable cards and discarded cards
	* @param null
	* @return void
	*
	*/
	public void showPileSize(){
		System.out.println("playableCards has "+playableCards.size()+" cards");
		System.out.println("discardPile has "+discardPile.size()+" cards");
	}
}