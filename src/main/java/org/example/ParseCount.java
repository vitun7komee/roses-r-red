package org.example;


import java.util.HashMap;

import static java.lang.Character.isLetter;

public class ParseCount extends ShowStrategy implements Parse{

    @Override
    public void showName(){
        System.out.println("Алгоритм подсчета количества слов.");
    }

    @Override
    public void showDescription(){
        System.out.println("Алгоритм подсчета слов работает следующим образом:\n" +
                "Переменная countWord хранит количество найденных слов.\n" +
                "Цикл while проходит по каждому символу строки.\n" +
                "Если текущий символ является буквой (isLetter), то это начало слова, и увеличивается счетчик countWord.\n" +
                "Вложенный цикл пропускает остальные буквы до конца слова.\n" +
                "Далее цикл пропускает любые не-буквенные символы (например, пробелы, знаки препинания и т. д.).\n" +
                "После завершения основного цикла в хэш-таблицу добавляется запись, где ключом является строка line, а значением — количество слов в этой строке.");
    }


    @Override
    public void parse(String line, HashMap hashMap){
        int countWord = 0;
        int c=0;
        while(c<line.length())
        {
            if (isLetter(line.charAt(c))) {
                countWord++;
                while(c<line.length()&&isLetter(line.charAt(c)))
                    c++;
                while(c<line.length()&&!isLetter(line.charAt(c)))
                    c++;
            }
            else
                c++;
        }
        hashMap.put(line, countWord);
    }

}
