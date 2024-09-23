package org.example;

import java.util.HashMap;

public class Parser {
    private final Parse parse;

    public Parser(Parse parse) {
        this.parse = parse;
    }

    public void parsing(String line, HashMap hashMap){
        parse.parse(line, hashMap);
    }
}
