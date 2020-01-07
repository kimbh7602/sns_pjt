package edu.ssafy.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.repository.IUserDAO;

@Service("UserService")
public class UserService implements IUserService {

	@Autowired
	@Qualifier("UserDAOImpl")
	IUserDAO dao;
}
