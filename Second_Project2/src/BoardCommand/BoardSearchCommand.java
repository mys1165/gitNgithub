package BoardCommand;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.BoardDAO;
import Board.BoardDTO;
import MYS.Command;
import MYS.CommandAction;

public class BoardSearchCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String bool = request.getParameter("bool");
		String content = request.getParameter("content");
		
		if (bool != null) {
			switch (bool) {
			case "contentbool":
					bool = "contentbool";				
					break;
					
			case "titlebool":
					bool = "titlebool";
					break;
					
			case "authorbool":
					bool = "authorbool";
					System.out.println(bool);
					break;
			
			case "authorcontenbool":
					bool = "authorcontenbool";
					System.out.println(bool);
					break;

			default:
				break;
			}
			BoardDAO dao = new BoardDAO();
			List<BoardDTO> list = dao.search(content, bool);
			request.setAttribute("list", list);
		}
		return new CommandAction(false, "board_list.jsp");
	}

}
