package edu.ssafy.boot.service;

import java.util.ArrayList;

import edu.ssafy.boot.dto.NoticeVo;

public interface INoticeService {
	public boolean deleteNotice(int nid);

	public boolean updateNotice(int nid, String ntitle, String ncontent);

	public NoticeVo infoNotice(int nid);

	public ArrayList<NoticeVo> listNotice();

	public boolean registerNotice(String ntitle, String ncontent);
	
	public ArrayList<NoticeVo> searchNotice(String keyword);

	public boolean countUp(int nid);
}
