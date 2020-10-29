package lesson1.problem6;

import java.util.HashMap;

// O(n) time | O(n) space (HashMap creation)
// 20 mins
 public class PalindromePermutation {
     private HashMap<Character,Integer> charCounts = new HashMap<>();

     public boolean isPalindromePermutation(String input) {
         if (input.length() == 0 || input.equals(null)) return false;
         if (input.length() == 1) return true;

         for (int i = 0; i <= input.length() - 1; i++) {
             char c = input.charAt(i);
             if (!charCounts.containsKey(c)) {
                 charCounts.put(c,1);
             }
             else {
                 charCounts.put(c, charCounts.get(c) + 1);
             }
         }

         int numberOfOddChars = 0;

         for (Integer value : charCounts.values()) {
             if (value % 2 != 0) {
                 numberOfOddChars++;
             }
             if (numberOfOddChars > 1) {
                 return false;
             }
         }
         return true;
     }
}


//-
//a
//ab
//aba
//abbac

// check valid input
// loop  thru string, put count of letter in map
// check to see if there are even occurences of every letter
// or if there is only 1 letter !% 0

//Palindrome Permutation: Given a string, write a function to check if it is a permutation of a
//palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
//permutation is a rearrangement of letters. The palindrome does not need to be limited to
//just dictionary words.
//Input: Tact Coa
//Output: True (permutations: “taco cat”, “atco cta” etc.)
