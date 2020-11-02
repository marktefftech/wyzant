package lesson2.problem0;

import javax.naming.OperationNotSupportedException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class LinkedList<E> {
    public Link head;

    public LinkedList() {
        head = null;
    }

    public Link getHead() {
        return this.head;
    }

    public Link setHead(Link newHead) {

        head = newHead;

        return this.head;
    }

    public boolean isEmpty() {
        return (head ==null);
    }

    public void addFirstLink(int value) {
        Link newLink = new Link(value);

        newLink.next = head;

        head = newLink;
    }

    public void insert(int value) {
        Link newLink = new Link(value);

        if (isEmpty()) {
            this.head = newLink;
        }
        else {
            Link currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newLink;
        }
    }

    public void insertAll(int[] values) {
        for (int value : values) {
            Link newLink = new Link(value);

            if (isEmpty()) {
                this.head = newLink;
            }
            else {
                Link currentNode = head;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = newLink;
            }
        }
    }

    public Link getLink(int value) {
        Link linkReference = getHead();

        if (!isEmpty()) {
            while (linkReference.value != value) {
                if (linkReference.next == null) {
                    return null;
                }
                else {
                    linkReference = linkReference.next;
                }
            }
        }
        else {
            System.out.println("List is empty");
        }
        return linkReference;
    }

    public Link removeFirst() {
        Link linkReference = head;
        if (!isEmpty()) {
            head = head.next;
        }
        else {
            System.out.println("Removed Head");
        }
        return linkReference;
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        Link linkReference = head;
        while (linkReference != null) {
            sb.append(linkReference.value + "-->");
            linkReference = linkReference.next;
        }
        System.out.println(sb.substring(0, sb.length()-3));
    }

    public Link removeLink(int value) {
        Link linkReference = head;
        Link previousLink  = head;

        while (linkReference.value != value) {
            if (linkReference.next != null) {
                previousLink = linkReference;
                linkReference = linkReference.next;
            }
            else {
                return null;
            }
        }
        if (linkReference == head) {
            head = head.next;
        }
        else {
            previousLink.next = linkReference.next;
        }
        return linkReference;
    }

    // ********************* TESTING ************************** //
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

    public static void deleteMiddleNode (Link head) {
        if (head.next == null || head == null) {
            return;
        }

        Link jumper = head;
        jumper.value = jumper.next.value;
        jumper.next = head.next.next;
    }

    public Link partition(Link head, int pivot) {
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

    public static Link mergeLists(List<Link> input) {
        if (input == null || input.size() == 0) {
            throw new IllegalArgumentException();
        }
        final PriorityQueue<Link> myQueue = new PriorityQueue<>(input.size(), new Comparator<Link>() {
            @Override
            public int compare(Link o1, Link o2) {
                return 0;
            }
        });

        Link returnList = new Link(0);
        Link listEnd = returnList;

        for (Link thisLink : input) {
            if (thisLink != null) {
                myQueue.add(thisLink);
            }
        }

        while (!myQueue.isEmpty()) {
            listEnd.next = myQueue.poll();
            listEnd = listEnd.next;

            if (listEnd.next != null) {
                myQueue.add(listEnd.next);
            }
        }
        return returnList.next;
    }

    public Link reverseListUsingStack(Link head) {
        Stack<Link> myStack = new Stack<>();
        Link current = head;

        if (current == null || current.next == null) {
            throw new IllegalArgumentException();
        }

        while (current != null) {
            myStack.push(current);
            current = current.next;
        }

        head = myStack.pop();
        Link next = head;

        while (!myStack.isEmpty()) {
            Link nextLink = myStack.pop();
            next.next = nextLink;
            next = nextLink;
        }
        next.next = null;
        return head;
    }

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

    public static Link getListIntersection(Link list1, Link list2) {
        Link a = list1;
        Link b = list2;

        while (a != b) {
            a = a == null ? list2 : a.next;
            b = b == null ? list1 : b.next;
        }
        return a;
    }

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

}



