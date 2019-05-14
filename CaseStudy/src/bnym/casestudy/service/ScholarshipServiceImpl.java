package bnym.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bnym.casestudy.entity.Scholarship;
import bnym.casestudy.repository.ScholarshipRepository;

@Service
@Transactional
public class ScholarshipServiceImpl implements ScholarshipService {
	
	@Autowired
	private ScholarshipRepository repository;

	@Override
	public List<Scholarship> getAllScholarships() {
		List<Scholarship> list = new ArrayList<Scholarship>();

		for (Scholarship scholarship : repository.findAll()) {
			list.add(scholarship);
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Scholarship getScholarshipById(Long id) {
		Scholarship scholarship = repository.findById(id).get();
		return scholarship;
	}

	@Override
	public boolean saveScholarship(Scholarship scholarship) {
		try {
			repository.save(scholarship);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteScholarshipById(Long id) {
		try {
			repository.deleteById(id);
			System.err.println("deleting");
			return true;
		} catch (Exception ex) {
			return false;
		}
	}


}
