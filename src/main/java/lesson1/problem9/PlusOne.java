package lesson1.problem9;

import java.util.ArrayList;

// Average case O(1) time | Worst case O(n) time if we have all 9's
// O(1) space
// 25 mins to solve
public class PlusOne {
    private ArrayList<Integer> array;

    public PlusOne() {
        this.array = new ArrayList<Integer>();
    }

    public ArrayList<Integer> addOne(ArrayList<Integer> input) {
        array = input;

        if (array == null || array.size() == 0) return array;
        if (checkIfAll9s()) {
            // Array consists of all 9's, handle special case
            array.add(0);
            for (int i = 0; i <= array.size() - 1; i++) {
                array.set(i, 0);
            }
            array.set(0,1);
            return array;
        }

        int last = array.size() - 1;

        if (array.get(last) != 9) {
            array.set(last, ++last);
            return array;
        }

        while (array.get(last) == 9) {
            array.set(last,0);
            last--;
        }
        array.set(last, array.get(last) + 1);

        return array;
    }

    private boolean checkIfAll9s() {
        for (int i = 0; i <= array.size() - 1; i++) {
            if (array.get(i) != 9) return false;
        }
        return true;
    }
}

//Plus One: Given a non-negative number represented as an array of digits, add one to the
//number. The digits are stored such that the most significant digit is at the head of the list.
//Return an array of digits with the result (don’t return an integer)

// [1,2,9,9,9]
//    ^
// [1,2]       = 12
// [4,4,4,4,4] = 44444

// if last number != 9
    //--> add 1 to last number and return
    //--> while len - 1 != 9
        // set to zero
        // idx--

// edge case: all 9's
// set everything to 0
// insert 1 at head
