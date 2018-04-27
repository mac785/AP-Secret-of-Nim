import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RowTest 
{

	Row rowA, rowB, rowC;
	@Before
	public void setUp() throws Exception 
	{
		rowA = new Row(5);
		rowB = new Row(12);
		rowC = new Row(0);
	}

	@Test
	public void testConstructor()
	{
		assertEquals(5,rowA.getNumChips());
		assertEquals(12,rowB.getNumChips());
		assertEquals(0, rowC.getNumChips());
	}
	
	@Test
	public void testIsEmpty() 
	{
		assertFalse(rowA.isEmpty());
		assertTrue(rowC.isEmpty());
	}
	
	@Test
	public void testHasNChips()
	{
		assertTrue(rowA.hasNChipsAvaliable(4));
		assertFalse(rowB.hasNChipsAvaliable(15));
		assertFalse(rowC.hasNChipsAvaliable(6));
	}
	
	@Test
	public void testToString()
	{
		assertEquals("*****",rowA.toString());
		assertEquals("************",rowB.toString());
		assertEquals("",rowC.toString());
	}
	
	@Test
	public void testRemoveNChips()
	{
		rowA.removeNChips(3);
		assertEquals(2,rowA.getNumChips());
		
		rowB.removeNChips(5);
		assertEquals("*******",rowB.toString());
		
		rowB.removeNChips(7);
		assertTrue(rowB.isEmpty());
	}
}
