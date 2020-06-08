/**
* @author Will Luttmann
* @version 1.0
* cs570 Project 2	Final Draft Code
*
*/
public class Card{
	private int rank;
	private int suit;
	private String color;
	private String [] suits= {"Hearts","Diamonds","Clubs","Spades"};
	private String [] ranks= {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};

	Card(int s, int r){
		suit = s;
		rank = r;
	}

	/**
	* returns the rank as int
	* @param null
	* @return rank
	*
	*/
	public int getRank(){
		return rank;
	}

	/**
	* sets rank to the value of r
	* @param r
	* @return void
	*
	*/
	public void setRank(int r){
		rank = r;
	}

	/**
	* returns the suit as int
	* @param null
	* @return suit
	*
	*/
	public int getSuit(){
		return suit;
	}

	/**
	* sets suit to the value of s
	* @param s
	* @return void
	*
	*/
	public void setSuit(int s){
		suit = s;
	}

	/**
	* returns color of card
	* @param void
	* @return color
	*
	*/
	public String getColor(){
		return color;
	}

	/**
	* sets color to the value of c
	* @param c
	* @return void
	*
	*/
	public void setColor(String c){
		color = c;
	}

	/**
	* prints the name of the card's rank and suit
	* @param null
	* @return void
	*
	*/
	public void showCard(){
		int r = getRank();
		int s = getSuit();

		System.out.println(ranks[r]+" of "+suits[s]);
	}
}
