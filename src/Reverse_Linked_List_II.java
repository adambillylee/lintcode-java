import java.util.LinkedList;

/**
 * Created by adamli on 10/8/15.
 */
public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // look for preM node location
        // since we need to point it to m after reverse m~n
        head = dummy;
        for (int i=1; i<m; i++) {
            head = head.next;
        }

        ListNode preM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;

        // reverse [m~n]
        for (int i=m; i<n; i++) {
            if (postN == null)
                return null;

            ListNode tmp = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = tmp;
        }

        /**
         * connect prem to N
         * connect n to post M
         * since the middle portion is flipped already
         */
        preM.next = nNode;
        mNode.next = postN;

        return dummy.next;
    }

    public static void main(String arg[]) {
        Reverse_Linked_List_II sol = new Reverse_Linked_List_II();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;

        ListNode A = sol.reverseBetween(head,2,4);

        while (A != null) {
            System.out.println(A.val);
            A = A.next;
        }
    }
}
