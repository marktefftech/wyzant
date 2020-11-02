package lesson2.problem10;

import lesson2.problem0.Link;

public class LoopDetector {

    public static Link detectLoop(Link head) {
        if (head == null) {
            return new Link(0);
        }

        Link slow = head;
        Link fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (head != fast) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        Link circle = new Link(2);

        Link circleList = new Link(0); // 0 > 2 > 3
        circleList.next = circle;
        circleList.next.next = new Link(3);
        circleList.next.next.next = circle;

        Link actual = detectLoop(circleList);

        if (actual == null) {
            System.out.println("No intersection");
        }
        else {
            System.out.println(actual.value);
        }
    }
}
