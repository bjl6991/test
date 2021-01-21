package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.domain.ReplyVO;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="/write")
	public String posttWrite(ReplyVO vo) throws Exception{
		
		replyService.write(vo);
		
		return "redirect:/board/view?bno=" + vo.getBno();
 	}
	
}
