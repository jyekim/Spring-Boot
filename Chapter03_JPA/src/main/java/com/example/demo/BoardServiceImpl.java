package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void write() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId("hong");
		boardDTO.setName("허균");
		boardDTO.setSubject("홍길동전");
		boardDTO.setContent("불쌍한 사람들을 도와주는 의적!");
		
		boardDAO.save(boardDTO);
		
	
		boardDTO = new BoardDTO();
		boardDTO.setId("doori");
		boardDTO.setName("김수정");
		boardDTO.setSubject("아기공룡 둘리");
		boardDTO.setContent("빙하타고 내려온 아기공룡");
		
		boardDAO.save(boardDTO);
		
	}

	@Override
	public List<BoardDTO> getBoardList() {
		return boardDAO.findAll();
	}

}
