package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws FileNotFoundException {
        File file = new File("src/main/textFile");
        Scanner choiceAction = new Scanner(System.in);
        boolean flagExit = true;
        int choice;
        long startTime;
        long endTime;
        long timeElapsed;
        while (flagExit) {
            System.out.println("Выберите действие: 1-посчитать слова. 2-самое популярное слово. " +
                    "3-самая популярная буква. 4 - выход ");
            choice = choiceAction.nextInt();
            HashMap<String, Integer> hashMap = new HashMap<>();
            switch (choice) {
                case (1):
                    Scanner scannerForCount = new Scanner(file);
                    ShowStrategy countInfo = new ParseCount();
                    startTime = System.nanoTime();
                    int countWord=0;
                    while (scannerForCount.hasNextLine()) {
                        String line = scannerForCount.nextLine();
                        Parser parserCount = new Parser(new ParseCount());
                        parserCount.parsing(line,hashMap);
                        countWord+=hashMap.get(line);
                    }
                    endTime = System.nanoTime();
                    countInfo.show();
                    System.out.println("Количество слов:" + countWord);
                    timeElapsed = endTime - startTime;
                    System.out.println("Время выполнения:" + timeElapsed + " нс");
                    hashMap.clear();
                    break;
                case (2):
                    Scanner scannerForWord = new Scanner(file);
                    ShowStrategy wordInfo = new TheMostChetoWord();
                    startTime = System.nanoTime();
                    while (scannerForWord.hasNextLine()) {
                        String line = scannerForWord.nextLine();
                        Parser TheMostChetoWord= new Parser(new TheMostChetoWord());
                        TheMostChetoWord.parsing(line,hashMap);
                    }
                   Map.Entry<String, Integer> max = hashMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
                    endTime = System.nanoTime();
                    wordInfo.show();
                    System.out.println("Самое популярное слово: " + max.getKey());
                    System.out.println("Количество повторений: " + max.getValue());
                    timeElapsed = endTime - startTime;
                    System.out.println("Время выполнения:" + timeElapsed + " нс");
                    hashMap.clear();
                    break;
                case (3):
                    Scanner scannerForLetter = new Scanner(file);
                    ShowStrategy letterInfo = new TheMostChetoLetter();
                    startTime = System.nanoTime();
                    while (scannerForLetter.hasNextLine()) {
                        String line = scannerForLetter.nextLine();
                        Parser TheMostChetoLetter= new Parser(new TheMostChetoLetter());
                        TheMostChetoLetter.parsing(line,hashMap);
                    }
                    Map.Entry<String, Integer> maxx = hashMap.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
                    endTime = System.nanoTime();
                    letterInfo.show();
                    System.out.println("Самая популярная буква: " + maxx.getKey());
                    System.out.println("Количество повторений: " + maxx.getValue());
                    timeElapsed = endTime - startTime;
                    System.out.println("Время выполнения:" + timeElapsed + " нс");
                    hashMap.clear();
                    break;
                case(4):
                    Scanner scannerForLetterA = new Scanner(file);
                    while (scannerForLetterA.hasNextLine()) {
                        String line = scannerForLetterA.nextLine();
                        Parser TheMostCountworda= new Parser(new Count_word_a());
                        TheMostCountworda.parsing(line,hashMap);
                    }

                case (5):
                    flagExit = false;
                    break;
            }
        }
    }
}
