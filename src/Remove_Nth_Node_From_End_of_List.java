/**
 * Created by adamli on 9/30/15.
 */
public class Remove_Nth_Node_From_End_of_List {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = head;

        // since slow cursor needs to point to the previous node of delete position as last
        // it has to start with one node behind head
        ListNode slow = dummy;

        // move fast by n step
        for (int i=0; i<n; i++) {
            // if fast already reached null, it means linked list length < n, return null
            if (fast == null)
                return null;

            // move cursor after non-null desicion to avoid the case where n=length of linked list
            // and fast move to null
            fast = fast.next;
        }

        /**
         * move cursor until fast hit null
         * since slow starts at dummy, it will be at n+1th position before null
         * slow.next = nth node from the end
         */
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove node
        slow.next = slow.next.next;

        // return dummy.next for head node
        return dummy.next;
    }


    public static void main(String ags[]) {
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);

        Remove_Nth_Node_From_End_of_List sol = new Remove_Nth_Node_From_End_of_List();

        ListNode result = sol.removeNthFromEnd(root, 4);
    }
}
