package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String num = request.getParameter("num");
		
		BoardDAO dao = new BoardDAO();
		dao.delete(num);
		
		
		return new CommandAction(true, "list.do");
	}

}
