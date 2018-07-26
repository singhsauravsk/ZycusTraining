package com.korupt.cards;

/**
 * This class stores all the credit card information and it extends 'Card' class.
 * @author saurav.kumar
 *
 */
public class CreditCard extends Card {
	private int pointsAccumalated;
	private static final int CREDIT_LIMIT = 40000;
	private static final double INTEREST_RATE = 12.78d;
	private static final int FIRST_TIME_POINTS = 10000;
	
	/**
	 * This is constructor for 'CreditClass' which will first call constructor of 'Card' class.
	 * It also sets value for first time bonus points accumulated against a particular credit 
	 * card in 'pointsAccumalated' property of 'CreditCard' class.
	 * @param cardNo	Unique card number provided to each card.
	 * @param contact	Contact number of card holder.
	 * @param panNo		PAN number of card holder.
	 * @param holderName	Name of the card holder.
	 */
	public CreditCard(long cardNo, int contact, String panNo, String holderName) {
		super(cardNo, contact, panNo, holderName);
		this.pointsAccumalated = FIRST_TIME_POINTS;
	}

	/**
	 * Getter method to retrieve value of 'pointsAccumalated' property of 'CreditCard' class.
	 * @return total points accumulated against a particular credit card.
	 */
	public int getPointsAccumalated() {
		return pointsAccumalated;
	}

	/**
	 * Setter method to set value of 'pointsAccumalated' property of 'CreditCard' class.
	 * @param pointsAccumalated Stores total points accumulated against a particular credit card. It is of long type; 
	 */
	public void setPointsAccumalated(int pointsAccumalated) {
		this.pointsAccumalated = pointsAccumalated;
	}
}
