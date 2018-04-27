/**
 * This class represents a single row of chips.
 *
 */
public class Row{
	private int numChips;
	
	/**
	 * constructor that starts this row off with a given number of chips.
	 * @param numChipsToStart
	 */
	public Row(int numChipsToStart){
		//-----------------------
		//TODO: Write your code here.
		numChips = numChipsToStart;
		}
		//------------------------		
	
	public int getNumChips(){
		return numChips;
	}
	
	/**
	 * indicates whether this is an empty row
	 * @return (true/false) whether the row is currently empty.
	 */
	public boolean isEmpty(){
		boolean iAmEmpty = false;
		//-----------------------
		//TODO: Write your code here.
		iAmEmpty = numChips<=0;
		//------------------------
		//------------------------
		return iAmEmpty; // replace this!
	}
	
	/**
	 * indicates whether there are at least N chips remaining in this row
	 * @param N - the minimum number of chips we are asking about
	 * @return whether there are at least N chips. (true/false)
	 */
	public boolean hasNChipsAvaliable(int N){
		boolean hasEnough = false;
		//-----------------------
		//TODO: Write your code here.
		hasEnough = numChips>N;
		//------------------------
		return hasEnough; // replace this!
	}
	
	/**
	 * decreases the number of chips in this row by N.
	 * @param N - how many chips to remove.
	 */
	public void removeNChips(int N){
		//-----------------------
		//TODO: Write your code here.
		numChips -= N;
		//------------------------
	}
	
	/**
	 * gives a sequence of stars, corresponding to how many chips there are.
	 * For example, if there are 4 stars, this will return "****".
	 */
	public String toString(){
		String response = "";
		//-----------------------
		//TODO: Write your code here.
		for(int i=0; i<numChips; i++){
			response += "*";
		}
		//------------------------
		return response;
	}
}
