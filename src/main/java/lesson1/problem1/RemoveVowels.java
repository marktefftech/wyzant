package lesson1.problem1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// O(n) time | O(1) space since new HashSet always has constant size
// 8 minutes to solve
public class RemoveVowels {
    private final Set<String> vowels = new HashSet<>(Arrays.asList("a","e","i","o","u"));

    public String removeVowels(String input) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.length() - 1; i++) {
            if (!vowels.contains(input.charAt(i))) {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}
