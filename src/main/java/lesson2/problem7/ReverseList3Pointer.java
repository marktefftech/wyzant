package lesson2.problem7;

import lesson2.problem0.Link;

public class ReverseList3Pointer {

    public Link reverseList3Pointer(Link head) {
        if (head == null || head.next == null){
            return head;
        }
        Link pre = null;
        Link cursor = head;
        Link next = cursor.next;
        while(next != null){
            cursor.next = pre;
            pre = cursor;
            cursor = next;
            next = next.next;
        }
        cursor.next = pre;
        return cursor;
    }
}
