import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;

import java.util.*;

/**
 * Created by adamli on 11/8/15.
 */
public class Top_K_Frequent_Words {
    /**
     * Solve it by using HashMap
     * @param words an array of string
     * @param k     an integer
     * @return an array of string
     */
//    public String[] topKFrequentWords(String[] words, int k) {
//        // define a hash map to record frequency
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//
//        int len = words.length;
//
//        // compute all word frequency and put into hashmap
//        for (String word : words) {
//            // if word freq in map, add it by 1
//            if (map.containsKey(word)) {
//                map.put(word, map.get(word)+1);
//            }else{
//                map.put(word, 1);
//            }
//        }
//
//        // create an ArrayList for purpose of sorting map elements
//        ArrayList<Map.Entry<String ,Integer>> tmp = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
//
//        // sort the elements in map from highest frequency to lowest
//        Collections.sort(tmp, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                if (o1.getValue() == o2.getValue()) {
//                    /**
//                     * if word freq of both map ele is same
//                     * return the one with lower alphabet order
//                     */
//                    return o1.getKey().compareTo(o2.getKey());
//                }else{
//                    return o2.getValue() - o1.getValue();
//                }
//            }
//        });
//
//        // put top k elements into result set
//        String rst[] = new String[k];
//
//        for (int i=0; i<k; i++) {
//            rst[i] = tmp.get(i).getKey();
//        }
//
//        return rst;
//    }

    public String[] topKFrequentWords(String[] words, int k) {
        String rst[] = new String[k];
        if (k==0)
            return rst;

        PriorityQueue<HeapNode> heap = new PriorityQueue<HeapNode>(k, new Comparator<HeapNode>() {
            @Override
            public int compare(HeapNode o1, HeapNode o2) {
                if (o2.freq == o1.freq) {
                    return o1.word.compareTo(o2.word);
                }else{
                    return o2.freq - o1.freq;
                }
            }
        });

        ArrayList<HeapNode> nodes = new ArrayList<HeapNode>();

        HashMap<String, HeapNode> map = new HashMap<String, HeapNode>();

        for (String word : words) {
            if (map.containsKey(word)) {
                HeapNode node = map.get(word);
                node.freq++;
                map.put(word, node);
            }else{
                // create new node
                HeapNode node = new HeapNode();
                node.word = word;
                node.freq = 1;
                node.index = nodes.size();

                // put node in map and list
                map.put(word,node);
                nodes.add(node);
            }
        }

        // get top k nodes by word freqs
        for(HeapNode node : nodes) {
            heap.offer(node);
        }

        for (int i=0; i<k; i++) {
            String word = heap.poll().word;
            rst[i] = word;
        }

        return rst;
    }

    class HeapNode{
        String word;
        int freq;
        int index;
    }

}