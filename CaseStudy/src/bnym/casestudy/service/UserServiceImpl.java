package bnym.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bnym.casestudy.entity.User;
import bnym.casestudy.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();

		for (User user : repository.findAll()) {
			list.add(user);
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public User getUserById(Long id) {
		User user = repository.findById(id).get();
		return user;
	}

	@Override
	public boolean saveUser(User user) {
		try {
			repository.save(user);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteUserById(Long id) {
		try {
			repository.deleteById(id);
			System.err.println("deleting");
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
