import java.util.*;

/**
 * Created by adamli on 11/4/15.
 */
public class Word_Ladder_II {
    /**
     * @param start, a string
     * @param end,   a string
     * @param dict,  a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // arraylist of paths for final result
        List<List<String>> ladders = new ArrayList<List<String>>();

        // record visited nodes and its distance to start
        HashMap<String, Integer> distance = new HashMap<String, Integer>();

        // a reverse node map for reverst DFS
        HashMap<String, ArrayList<String>> reverseMap = new HashMap<String, ArrayList<String>>();

        // a new array to record a single path from start to end
        ArrayList<String> path = new ArrayList<String>();

        // initiation
        dict.add(start);
        dict.add(end);

        bfs(distance, reverseMap, start, dict);
        dfs(ladders, path, reverseMap, distance, end, start, dict);

        return ladders;
    }


    /**
     * use BFS in order for
     * 1. calculate all path distance from start to any node
     * 2. construct a version node map for reverse DFS later
     */
    void bfs(HashMap<String, Integer> distance, HashMap<String, ArrayList<String>> reverseMap, String start,
             Set<String> dict) {

        // an empty queue for BST
        LinkedList<String> queue = new LinkedList<String>();

        distance.put(start, 0);

        // for all nodes, initiate its reverseMap with an empty arrayList
        for (String word : dict) {
            reverseMap.put(word, new ArrayList<String>());
        }

        queue.offer(start);

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            for (String nextWord : getNextWords(curr, dict)) {
                // add current word into reverse map of next word
                reverseMap.get(nextWord).add(curr);

                // if next word is visited, continue
                if (distance.containsKey(nextWord)) {
                    continue;
                }else{
                    // path distance of next word is current path distance + 1
                    distance.put(nextWord, distance.get(curr)+1);
                    queue.offer(nextWord);
                }
            }
        }
    }

    /**
     * reverse DFS, starting from end and look for start
     * always go to node with one less distance on each depth lvl
     * construct path on its way, if path is complete, add to ladder
     * @param ladders all possible min path from start to end
     * @param path recording nodes that build up a complete path
     * @param reverseMap a mapping (to, from)
     * @param distance path distance mapping
     * @param curr current node, start with end, moving to start
     * @param start start node
     * @param dict dict of all nodes
     */
    void dfs(List<List<String>> ladders, ArrayList<String> path, HashMap<String, ArrayList<String>> reverseMap,
             HashMap<String, Integer> distance, String curr, String start, Set<String> dict) {
        // add end into path
        path.add(curr);

        /**
         * base case: if path is complete, DFS finished, add completed path into ladders
         */
        if (curr.equals(start)) {
            // reverse path and add into ladder
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));

            // to continue, reverse the path back
            Collections.reverse(path);
        }else{
            for (String prev :reverseMap.get(curr)) {
                // if curr node has prev node and path distance of prev node is 1 unit smaller
                // recursive call DFS on prev node
                if (distance.containsKey(prev) && distance.get(prev) == distance.get(curr)-1)
                    dfs(ladders, path, reverseMap, distance, prev, start, dict);
            }
        }

        // remove path for backtracking, beware of the position
        path.remove(path.size()-1);
    }

    /**
     * search for all possible next words
     * @param curr
     * @param dict
     * @return
     */
    private ArrayList<String> getNextWords(String curr, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();

        for (int i=0; i<curr.length(); i++) {
            for (char j='a'; j<='z'; j++) {
                char letter[] = curr.toCharArray();

                if(letter[i] == j)
                    continue;

                letter[i] = j;
                String newWord = new String(letter);

                if(dict.contains(newWord))
                    nextWords.add(newWord);
            }
        }

        return nextWords;
    }

}