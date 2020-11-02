package lesson2.problem8;

import lesson2.problem0.Link;
import lesson2.problem0.LinkedList;

import java.util.Stack;

public class PalindromeChecker {

    public boolean isPalindrome(Link input) {
        Stack<Integer> myStack = new Stack<>();
        Link current = input;

        if (input == null) {
            return false;
        }

        while (input != null) {
            myStack.push(input.value);
            input = input.next;
        }

        while (!myStack.isEmpty()) {
            int value = myStack.pop();
            if (value != current.value) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public static void main(String args[]) {
        LinkedList underTest = new LinkedList();
        int[] values = {1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1};
        //int[] values = {1};

        underTest.insertAll(values);
        boolean actual = underTest.isPalindrome(underTest.getHead());
        System.out.println(actual);

    }
}
