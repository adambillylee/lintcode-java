/**
 * Created by adamli on 10/8/15.
 */
public class Sort_List {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // find middle point of linked list
        ListNode mid = findMid(head);

        /**
         * divide and conquer
         * right half of linkedlist is [mid.next~end]
         */
        ListNode right = sortList(mid.next);

        /**
         * after right is sorted
         * put mid.next so head is connected until mid
         * left half = [head~mid]
         */
        mid.next = null;

        // sort left half
        ListNode left = sortList(head);

        // conquer, merge left and right
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode head = new ListNode(0);
        dummy.next = head;

        /**
         * when two lists still have nodes
         */
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            }else {
                head.next = right;
                right = right.next;
            }

            head = head.next;
        }

        /**
         * where there is only one list have nodes
         */
        while (left != null) {
            head.next = left;
            left = left.next;
            head = head.next;
        }

        while (right != null) {
            head.next = right;
            right = right.next;
            head = head.next;
        }


        //dummy.next.val = 0, remember to skip the very first "head node"
        return dummy.next.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
