package edu.ssafy.boot.service;

import java.util.ArrayList;
import java.util.List;

import edu.ssafy.boot.dto.BoardVo;
import edu.ssafy.boot.dto.RecipeBoardVo;

public interface IRecipeBoardService {
	public boolean deleteRecipeBoard(String user_id, int rbid);
	public boolean updateRecipeBoard(RecipeBoardVo rbvo);

	public RecipeBoardVo infoRecipeBoard(int rbid);

	public List<RecipeBoardVo> listRecipeBoard();

	public boolean registerRecipeBoard(RecipeBoardVo rbvo);
	
	public List<RecipeBoardVo> searchRecipeBoard(String keyword);

	public boolean countUp(int rbid);
	
	
	
}
