package org.example;



import java.util.HashMap;

import static java.lang.Character.isLetter;

public class Count_word_a implements Parse{
    @Override
    public void parse(String line, HashMap hashMap) {
        int countWord = 0;
        int c=0;
        while(c<line.length())
        {
            while(c<line.length()) {
                if (line.charAt(c)=='a')
                    countWord++;
                c++;
            }
            System.out.println(countWord);
        }
    }


}
