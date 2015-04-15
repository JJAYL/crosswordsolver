//package wordsearch;
import java.util.*;
class Tables
{
    private char[][] multi;     
    private String dictionnaire[]; 
    private int height=4;
    private int width=4;
	private int numbwords= 4;
	private int currentWordIndex;
    
	public int getNumbwords()
	{
		return numbwords;
	}
    
	public void setNumbwords(int numbwords)
	{
		this.numbwords = numbwords;
	}
    
	public void setWidth(int width)
	{
		this.width=width;
	}
    
	public int getWidth()
	{
		return width;
	}
    
	public void setHeight(int height)
	{
		this.height= height;
	}
    
	public int getHeight()
	{
		return height;
	}
    
	public void setDictionaire(String[] dictionaire)
	{
		this.dictionnaire= dictionaire;
	}
    
	Tables(int aheight, int awidth, char[][] multi)
	{
		height = aheight;
		width = awidth;
		this.multi = multi;
	}
    
    /**
	* It goes through every element of the matrix checking all directions
	*/	
    public void scan_matrix() 
    {
        for(currentWordIndex = 0; currentWordIndex < numbwords; currentWordIndex++)
		{
			System.out.print(dictionnaire[currentWordIndex]+": ");
			for(int j=0; j<height; j++)
				for(int i=0; i<width; i++)
					check_all_direction(j, i);
			System.out.println();
		}
    }
    
    /**
	*Takes the word in the array and compares it to the word in the word bank
	*@param candidate_word the word taken by checking the array in a direction
	*@param line initial position of the line (col, line)
	*@param col initial position of the column (col,line)
	*@param dir_east direction of the column is 1 or -1 depending on where it goes
	*@param dir_south direction of the line is 1 or -1 depending on where it goes
	*/
    private void match_word_in_dictionary(String candidate_word, int line, int col,int dir_east,int dir_south)
    {
		
	   if(candidate_word.startsWith(dictionnaire[currentWordIndex]))
		{
			int end_line = line + (dictionnaire[currentWordIndex].length()-1) * dir_south;
			int end_col = col + (dictionnaire[currentWordIndex].length()-1) * dir_east;
			System.out.print("[("+(line+1)+","+(col+1)+")-("+(end_line+1)+","+(end_col+1)+")]");
		}
    }
    
    private void east(int line,int col)
    {
	// east (left to right)
	String east="";
        for (int i=col; i< multi[line].length; i++) 
        {
            east+=multi[line][i];
        } 
        match_word_in_dictionary(east, line, col,1,0);
    }
    
    private void west(int line, int col)
    {
        // west (right to left)
		String west="";
        for (int i=col; i>= 0; i--)
        {
            west+=multi[line][i];
        }
        match_word_in_dictionary(west, line, col,-1,0);
    }
    
    private void south(int line, int col)
	{
        // south (top to bottom)
	    String south="";
        for (int j=line; j< height ; j++)
        {
            south+=multi[j][col];
        }
        match_word_in_dictionary(south, line, col,0,1);
	}
    
    private void north(int line, int col)
	{
	    // north (bottom to top)
	    String north="";
        for (int j=line; j>=0 ; j--)
        {
            north+=multi[j][col];
        }
        match_word_in_dictionary(north, line, col,0,-1);
	}
    
    private void south_east(int line, int col)
    {
        // south_east (top left to bottom right)
		String south_east="";
        for (int i=col, j=line; (i< multi[line].length) && (j< height); i++, j++)
        {
            south_east+=multi[j][i];
        }
        match_word_in_dictionary(south_east, line, col,1,1);
    }
    
    private void south_west(int line, int col)
    {
        // south_west (top left to bottom right)
		String south_west="";
        for (int i=col, j=line; (i>=0) && (j< height); i--, j++)
        {
            south_west+=multi[j][i];
        }
        match_word_in_dictionary(south_west, line, col,-1,1);
    }
    
    private void north_west(int line, int col)
    {
        // north_west (bottom right to top left)	
		String north_west="";
        for (int i=col, j=line; (i>=0) && (j>=0); i--, j--)
        {
            north_west+=multi[j][i];
        }
        match_word_in_dictionary(north_west, line, col,-1,-1);
    }
    
    private void north_east(int line, int col)
    {
        // north_east (bottom left to top right)
		String north_east="";
        for (int i=col, j=line; (i< multi[line].length) && (j>=0); i++, j--)
        {
            north_east+=multi[j][i];
        }
        match_word_in_dictionary(north_east, line, col,1,-1);
    }

    private void check_all_direction(int line, int col) 
    {
		north(line,col);
		south(line,col);
		east(line,col);
		west(line,col);
		north_east(line,col);
		north_west(line,col);
		south_east(line,col);
		south_west(line,col);
    }

}
