package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}
	
	@Override
	public void write(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.write(vo);
	}
	
	@Override
	public BoardVO view(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.view(bno);
	}
	
	@Override
	public void modify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.modify(vo);
	}
	
	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}
	
	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return dao.count();
	}
	
	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(displayPost, postNum);
	}
	
	// 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardVO> listPageSearch(
	  int displayPost, int postNum, String searchType, String keyword) throws Exception {
	 return  dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}
	
	// 게시물 총 갯수
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
	 return dao.searchCount(searchType, keyword);
	}
}
