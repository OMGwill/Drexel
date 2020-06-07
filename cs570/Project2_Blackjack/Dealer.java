import java.util.ArrayList;

public class Dealer extends Player{

	private Deck deck;
	private Card cardDelt = null;

	Dealer(Deck d){
		deck = d;
	}




	public void deal(Player p){
		System.out.println("dealing...");
			cardDelt= deck.dealCard();
			cardDelt.showCard();
			p.setHand(cardDelt);
	}


}
 	