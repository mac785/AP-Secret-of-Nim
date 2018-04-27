/**
 * This class represents a collection of three rows in our Nim game.
 *
 */
public class Board
{
	private Row row1, row2, row3;
	
	/**
	 * set up the board, initializing the three rows.
	 */
	public Board()
	{
		//-----------------------
		//TODO: Write your code here.
		row1=new Row(5);
		row2=new Row(7);
		row3=new Row(9);
		//------------------------
	}
	
	/**
	 * determines how many chips are in the given row, 1-3.
	 * @param whichRow - the row number: 1, 2, or 3.
	 * @return the number of chips in the row.
	 * precondition: whichRow is in range {1,2,3}
	 * postcondition: the board is not changed.
	 */
	public int getNumChipsInRow(int whichRow)
	{
		int chips = 0;
		//-----------------------
		//TODO: Write your code here.
		if(whichRow == 1){
			chips = row1.getNumChips();
		}
		else if(whichRow == 2){
			chips = row2.getNumChips();
		}
		else if(whichRow == 3){
			chips = row3.getNumChips();
		}
		//------------------------
		return chips;		
	}
	
	/**
	 * determines whether the given row contains no chips.
	 * @param whichRow - 1, 2, or 3.
	 * @return whether whichRow is empty.
	 * precondition: whichRow is in range {1,2,3}
	 * postcondition: the board is not changed.
	 */
	public boolean rowIsEmpty(int whichRow)
	{
		boolean empty = false;
		//-----------------------
		//TODO: Write your code here.
		empty = getNumChipsInRow(whichRow)<=0;
		//------------------------
		return empty;
	}
	
	/**
	 * Indicates whether removing the given number of chips from the given row would be a legal move.
	 * @param row
	 * @param numChips
	 * @return whether it would be legal (true/false).
	 * precondition: whichRow is in range {1,2,3}
	 * postcondition: the board is not changed.
	 */
	public boolean isLegalMove(int row, int numChips)
	{
		boolean legal = false;
		//-----------------------
		//TODO: Write your code here.
		if (numChips > 0){
			legal = numChips <= getNumChipsInRow(row);
		}
		//------------------------
		return legal;
	}
	
	/**
	 * removes the given number of chips from the given row.
	 * @param row
	 * @param numChips
	 * @return whether this move was actually performed
	 * precondition: whichRow is in range {1,2,3}
	 * postcondition: the number of chips in "row" has decreased by "numChips" 
	 *                and returned true OR row is unchanged and returned false.
	 */
	public boolean makeMove(int row, int numChips)
	{
		boolean moveMade = false;
		//-----------------------
		//TODO: Write your code here.
		if(isLegalMove(row,numChips)==true){
			if(row == 1){
				row1.removeNChips(numChips);
			}
			else if(row == 2){
				row2.removeNChips(numChips);
			}
			else if(row == 3){
				row3.removeNChips(numChips);
			}
			moveMade = true;
		}
		//------------------------
		return moveMade;
	}
	
	/**
	 * checks to see whether the board is in such a state that there are
	 * no legal moves left.
	 * @return whether the game is over (true/false)
	 */
	public boolean gameIsOver()
	{
		boolean gameOver = false;
		//-----------------------
		//TODO: Write your code here.
		gameOver = (row1.isEmpty() && row2.isEmpty() && row3.isEmpty());
		//------------------------
		return gameOver; // replace this!
	}
	
	/**
	 * displays the current state of the board to the screen.
	 */
	public void displayBoard()
	{
		//-----------------------
		//TODO: Write your code here.
		System.out.println("Current Game State:");
		System.out.println(row1.toString());
		System.out.println(row2.toString());
		System.out.println(row3.toString());
		//------------------------
	}
}