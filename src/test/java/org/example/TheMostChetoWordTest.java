package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TheMostChetoWordTest {

    @Test
    void testParse() {
        String line = "  fg fd faf   dff faf fs";
        HashMap<String, Integer> hashMap = new HashMap<>();
        TheMostChetoWord parseOnlyLetters = new TheMostChetoWord();
        parseOnlyLetters.parse(line, hashMap);
        String expected = "faf";
        Map.Entry<String, Integer> max = hashMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
        assertEquals(expected,max.getKey());
    }
}