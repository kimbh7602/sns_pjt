package edu.ssafy.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.repository.ICommentDAO;

@Service("CommentService")
public class CommentService implements ICommentService {

	@Autowired
	@Qualifier("CommentDAOImpl")
	ICommentDAO dao;
}
