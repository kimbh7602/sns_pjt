package edu.ssafy.boot.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.ContentVo;

@Repository("ContentDAOImpl")
public class ContentDAOImpl implements IContentDAO {

	@Autowired
	SqlSession session;
	
	@Override
	public List<ContentVo> contentMyList(String user_id) {
		// TODO Auto-generated method stub
		return session.selectList("ssafy.content.selectMyList", user_id);
	}

}
