import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class t1tests {
    @Test
    void testMethodFind_1() {
        int actual = t1.find("abc", 'b');
        assertEquals(1, actual);
    }

    @Test
    void testMethodFind_2() {
        int actual = t1.find("abc", 'd');
        assertEquals(-1, actual);
    }

    @Test
    void testMethodFind_3() {
        int actual = t1.find("1234", '3');
        assertEquals(2, actual);
    }

    @Test
    void testMethodFind_4() {
        int actual = t1.find("1234", '6');
        assertEquals(-1, actual);
    }

    @Test
    void testMethodFind_5() {
        int actual = t1.find("", 'a');
        assertEquals(-1, actual);
    }
}
