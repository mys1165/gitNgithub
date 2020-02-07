package BoardCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.BoardDAO;
import MYS.Command;
import MYS.CommandAction;

public class RecommendCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String sNum = request.getParameter("c_board_num");
		int c_board_num = -1;
		if (sNum != null) {
			c_board_num = Integer.parseInt(sNum);
		}
		BoardDAO dao = new BoardDAO();
		dao.recommend(c_board_num);

		response.getWriter().print(dao.read(c_board_num).getC_board_recom());
		return null;

	}

}
