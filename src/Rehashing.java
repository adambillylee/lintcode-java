/**
 * Created by adamli on 10/28/15.
 */
public class Rehashing {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length==0)
            return hashTable;

        int oldCap = hashTable.length;
        int newCap = oldCap * 2;

        // create empty new table
        ListNode[] newTable = new ListNode[newCap];

        /**
         * out loop: loop through old table
         */
        for (int oldKey=0; oldKey<oldCap; oldKey++) {
            ListNode curr = hashTable[oldKey];

            /**
             * inner loop: loop through all nodes of one
             * specific old key
             */
            while (curr != null) {
                // calculate new key
                int newKey = (curr.val % newCap + newCap) % newCap;

                /** if there is no new key in new table
                 * create a node for new key directly
                 */
                if(newTable[newKey] == null) {
                    newTable[newKey] = new ListNode(curr.val);
                }else {
                    // create a dummy node at head node of new key linkedlist
                    ListNode dummy = newTable[newKey];

                    // move dummy node to the end
                    while(dummy.next != null) {
                        dummy = dummy.next;
                    }

                    // create a new list node next to the end
                    dummy.next = new ListNode(curr.val);
                }

                // check the next node in old key linkedlist
                curr = curr.next;
            }
        }

        return newTable;
    }
}
