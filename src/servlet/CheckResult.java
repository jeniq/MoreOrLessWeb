package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import view.View;

/**
 * Servlet implementation class CheckResult
 */
@WebServlet("/CheckResult")
public class CheckResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		PrintWriter out = response.getWriter();
		
		if (session.getAttribute(Constant.SECRET_NUMBER) != null){
			int secretNumber = (int)session.getAttribute(Constant.SECRET_NUMBER);
			int userNumber = new Integer(request.getParameter(Constant.USER_NUMBER));
			if (userNumber != secretNumber){
				out.print(View.WRONG_ATTEMPT);
				if (userNumber > secretNumber){
					out.print(View.HIGHER_NUMBER);
				}else{
					out.print(View.LOWER_NUMBER);
				}
			}else{
				out.print(View.CONGRATULATION);
			}
		}else{
			out.print(View.NULL_SECRET_NUMBER);
		}
		out.close();
	}

}
