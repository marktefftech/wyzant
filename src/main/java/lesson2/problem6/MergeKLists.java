package lesson2.problem6;

import lesson2.problem0.Link;
import lesson2.problem0.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

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

    public static void main(String args[]) {
        LinkedList underTest = new LinkedList();
        int[] values = {1,2,3,4,5,6,50,60,70};
        LinkedList underTest2 = new LinkedList();
        int[] values2 = {40,50,60,70,80};
        //int[] values = {1};
        underTest.insertAll(values);
        underTest2.insertAll(values2);

        ArrayList<Link> myList = new ArrayList<>();
        myList.add(underTest.getHead());
        myList.add(underTest2.getHead());

        Link actual = mergeLists(myList);

        StringBuilder res = new StringBuilder();
        while (actual != null) {
            res.append(actual.value + "-->");
            actual = actual.next;
        }

        System.out.println(res.substring(0,3));

    }
}
