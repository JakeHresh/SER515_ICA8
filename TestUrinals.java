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
}
