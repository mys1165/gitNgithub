package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String sNum = request.getParameter("num"); //획득하고
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);// 가공하고
		}
			
		BoardDTO dto = new BoardDAO().read(num);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "read.jsp");
	}

}

