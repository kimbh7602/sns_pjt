package edu.ssafy.boot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import edu.ssafy.boot.dto.NoticeVo;
import edu.ssafy.boot.repository.INoticeDAO;
import edu.ssafy.boot.repository.NoticeDaoDBImpl;

@Service("NoticeService")
public class NoticeService implements INoticeService {
	@Autowired
	@Qualifier("NoticeDaoDBImpl")
	INoticeDAO dao;

	public NoticeService() {
	}

	@Override
	public boolean deleteNotice(int nid) {

		boolean res = false;
		if (dao.noticeDelete(nid) > 0)
			res = true;
		return res;
	}

	@Override
	public boolean updateNotice(int nid, String ntitle, String ncontent) {
		boolean res = false;
		if (dao.noticeUpdate(nid, ntitle, ncontent) > 0)
			res = true;
		return res;
	}

	@Override
	public NoticeVo infoNotice(int nid) {
		NoticeVo notice = dao.noticeInfo(nid);
		return notice;
	}

	@Override
	public ArrayList<NoticeVo> listNotice() {
		ArrayList<NoticeVo> list = (ArrayList<NoticeVo>) dao.noticeList();
		return list;
	}

	@Override
	public boolean registerNotice(String ntitle, String ncontent) {
		boolean res = false;
		if (dao.noticeInsert(ntitle, ncontent) > 0)
			res = true;
		return res;
	}

	@Override
	public ArrayList<NoticeVo> searchNotice(String keyword) {
		ArrayList<NoticeVo> list = (ArrayList<NoticeVo>) dao.noticeSearch(keyword);
		return list;
	}

	@Override
	public boolean countUp(int nid) {
		boolean res = false;
		if (dao.countUp(nid) > 0)
			res = true;
		return res;
	}
}
