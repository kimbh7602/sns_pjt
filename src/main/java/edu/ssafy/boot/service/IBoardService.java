package edu.ssafy.boot.service;

import java.util.ArrayList;
import java.util.List;

import edu.ssafy.boot.dto.BoardVo;
import edu.ssafy.boot.dto.CommVo;

public interface IBoardService {
	public boolean deleteBoard(String user_id, int bid);

	public boolean updateBoard(String user_id, int bid, String btitle, String bcontent);

	public BoardVo infoBoard(int bid);

	public ArrayList<BoardVo> listBoard();

	public boolean registerBoard(String user_id, String btitle, String bcontent);
	
	public ArrayList<BoardVo> searchBoard(String keyword);

	public boolean countUp(int bid);
	
	public List<CommVo> commList(int bid); 
	
	public boolean insertComm(int cid, String ccontent, String user_id, int bid);
	
	public boolean deleteComm(int cid);
}
