package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TheMostChetoLetterTest {

    @Test
    void testParse() {
        String line = "fg de faf dff";
        HashMap<String, Integer> hashMap = new HashMap<>();
        TheMostChetoLetter parseOnlyLetters = new TheMostChetoLetter();
        parseOnlyLetters.parse(line, hashMap);
        String expected = "f";
        Map.Entry<String, Integer> max = hashMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
        assertEquals(expected,max.getKey());
    }
}