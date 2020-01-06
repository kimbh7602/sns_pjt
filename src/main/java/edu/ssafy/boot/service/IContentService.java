package edu.ssafy.boot.service;

import java.util.List;

import edu.ssafy.boot.dto.ContentVo;

public interface IContentService {
	public List<ContentVo> contentMyList(String user_id);
}
