package bnym.casestudy.service;

import java.util.List;

import bnym.casestudy.entity.Winner;



public interface WinnerService {
	
	public List<Winner>getAllWinners();
	public Winner getWinnerById(Long id);
	public boolean saveWinner(Winner winner);
	public boolean deleteWinnerById(Long id);

}
