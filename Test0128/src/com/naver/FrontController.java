package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String what = request.getServletPath();
		String uri = request.getRequestURI();
		System.out.println(uri);

		String cPath = request.getContextPath();
		System.out.println(cPath);

		String what = uri.substring(cPath.length());
		System.out.println(what);

		Command com = null;

		if (what.equalsIgnoreCase("/insertui.do")) { //equalsIgnoreCase는 대소문자구분 없이 무조건  true
			com = new InsertUICommand();

		} else if (what.equalsIgnoreCase("/insert.do")) {
			com = new InsertCommand();

		} else if (what.equalsIgnoreCase("/list.do")) {
			com = new ListCommand();
			
		}else if (what.equalsIgnoreCase("/read.do")) {
			com = new ReadCommand();
		
		}else if (what.equalsIgnoreCase("/updateui.do")) {
			com = new UpdateUICommand();
			
		}else if (what.equalsIgnoreCase("/update.do")) {
			com = new UpdateCommand();
		
		}else if (what.equalsIgnoreCase("/loginui.do")) {
			com = new LogiUICommand();
		
		}else if (what.equalsIgnoreCase("/login.do")) {
			com = new LoginCommand();
			
		}else if (what.equalsIgnoreCase("/logout.do")) {
			com = new LogoutCommand();
			
		}	
		
		
		if (com != null) {
			CommandAction action = com.execute(request, response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			}else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
