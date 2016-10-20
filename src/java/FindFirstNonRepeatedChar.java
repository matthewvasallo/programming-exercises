/**
 * Write a low level string to int and int to string converter.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindFirstNonRepeatedChar {
    public static void main(String[] args) {
        System.out.println("AAABBBC -> " + FindFirstNonRepeatingCharacter("AAABBBC"));
        System.out.println("AAADBBBC -> " + FindFirstNonRepeatingCharacter("AAABBBC"));

    }

    public static Character FindFirstNonRepeatingCharacter(String str) {
        //look up for char to number of times it is found in the string
        HashMap<Character, Integer> charLookup = new HashMap<Character, Integer>();
        Character c;
        if (str != null) {
            int length = str.length();

            for (int i = 0; i < length; i++) {
                c = str.charAt(i);
                if (!charLookup.containsKey(c)) {
                    charLookup.put(c, 1);
                } else {
                    charLookup.put(c, charLookup.get(c) + 1);
                }
            }

            for (int i = 0; i < length; i++) {
                c = str.charAt(i);
                if (charLookup.get(c) == 1) {
                    return c;
                }

            }
        }

        return null;
    }

    public static String removeChars(String str, String remove) {
        char[] s = str.toCharArray();
        char[] r = remove.toCharArray();
        int src, dst = 0;

        // flags automatically initialized to false, size of 128 assumes ASCII
        boolean[] flags = new boolean[128];

        // Set flags for characters to be removed
        for (src = 0; src < r.length; ++src) {
            flags[r[src]] = true;
        }

        // Now loop through all the characters,
        // copying only if they aren’t flagged
        for (src = 0; src < s.length; ++src) {
            if (!flags[s[src]]) {
                s[dst++] = s[src];
            }
        }
        return new String(s, 0, dst);
    }
}
