package com.korupt.cards;

/**
 * This class stores all the debit card information and it extends 'Card' class.
 * @author saurav.kumar
 *
 */
public class DebitCard extends Card {
	private long accountLinked;
	private static final int MAX_WITHDRAWAL_LIMIT = 10000;
	
	/**
	 * This is constructor for 'DebitClass' which will first call constructor of 'Card' class.
	 * @param cardNo	Unique card number provided to each card.
	 * @param contact	Contact number of card holder.
	 * @param panNo		PAN number of card holder.
	 * @param holderName	Name of the card holder.
	 * @param accountLinked	Account to which debit card is linked.
	 */
	public DebitCard(long cardNo, int contact, String panNo, String holderName, long accountLinked) {
		super(cardNo, contact, panNo, holderName);
		this.accountLinked = accountLinked;
	}

	/**
	 * Getter method to retrieve value of 'accountLinked' property of 'DebitCard' class.
	 * @return account number to which a particular debit card is linked.
	 */
	public long getAccountLinked() {
		return accountLinked;
	}
}
