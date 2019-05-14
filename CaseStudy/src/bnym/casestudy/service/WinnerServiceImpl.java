package bnym.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bnym.casestudy.entity.Winner;
import bnym.casestudy.repository.WinnerRepository;

@Service
@Transactional
public class WinnerServiceImpl implements WinnerService {
	
	@Autowired
	private WinnerRepository repository;

	@Override
	public List<Winner> getAllWinners() {
		List<Winner> list = new ArrayList<Winner>();

		for (Winner winner : repository.findAll()) {
			list.add(winner);
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Winner getWinnerById(Long id) {
		Winner winner = repository.findById(id).get();
		return winner;
	}

	@Override
	public boolean saveWinner(Winner winner) {
		try {
			repository.save(winner);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteWinnerById(Long id) {
		try {
			repository.deleteById(id);
			System.err.println("deleting");
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	
}
