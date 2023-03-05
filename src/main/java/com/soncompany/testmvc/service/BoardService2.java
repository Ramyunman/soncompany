package com.soncompany.testmvc.service;

import java.util.ArrayList;

import com.soncompany.testmvc.dao.BoardDAO2;
import com.soncompany.testmvc.vo.Board2;

public class BoardService2 {

	private static BoardService2 service = null;
	private static BoardDAO2 dao = null;
	
	private BoardService2() {
		
	}
	
	public static BoardService2 getInstance() {
		if(service == null) {
			service = new BoardService2();
			dao = BoardDAO2.getInstance();
		}
		return service;
	}
	
	public ArrayList<Board2> getBoards() {	// board list
		return dao.getBoards();
	}
}
