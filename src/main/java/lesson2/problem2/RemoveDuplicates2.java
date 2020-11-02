package lesson2.problem2;

import lesson2.problem0.Link;
import lesson2.problem0.LinkedList;

public class RemoveDuplicates2 {

    //O(n^2) time | O(1) space
    public void removeDuplicates2(Link head) {
       if (head == null || head.next == null) {
           return;
       }
       Link currentNode = head;

       while (currentNode != null) {
           Link runner = currentNode;
           while (runner.next != null) {
               if (runner.next.value == currentNode.value) {
                   runner.next = runner.next.next;
               }
               else {
                   runner = runner.next;
               }
           }
           currentNode = currentNode.next;
       }
    }

    public static void main(String args[]) {
        LinkedList underTest = new LinkedList();
        int[] values = {9,9,9,9,9,9};
        //int[] values = {1};

        underTest.insertAll(values);
        underTest.removeDuplicates2(underTest.getHead());
        underTest.display();
    }
}

//Remove Duplicates 2: Given a sorted linked list, delete all nodes that have duplicate
//numbers, leaving only distinct numbers from the original list. Return the linked list sorted
//as well.
//● Example:
//○ Input: 1 -> 1 -> 2 -> 3 -> 3 -> 3 -> 4 -> 4 -> 5
//○ Output: 2 -> 5
// 1, false
