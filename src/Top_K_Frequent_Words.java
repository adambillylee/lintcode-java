import java.util.*;

/**
 * Created by adamli on 11/8/15.
 */
public class Top_K_Frequent_Words {
    /**
     * @param words an array of string
     * @param k     an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        int len = words.length;

        for(String word: words) {
            if (map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }else{
                map.put(word, 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> listForSort = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(listForSort, new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
                if (o2.getValue() == o1.getValue()) {
                    return o2.getKey().compareTo(o2.getKey());
                }else{
                    return o2.getValue() - o1.getValue();
                }
            }
        });

        String rst[] = new String[k];

        for (int i=0; i<k; i++) {
            rst[i] = (listForSort.get(i).getKey());
        }

        return rst;
    }
}