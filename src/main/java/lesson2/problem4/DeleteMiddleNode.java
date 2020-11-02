package lesson2.problem4;

import lesson2.problem0.Link;
import lesson2.problem0.LinkedList;

public class DeleteMiddleNode {
    // O(n) time | O(1) space
    // Not sure why slides say O(1) time... we must iterate through nodes
    public static void deleteMiddleNode (Link head) {
        if (head.next == null || head == null) {
            return;
        }

        Link jumper = head;
        jumper.value = jumper.next.value;
        jumper.next = head.next.next;
    }

    public static void main(String args[]) {
        LinkedList underTest = new LinkedList();
        int[] values = {1,2,3,4,5,6,7,8,9,10};
        //int[] values = {1};

        underTest.insertAll(values);
        underTest.deleteMiddleNode(underTest.getLink(6));
        underTest.display();

    }
}




//Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e.: any node
//but the first and last node, not necessarily the exact middle) of a singly-linked list, given
//only access to that node.
//● Example:
//○ Input: the node c from the linked list a->b->d->e->f
//                                               ^
//                                              c, j
//○ Result: nothing is returned, but the updated linked list looks like a->b->d->e->f
