/**
 * Created by adamli on 9/30/15.
 */
public class Partition_List {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode lDummy = new ListNode(0);
        ListNode rDummy = new ListNode(0);

        ListNode curr = head;
        ListNode lCurr = lDummy;
        ListNode rCurr = rDummy;

        while (curr!=null) {
            if (curr.val < x) {
                lCurr.next = curr;
                lCurr = lCurr.next;
            }else {
                rCurr.next = curr;
                rCurr = rCurr.next;
            }
        }

        rCurr.next = null;
        lCurr.next = rDummy.next;

        return lDummy.next;
    }
}
