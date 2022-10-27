/**
 * Author: Jacob Hreshchyshyn
 * */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class urinals {
    public String constructedString = "";
    public static void main(String args[])
    {
        System.out.println("Hello!");
    }
    public boolean buildString(String str) // Builds string to test from characters read by keyboard or file.
    {
        if((!str.equals("1") && !str.equals("0")) || constructedString.length() >= 20)
        {
            return false;
        }
        constructedString = constructedString + str;
        return true;
    }
    public boolean lookForResultsFile(String fileName) // Opens specified file for incrementing results.txt files.
    {
        try
        {
            new BufferedReader(new FileReader(fileName));
            return true;
        }
        catch (FileNotFoundException e)
        {
            return false;
        }
    }
}
// Read from file or input string occupied urinals (1 means occupied. 0 means unoccupied.)
// e.g. 10001 returns the number 3, meaning 3 is the highest number of people who can occupy the urinals.
// If the string already has adjacent occupants, e.g. 110, return -1.
// If the input string has characters other than a 0 or a 1,stop building the string.
// If the file being read reaches the end of the file, stop building the string.
// If keyboard was used to build string, print resulting output.
// If file was used to build string, output file as rule.txt.
// If rule.txt already exists, increment a counter to rule1.txt, rule2.txt, etc.