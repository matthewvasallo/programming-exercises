//Athena Health Interview Question
/*
Consider a "word" as any sequence of capital letters A-Z (not limited to just "dictionary words"). For any
word with at least two different letters, there are other words composed of the same letters but in a
different order (for instance, STATIONARILY/ANTIROYALIST, which happen to both be dictionary words;
for our purposes "AAIILNORSTTY" is also a "word" composed of the same letters as these two).
We can then assign a number to every word, based on where it falls in an alphabetically sorted list of all
words made up of the same set of letters. One way to do this would be to generate the entire list of
words and find the desired one, but this would be slow if the word is long.
Write a program which takes a word as a command line argument and prints to standard output its
number. Do not use the method above of generating the entire list. Your program should be able to
accept any word 25 letters or less in length (possibly with some letters repeated), and should use no
more than 1 GB of memory and take no more than 500 milliseconds to run. Any answer we check will fit
in a 64-bit integer.
Sample words, with their rank:
ABAB = 2
AAAB = 1
BAAA = 4
QUESTION = 24572
BOOKKEEPER = 10743
Your program will be judged on how fast it runs and how clearly the code is written. We will be running
your program as well as reading the source code, so anything you can do to make this process easier
would be appreciated.
 */

import java.util.*;
import java.lang.*;

public class StringSortIndexExercise {
    public static void main(String[] args) {
        System.out.println("CBA -> " + DetermineAlphaSortIndex("BCA"));
        System.out.println("QUESTION -> " + DetermineAlphaSortIndex("QUESTION"));
        System.out.println("BOOKKEEPER -> " + DetermineAlphaSortIndex("BOOKKEEPER"));
        System.out.println("ZYXWVUTSRQPONMLKJIHGFEDCB -> " + DetermineAlphaSortIndex("ZYXWVUTSRQPONMLKJIHGFEDCB"));
    }

    public static int DetermineAlphaSortIndex(String myString) {
        int stringLength = myString.length();
        //build repeated character array
        int[] repeatedCharArray = BuildRepeatedCharArray(myString);
        int totalPossibilities = DetermineTotalPossibleCombinations(repeatedCharArray, stringLength);

        int alphaSortIndexValue = 1;
        int newStringLength = stringLength;
        //loop through the string and add together position indexes
        for (int i = 0; i < stringLength; i++) {
            char currentChar = myString.charAt(i);
            int currentCharIndex = currentChar - 'A';

            for (int j = 0; j < currentCharIndex; j++) {
                //add up different indexes
                alphaSortIndexValue += (totalPossibilities * repeatedCharArray[j]) / newStringLength;
            }

            //Update data
            int lastRepeatedCharNumber = repeatedCharArray[currentCharIndex];
            int lastStringLength = newStringLength;
            newStringLength--;
            repeatedCharArray[currentCharIndex]--;
            totalPossibilities *= lastRepeatedCharNumber;
            totalPossibilities /= lastStringLength;

        }
        return alphaSortIndexValue;
    }

    public static int[] BuildRepeatedCharArray(String myString) {
        int[] repeatedCharArray = new int[26];
        char[] charArray = myString.toCharArray();
        for (char currentChar : charArray) {
            repeatedCharArray[currentChar - 'A']++;
        }
        return repeatedCharArray;
    }

    public static int DetermineTotalPossibleCombinations(int[] repeatedCharArray, int stringLength) {
        int repeatedCharDiviser = 1;
        for (int currentRepeatedCharCount : repeatedCharArray) {
            if (currentRepeatedCharCount > 1) {
                repeatedCharDiviser *= ComputeFactorial(currentRepeatedCharCount);
            }
        }
        int value = ComputeFactorial(stringLength) / repeatedCharDiviser;
        return value;
    }

    public static int ComputeFactorial(int num) {
        if (num > 1) {
            num *= ComputeFactorial(num - 1);
        }
        return num;
    }

}