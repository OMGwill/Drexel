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

	public int getRank(){
		return rank;
	}

	public void setRank(int r){
		rank = r;
	}

	public int getSuit(){
		return suit;
	}

	public void setSuit(int s){
		suit = s;
	}

	public String getColor(){
		return color;
	}

	public void setColor(String c){
		color = c;
	}

	public void showCard(){
		int r = getRank();
		int s = getSuit();

		System.out.println(ranks[r]+" of "+suits[s]);
	}
}
