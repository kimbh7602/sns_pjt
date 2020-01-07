package edu.ssafy.boot.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ScrapDAOImpl")
public class ScrapDAOImpl implements IScrapDAO {

	@Autowired
	SqlSession session;
}
