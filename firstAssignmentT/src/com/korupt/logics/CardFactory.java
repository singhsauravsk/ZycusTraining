package com.korupt.logics;

import java.util.Scanner;
import com.korupt.cards.*;

/**
 * This is class which will generate unique card number and account number for 'DebitCard' and 'CreditCard'.
 * And also issue new card of any type.
 * @author saurav.kumar
 *
 */
public class CardFactory {
	private static long uniqueCardNo = System.currentTimeMillis();
	private static long uniqueAccountNo = System.currentTimeMillis() + 1234543l;
	
	/**
	 * This is method to issue new card of any type.
	 * This method will take all the necessary inputs from users and pass that
	 * values to the constructor of particular card type class to issue new card.
	 * @param cardType	Type of new card (CREDIT or DEBIT)
	 * @return Object of new card(That is object of 'Card' class).
	 */
	public Card issueNewCard(CardType cardType) {
		int contact;
		String panNo;
		String holderName;
		Scanner scan = new Scanner(System.in);
		long cardNo = uniqueCardNo;
		
		System.out.println("Enter Your Name :");
		holderName = scan.nextLine();
		System.out.println("Enter Your Contact Number : ");
		contact = scan.nextInt();
		System.out.println("Enter Your PAN Number : ");
		panNo = scan.next();
		
		if(cardType.name() == "DEBIT") {
			long accountLinked = uniqueAccountNo;
			return new DebitCard(cardNo, contact, panNo, holderName, accountLinked);
		}
		else if(cardType.name() == "CREDIT")
			return new CreditCard(cardNo, contact, panNo, holderName);
		else
			return null;
	}
}
