package com.ge.exercise3;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

	Bank bank;

	@Before
	public void setUp() {
		bank = new Bank();
	}

	@Test
	public void addAccountTest() {
		Account account = new Account("001");
		bank.addAccount(account);
		assertEquals(1, bank.numAccounts());
	}

	@Test
	public void getAccountTest() {
		Account account = new Account("002", "Checking", 100.0f);
		bank.addAccount(account);
		assertEquals(account, bank.getAccount("002"));
	}

	@Test
	public void depositToAccountTest() {
		Account account = new Account("003", "Checking", 100.0f);
		bank.addAccount(account);
		bank.depositToAccount("003", 100.0f);
		assertEquals(200.0f, account.getBalance(), 0.01);
	}

	@Test
	public void withdrawFromAccountTest() {
		Account account = new Account("004", "Checking", 100.0f);
		bank.addAccount(account);
		bank.withdrawFromAccount("004", 100.0f);
		assertEquals(0.0f, account.getBalance(), 0.01);
	}

	@Test
	public void preventOverdrawn100FromAccountTest() {
		Account account = new Account("004", "Checking", 80.0f);
		bank.addAccount(account);
		boolean isPrevent = bank.withdrawFromAccount("004", 100.0f);
		assertEquals(isPrevent, false);
	}

	@Test
	public void preventOverdrawnMoreThan100FromAccountTest() {
		Account account = new Account("004", "Checking", 80.0f);
		bank.addAccount(account);
		boolean isPrevent = bank.withdrawFromAccount("004", 190.0f);
		assertEquals(isPrevent, true);
	}

	@Test
	public void preventNegativeBalanceFromAccountTest() {
		Account account = new Account("004", "Savings", 80.0f);
		bank.addAccount(account);
		boolean isPrevent = bank.withdrawFromAccount("004", 81.0f);
		assertEquals(isPrevent, true);
	}

	@Test
	public void calculateProfitFromAccountTest() {
		Account account = new Account("004", "Checking", 100.0f);
		bank.addAccount(account);
		bank.withdrawFromAccount("004", 50.0f);
		account.setMonthlyFee(10);
		account.setMonthlyInterestRate(10.0f);
		boolean profit = bank.calculateProfitOrLoss();
		assertEquals(profit, true);
	}
	
	@Test
	public void calculateLossFromAccountTest() {
		Account account = new Account("004", "Checking", 100.0f);
		bank.addAccount(account);
		bank.withdrawFromAccount("004", 50.0f);
		account.setMonthlyFee(5);
		account.setMonthlyInterestRate(10.0f);
		boolean profit = bank.calculateProfitOrLoss();
		assertEquals(profit, false);
	}
	
	@Test
	public void accountTotalCurrentHoldingsFromAccountTest() {
		Account account = new Account("004", "Checking", 100.0f);
		bank.addAccount(account);
		bank.withdrawFromAccount("004", 50.0f);
		account.setMonthlyFee(5);
		account.setMonthlyInterestRate(10.0f);
		double sum = bank.accountTotalCurrentHoldings(account.getAccountType());
		assertEquals(50.0f, sum, 0.01);
	}
	
	@Test
	public void totalCurrentHoldingsFromAccountTest() {
		Account account = new Account("004", "Checking", 100.0f);
		bank.addAccount(account);
		bank.withdrawFromAccount("004", 50.0f);
		Account account2 = new Account("005", "Checking", 100.0f);
		bank.addAccount(account2);
		bank.withdrawFromAccount("004", 50.0f);
		double sum = bank.totalCurrentHoldings();
		assertEquals(100.0f, sum, 0.01);
	}
}
