package com.capgemini.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.beans.Account;
import com.capgemini.beans.Options;

public class AccountDAOImpl implements AccountDAO {

	private Map<Integer, Account> accountDetails;

	public AccountDAOImpl() {

		accountDetails = new TreeMap<>();

		Account account1 = new Account();
		account1.setId(1);
		account1.setBalance(4000);
		account1.setName("Akash");

		accountDetails.put(account1.getId(), account1);

		Account account2 = new Account();
		account2.setId(2);
		account2.setBalance(4000);
		account2.setName("Suhas");

		accountDetails.put(account2.getId(), account2);

		Account account3 = new Account();
		account3.setId(3);
		account3.setBalance(4000);
		account3.setName("Mahesh");

		accountDetails.put(account3.getId(), account3);

		Account account4 = new Account();
		account4.setId(4);
		account4.setBalance(4000);
		account4.setName("Suresh");

		accountDetails.put(account4.getId(), account4);

	}

	@Override
	public List<Account> findAll() {
//Set s=accountDetails.keySet(); 
		List<Account> accounts = new ArrayList<>(accountDetails.values());
		return accounts;
	}

	@Override
	public List<Account> sortAccountDetails(Options option) {
		List<Account> accounts = new ArrayList<>(accountDetails.values());

		if (option == Options.byName) {

			class CustomComparator implements Comparator<Account> {
				@Override
				public int compare(Account o1, Account o2) {
					return o1.getName().compareTo(o2.getName());
				}
			}

			Collections.sort(accounts, new CustomComparator());

		} else if (option == Options.byId) {
			class CustomComparator implements Comparator<Account> {

				@Override
				public int compare(Account o1, Account o2) {
					return o1.getId() -  o2.getId();
				}
			}

			Collections.sort(accounts, new CustomComparator());

		}

		return accounts;
	}

	
	@Override
	public boolean create(Account newAccount) {
	
		Account accountRef;
		accountRef = accountDetails.putIfAbsent(newAccount.getId(), newAccount);
	
		if(accountRef == null)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(int id) {
		Account a=accountDetails.remove(id);
		if(a==null)
			return false;
		System.out.println();
		System.out.println(a+" Deleted");
		return true;
	}

	@Override
	public boolean update(int id, Account account) {
		Account a=accountDetails.put(id, account);
		System.out.println(a);
		return true;
	}

	@Override
	public Account findById(int id) {
		Account a=accountDetails.get(id);
		if(a==null)
			return null;
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
