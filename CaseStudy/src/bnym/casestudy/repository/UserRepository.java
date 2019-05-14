package bnym.casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bnym.casestudy.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
