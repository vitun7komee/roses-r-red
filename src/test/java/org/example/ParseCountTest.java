package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParseCountTest {

    @Test
    void testParse() {
        String line = "  fg de faf  dff";
        HashMap<String, Integer> hashMap = new HashMap<>();
        ParseCount parseOnlyLetters = new ParseCount();
        parseOnlyLetters.parse(line, hashMap);
        int expected = 4;
        assertEquals(expected, hashMap.get(line));
    }
}