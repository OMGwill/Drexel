import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> playableCards = new ArrayList<Card>();
	private ArrayList<Card> dicardPile = new ArrayList<Card>();

	Deck(){
		for(int i=0;i<=3;i++){
			for(int j =0;j<=12;j++){
				playableCards.add(new Card(i,j));
			}
		}
		System.out.println("Deck Created");

		for(Card card : playableCards){
			card.showCard();
		}

		System.out.println("Number of Playable Cards: " + getNumPlayable());

		System.out.println("Deck Shuffling...");
		shuffle();

		System.out.println("Showing shuffled deck (hide later)");

		for(Card card : playableCards){
			card.showCard();
		}
	}


	public void shuffle(){
		Collections.shuffle(playableCards);
		Collections.shuffle(dicardPile);
	}

	public int getNumPlayable (){
		return playableCards.size();
	}
}