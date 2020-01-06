package edu.ssafy.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.dto.BoardVo;
import edu.ssafy.boot.dto.CommVo;
import edu.ssafy.boot.repository.IBoardDAO;

@Service("BoardService")
public class BoardService implements IBoardService {
	@Autowired
	@Qualifier("BoardDaoDBImpl")
	IBoardDAO dao;
	public BoardService() {}
	
	@Override
	public boolean deleteBoard(String user_id, int bid) {
		boolean res = dao.boardDelete(user_id, bid);
		return res;
	}

	@Override
	public boolean updateBoard(String user_id, int bid, String btitle, String bcontent) {
		boolean res = dao.boardUpdate(user_id, bid, btitle, bcontent);
		return res;
	}

	@Override
	public BoardVo infoBoard(int bid) {
		BoardVo board = dao.boardInfo(bid);
		return board;
	}

	@Override
	public ArrayList<BoardVo> listBoard() {
		ArrayList<BoardVo> list = (ArrayList<BoardVo>) dao.boardList();
		return list;
	}

	@Override
	public boolean registerBoard(String user_id, String btitle, String bcontent) {
		boolean res = dao.boardInsert(user_id, btitle, bcontent);
		return res;
	}

	@Override
	public ArrayList<BoardVo> searchBoard(String keyword) {
		ArrayList<BoardVo> list = (ArrayList<BoardVo>) dao.boardSearch(keyword);
		return list;
	}

	@Override
	public boolean countUp(int bid) {
		boolean res = dao.countUp(bid);
		return res;
	}

	@Override
	public List<CommVo> commList(int bid) {
		List<CommVo> list = dao.commList(bid);
		return list;
	}

	@Override
	public boolean insertComm(int cid, String ccontent, String user_id, int bid) {
		return dao.insertComm(cid, ccontent, user_id, bid);
	}

	@Override
	public boolean deleteComm(int cid) {
		return dao.deleteComm(cid);
	}

}
