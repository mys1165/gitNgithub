package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String what = uri.substring(cPath.length());

		Command com = null;

		if (what.equalsIgnoreCase("/list.do")) {
			com = new ListCommand();
		} else if (what.equalsIgnoreCase("/insertui.do")) {
			com = new InsertUICommand();
		} else if (what.equalsIgnoreCase("/insert.do")) {
			com = new InsertCommand();
		}else if (what.equalsIgnoreCase("/read.do")) {
			com = new ReadCommand();
		}else if(what.equalsIgnoreCase("/delete.do")) {
			com = new DeleteCommand();
		}else if (what.equalsIgnoreCase("/updateui.do")) {
			com = new UpdateUICommand();
		}else if (what.equalsIgnoreCase("/update.do")) {
			com = new UpdateCommand();
		}else if (what.equalsIgnoreCase("/replyui.do")) {
			com = new ReplyUICommand();
		}else if (what.equalsIgnoreCase("/reply.do")) {
			com = new ReplyCommand();
			
		}

		if (com != null) {
			CommandAction action = com.execute(request, response);

			if (action != null) {
				if (action.isRedirect()) {
					response.sendRedirect(action.getWhere());

				} else {
					request.getRequestDispatcher(action.getWhere()).forward(request, response);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
