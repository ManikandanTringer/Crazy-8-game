package cardgame;

import java.util.*;
import cardgame.Card.*;

public class Game {
	public static void main(String[] args) {		
		int i,point1=0,point2=0;
		Card topCard;
		List<Card> cardDeck=new ArrayList<>();		
		cardDeck=Card.getDeck();
		Collections.shuffle(cardDeck);
		Player1 play1=new Player1();
		Player2 play2=new Player2();
		List<Card> player1=new ArrayList<>();
		List<Card> player2=new ArrayList<>();
		for(i=0;i<14;i++) {
			if(i%2==0)
				player2.add(cardDeck.get(0));
			else 
				player1.add(cardDeck.get(0));
			
			cardDeck.remove(0);			
		}
		topCard=cardDeck.get(0);
		cardDeck.remove(0);
		for(i=0;i<player1.size();i++) {
			System.out.print(player1.get(i).getRank()+" "+player1.get(i).getSuit()+" ");
		}
		System.out.println();
		for(i=0;i<player2.size();i++) {
			System.out.print(player2.get(i).getRank()+" "+player2.get(i).getSuit()+" ");
		}
		System.out.println();
		System.out.println("TopCard : "+topCard.getRank()+" "+topCard.getSuit());
		play1.receiveInitialCards(player1);
		play2.receiveInitialCards(player2);
		Card.Suit declaredCard=null;
		while(point1<200 && point2<200) {
			for(i=0;i<3;i++) {
				if(play2.shouldDrawCard(topCard, declaredCard)) {
					if(cardDeck.size()!=0) {
						play2.receiveCard(cardDeck.get(0));		
						cardDeck.remove(0);			
					}
				}
				else {
					topCard=play2.playCard();
					if(topCard.getRank()==Rank.EIGHT && play2.myCards.size()!=0) {
						declaredCard=play2.declareSuit();
					}
					break;
				}
			}
			for(i=0;i<3;i++) {
				if(play1.shouldDrawCard(topCard, declaredCard)) {
					if(cardDeck.size()!=0) {
						play1.receiveCard(cardDeck.get(0));	
						cardDeck.remove(0);
						
					}
				}
				else {
					topCard=play1.playCard();
					if(topCard.getRank().equals(Rank.EIGHT)&&play1.myCards.size()!=0) {
						declaredCard=play1.declareSuit();
					}
					break;
				}
			}
			if(play1.myCards.size()==0||cardDeck.size()==0) {
				point2+=play2.getScore();
				System.out.println("player2 :"+point2);
			}
			if(play2.myCards.size()==0||cardDeck.size()==0) {
				point1+=play1.getScore();
				System.out.println("player1 :"+point1);
			}
			if(cardDeck.size()==0) {
				cardDeck=Card.getDeck();
				Collections.shuffle(cardDeck);
			
			}
		}
		if(point1>=200) {
			System.out.println("player2 wins");
		}
		else if(point2>=200) {
			System.out.println("player1 wins");
		}
		
		
	}
}