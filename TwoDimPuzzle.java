import java.io.FileNotFoundException;

/**
 * Used to find words in two-dimmensional array of chars.
 */
public class TwoDimPuzzle {
	public static void main(String[] args) {
		
		try {
			Tables puzzle = TwoDimPuzzleReader.getInput();
			puzzle.scan_matrix();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: \"input.txt\" does not exist!");
		}
		
	}

}