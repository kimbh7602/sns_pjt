package edu.ssafy.boot.repository;

import java.util.List;

import edu.ssafy.boot.dto.ContentVo;

public interface IContentDAO {
	public List<ContentVo> contentMyList(String user_id);
}
