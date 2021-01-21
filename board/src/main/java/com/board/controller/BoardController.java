package com.board.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.board.domain.BoardVO;
import com.board.domain.Page;
import com.board.domain.ReplyVO;
import com.board.service.BoardService;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	 @Autowired
	 private BoardService service;
	
	 @Autowired
	 private ReplyService replyService;
	 
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 public void getList(Model model) throws Exception {
	  
		  List<BoardVO> list = null;
		  list = service.list();
		  model.addAttribute("list", list);
		 }
	 
	 @RequestMapping(value = "/write", method=RequestMethod.GET )
	 public void getWrite() throws Exception{
	
	 }
	 
	 @RequestMapping(value = "/write")
	 public String posttWrite(BoardVO vo) throws Exception{
		 service.write(vo);
		 
		 return "redirect:/board/list";
	 }
	 
	 @RequestMapping(value ="/view")
	 public void getvuew(@RequestParam("bno") int bno, Model model) throws Exception{
		 
		 BoardVO vo = service.view(bno);
		 
		 model.addAttribute("view", vo);
	 }
	 
	 @RequestMapping(value = "/modify", method = RequestMethod.GET)
	 public void getModify(@RequestParam("bno") int bno, Model  model) throws Exception{
		 
		 BoardVO vo = service.view(bno);
		 
		 model.addAttribute("view", vo);
	 }
	 
	 @RequestMapping(value = "/modify", method = RequestMethod.POST)
	 public String postModify(BoardVO vo) throws Exception{
		 
		 service.modify(vo);
		 
		 return "redirect:/board/view?bno=" + vo.getBno();
	 }
	 
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	 public String getDelete(@RequestParam("bno") int bno) throws Exception{
		 
		 service.delete(bno);
		 
		 return "redirect:/board/list";
	 }
	 
	 @RequestMapping(value = "/listPage")
	 public void getListPage(Model model) throws Exception{
		 
		 List<BoardVO> list = null; list = service.list();
		 model.addAttribute("list", list);
	 }
	 
	// 게시물 목록 + 페이징 추가 + 검색
	 @RequestMapping(value = "/listPageSearch", method = RequestMethod.GET)
	 public void getListPageSearch(Model model, @RequestParam("num") int num, 
	   @RequestParam(value = "searchType", required=false, defaultValue="title") String searchType,
	   @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword
	   ) throws Exception {

	  
	  Page page = new Page();
	  
	  page.setNum(num);
	  page.setCount(service.searchCount(searchType, keyword));  
	  
	// 검색 타입과 검색어
//	  page.setSearchTypeKeyword(searchType, keyword);
	  page.setSearchType(searchType);
	  page.setKeyword(keyword);
	  
	  List<BoardVO> list = null; 
	  //list = service.listPage(page.getDisplayPost(), page.getPostNum());
	  list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
	  
	  model.addAttribute("list", list);
	  model.addAttribute("page", page);
	  model.addAttribute("select", num);
	  
//	  model.addAttribute("searchType", searchType);
//	  model.addAttribute("keyword", keyword);
//	  
	 }
	 
	 @RequestMapping(value = "/view", method=RequestMethod.GET)
	 public void getView(@RequestParam("bno") int bno, Model model ) throws Exception{
		 
		 BoardVO vo = service.view(bno);
		 
		 model.addAttribute("view", vo);
		 
		 List<ReplyVO> reply = null;
		 reply = replyService.list(bno);
		 model.addAttribute("reply", reply);
	 }
	 
	 
	 
}