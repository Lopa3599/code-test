package com.ge.exercise3;

import java.util.HashMap;
import java.util.Map;

public class Bank {

	private Map<String, Account> accountMap;

	public Bank() {
		accountMap = new HashMap<>();
	}

	public Account getAccount(String accountNumber) {
		return accountMap.get(accountNumber);
	}

	public void addAccount(Account account) {
		accountMap.put(account.getAccountNumber(), account);
	}

	public void depositToAccount(String accountNumber, float amount) {
		getAccount(accountNumber).deposit(amount);
	}

	public boolean withdrawFromAccount(String accountNumber, float amount) {

		boolean isPrevent = false;

		if (accountMap != null && accountMap.get(accountNumber) != null) {

			Account account = accountMap.get(accountNumber);

			if ("Checking".equalsIgnoreCase(account.getAccountType())) {

				isPrevent = addPreventOverdrawnCheckingAccount(account, amount);

			}

			if ("Savings".equalsIgnoreCase(account.getAccountType())) {

				isPrevent = preventNegativeBalanceSavingAccount(account, amount);
			}

			if (!isPrevent) {

				getAccount(accountNumber).withdraw(amount);
			}
		}

		return isPrevent;
	}

	public int numAccounts() {
		return accountMap.size();
	}

	public double accountTotalCurrentHoldings(String accountType) {

		double sum = 0.0;

		if (accountMap != null && accountType != null) {

			for (Map.Entry<String, Account> entry : accountMap.entrySet()) {

				Account account = entry.getValue();

				if (accountType.equalsIgnoreCase(account.getAccountType())) {

					sum = sum + account.getBalance();

				}

			}
		}

		return sum;
	}

	public double totalCurrentHoldings() {

		double sum = 0.0;

		if (accountMap != null) {

			for (Map.Entry<String, Account> entry : accountMap.entrySet()) {

				Account account = entry.getValue();

				sum = sum + account.getBalance();

			}
		}

		return sum;
	}

	public boolean calculateProfitOrLoss() {

		double collectedAmount = 0.0;

		double interestPaid = 0.0;

		if (accountMap != null) {

			for (Map.Entry<String, Account> entry : accountMap.entrySet()) {

				Account account = entry.getValue();

				collectedAmount = collectedAmount + account.getMonthlyFee();

				interestPaid = interestPaid + (account.getBalance() * account.getMonthlyInterestRate() / 100);

			}
		}

		boolean profit = false;

		if (collectedAmount - interestPaid > 0) {

			profit = true;
		}

		return profit;
	}

	private boolean addPreventOverdrawnCheckingAccount(Account account, double amount) {

		boolean isPrevent = false;

		if (account.getBalance() <= 0) {

			isPrevent = true;

		} else if (amount - account.getBalance() > 100) {

			isPrevent = true;

		}
		return isPrevent;
	}

	private boolean preventNegativeBalanceSavingAccount(Account account, double amount) {

		boolean isPrevent = false;

		if (account.getBalance() <= 0 || (account.getBalance() - amount) <= 0) {

			isPrevent = true;

		}

		return isPrevent;
	}
}
