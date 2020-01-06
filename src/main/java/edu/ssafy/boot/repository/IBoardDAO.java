package edu.ssafy.boot.repository;

import java.util.List;

import edu.ssafy.boot.dto.BoardVo;
import edu.ssafy.boot.dto.CommVo;

public interface IBoardDAO {
	public boolean boardInsert(String user_id, String btitle, String bcontent);
	
	public List<BoardVo> boardList();
	
	public BoardVo boardInfo(int bid);
	
	public boolean boardUpdate(String user_id, int bid, String btitle, String bcontent);
	
	public boolean boardDelete(String user_id, int bid);
	
	public List<BoardVo> boardSearch(String keyword);

	public boolean countUp(int nid);
	
	public List<CommVo> commList(int bid);
	
	public boolean insertComm(int cid, String ccontent, String user_id, int bid);
	
	public boolean deleteComm(int cid);
}
