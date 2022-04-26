package com.yjj.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjj.board.dao.BDao;
import com.yjj.board.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bid = request.getParameter("bid");
		
		BDao dao = new BDao();
		BDto dto = dao.content_view(bid);
		
		request.setAttribute("content_view", dto);
	}

}
