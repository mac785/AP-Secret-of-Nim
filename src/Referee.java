import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The referee keeps track of the board and does the work of asking the user(s) for input,
 * asking the board whether the moves are legal, and telling the board to make changes.
 * It also determines whether the game is over (by asking the board) and behaves accordingly.
 *
 */
public class Referee{
	private Board theBoard;
	//private String playerOne;
	//private String playerTwo;
	
	/**
	 * initialize any variables (such as the board) here.
	 */
	public Referee(){
		//-----------------------
		//TODO: Write your code here.
		theBoard = new Board();
		//------------------------
	}
	
	/**
	 * runs us through the process of playing a game of NIM.
	 */
	public void playGame(){
		int row = 0;
		int chips = 0;
		boolean moveMade = false;
		boolean rowIsValid = false;
		int whoTurn = 1;
		System.out.println("Start of game");
		// Hint: write for yourself (in English) what must happen in a given turn, 
		// and what parts must repeat. You might consider doing this on paper.
		// DON'T REINVENT THE WHEEL! Make use of the other methods in this program!
		//-----------------------
		//TODO: Write your code here.
		System.out.println("WELCOME TO THE JAMIE MOSELEY NIM EXTTRAVOGANZA");
		System.out.println("PREPARE FOR THE GAME OF A LIFETIME \nSTART");
		while (!theBoard.gameIsOver()){
			whoTurn = 1;
			chips = 0;
			row = 0;
			moveMade = false;
			rowIsValid = false;
			System.out.println("Player One's board:");
			theBoard.displayBoard();
			while (moveMade == false){
				row = 5;
				while (rowIsValid == false){
					System.out.println("Player One, which row would you like to take chips from?");
					row = getInt();
					if ((row == 1 || row == 2 || row ==3) && theBoard.rowIsEmpty(row)==false){
						rowIsValid = true;
					}
					else{
						System.out.println("Invalid row. Please try again.");
					}
				}
				while (theBoard.isLegalMove(row, chips) == false){
					System.out.println("Player One, how many chips would you like to remove?");
					chips = getInt();
					if (theBoard.isLegalMove(row, chips) == false){
						System.out.println("Invalid number of chips. Please try again");
					}
				}
				moveMade = theBoard.makeMove(row, chips);
				if (moveMade == false){
					System.out.println("Invalid move, please try again");
				}
			}
			if (theBoard.gameIsOver()){ break;}
			whoTurn = 2;
			chips = 0;
			row = 0;
			moveMade = false;
			rowIsValid = false;
			System.out.println("Player Two's board:");
			theBoard.displayBoard();
			while (moveMade == false){
				row = 5;
				while (rowIsValid == false){
					System.out.println("Player Two, which row would you like to take chips from?");
					row = getInt();
					if ((row == 1 || row == 2 || row ==3) && theBoard.rowIsEmpty(row)==false){
						rowIsValid = true;
					}
					else{
						System.out.println("Invalid row. Please try again.");
					}
				}
				while (theBoard.isLegalMove(row, chips) == false){
					System.out.println("Player Two, how many chips would you like to remove?");
					chips = getInt();
					if (theBoard.isLegalMove(row, chips) == false){
						System.out.println("Invalid number of chips. Please try again");
					}
				}
				moveMade = theBoard.makeMove(row, chips);
				if (moveMade == false){
					System.out.println("Invalid move, please try again");
				}
			}
		}
		//------------------------
		System.out.println("Game over.");
		System.out.println("Player "+whoTurn+" loses");
	}
	
	/**
	 * waits for the user to enter an integer and keeps asking until it gets one.
	 * @return the integer the user types in.
	 */
	public int getInt(){   // I've written this one for you. 
		// It's a little complicated, and I don't expect you to follow it yet,
		// but if you are curious, I've included an explanation. - HH
		Scanner keyboardReader = new Scanner(System.in);
		int result;
		while (true){
			/* we're about to do something that might crash the program - 
			  ask the user for an integer. If they do, great, but they
			  might give us a string that doesn't translate, like "four thousand
			  ninety six" or "as;jken dinka;ds  askdfj ", and then the program
			  will die with a message that there is an "InputMismatchException."
			  So we acknowledge that this is risky with a "try" statement. By 
			  doing so, we can "catch" the exception BEFORE it stops the program
			  and deal with that situation INSTEAD of crashing. The program execution
			  jumps straight from the line where the error occurs (in this case, 
			  the nextInt command) to the "catch" block.
			  So this loop has us continue to ask for numbers until the nextInt()
			  doesn't throw an exception, at which point, it will break out. */
			try{
				result = keyboardReader.nextInt();
				break; // leave the loop now.
			}
			catch (InputMismatchException nfe){
				System.out.println("Please enter an integer (in numerals).");
			}
			keyboardReader.next(); // clears any extra characters.
		}
		return result;
	}
}
