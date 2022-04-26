package com.yjj.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjj.board.dao.BDao;
import com.yjj.board.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list(); // dto들의 배열인 dtos(ArrayList 타입)가 반환
		
		request.setAttribute("list", dtos); // 셋팅
	}

}
