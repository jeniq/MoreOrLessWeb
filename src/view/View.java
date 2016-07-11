package view;

/**
 * This class contains String constants that user see
 * during the game. There are messages that should help user
 * with number choice, error messages and congratulation message.
 *  
 * @author Yevhen Hryshchenko
 * @version 11 Jule 2016
 *
 */
public class View {
	public static final String WRONG_ATTEMPT = "<div align = \"center\">Your attemp is wrong, try again";
	public static final String HIGHER_NUMBER = "<br>Your number is higher than secret one. </div>";
	public static final String LOWER_NUMBER = "<br>Your number is lower than secret one. </div>";
	public static final String CONGRATULATION = "<div align = \"center\"><b>Congratulation!</b>"
			+ "<br>You guessed the secret number!</div>";
	public static final String NULL_SECRET_NUMBER = "Oops, something went wrong, try new game.";
	public static final String ATTEMPS_TITLE = "<br>Attemps";
	public static final String NEW_LINE = "<br>";
	public static final String IN_RANGE = " in range (";
	public static final String SEMICOLON = ";";
	public static final String CLOSING_BRACKET = ")";
}
