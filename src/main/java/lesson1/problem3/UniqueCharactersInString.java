package lesson1.problem3;

import java.util.HashMap;

// Hash map solution: O(n) time | O(n) space
// 6 minutes to solve
public class UniqueCharactersInString {
    private HashMap<Character, Integer> charMap = new HashMap<>();

    public boolean hasUniqueChars(String input) {

        if (input.equals(null) || input.length() == 0 || input.length() > 26) return false;

        for (int i = 0; i <= input.length() - 1; i++) {
            if (charMap.containsKey(input.charAt(i))) return false;
            charMap.put(input.charAt(i),i);
        }
        return true;
    }

}

//Is Unique: Implement an algorithm to determine if a string has all unique characters.
