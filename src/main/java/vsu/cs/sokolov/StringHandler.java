package vsu.cs.sokolov;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandler {

    public static String findTheLongestSentence(String text) {

        String[] dividedText = getSentencesWithoutStartingSpaces(
                getDividedIntoSentencesText(text, new char[] {'.', '!', '?'}));
        StringBuilder longestSentence = new StringBuilder();

        for (String sentence : dividedText) {
            if (getAmountOfWords(sentence) > getAmountOfWords(longestSentence.toString())) {
                longestSentence.replace(0, longestSentence.length(), sentence);
            }
        }

        return longestSentence.toString();
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
        Pattern toDivide = Pattern.compile("[^a-zA-ZА-Яа-я0-9]");
        Pattern pattern = Pattern.compile("[a-zA-ZА-Яа-я0-9]");
        Matcher matcher;
        String[] words = toDivide.split(sentence);
        int counter = 0;
        for (String str:
             words) {
            matcher = pattern.matcher(str);

            if (matcher.find()) {
                counter++;
            }
        }
        return counter;
    }

    private static String[] getSentencesWithoutStartingSpaces (String[] sentences) {
        StringBuilder tempSentence;
        String[] result = new String[sentences.length];

        int i = 0;
        for (String sentence:
             sentences) {
            tempSentence = new StringBuilder(sentence);

            for (int j = 0; j < tempSentence.length(); j++) {

                if (tempSentence.charAt(j) == ' ') {
                    tempSentence.deleteCharAt(j);

                } else {
                    break;
                }
            }
            result[i++] = new String(tempSentence);
            tempSentence.replace(0, tempSentence.length(), "");
        }

        return result;
    }
}
