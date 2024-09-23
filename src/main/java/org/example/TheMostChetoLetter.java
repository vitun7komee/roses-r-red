package org.example;

import java.util.HashMap;

import static java.lang.Character.isLetter;

public class TheMostChetoLetter extends ShowStrategy implements Parse{

    @Override
    public void showName(){
        System.out.println("Алгоритм ищет чаще всего встречающуюся букву.");
    }

    @Override
    public void showDescription(){
        System.out.println("Алгоритм работает следующим образом:\n" +
                "\n" +
                "Инициализируется указатель c для прохождения по строке.\n" +
                "Цикл проходит по строке символ за символом.\n" +
                "Для каждого символа проверяется, является ли он буквой с помощью isLetter():\n" +
                "Если да, то буква сохраняется в переменной word.\n" +
                "Если буква уже встречалась, её счётчик в хэш-таблице увеличивается на 1.\n" +
                "Если это первая встреча буквы, она добавляется в хэш-таблицу с количеством 1.\n" +
                "Процесс повторяется до конца строки.\n" +
                "Таким образом, подсчитывается, сколько раз каждая буква встречается в строке, и результат сохраняется в хэш-таблицу.");
    }

    @Override
    public void parse(String line, HashMap hashMap){
        int c=0;
        int count=1;
        String word= "";
        while(c<line.length())
        {
            word="";
            if (isLetter(line.charAt(c))) {
                word+=line.charAt(c);
                if(hashMap.get(word)==null)
                    hashMap.put(word,1);
                else {
                    count += (Integer) hashMap.get(word);
                    hashMap.put(word, count);
                    count=1;
                }
            }
            c++;
        }
    }

}

