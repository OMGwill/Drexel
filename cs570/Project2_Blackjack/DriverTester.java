import java.util.ArrayList;
import java.util.Scanner;

public class DriverTester{
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Double> userBets = new ArrayList<Double>();
		int numUsers;
		double playerBet;
		char playerAction;

		// ArrayList<Card> deck = new ArrayList<Card>();

		// for(int i=0;i<=3;i++){
		// 	for(int j =0;j<=12;j++){
		// 		deck.add(new Card(i,j));
		// 	}
		// }


		// for(Card card : deck){
		// 	card.showCard();

		// }


		//initializes and shuffles deck of 52 playable cardes
		Deck deck = new Deck();

		System.out.println("How many users are playing?");
		numUsers = scnr.nextInt();

		for(int i=0;i<=numUsers-1;i++){
			users.add(new User(i+1));
			}

			System.out.println(users.size() + " users playing.");

			Dealer dealer = new Dealer(deck);


			for(int i=0;i<=users.size()-1;i++){
				System.out.println("How much cash does User"+(i+1)+" have?");
			try{
				users.get(i).setCash(scnr.nextDouble());
			}
			catch(IndexOutOfBoundsException e){
				System.out.println("Incorrect amount. Please enter a cash amount ex(5.00)");
				users.get(i).setCash(scnr.nextDouble());
			}
			
		}

		for(int i=0;i<=users.size()-1;i++){
			System.out.printf("User%d has $%.2f%n",users.get(i).getUserNum(),users.get(i).getCash()); 
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("================BLACKJACK================");

		System.out.println();
		System.out.println();
		System.out.println("Users, place your bets!");
		System.out.println("=======================");


		for(int i=0;i<=users.size()-1;i++){
			System.out.printf("User%d, enter bet $",users.get(i).getUserNum());
			playerBet = scnr.nextDouble();
			users.get(i).placeBet(playerBet);
			userBets.add(playerBet);
		}

		System.out.println();
		for(int i=0;i<=users.size()-1;i++){
			System.out.printf("User%d bet $%.2f",users.get(i).getUserNum(),users.get(i).getCurrentBet());
			System.out.println();
		}

		System.out.println();
		System.out.println();
		System.out.println("Dealing Cards...");
		System.out.println("=======================");
		System.out.println();
		
		for(int i=0;i<=users.size()-1;i++){
			dealer.deal(users.get(i));
			System.out.printf("User%d has:%n",users.get(i).getUserNum());
			users.get(i).showHand();
			System.out.println();
		}


		dealer.deal(dealer);
		System.out.print("Dealer has the ");
		dealer.showHand();
		System.out.println();
		System.out.println();

		for(int i=0;i<=users.size()-1;i++){
			dealer.deal(users.get(i));
			System.out.printf("User%d has:%n",users.get(i).getUserNum());
			users.get(i).showHand();
			System.out.println();
		}



		dealer.deal(dealer);
		System.out.print("Dealer is delt a card face down");
		System.out.println();
		System.out.println();

		System.out.println("Users, hit or stand!");
		System.out.println("=======================");
		System.out.println();

		for(int i=0;i<=users.size()-1;i++){
			System.out.printf("User%d's hand total:%d%n",users.get(i).getUserNum(),users.get(i).getHandTotal());
			users.get(i).showHand();
			System.out.println();

			while(users.get(i).getHandTotal()<21){
			System.out.printf("User%d - (h)it or (s)tand?%n",users.get(i).getUserNum());
				playerAction=scnr.next().charAt(0);
				if(playerAction == 'h'){
					dealer.deal(users.get(i));
					System.out.printf("User%d's hand total:%d%n",users.get(i).getUserNum(),users.get(i).getHandTotal());
					users.get(i).showHand();
					System.out.println();
				}
				if(playerAction == 's'){
					break;
				}
			}
			System.out.println();
			System.out.println();
		}


		System.out.println("Round Totals");
		System.out.println("=======================");
		System.out.println();
		for(int i=0;i<=users.size()-1;i++){
			System.out.printf("User%d's hand total:%d%n",users.get(i).getUserNum(),users.get(i).getHandTotal());
			users.get(i).showHand();
			System.out.println();
		}
		System.out.println("Dealers Turn");
		System.out.println("=======================");
		System.out.println();
		
			System.out.printf("Dealer's hand total:%d%n",dealer.getHandTotal());
			dealer.showHand();
			System.out.println();

			while(dealer.getHandTotal() < 17){
				dealer.deal(dealer);
				System.out.printf("Dealer's hand total:%d%n",dealer.getHandTotal());
				dealer.showHand();
				System.out.println();
			}
		
	}
}