package com.capgemini.service;

import java.util.List;

import com.capgemini.beans.Account;
import com.capgemini.beans.Options;
import com.capgemini.dao.AccountDAO;
import com.capgemini.dao.AccountDAOImpl;

public class AccountServiceImpl implements AccountService{
	
	private AccountDAO daoRef = new AccountDAOImpl();
	
	@Override
	public List<Account> findAll() {
		List<Account> accounts = daoRef.findAll();
		return accounts; 
	}
	
	@Override
	public List<Account> sortAccountDetails(Options option) {
		return daoRef.sortAccountDetails(option);
	}
	
	@Override
	public boolean create(Account newAccount) {
		return daoRef.create(newAccount);
	}

	@Override
	public boolean delete(int id) {
		
		return daoRef.delete(id);
	}

	@Override
	public boolean update(int id, Account account) {
		// TODO Auto-generated method stub
		return daoRef.update(id, account);
	}

	@Override
	public Account findById(int id) {
		return daoRef.findById(id);
	}
	
	
	
}
