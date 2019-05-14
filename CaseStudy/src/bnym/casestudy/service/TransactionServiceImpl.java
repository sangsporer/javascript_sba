package bnym.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bnym.casestudy.entity.Transaction;
import bnym.casestudy.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository repository;

	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> list = new ArrayList<Transaction>();

		for (Transaction transaction : repository.findAll()) {
			list.add(transaction);
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Transaction getTransactionById(Long id) {
		Transaction transaction = repository.findById(id).get();
		return transaction;
	}

	@Override
	public boolean saveTransaction(Transaction transaction) {
		try {
			repository.save(transaction);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteTransactionById(Long id) {
		try {
			repository.deleteById(id);
			System.err.println("deleting");
			return true;
		} catch (Exception ex) {
			return false;
		}
	}


}
