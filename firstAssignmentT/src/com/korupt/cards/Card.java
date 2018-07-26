package com.korupt.cards;

import java.io.Serializable;

/**
 * 'Card' class will store common details of any type of cards.
 * It implements 'Serializable' so that we can directly store its object in .dat/.txt file;
 * @author saurav.kumar
 *
 */
public abstract class Card implements Serializable{
	private static final long serialVersionUID = 7140463647773286549L;
	private long cardNo;
	private int contact;
	private String panNo;
	private String holderName;
	
	/**
	 * This is constructor which will initialize object of Card class
	 * @param cardNo	Unique card number provided to each card.
	 * @param contact	Contact number of card holder.
	 * @param panNo		PAN number of card holder.
	 * @param holderName	Name of the card holder.
	 */
	public Card(long cardNo, int contact, String panNo, String holderName) {
		super();
		this.cardNo = cardNo;
		this.contact = contact;
		this.panNo = panNo;
		this.holderName = holderName;
	}
	
	public long getCardNo() {
		return cardNo;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
}
