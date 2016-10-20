/**
 * Write a low level string to int and int to string converter.
 */

import java.util.*;
import java.lang.*;

public class FindFirstDuplicateNumber {
    public static void main(String[] args) {
        int sampleData[] = {6, 3, 1, 4, 7, 4, 2, 8, 9, 2};
        System.out.println(findFirstDuplicateUsingHashSet(sampleData));
        System.out.println(firstDuplicateUsingIn(sampleData));
        System.out.println(findDuplicateUsingMap(sampleData));
        System.out.println(findFirstDuplicateNestedLoop(sampleData));
    }

    public static int findFirstDuplicateUsingHashSet(int sampleData[]) {
        HashSet<Integer> integersAlreadySeen = new HashSet<Integer>();

        for (int i = 0; i < sampleData.length; i++) {
            if (integersAlreadySeen.contains(sampleData[i])) {
                return sampleData[i];
            } else {
                integersAlreadySeen.add(sampleData[i]);
            }

        }
        return -1;
    }

    public static int firstDuplicateUsingIn(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();

        for (int n : nums) {
            if (!hs.contains(n))
                hs.add(n);
            else
                return n;
        }

        return -1;
    }

    public static String findDuplicateUsingMap(int data[]) {
        Map<Integer, Boolean> isInArrayMap = new HashMap<Integer, Boolean>();

        for (int i = 0; i < data.length; i++) {
            if (isInArrayMap.containsKey(data[i])) {
                return "Duplicate found => " + data[i];
            } else {
                isInArrayMap.put(data[i], true);
            }
        }
        return "No duplicate found!";
    }

    public static String findFirstDuplicateNestedLoop(int[] data) {
        boolean foundDuplicate = false;
        String result = "No duplicate found!";
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {

                if (data[i] == data[j] && !foundDuplicate) {
                    result = "First duplicate => " + data[i];
                    foundDuplicate = true;
                    //return result;
                }
            }
        }
        return result;
    }
}
