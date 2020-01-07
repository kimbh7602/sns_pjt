package edu.ssafy.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.repository.IFollowDAO;

@Service("FollowService")
public class FollowService implements IFollowService {

	@Autowired
	@Qualifier("FollowDAOImpl")
	IFollowDAO dao;
}
