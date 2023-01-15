import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class t3tests {
    @Test
    void testMethodMatches_1() {
        boolean actual = t3.matches("", "", 0);
        assertTrue(actual);
    }

    @Test
    void testMethodMatches_2() {
        boolean actual = t3.matches("", "", 3);
        assertFalse(actual);
    }

    @Test
    void testMethodMatches_3() {
        t3.matches("aoeu", "aoeu", -1);
        assertFalset3.matches("aoeu", "aoeu", -1);
);
    }

    @Test
    void testMethodMatches_4() {
        boolean actual = t3.matches("aoeu", "aoeu", 0);
        assertTrue(actual);
    }

    @Test
    void testMethodMatches_5() {
        boolean actual = t3.matches("htns", "htns", 4);
        assertTrue(actual);
    }

    @Test
    void testMethodMatches_6() {
        boolean actual = t3.matches("aoeuhtns", "aoeu", 4);
        assertTrue(actual);
    }

    @Test
    void testMethodMatches_7() {
        boolean actual = t3.matches("aoeu", "dhn", 3);
        assertFalse(actual);
    }
}
