package lesson1.problem5;

//2 pointer solution: O(n) time | O(1) space
    //--> even though there is a nested while loop, each number in array is only being iterated through one single time
//31 minutes to solve
public class StringCompressor {
    private StringBuilder output = new StringBuilder();

    public String compressString(String input) {
        if (input == null || input.length() == 0) return new String();
        if (input.length() == 1) return new String(input + "1");

        int left = 0;
        int right = 0;

        while (left <= input.length() - 1) {
            if (left == input.length() - 1) {
                output.append(input.charAt(left) + "1");
                return output.toString();
            }

            right = left + 1;
            int counter = 1;

            while (input.charAt(left) == input.charAt(right)) {
                right++;
                counter++;
                if (right == input.length() - 1) {
                    counter++;
                    break;
                }
            }
            output.append(input.charAt(left));
            output.append(Integer.toString(counter));
            left += counter;
        }
        return output.toString();
    }
}


//String compression: Implement a method to perform basic string compression using the
//counts of repeated characters. For example the string aabcccccaaa would become
//a2b1c5a3.
//aaaaaaaabcccccaaa
//^               ^
//a2b
// counter = 2
//ab