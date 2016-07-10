package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("secretNumber") != null){
			System.out.println(session.getAttribute("secretNumber"));
			Integer secretNumber = (Integer)session.getAttribute("secretNumber");
			int userNumber = Integer.parseInt(request.getParameter("userNumber"));
			System.out.println(userNumber);
			PrintWriter out = response.getWriter();
			if (userNumber != secretNumber){
				out.print("Your attemp is wrong, try again\n");
			}else{
				out.print("Congratulation! You win!");
			}
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
