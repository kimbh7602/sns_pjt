package edu.ssafy.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.boot.dto.BoardVo;
import edu.ssafy.boot.dto.CommVo;
import edu.ssafy.boot.dto.RecipeBoardVo;
import edu.ssafy.boot.repository.IBoardDAO;
import edu.ssafy.boot.repository.RecipeBoardDAO;

@Service("RecipeBoardService")
public class RecipeBoardService implements IRecipeBoardService {
	@Autowired
	@Qualifier("RecipeBoardDAOImpl")
	private RecipeBoardDAO dao ;
	   
	public RecipeBoardService() {}

	@Override
	public boolean deleteRecipeBoard(String user_id, int rbid) {
		return dao.recipeBoardDelete(user_id, rbid);
	}

	@Override
	public boolean updateRecipeBoard(RecipeBoardVo rbvo) {
		return dao.recipeBoardUpdate(rbvo);
	}

	@Override
	public  RecipeBoardVo infoRecipeBoard(int rbid) {
		return dao.recipeBoardInfo(rbid);
	}

	@Override
	public List<RecipeBoardVo> listRecipeBoard() {
		return dao.recipeBoardList();
	}

	@Override
	public boolean registerRecipeBoard(RecipeBoardVo rbvo) {
		return dao.recipeBoardInsert(rbvo);
	}

	@Override
	public List<RecipeBoardVo> searchRecipeBoard(String keyword) {
		return dao.boardSearch(keyword);
	}

	@Override
	public boolean countUp(int rbid) {
		return dao.countUp(rbid);
	}

}
