package bnym.casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bnym.casestudy.entity.Scholarship;

@Repository
public interface ScholarshipRepository extends CrudRepository<Scholarship, Long> {

}
