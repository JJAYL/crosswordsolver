import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * TwoDimPuzzleReader is used to read in the table and words associated
 * with a word search puzzle. It contains only static methods and constants.
 */

public class TwoDimPuzzleReader {
    
    /**
     * The maximum number of rows and columns in the table, and the maximum
     * number of words to search.
     */
    private static final int MAX_ELEMENTS = 10000;
    
    /**
     * Reads table and words from input file "input.txt" and stores data
     * in a Tables object.
     *
     * @return  the Tables object that holds the table and words
     * 
     * @throws  FileNotFoundException
     *          if file "input.txt" cannot be found
     *
     */
    public static Tables getInput() throws FileNotFoundException {
		File inputFile = new File("input.txt");
		Scanner in = new Scanner(inputFile);
		
		Tables puzzle = readTable(in);
		readWords(in, puzzle);
		
		in.close();
		
		return puzzle;
	}
    
    /**
     * Reads table and instantiates a Tables object to hold the data.
     * Table is read in from Scanner in and stored in a two-dimmensional
     * array. The number of rows and columns are kept track of and, along with
     * the two-dimmensional array, are used to instantiate a Tables object.
     *
     * @param   in
     *          Scanner object that is used to read in the table
     *
     * @return  Tables object containing the table
     */
    private static Tables readTable(Scanner in) {
		char[][] puzzle = new char[MAX_ELEMENTS][MAX_ELEMENTS];
		int rows = 0, columns = 0;
		int currentRow = 0, currentColumn = 0;
		String currentLine = in.nextLine();
		char currentLetter;
		int stringIndex;
		while(!currentLine.equals("")) { // check if end of table reached
			stringIndex = 0;
			currentColumn = 0;
			
			do {
				currentLetter = currentLine.charAt(stringIndex);
				puzzle[currentRow][currentColumn] = currentLetter;
				currentColumn++;
				stringIndex += 2;
			} while(stringIndex < currentLine.length());
			
			currentRow++;
			currentLine = in.nextLine();
		}
		
		rows = currentRow;
		columns = currentColumn;
		
		return new Tables(rows, columns, puzzle);
    }
    
    /**
     * Reads words and passes the data to the Tables object. The words are read
     * from Scanner in and stored in an array. The array and the number of
     * words are passed to Tables object to store.
     *
     * @param   in
     *          Scanner object that is used to read in the words
     *
     * @param   puzzle
     *          Tables object that already hold table
     *
     * @postcondition   puzzle will have words array and number of words
     */
    private static void readWords(Scanner in, Tables puzzle) {
		String[] words = new String[MAX_ELEMENTS];
		String currentWord;
		int indexOfCurrentWord = 0;
		
		do {
			currentWord = in.next();
			words[indexOfCurrentWord] = currentWord;
			indexOfCurrentWord++;
		} while(in.hasNextLine());
		int numberOfWords = indexOfCurrentWord;
		
		puzzle.setDictionaire(words);
		puzzle.setNumbwords(numberOfWords);
	}
}