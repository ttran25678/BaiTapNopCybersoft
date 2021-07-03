package java12.crmapp.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java12.crmapp.util.Path;
import java12.crmapp.util.Url;


@WebServlet(urlPatterns = Path.HOME)
public class HomeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Url.DASHBOARD).forward(req, resp);
	}
	
	
}
