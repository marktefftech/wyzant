package lesson2.problem1;

import lesson1.problem3.UniqueCharactersInStringFeedback;
import lesson2.problem0.Link;
import lesson2.problem0.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static Link deleteDuplicates(Link head) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        final Set<Integer> set = new HashSet<>();
        Link previous = null;
        Link currentNode = head;

        while (currentNode != null){
            boolean isVisited = set.add(currentNode.value);
            if (!isVisited){
                previous.next = currentNode.next;
            }
            else{
                previous = currentNode;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    public static void main(String args[]) {
        LinkedList underTest = new LinkedList();
        int[] values = {1,2,3,4,5,6,5,4,3,2,1,1,1,1,1,1,2,9};
        //int[] values = {1};

        underTest.insertAll(values);
        underTest.deleteDuplicates(underTest.getHead());
        underTest.display();
    }
}



//Remove Duplicates: Write code to remove duplicates from an unsorted list.
//● What if a temporary buffer is not allowed?
//● Example:
//○ Input: 1 -> 1 -> 5 -> 5 -> 3 -> 3 -> 3 -> 2
//○ Output: 1 -> 5 -> 3 -> 2

// below works for sorted
//  public Link deleteDuplicates(Link head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        Link currentNode = head;
//
//        while(currentNode.next != null){
//            if (currentNode.next.value == currentNode.value){
//                currentNode.next = currentNode.next.next;
//            }
//            else {
//                currentNode = currentNode.next;
//            }
//        }
//        return head;
//    }