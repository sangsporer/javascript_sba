package bnym.casestudy.service;

import java.util.List;

import bnym.casestudy.entity.Scholarship;



public interface ScholarshipService {
	
	public List<Scholarship>getAllScholarships();
	public Scholarship getScholarshipById(Long id);
	public boolean saveScholarship(Scholarship scholarship);
	public boolean deleteScholarshipById(Long id);

}
