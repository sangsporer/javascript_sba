package bnym.casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bnym.casestudy.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
