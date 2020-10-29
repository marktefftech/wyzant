package lesson1.problem4;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;

// HashMap solution: O(n) time | O(n) space
//17 minutes to solve
public class PermutationChecker {
    private HashMap<Character, Integer> charQuantities = new HashMap<>();

    public boolean checkPermutation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) return false;

        if (str1.equals(str2)) return true;

        for (int i = 0 ; i <= str1.length() - 1 ; i++) {
            if (!charQuantities.containsKey(str1.charAt(i))) {
                charQuantities.put(str1.charAt(i), 1);
            }
            else {
                charQuantities.put(str1.charAt(i), charQuantities.get(str1.charAt(i)) + 1);
            }
        }

        for (int i = 0 ; i <= str2.length() - 1 ; i++) {
            if (!charQuantities.containsKey(str2.charAt(i))) return false;
            else charQuantities.put(str2.charAt(i), charQuantities.get(str2.charAt(i)) - 1);
        }

        for (Integer value : charQuantities.values()) {
            if (value != 0) return false;
        }
        return true;
    }
}

