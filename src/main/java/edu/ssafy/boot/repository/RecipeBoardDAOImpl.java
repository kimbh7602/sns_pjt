package edu.ssafy.boot.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.boot.dto.RecipeBoardVo;

@Repository("RecipeBoardDAOImpl")
public class RecipeBoardDAOImpl implements RecipeBoardDAO {

	@Autowired
	SqlSession session;

	@Override
	public RecipeBoardVo findOne(int rbid) {
		return session.selectOne("ssafy.recipeboard.findOne", rbid);
	}

	@Override
	public boolean recipeBoardInsert(RecipeBoardVo rbvo) {
		int insert = session.insert("ssafy.recipeboard.insert",rbvo);
		if(insert>0) {
			return true;
		}else 
		return false;
	}

	@Override
	public List<RecipeBoardVo> recipeBoardList() {
		return session.selectList("ssafy.recipeboard.selectList");
	}

	@Override
	public RecipeBoardVo recipeBoardInfo(int rbid) {
		return session.selectOne("ssafy.recipeboard.selectOne", rbid);
	}

	@Override
	public boolean recipeBoardUpdate(RecipeBoardVo rbvo) {
		int res = session.update("ssafy.recipeboard.update",rbvo);
		if(res>0) {
			return true; 
		}else 
		return false;
	}

	@Override
	public boolean recipeBoardDelete(String user_id, int rbid) {
		int res = session.delete("ssafy.recipeboard.delete",rbid);
		if(res>0) {
			return true;
		}else 
		return false;
	}

	@Override
	public List<RecipeBoardVo> boardSearch(String keyword) {
		List<RecipeBoardVo> list = new ArrayList<RecipeBoardVo>();
		list= session.selectList("ssafy.recipeboard.Search", keyword);
		return list;
	}

	@Override
	public boolean countUp(int rbid) {
		int res = session.update("ssafy.recipeboard.countUp",rbid);
		if(res>0)return true;
		else
		return false;
	}
	
	

}
