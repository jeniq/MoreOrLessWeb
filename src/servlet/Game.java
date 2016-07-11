package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter(Constant.RANGE_TYPE); // mode of selecting range - random or by user
		HttpSession gameSession = request.getSession();
		model = new Model();
		
		gameSession.setMaxInactiveInterval(60); // session time is 1 minute
		model.setMinValue(new Integer(request.getParameter(Constant.MIN_VALUE)));
		model.setMaxValue(new Integer(request.getParameter(Constant.MAX_VALUE)));
		if (Constant.RANDOM.equals(mode)) {
			model.setSecretNumber(model.rand());
		} else {
			model.setSecretNumber(model.rand(model.getMinValue(), model.getMaxValue()));
		}
		gameSession.setAttribute(Constant.GAME, model);
		getServletContext().getRequestDispatcher(Constant.REDIRECT_LINK).forward(request, response);
	}
}
