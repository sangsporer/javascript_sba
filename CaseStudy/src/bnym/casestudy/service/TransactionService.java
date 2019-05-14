package bnym.casestudy.service;

import java.util.List;

import bnym.casestudy.entity.Transaction;



public interface TransactionService {
	
	public List<Transaction>getAllTransactions();
	public Transaction getTransactionById(Long id);
	public boolean saveTransaction(Transaction transaction);
	public boolean deleteTransactionById(Long id);

}
