/**
 * Created by adamli on 10/4/15.
 */


import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
  int label;
  RandomListNode next, random;
  RandomListNode(int x) { this.label = x; }
}

public class Copy_List_with_Random_Pointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        /**
         * create a hashmap to store mapping from original node to copy node
         */
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        // create orignal dummy node and copy dummy node
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode dummyCopy = new RandomListNode(0);
        dummy.next = head;

        // create copy head node and dummy copy node
        RandomListNode copy = new RandomListNode(head.label);
        dummyCopy.next = copy;

        while (head !=  null) {
            // deal with last node
            if (head.next == null) {
                copy.next = null;
            }else {
                copy.next = new RandomListNode(head.next.label);
            }

            //put mapping from head nodes to copy nodes
            map.put(head, copy);

            head = head.next;
            copy = copy.next;
        }

        // replace head of both linked list to origin node
        copy = dummyCopy.next;
        head = dummy.next;

        // for each node in origin, put the corresponding random node into copy node
        while (head != null) {
            copy.random = map.get(head.random);
            head = head.next;
            copy = copy.next;
        }

        // return head of copy node
        return dummyCopy.next;
    }
}
