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
	public static final String WRONG_ATTEMPT = "Your attemp is wrong, try again";
	public static final String HIGHER_NUMBER = "\nYour number is higher than secret one.";
	public static final String LOWER_NUMBER = "\nYour number is lower than secret one.";
	public static final String CONGRATULATION = "<div align = \"center\"><b>Congratulation!</b>"
			+ "<br>You guessed the secret number!</div>";
	public static final String NULL_SECRET_NUMBER = "Oops, something went wrong, try new game.";
}
