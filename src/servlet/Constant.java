package servlet;

public interface Constant {
	// Game servlet
	String RANGE_TYPE = "rangeType";
	String RANDOM = "random";
	String MIN_VALUE = "minValue";
	String MAX_VALUE = "maxValue";
	String SECRET_NUMBER = "secretNumber";
	String REDIRECT_LINK = "/game.jsp";
	String GAME = "game";
	
	// Check result servlet
	String USER_NUMBER = "userNumber";
	String ATTEMPTS = "attemps";
	String RESULT = "result";
	String SESSION_TIMED_OUT_LINK = "/SessionIsOver.html";
}
