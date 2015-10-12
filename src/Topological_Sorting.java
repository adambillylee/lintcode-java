import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by adamli on 10/11/15.
 */
public class Topological_Sorting {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        /**
         * BST on graph:
         * keep looking for node with in-degree = 0, add it into result
         * then remove its all edges, keep looking
         */

        if (graph == null || graph.size()==0)
            return null;

        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

        // use a hash map to record the in-degree of all nodes in graph (only when in-degree > 0)
        HashMap<DirectedGraphNode, Integer> in_degree = new HashMap<DirectedGraphNode, Integer>();

        /**
         * add all node's in-degree into map (all nodes with in-degree > 0)
         */
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor: node.neighbors) {

                // in indegree is already in map, add it by 1
                if (in_degree.containsKey(neighbor)) {
                    in_degree.put(neighbor, in_degree.get(neighbor)+1);
                }else {
                    // if not, add it into map and set in-degree tobe 1
                    in_degree.put(neighbor, 1);
                }
            }
        }

        /**
         * add all nodes with in-degree = 0 into queue
         * and result
         */
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

        for (DirectedGraphNode node : graph) {
            if (!in_degree.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }

        /**
         * Removing edges and final traverse:
         * poll the head from queue (in-degree = 0)
         * remove all edges (loop through all neighbours of head and minues their in-degree by 1 from head)
         * if it produce more zero in-degree nodes, add it into queue
         */
        while(!queue.isEmpty()) {
            DirectedGraphNode head = queue.poll();

            for (DirectedGraphNode neighbor : head.neighbors) {
                in_degree.put(neighbor, in_degree.get(neighbor)-1);

                if (in_degree.get(neighbor) ==0) {
                    queue.add(neighbor);
                    result.add(neighbor);
                }
            }
        }

        return result;
    }
}

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}

