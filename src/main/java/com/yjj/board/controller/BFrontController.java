package com.yjj.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjj.board.command.*;


/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI(); // 클라이언트가 요청한 url 전부 가져오기
		String conPath = request.getContextPath(); //context 경로만 가져오기
		String com = uri.substring(conPath.length()); // 전체 url 에서 context 경로 길이만큼 빼기
		
		if(com.equals("/list.do")) { //글 목록보기 요청
			
			command = new BListCommand(); // 업케스팅
			command.execute(request, response);
			
			
			
			viewPage = "list.jsp";
			
		} else if(com.equals("/write_view.do")) { //글 내용보기 요청
			
			viewPage = "write_view.jsp";
			
		} else if(com.equals("/delete.do")) { //글 삭제 요청
			
			command = new BDeleteCommand();
			command.execute(request, response);
			
			viewPage = "list.do";
			
		} else if(com.equals("/modify.do")) { //글 수정 요청
			
			command = new BModifyCommand();
			command.execute(request, response);
			
			viewPage = "list.do";
			
		} else if(com.equals("/write.do")) { //글 쓰기 요청
			
			command = new BWriteCommand(); // 업케스팅
			command.execute(request, response);
			
			viewPage = "list.do";
			
		} else if(com.equals("/content_view.do")) { //글 쓰기 요청
			
			command = new BContentCommand(); // 업케스팅
			command.execute(request, response);
			
			viewPage = "content_view.jsp";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
		
		
	}
	
}
