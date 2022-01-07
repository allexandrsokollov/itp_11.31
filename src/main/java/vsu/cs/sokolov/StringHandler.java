package vsu.cs.sokolov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringHandler {

    public static String findTheLongestSentence(String text) {


        return null;
    }

    private static String[] getDividedIntoSentencesText(String text, char[] dividers) {

        List<String> stringList = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        List<Character> divs = new ArrayList<>();

        for (char ch : dividers) {
            divs.add(ch);
        }

        for (int i = 0; i < text.length(); i++) {
            if (!divs.contains(text.charAt(i))) {
                temp.append(text.charAt(i));
            } else {
               stringList.add(new String(temp));
               temp.replace(0, temp.length(), "");
            }
        }

        int stringsAmount = stringList.size();
        String[] result = new String[stringsAmount];

        for (int i = 0; i < stringsAmount; i++) {
            result[i] = stringList.get(i);
        }

        return result;
    }

    private static int getAmountOfWords(String sentence) {

    }
}
