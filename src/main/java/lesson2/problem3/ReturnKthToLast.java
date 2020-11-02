package lesson2.problem3;

import lesson2.problem0.Link;
import lesson2.problem0.LinkedList;

public class ReturnKthToLast {

    public static int returnKthToLastElement(Link head, int index) {
        Link current = head;
        Link runner = current;
        int k = 0;

        while (runner.next != null && k < index) {
            runner = runner.next;
            k++;
        }

        if (k != index) {
            return 0;
        }
        else {
            while (runner.next != null) {
                runner = runner.next;
                current = current.next;
            }
            return current.value;
        }
    }

    public static void main(String args[]) {
        LinkedList underTest = new LinkedList();
        int[] values = {1,2,3,4,5,6,7,8,9,10};
        //int[] values = {1};

        underTest.insertAll(values);
        int actual = underTest.returnKthToLastElement(underTest.getHead(),100);
        System.out.println("Kth to last element is: " + actual);

    }
}

//Return Kth to Last: Implement an algorithm to find the Kth to last element of a singly linked
//list.
//1,2,3,4,5,6,5,4,3,2,1,1,1,1,1,1,2,9
//send runner <n> positions out
    // if you can't, return first element
//increment both runner and current until runner is null'
