package edu.ssafy.boot.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import edu.ssafy.boot.dto.RecipeBoardVo;

public interface RecipeBoardDAO {
/*
 *     private int rbid;
    private String rbtitle;
    
    @Column(length = 100000000)
    private String rbcontent;
    private int rbcount; // 조회수
    private String user_id;
    
    private Date regDate;
    private Date updDate;
 */
	RecipeBoardVo findOne(int rbid);
    boolean recipeBoardInsert(RecipeBoardVo rbvo);
    List<RecipeBoardVo> recipeBoardList();
    RecipeBoardVo recipeBoardInfo(int rbid);
    boolean recipeBoardUpdate(RecipeBoardVo rbvo);
    boolean recipeBoardDelete(String user_id, int rbid);
    List<RecipeBoardVo> boardSearch(String keyword);
    boolean countUp(int rbid);
    
}