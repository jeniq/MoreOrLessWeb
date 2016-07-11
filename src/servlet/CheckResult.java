package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import view.View;

/**
 * Servlet implementation class CheckResult
 */
@WebServlet("/CheckResult")
public class CheckResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model game;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckResult() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String result;
		game = (Model)session.getAttribute(Constant.GAME);
		
		if (game != null){
			int userNumber = new Integer(request.getParameter(Constant.USER_NUMBER));
			
			// history
			game.addToHistory(userNumber);
			
			// check attemp
			if (game.isEquals(userNumber) < 0){
				result = View.LOWER_NUMBER;
			}else if (game.isEquals(userNumber) > 0){
				result = View.HIGHER_NUMBER;
			}else{
				result = View.CONGRATULATION;
			}
			request.setAttribute(Constant.RESULT, result);
		}else{
			getServletContext().getRequestDispatcher(Constant.SESSION_TIMED_OUT_LINK).forward(request, response);
		}
		getServletContext().getRequestDispatcher(Constant.REDIRECT_LINK).forward(request, response);
	}

}
