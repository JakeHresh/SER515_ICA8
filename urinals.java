/**
 * Author: Jacob Hreshchyshyn
 * */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class urinals {
    public String constructedString = "";
    public static void main(String[] args)
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
    public int findMaxNumFromConstructedString() // Returns the maximum number of occupants from constructedString of 1's and 0's.
    {
        int maxNum = 0;
        int currentOnes = 0;
        int length = 0;
        char[] constructedStringChars = constructedString.toCharArray();
        if(constructedString.length() == 0)
        {
            return -1;
        }
        if(constructedString.length() == 1)
        {
            if(constructedStringChars[0] == '1')
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
        // Check for adjacent 1's in the string
        for(int i = 0; i < constructedString.length() - 1; i++)
        {
            if(constructedStringChars[i] == '1' && constructedStringChars[i + 1] == '1')
            {
                return -1;
            }
        }
        for(int i = 0; i < constructedString.length(); i++)
        {
            if(constructedStringChars[i] == '1')
            {
                currentOnes++;
            }
        }
        if(constructedString.length() % 2 == 0)
        {
            length = constructedString.length()/2;
        }
        else
        {
            length = constructedString.length()/2 + 1;
        }
        for(int i = 0; i < length; i++)
        {
            if(i == 0)
            {
                if(constructedStringChars[i + 1] == '0')
                {
                    maxNum++;
                    constructedStringChars[i] = '1';
                }
            }
            else
            {
                if(constructedStringChars[i + 1] == '0' && constructedStringChars[i - 1] == '0')
                {
                    maxNum++;
                    constructedStringChars[i] = '1';
                }
            }
            if(constructedString.length() - 1 - i == constructedString.length() - 1)
            {
                if(constructedStringChars[constructedString.length() - 2 - i] == '0')
                {
                    maxNum++;
                    constructedStringChars[constructedString.length() - 1 - i] = '1';
                }
            }
            else
            {
                if(constructedStringChars[constructedString.length() - 2 - i] == '0' && constructedStringChars[constructedString.length() - i] == '0' && constructedString.length() - 1 - i != i)
                {
                    maxNum++;
                    constructedStringChars[constructedString.length() - 1 - i] = '1';
                }
            }
        }
        return maxNum - currentOnes;
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