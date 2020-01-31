package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String sNum = request.getParameter("num");
		int num= -1;
		if (sNum != null) {
			num = Integer.valueOf(sNum); //valueof = parseInt
		}
		//작성자는 안바뀌므로 넣을필요없다.
		String title = request.getParameter("title");		
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(num, null, title, content, null, 0, 0, 0, 0);
		dao.update(dto);
		
		return new CommandAction(true, "list.do");
	}

}
