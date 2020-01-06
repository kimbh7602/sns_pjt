package edu.ssafy.boot.repository;

import java.util.ArrayList;
import java.util.List;

import edu.ssafy.boot.dto.NoticeVo;

public interface INoticeDAO {
	public int noticeInsert(String ntitle, String ncontent);
	
	public List<NoticeVo> noticeList();
	
	public NoticeVo noticeInfo(int nid);
	
	public int noticeUpdate(int nid, String ntitle, String ncontent);
	
	public int noticeDelete(int nid);
	
	public List<NoticeVo> noticeSearch(String keyword);

	public int countUp(int nid);
}
