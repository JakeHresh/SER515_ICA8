/**
 * Author: Jacob Hreshchyshyn
 * */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUrinals {
    /*The following tests the buildString method to see if it will
    * properly return false when fed an inappropriate character.*/
    @Test
    public void testBuildStringExit() {
        urinals urinal = new urinals();
        Assertions.assertFalse(urinal.buildString("a"));
    }
    /*The following tests the buildString method to see if it will
     * properly return true when fed an appropriate character.*/
    @Test
    public void testBuildStringProperCharacter() {
        urinals urinal = new urinals();
        Assertions.assertTrue(urinal.buildString("1"));
        Assertions.assertTrue(urinal.buildString("0"));
    }
    /*The following tests the buildString method to see if it will
     * properly build a string of 1's and 0's.*/
    @Test
    public void testBuildString() {
        urinals urinal = new urinals();
        urinal.buildString("1");
        urinal.buildString("0");
        Assertions.assertEquals("10", urinal.constructedString);
    }
    /*The following tests the buildString method to see if it will
     * properly build a string of 1's and 0's.*/
    @Test
    public void testBuildStringNotTooLarge() {
        urinals urinal = new urinals();
        for(int i = 0; i < 20; i++)
        {
            urinal.buildString("1");
        }
        Assertions.assertFalse(urinal.buildString("1"));
    }
    /*The following tests the lookForResultsFile method to see if it will
     * fail at finding the specified file.*/
    @Test
    public void testLookForResultsFile() {
        urinals urinal = new urinals();
        Assertions.assertFalse(urinal.lookForResultsFile("TestResults.txt"));
        Assertions.assertTrue(urinal.lookForResultsFile("TestResultsWorking.txt"));
    }
    /*The following tests the findMaxNumFromConstructedString method to see if it will
     * produce the correct maximum number from the string of 1's and 0's.*/
    @Test
    public void testFindMaxNumFromConstructedString() {
        urinals urinal = new urinals();
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("0");
        Assertions.assertEquals(3, urinal.findMaxNumFromConstructedString());
    }
    /*The following tests the findMaxNumFromConstructedString method to see if it will
     * produce the correct maximum number from the string of 1's and 0's.*/
    @Test
    public void testFindMaxNumFromConstructedStringWithOccupancy() {
        urinals urinal = new urinals();
        urinal.buildString("1");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("1");
        Assertions.assertEquals(1, urinal.findMaxNumFromConstructedString());
    }
    /*The following tests the findMaxNumFromConstructedString method to see if it will
     * produce the correct maximum number from the string of 1's and 0's that has an evenly-numbered length.*/
    @Test
    public void testFindMaxNumFromConstructedStringWithOccupancyEven() {
        urinals urinal = new urinals();
        urinal.buildString("1");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("1");
        Assertions.assertEquals(0, urinal.findMaxNumFromConstructedString());
    }
    /*The following tests the findMaxNumFromConstructedString method to see if it will
     * produce the correct maximum number from the string of 1's and 0's that has a large length.*/
    @Test
    public void testFindMaxNumFromConstructedStringWithOccupancyLarge() {
        urinals urinal = new urinals();
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("1");
        urinal.buildString("0");
        urinal.buildString("1");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("1");
        urinal.buildString("0");
        urinal.buildString("1");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("1");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("0");
        urinal.buildString("1");
        Assertions.assertEquals(3, urinal.findMaxNumFromConstructedString());
    }
    /*The following tests the findMaxNumFromConstructedString method to see if it will
     * produce the correct maximum number from the string of 1's and 0's that has a length of 1.*/
    @Test
    public void testFindMaxNumFromConstructedStringWithOccupancySmall() {
        urinals urinal = new urinals();
        urinal.buildString("0");
        Assertions.assertEquals(1, urinal.findMaxNumFromConstructedString());
        urinal.constructedString = "";
        urinal.buildString("1");
        Assertions.assertEquals(0, urinal.findMaxNumFromConstructedString());
    }
    /*The following tests the findMaxNumFromConstructedString method to see if it will
     * produce the correct maximum number from the string of 1's and 0's that has adjacent occupancies.*/
    @Test
    public void testFindMaxNumFromConstructedStringWithOccupancyAdjacent() {
        urinals urinal = new urinals();
        urinal.buildString("1");
        urinal.buildString("1");
        Assertions.assertEquals(-1, urinal.findMaxNumFromConstructedString());
    }
    /*The following tests the findMaxNumFromConstructedString method to see if it will
     * produce the correct maximum number from the empty string.*/
    @Test
    public void testFindMaxNumFromConstructedStringEmpty() {
        urinals urinal = new urinals();
        Assertions.assertEquals(-1, urinal.findMaxNumFromConstructedString());
    }
    /*The following tests the readFile method to see if it will
     * fail to read the data file.*/
    @Test
    public void testReadFile() {
        urinals urinal = new urinals();
        Assertions.assertFalse(urinal.readFile(""));
    }
    /*The following tests the readFile method to see if it will
     * fail to read the data file.*/
    @Test
    public void testReadFileBuildString() {
        urinals urinal = new urinals();
        Assertions.assertTrue(urinal.readFile("testurinal1.dat"));
        Assertions.assertEquals("000", urinal.constructedString);
    }
}
