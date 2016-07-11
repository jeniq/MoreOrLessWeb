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
		String mode = request.getParameter(Constant.RANGE_TYPE);
		HttpSession gameSession = request.getSession();
		int secretNumber;
		int minValue;
		int maxValue;
		model = new Model();
		
		gameSession.setMaxInactiveInterval(60); // session time is 1 minute
		if (Constant.RANDOM.equals(mode)) {
			model.setMinValue(1);
			model.setMaxValue(99);
			model.setSecretNumber(model.rand());
			secretNumber = model.getSecretNumber();
		} else {
			model.setMinValue(new Integer(request.getParameter(Constant.MIN_VALUE)));
			model.setMaxValue(new Integer(request.getParameter(Constant.MAX_VALUE)));
			model.setSecretNumber(model.rand(model.getMinValue(), model.getMaxValue()));
			secretNumber = model.getSecretNumber();
		}
		minValue = model.getMinValue();
		maxValue = model.getMaxValue();
		gameSession.setAttribute(Constant.ATTEMPTS, "");
		gameSession.setAttribute(Constant.SECRET_NUMBER, new Integer(secretNumber));
		gameSession.setAttribute(Constant.MIN_VALUE, new Integer(minValue));
		gameSession.setAttribute(Constant.MAX_VALUE, new Integer(maxValue));
		getServletContext().getRequestDispatcher(Constant.REDIRECT_LINK).forward(request, response);
	}
}
