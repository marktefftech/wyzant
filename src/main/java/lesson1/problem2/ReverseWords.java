package lesson1.problem2;

//O(n) time | O(n) space
//11 minutes to solve
public class ReverseWords {
    private String output;

    public String reverseWords(String input) {
        String[] words;
        StringBuilder sb = new StringBuilder();

        if (input.equals(null) || input.length() == 0) return input;

        words = input.split(" ");

        for (int i = 0; i <= words.length -1 ; i++) {
            String word = words[i];
            int rightIdx = word.length() - 1;

            while (rightIdx >= 0) {
                sb.append(word.charAt(rightIdx));
                rightIdx--;
            }
            sb.append(" ");
        }
        return sb.toString().substring(0,sb.length()-1); //Delete last space
    }
}



//Reverse Words: Given a string, you need to reverse the order of characters in each word
//within a sentence while still preserving whitespace and initial word order.

//Input: “It is an interesting problem”
//Output: “tI si na gnitseretni melborp”
