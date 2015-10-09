import com.sun.tools.javac.util.*;

import java.util.*;
import java.util.List;

/**
 * Created by adamli on 10/6/15.
 */
public class Merge_k_Sorted_Lists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKListsHeap(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        /**
         * use heap to sort all nodes from all lists
         */
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);

        // push the head of all nodes in to heap as initialization
        for (int i=0; i<lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        // create dummy node and pointer to construct new merged list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        /**
         * use heap to pop min node of all lists (O(1))
         * use tail pointer to add node into merged list, REMEMBER TO MOVE IT FORWARD FOR NEXT INSERTION
         * add the next node of min node into heap, for next round of comparison
         * continue until all nodes from all lists are added to heap -> poped from heap and added into merged list
         */
        while(!heap.isEmpty()) {
            // pop the min value in queue as next value of merged list
            ListNode head = heap.poll();
            tail.next = head;

            // move pointer forward to prepare for next insertion
            tail = tail.next;

            // get the next node from the lists and continue comparing
            if (head.next != null) {
                heap.add(head.next);
            }
        }

        // return the first node of merged list
        return dummy.next;
    }

    /**
     * define a ListNode comparator
     * if its an increasing list, use left-right
     */
    private Comparator<ListNode> comparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };


    /*****************************************************************************************************
     * 2X2 merged method
     */

    public ListNode mergeKListsDuoMerge(List<ListNode> lists) {
        if (lists == null || lists.size()==0)
            return null;

        while (lists.size() > 1) {
            List<ListNode> tmp = new ArrayList<ListNode>();

            for (int i=0; i<lists.size()-1;i+=2) {
                tmp.add(mergeTwo(lists.get(i), lists.get(i + 1)));
            }

            if (lists.size() % 2 == 1)
                tmp.add(lists.get(lists.size()-1));

            lists = tmp;
        }

        return lists.get(0);
    }

    public ListNode mergeTwo(ListNode headA, ListNode headB) {
        ListNode head = new ListNode(0);
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while(headA != null & headB != null) {
            if (headA.val < headB.val) {
                head.next = headA;
                headA = headA.next;
            }else {
                head.next = headB;
                headB = headB.next;
            }

            head = head.next;
        }

        while(headA != null) {
            head.next = headA;
            headA = headA.next;
            head = head.next;
        }

        while(headB != null) {
            head.next = headB;
            headB = headB.next;
            head = head.next;
        }

        head.next = null;

        return dummy.next.next;
    }

    public static void main(String args[]) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(3);
        A.next.next = new ListNode(5);
        A.next.next.next = null;

        ListNode B = new ListNode(2);
        B.next = new ListNode(8);
        B.next.next = new ListNode(10);
        B.next.next.next = null;

        ListNode C = new ListNode(22);
        B.next = new ListNode(83);
        B.next.next = new ListNode(100);
        B.next.next.next = null;

        Merge_k_Sorted_Lists sol = new Merge_k_Sorted_Lists();

        List<ListNode> lists = new ArrayList<ListNode>();
        lists.add(A);
        lists.add(B);
        lists.add(C);

        ListNode c = sol.mergeKListsDuoMerge(lists);

        while(c != null) {
            System.out.println(c.val);
            c = c.next;
        }
    }
}
