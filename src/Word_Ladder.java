import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by adamli on 11/3/15.
 */
public class Word_Ladder {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // from start to any node has a initial path length of 1
        int pathLength = 1;

        // create a hashset to record visited strings for de-duplication
        HashSet<String> visited = new HashSet<String>();

        // create a queue to record all nodes in current level of "breath"
        LinkedList<String> queue = new LinkedList<String>();

        // initiation: add start into hash and queue
        visited.add(start);
        queue.offer(start);

        /**
         * 3 loops for BST
         * 1st loop: keep BST running until queue is empty
         */
        while (!queue.isEmpty()) {
            int size = queue.size();

            // if queue is not empty, we enter a new lvl of breath, add path length by 1
            pathLength++;

            /**
             * 2dn loop: loop through all nodes in current queue
             */
            for(int i=0; i<size; i++) {
                String word = queue.poll();

                /**
                 * 3rd loop: loop through all possible next word for current word
                 */
                for (String nextWord: getNextWords(word, dict)) {
                    // it next word is end, return path length
                    if (nextWord.equals(end)) {
                        return pathLength;
                    }else{
                        // if not, add next word into queue (next lvl of breath) and visited set
                        visited.add(nextWord);
                        queue.add(nextWord);
                    }
                }
            }
        }

        return pathLength;
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> rst = new ArrayList<String>();

        // list all possibilities of next alphabet
        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        int len = word.length();
        for(int i=0; i<len; i++) {
            for (int j=0; j< alphabets.length(); j++) {
                char letters[] = word.toCharArray();
                letters[i] = alphabets.charAt(j);
                String replaced = new String(letters);

                // if new word is in dict, add it into result
                if (dict.contains(replaced)) {
                    rst.add(replaced);
                }
            }
        }

        return rst;
    }

}
