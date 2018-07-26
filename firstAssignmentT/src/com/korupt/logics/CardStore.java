package com.korupt.logics;

import java.io.IOException;
import java.io.EOFException;
import com.korupt.cards.Card;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class contains all the issued card details in a array and that card list is loaded from 
 * .dat/.txt file.And also stores all the card in that particular file when program terminates.
 *  @author saurav.kumar
 *
 */
public class CardStore {
	private static int i = 0;
	private static Card[] cardList = new Card[100];
	private static final String CARD_PATH = "d:/data/cards.txt";
	
	/**
	 * This method will load all the cards from file to array.
	 */
	public void loadCards() {
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(CARD_PATH))) {
			Object ob = in.readObject();
			
			while(ob != null) {
				cardList[i++] = (Card) ob;
				ob = in.readObject();
			}
		}catch(EOFException e) {
			System.out.println("Currently there is no cards in database.");
		}catch(IOException e) { 
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will store all the card list to the file.
	 */
	public void storeCards() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CARD_PATH))) {
			
			for(Card card: cardList) {
				out.writeObject(card);
				out.flush();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This will add new issued card in 'CardFactory' class to the current array.
	 * @param card Object for new issued card
	 */
	public void add(Card card) {
		cardList[i++] = card;
	}
	
	public Card searchByCardNo(long cardNo) {
		
		for(Card card: cardList) {
			
			if(card != null && card.getCardNo() == cardNo) {
				return card;
			}
		}
		
		return null;
	}
	
	public Card[] findByHolderName(String name) {
		int index = 0;
		Card[] newList = new Card[100];
		
		for(Card card: cardList) {
			
			if(card != null && card.getHolderName().equalsIgnoreCase(name)) {
				newList[index++] = card;
			}
		}
		
		return newList;
	}
} 
