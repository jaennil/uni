import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class t2tests {
    @Test
    void testMethodFindString_1() {
        int actual = t2.find("", "");
        assertEquals(0, actual);
    }

    @Test
    void testMethodFindString_2() {
        int actual = t2.find("a", "");
        assertEquals(0, actual);
    }

    @Test
    void testMethodFindString_3() {
        int actual = t2.find("", "a");
        assertEquals(-1, actual);
    }

    @Test
    void testMethodFindString_4() {
        int actual = t2.find("abc", "abc");
        assertEquals(0, actual);
    }

    @Test
    void testMethodFindString_5() {
        int actual = t2.find("abcabcabc", "bca");
        assertEquals(1, actual);
    }

    @Test
    void testMethodFindString_6() {
        int actual = t2.find("abc", "abca");
        assertEquals(-1, actual);
    }

    @Test
    void testMethodFindString_7() {
        int actual = t2.find("abc", "z");
        assertEquals(-1, actual);
    }
}
