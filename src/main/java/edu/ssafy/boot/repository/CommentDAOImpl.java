package edu.ssafy.boot.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("CommentDAOImpl")
public class CommentDAOImpl implements ICommentDAO {
	
	@Autowired
	SqlSession session;
}
