package com.soncompany.testmvc.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soncompany.testmvc.service.BoardService2;
import com.soncompany.testmvc.vo.Board2;

@WebServlet("*.can")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		String view = null;
		
		BoardService2 boardService2 = null;
		Board2 board2 = null;
		
		switch (command) {
		case "/board-list.can":
			boardService2 = BoardService2.getInstance();
			ArrayList<Board2> list = boardService2.getBoards();
			view = "board/b_list2";
			request.setAttribute("list", list);
			break;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view+".jsp");
		rd.forward(request, response);
		
	}
	
	

}
