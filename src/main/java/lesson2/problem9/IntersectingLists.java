package lesson2.problem9;

import lesson2.problem0.Link;
import lesson2.problem0.LinkedList;

public class IntersectingLists {

    public static Link getListIntersection(Link list1, Link list2) {
        Link a = list1;
        Link b = list2;

        while (a != b) {
            a = a == null ? list2 : a.next;
            b = b == null ? list1 : b.next;
        }
        return a;
    }

    public static void main(String args[]) {
        Link intersector = new Link(3);

        Link l1 = new Link(0);
        l1.next = intersector;

        Link l2 = new Link(0);
        //l2.next = intersector;

        Link actual = getListIntersection(l1,l2);

        if (actual == null) {
            System.out.println("No intersection");
        }
        else {
            System.out.println(actual.value);
        }

    }
}
