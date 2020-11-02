package lesson2.problem5;

import lesson2.problem0.Link;
import lesson2.problem0.LinkedList;

public class Partition {

    public Link partition(Link head, int pivot) {
        if (head == null ) {
            return new Link(0);
        }

        Link before = new Link(0);
        Link onOrAfter = new Link(0);
        Link curr1 = before, curr2 = onOrAfter;

        while (head != null) {
            if (head.value < pivot) {
                curr1.next = head;
                curr1 = head;
            }
            else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = onOrAfter.next;
        return before.next;
    }

    public static void main(String args[]) {
        LinkedList underTest = new LinkedList();
        int[] values = {1,2,3,4,5,6,7,777,0,0,900,8,9,10,5,5,5,5};
        //int[] values = {1};

        underTest.insertAll(values);
        underTest.partition(underTest.getHead(), 3);
        underTest.display();

    }
}
