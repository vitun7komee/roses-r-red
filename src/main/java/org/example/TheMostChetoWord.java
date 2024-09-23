package org.example;

import java.util.HashMap;

import static java.lang.Character.isLetter;

public class TheMostChetoWord extends ShowStrategy implements Parse{

    @Override
    public void showName(){
        System.out.println("Алгоритм ищет чаще всего встречающееся слово.");
    }

    @Override
    public void showDescription(){
        System.out.println("Алгоритм работает следующим образом:\n" +
                "\n" +
                "Инициализируется два указателя (c1, c2) для прохождения по строке.\n" +
                "Цикл проходит по строке, выделяя слова, состоящие из букв.\n" +
                "Для каждого слова проверяется, есть ли оно в хэш-таблице:\n" +
                "Если нет — добавляется с количеством 1.\n" +
                "Если есть — увеличивается счётчик для этого слова.\n" +
                "Пропускаются все небуквенные символы (пробелы, знаки препинания).\n" +
                "Процесс повторяется до конца строки.\n" +
                "В результате подсчитывается количество вхождений каждого слова в строке");
    }


    @Override
    public void parse(String line, HashMap hashMap){
        int c1=0;
        int c2=0;
        int count=1;
        String word= "";
        while(c2<line.length())
        {
            c1=c2;
            word="";
            if (isLetter(line.charAt(c1))) {
                while(c2<line.length()&&isLetter(line.charAt(c2)))
                    c2++;
                for (int i=c1; i<c2; i++)
                    word+=line.charAt(i);
                if(hashMap.get(word)==null)
                    hashMap.put(word,1);
                else {
                    count += (Integer) hashMap.get(word);
                    hashMap.put(word, count);
                    count=1;
                }
                while(c2<line.length()&&!isLetter(line.charAt(c2)))
                    c2++;
            }
            else
                c2++;
        }
    }

}

