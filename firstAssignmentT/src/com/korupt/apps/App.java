package com.korupt.apps;

import java.util.Scanner;
import com.korupt.cards.Card;
import com.korupt.cards.CardType;
import com.korupt.cards.DebitCard;
import com.korupt.logics.CardStore;
import com.korupt.cards.CreditCard;
import com.korupt.logics.CardFactory;

public class App {
	private static CardStore stores = new CardStore();
	
	public static void main(String[] args) {
		stores.loadCards();
		
		while(menu()) {
			
		}
		stores.storeCards();
	}
	
	private static boolean menu() {
		String action = new String();
		Scanner scan = new Scanner(System.in);
		System.out.println("Select an operation : ");
		System.out.println("Enter 'A' to add new card");
		System.out.println("Enter 'F' to find card by card number");
		System.out.println("Enter 'L' to list cards by holder name");
		System.out.println("Enter 'Q' to quite application");
		action = scan.next();
		
		if(action.equalsIgnoreCase("A")) {
			addCard();
		}
		else if(action.equalsIgnoreCase("F")) {
			 findCard();
		}
		else if(action.equalsIgnoreCase("L")) {
			 listCards();
		}
		else {
			System.out.println("Are you sure to quit?(y/n)");
			action = scan.next();
			
			if(action.equalsIgnoreCase("y"))
				return false;
		}
		
		return true;
	}
	
	private static void addCard() {
		String cardType = new String();
		String surietyAddCard = new String();
		Scanner scan = new Scanner(System.in);
		CardFactory factory = new CardFactory();
		System.out.println("Enter the type of card you want to have.('d' for DEBIT/'c' for CREDIT)");
		cardType = scan.next();
		
		if(cardType.equalsIgnoreCase("d"))
			cardType = "DEBIT";
		else if(cardType.equalsIgnoreCase("c"))
			cardType = "CREDIT";
		else
			System.out.println("Not a card type");
		
		Card newCard = factory.issueNewCard(CardType.valueOf(cardType));
		System.out.println("Are you sure to add this card(y/n)");
		surietyAddCard = scan.next();
			
		if(surietyAddCard.equalsIgnoreCase("y"))
			stores.add(newCard);	
	}
	
	private static void findCard() {
		long cardNo;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter card number to be searched : ");
		cardNo = scan.nextLong();
		CardStore store = new CardStore();
		Card searchedCard =  store.searchByCardNo(cardNo);
		
		try {
		
			if(searchedCard instanceof DebitCard) {
				DebitCard dc = (DebitCard)searchedCard;
				System.out.print("Card Type : Debit, "+searchedCard.getHolderName()+","+searchedCard.getContact());
				System.out.println(","+searchedCard.getPanNo()+","+searchedCard.getCardNo()+","+dc.getAccountLinked());
			}
			else {
				CreditCard cc = (CreditCard)searchedCard;
				System.out.print("Card Type : Credit, "+searchedCard.getHolderName()+","+searchedCard.getContact());
				System.out.println(","+searchedCard.getPanNo()+","+searchedCard.getCardNo()+","+cc.getPointsAccumalated());
			}
		}catch(NullPointerException e) {
			System.out.println("Card Not Found");
		}
	}
	
	private static void listCards() {
		boolean flag = true;
		String name = new String();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name to be searched : ");
		name = scan.nextLine();
		CardStore store = new CardStore();
		Card searchedCards[] = store.findByHolderName(name);
		
		for(Card card: searchedCards) {
			
			if(card != null) {
				flag = false;
				
				if(card instanceof DebitCard) {
					DebitCard dc = (DebitCard)card;
					System.out.print("Card Type : Debit, "+card.getHolderName()+","+card.getContact());
					System.out.println(","+card.getPanNo()+","+card.getCardNo()+","+dc.getAccountLinked());
				}
				else {
					CreditCard cc = (CreditCard)card;
					System.out.print("Card Type : Credit, "+card.getHolderName()+","+card.getContact());
					System.out.println(","+card.getPanNo()+","+card.getCardNo()+","+cc.getPointsAccumalated());
				}
			}
		}
		
		if(flag)
			System.out.println("Card Not Found");
	}
}