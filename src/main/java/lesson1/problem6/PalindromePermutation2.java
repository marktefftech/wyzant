package lesson1.problem6;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation2 {
    private Set<Character> chars = new HashSet<>();

    public boolean isPermutation(String input) {
        for (int i = 0; i < input.length(); ++i){
            char currentChar = input.charAt(i);
            if (!chars.contains(currentChar))
                chars.add(currentChar);
            else
                chars.remove(currentChar);
        }
        return chars.size()==0 || chars.size()==1;
    }
}
