package MemberCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MYS.Command;
import MYS.CommandAction;

public class MemberDeleteUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		return new CommandAction(true, "member_deleteui.jsp");
		 
			}

		}
