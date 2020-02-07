package BoardCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.BoardDAO;
import MYS.Command;
import MYS.CommandAction;
import MYS.PageTO;

public class BoardListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String sCurpage = request.getParameter("curPage");	
		int curPage = 1;
		if (sCurpage != null) {
			curPage = Integer.parseInt(sCurpage);
		}
		BoardDAO dao = new BoardDAO();
		PageTO to = dao.list(curPage);
		request.setAttribute("list", to.getList());
		
		request.setAttribute("to", to);
		return new CommandAction(false, "board_list.jsp");
		
		
	}

}
