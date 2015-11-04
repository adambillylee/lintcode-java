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
        int pathLength = 1;

        // use a hash set to record all traversed nodes in graph
        HashSet<String> hash = new HashSet<String>();

        // make a queue for BST
        LinkedList<String> queue = new LinkedList<String>();

        queue.offer(start);
        hash.add(start);

        /**
         * BST
         * 1st loop: check if queue is empty, if empty, end BST
         */
        while (!queue.isEmpty()) {
            // get the size of current queue
            int size = queue.size();

            // add path length +1 for one more breath level
            pathLength++;
            // 2nd loop: loop through the queue (all words in current breath lvl)
            for (int i=0; i<size; i++) {
                String word = queue.poll();

                // 3rd loop: loop through all possible next words for curr word
                // (one char diff than curr word and in dict)
                for (String nextWord: getNextWord(word, dict)) {
                    // the word has been checked before, don't duplicate the path
                    if (hash.contains(nextWord))
                        continue;

                    if(nextWord.equals(end)) {
                        return pathLength;
                    }else{
                        queue.offer(nextWord);
                        hash.add(nextWord);
                    }
                }
            }
        }

        return pathLength;
    }

    /**
     * get all possible next word based on curr word an dict
     * @param word
     * @return
     */
    public ArrayList<String> getNextWord(String word, Set<String> dict) {
        ArrayList<String> rst = new ArrayList<String>();

        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        int len = word.length();

        for(int i=0; i<len-1; i++) {
            for(int j=0; j<alphabets.length();j++) {
                char[] wordChar = word.toCharArray();
                wordChar[i] = alphabets.charAt(j);
                String newWord = new String(wordChar);

                if (dict.contains(newWord))
                    rst.add(newWord);
            }
        }

        return rst;
    }

    public static void main(String args[]) {
        Word_Ladder sol = new Word_Ladder();
    }
}
