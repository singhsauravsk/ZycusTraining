package com.zycus.banking;

/**
 * This class will take care of all the types of transactions/
 * @author saurav.kumar
 *
 */
public class Transaction {
	private Branch branch;
	private static final int MINIMUM_AMOUNT = 1000;

	public Transaction(Branch branch) {
		super();
		this.branch = branch;
	}
	
	/**
	 * Withdraw method will withdraw a particular amount from a account and also update the new amount.
	 * @param accountNumber		Withdrawing account
	 * @param amount			Withdrawing amount
	 * @return		String indicating message according to withdrawing status.
	 */
	public String withdraw(long accountNumber, double amount) {
		Account account = branch.getAccount(accountNumber);
		
		if(account == null) {
			return "Transaction failed because there is no account linked with this account number";
		}
		else {
			double temp = account.getAmount() - amount;
		
			if(account.getStatus() == Status.CLOSED) {
				return "Your account is closed";
			}
			else if(account.getAmount() <= MINIMUM_AMOUNT) {
				return "You have insufficient balance";
			}
			else if(temp < MINIMUM_AMOUNT) {
				return "You have insufficient balance";
			}
			else {
				account.setAmount(temp);
				return "Transcation Successful";
			}
		}
	}
	
	/**
	 * It will deposit a given amount to the specified account
	 * @param accountNumber		Depositing Account
	 * @param amount			Depositing Amount
	 * @return		String indication message according to deposit status.
	 */
	public String deposit(long accountNumber, double amount) {
		Account account = branch.getAccount(accountNumber);
		
		if(account == null) {
			return "Transaction failed because there is no account linked with this account number";
		}
		else {
			
			if(account.getStatus() == Status.CLOSED) {
				return "Your account is closed";
			}
			else {
				account.setAmount(account.getAmount()+amount);
				return "Transcation Successful";
			}
		}
	}
	
	/**
	 * This method will transfer given amount from source account to destination account.
	 * @param sourceAccountNumber		Account number of source account
	 * @param destinationAccountNumber	Account number of payee
	 * @param amount					Amount to be transferred
	 * @return							String indication message according to transferring status.
	 */
	public String transferFund(long sourceAccountNumber, long destinationAccountNumber, double amount) {
		Account sourceAccount = branch.getAccount(sourceAccountNumber);
		
		if(sourceAccount == null) {
			return "Transfer failed because there is no account linked with source account number";
		}
		else if(sourceAccount.getStatus() == Status.CLOSED){
			return "Source account is closed";
		}
		else {
			Account destinationAccount = branch.getAccount(destinationAccountNumber);
			
			if(destinationAccount == null) {
				return "Transfer failed because there is no account linked with destination account number";
			}
			else if(destinationAccount.getStatus() == Status.CLOSED){
				return "Destination account is closed";
			}
			else {
				String confirmationDeduction = withdraw(sourceAccountNumber, amount);
				
				if(confirmationDeduction == "You have insufficient balance") {
					return "Source account does not have sufficient balane";
				}
				else {
					return deposit(destinationAccountNumber, amount);
				}
			}
		}
	}
}
