/**
* @author Will Luttmann
* @version 1.0
* cs570 Project 2	Final Draft Code
*
*/
import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack{
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Double> userBets = new ArrayList<Double>();
		int numUsers;
		double playerBet;
		char playerAction;
		char playAgain = 'y';


		//initializes and shuffles deck of 52 playable cardes
		Deck deck = new Deck();

		//enters non dealer players
		System.out.println("How many users are playing?");
		numUsers = scnr.nextInt();

		for(int i=0;i<=numUsers-1;i++){
			users.add(new User(i+1));
			}

			System.out.println(users.size() + " users playing.");

		//init dealer with deck
		Dealer dealer = new Dealer(deck);

		//enter starting cash for each user
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

		//confirmation of cash
		for(int i=0;i<=users.size()-1;i++){
			System.out.printf("User%d has $%.2f%n",users.get(i).getUserNum(),users.get(i).getCash()); 
		}

		//loop while play again is true
		while(playAgain!='n'){
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

			//bets
			System.out.println("Users, place your bets!");
			System.out.println("=======================");

			for(int i=0;i<=users.size()-1;i++){
				System.out.printf("User%d has $%.2f%n",users.get(i).getUserNum(),users.get(i).getCash());
			}


			for(int i=0;i<=users.size()-1;i++){
				System.out.printf("User%d, enter bet $",users.get(i).getUserNum());
				playerBet = scnr.nextDouble();
				users.get(i).placeBet(playerBet);
				userBets.add(playerBet);
			}

			//bet confirmation
			System.out.println();
			for(int i=0;i<=users.size()-1;i++){
				System.out.printf("User%d bet $%.2f",users.get(i).getUserNum(),users.get(i).getCurrentBet());
				System.out.println();
			}
			System.out.println();
			System.out.println();

			//deal cards
			System.out.println("Dealing Cards...");
			System.out.println("=======================");
			System.out.println();

			if(deck.getNumPlayable()<=10)
				deck.shuffle();
			
			for(int i=0;i<=users.size()-1;i++){
				dealer.deal(users.get(i));
				System.out.printf("User%d has:%n",users.get(i).getUserNum());
				users.get(i).showHand();
				System.out.println();
			}


			dealer.deal(dealer);
			System.out.print("***Dealer has the ");
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
			System.out.print("***Dealer is delt a card face down");
			System.out.println();
			System.out.println();
			//end deal cards

			//hit or stad
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

				if (users.get(i).getHandTotal()>21)
					System.out.println("***BUSTED***");
				if (users.get(i).getHandTotal()==21)
					System.out.println("***BLACKJACK***");
				System.out.println();
				System.out.println();
			}


			//hand totals
			System.out.println("Round Totals");
			System.out.println("=======================");
			System.out.println();
			for(int i=0;i<=users.size()-1;i++){
				System.out.printf("User%d's hand total:%d%n",users.get(i).getUserNum(),users.get(i).getHandTotal());
				users.get(i).showHand();
				System.out.println();
			}

			//dealer hit or stand
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


			//declare winnings
			for(int i=0;i<=users.size()-1;i++){

				if(users.get(i).getHandTotal() > 21){
					System.out.printf("User%d loses %.2f%n",users.get(i).getUserNum(),userBets.get(i));
				}else{

					if(dealer.getHandTotal()<=21){
						if(users.get(i).getHandTotal() > dealer.getHandTotal()){
							System.out.printf("User%d wins %.2f%n",users.get(i).getUserNum(),userBets.get(i));
							users.get(i).setCash(users.get(i).getCash()+(userBets.get(i)*2.0));
						}
						if(users.get(i).getHandTotal() == dealer.getHandTotal()){
							System.out.printf("User%d ties and keeps %.2f%n",users.get(i).getUserNum(),userBets.get(i));
							users.get(i).setCash(users.get(i).getCash()+(userBets.get(i)));
						}
						if(users.get(i).getHandTotal() < dealer.getHandTotal()){
							System.out.printf("User%d loses %.2f%n",users.get(i).getUserNum(),userBets.get(i));
						}
					}
					if(dealer.getHandTotal()>21){
						if(users.get(i).getHandTotal() <=21){
							System.out.printf("User%d wins %.2f%n",users.get(i).getUserNum(),userBets.get(i));
							users.get(i).setCash(users.get(i).getCash()+(userBets.get(i)*2.0));
						}
					}
				}

			}

			//wipe current bets
			while(userBets.size()>0)
				userBets.remove(0);
			

			System.out.println();
			System.out.println();
				

			//discard used cards
			System.out.println("Discarding...");
			System.out.println("=======================");
			System.out.println();

			for(int i=0;i<=users.size()-1;i++){
				while(users.get(i).getHandSize()!=0){
					dealer.discardCard(users.get(i));
				}
				
			}

			while(dealer.getHandSize()!=0){
					dealer.discardCard(dealer);
				}


			//play again prompt
			System.out.println("Play Again? y/n");
			playAgain = scnr.next().charAt(0);
		}


		//end game printout
		System.out.println("Game Ending...");
		System.out.println("=======================");
		System.out.println();

		for(int i=0;i<=users.size()-1;i++){
			System.out.printf("User%d leaves the table with $%.2f%n",users.get(i).getUserNum(),users.get(i).getCash());
		}


	}
}