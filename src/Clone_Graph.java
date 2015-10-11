import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adamli on 10/10/15.
 */
public class Clone_Graph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        // use a hashmap and arraylist to implement a queue for BST
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode> ();
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();

        // add initial node
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        /**
         * use start to keep track of the position
         * of first new node added into nodes in each iteration
         */
        int start = 0;
        while(start < nodes.size()) {
            /** get the next node and add start by 1
             * this is why we don't use queue object
             * since queue.pop() removes head from queue
             * but we need them for adding neighbors later
             */
            UndirectedGraphNode head = nodes.get(start++);

            // use i to loop through all neighbors of head
            for (int i=0; i<head.neighbors.size(); i++) {
                // the new neighbor node
                UndirectedGraphNode neighbor = head.neighbors.get(i);

                // if new neighbor is not in map, its not in queue
                // to add new neighbor into queue:
                if (!map.containsKey(neighbor)) {
                    // 1. add it into map
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));

                    // 2. add neighbor into nodes
                    nodes.add(neighbor);
                }
            }
        }

        /**
         * OK, so we had all old into nodes
         * and each of them has a coresponding cloned node in map.get(node)
         * now fix the neighbor of each cloned node (edges) in map one by one
         * use i to loop through all nodes in queue
         */
        for (int i=0; i<nodes.size(); i++) {
            // use j to loop through all neighbors for old node
            for (int j=0; j<nodes.get(i).neighbors.size(); j++){
                // get old node
                UndirectedGraphNode oldNode = nodes.get(i);

                // get cloned node
                UndirectedGraphNode newNode = map.get(oldNode);

                // find the corresponding neighbor from map add stick into
                // neighbor of new nodes
                newNode.neighbors.add(map.get(oldNode.neighbors.get(j)));
            }
        }

        // return cloned initial node
        return map.get(node);
    }

    private class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
}
