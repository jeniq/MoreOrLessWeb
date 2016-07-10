package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

/**
 * Servlet implementation class CheckResult
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;
       
	// TODO: session contain secret number during the game
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("numberSet");
		HttpSession gameSession = request.getSession();
		int secretNumber;
		
		if (model == null) {
			newSession();
			gameSession.setMaxInactiveInterval(180); // session time is 3 minutes
			if ("random".equals(mode)) {
				model.setMinValue(0);
				model.setMaxValue(100);
				model.setSecretNumber(model.rand());
				secretNumber = model.getSecretNumber();
			} else {
				model.setMinValue(Integer.parseInt((String) request.getAttribute("minValue")));
				model.setMaxValue(Integer.parseInt((String) request.getAttribute("maxValue")));
				model.setSecretNumber(model.rand(model.getMinValue(), model.getMaxValue()));
				secretNumber = model.getSecretNumber();
			}
			gameSession.setAttribute("secretNumber", new Integer(secretNumber));
		}
		PrintWriter out = response.getWriter();
		System.out.println(gameSession.getAttribute("secretNumber"));
		response.sendRedirect("./game.html");
		out.close();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void newSession(){
		model = new Model();
	}

}