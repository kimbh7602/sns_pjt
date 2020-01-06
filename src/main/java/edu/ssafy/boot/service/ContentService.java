package edu.ssafy.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.dto.ContentVo;
import edu.ssafy.boot.repository.IContentDAO;

@Service("ContentService")
public class ContentService implements IContentService {
	
	@Autowired
	@Qualifier("ContentDAOImpl")
	IContentDAO dao;

	@Override
	public List<ContentVo> contentMyList(String user_id) {
		// TODO Auto-generated method stub
		return dao.contentMyList(user_id);
	}
	
}
