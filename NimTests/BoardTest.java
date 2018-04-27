import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	Board theBoard;
	
	@Before
	public void setUp() throws Exception 
	{
		theBoard = new Board();
	}
	
	@Test
	public void testConstructor() 
	{
		assertEquals(5,theBoard.getNumChipsInRow(1));
		assertEquals(7,theBoard.getNumChipsInRow(2));
		assertEquals(9,theBoard.getNumChipsInRow(3));
	}

	@Test
	public void testIsLegalMove()
	{
		assertTrue(theBoard.isLegalMove(1, 3));
		assertFalse(theBoard.isLegalMove(1, 7));
		assertTrue(theBoard.isLegalMove(2, 1));
		assertFalse(theBoard.isLegalMove(2, 10));
		assertTrue(theBoard.isLegalMove(3, 9));
	}
	
	@Test
	public void testMakeMove()
	{
		assertTrue(theBoard.makeMove(1, 3));
		assertFalse(theBoard.makeMove(1, 7));
		assertEquals(2,theBoard.getNumChipsInRow(1));
		
		assertTrue(theBoard.makeMove(2, 1));
		assertEquals(6,theBoard.getNumChipsInRow(2));
		
		assertTrue(theBoard.makeMove(3,9));
		assertTrue(theBoard.rowIsEmpty(3));
	}
	
	@Test
	public void testGameOver()
	{
		Board testBoard = new Board();
		assertFalse(testBoard.gameIsOver());
		
		testBoard.makeMove(1, testBoard.getNumChipsInRow(1));
		assertFalse(testBoard.gameIsOver());
		
		testBoard.makeMove(3, testBoard.getNumChipsInRow(3));
		assertFalse(testBoard.gameIsOver());
		
		testBoard.makeMove(2, testBoard.getNumChipsInRow(2));
		assertTrue(testBoard.gameIsOver());
	}
}
