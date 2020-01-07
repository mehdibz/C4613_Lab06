package a00123456.lab;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/header.jsp");
		dispatcher.include(request, response);
		dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/goodbye.jsp");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp");
		dispatcher.include(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}