package java12.crmapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java12.crmapp.util.Path;
import java12.crmapp.util.Url;

@WebServlet(urlPatterns = Path.USER_PROFILE)
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		switch (path) {
		case Path.USER_PROFILE:
			System.out.println("đã vào user profile");
			req.getRequestDispatcher(Url.USER_PROFILE).forward(req, resp);
			break;
		default:
			break;
		}
	}
}
