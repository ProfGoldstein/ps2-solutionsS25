import java.util.Iterator;
/**
 *   Generator to return the Collatz sequence starting with a given integer.
 *
 *   @author Ira Goldstein
 *   @version Spring 2025
 *
 */

public class CollatzGenerator implements Iterator<Long> {
	private long current;		   // The current number in the sequence
	private boolean hasNext = true; // Flag to know if we are done


	public CollatzGenerator(long n) {
		this.current = n;
	}
	
	/**
	* Overrides the Iterator.hasNext() method
	* Returns whether any numbers remain in the sequence.
	*
	* @return   Boolean true/false if there are any more numbers in the sequence
	*/
	@Override
	public boolean hasNext() {
		return hasNext;
	}


	@Override
	public Long next() {
		long result = current;
		if (current == 1) {
			hasNext = false;
		}
		else if (current % 2 == 0) {
			current = current / 2;
		} 
		else {
			current = current * 3 + 1;
		}
		return result;
	}


	public static void main(String[] args) {
		long n = 0;
		
		// convert the command-line parameter to the initial number in the sequence
		try {
			n = Long.parseLong(args[0]);
		}
		catch (NumberFormatException e) {
			System.err.println(e);
			System.exit(1);
		}
		
		CollatzGenerator generator = new CollatzGenerator(n);
		while (generator.hasNext()) {
			System.out.println(generator.next());
		}
	}
}
