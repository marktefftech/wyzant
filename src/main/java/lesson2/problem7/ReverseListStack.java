package lesson2.problem7;

import lesson2.problem0.Link;
import lesson2.problem0.LinkedList;

import java.util.Stack;

public class ReverseListStack {
    public Link reverseListUsingStack(Link head) {
        final Stack<Integer> myStack = new Stack<>();
        Link current = head;

        Link dummy = new Link(-1);
        Link returnList = dummy.next;

        if (current == null || current.next == null) {
            throw new IllegalArgumentException();
        }

        while (current != null) {
            myStack.add(current.value);

            if (current.next == null) {
                break;
            }
            current = current.next;
        }

        while (myStack.peek() != null) {
            returnList.next = new Link(myStack.pop());
        }

        return returnList;
    }

    public static void main(String args[]) {
        LinkedList underTest = new LinkedList();
        int[] values = {1,2,3,4,5,6,7,777,0,0,900,8,9,10,5,5,5,5};
        //int[] values = {1};

        underTest.insertAll(values);
        Link returnLink = underTest.reverseListUsingStack(underTest.getHead());

        StringBuilder res = new StringBuilder();
        while (returnLink != null) {
            res.append(returnLink.value + "-->");
            returnLink = returnLink.next;
        }
        System.out.println(res);

    }
}
