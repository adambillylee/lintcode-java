import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by adamli on 11/8/15.
 */
public class Top_K_Frequent_WordsTest {

    Top_K_Frequent_Words sol = new Top_K_Frequent_Words();

    @Test
    public void testTopKFrequentWords() throws Exception {
        String words[] = {"yes","lint","code","yes","code","baby","you","baby","chrome",
                "safari","lint","code","body","lint","code"};

        int k = 3;

        String expected[] = {"code", "lint", "baby"};

        String actual[] = sol.topKFrequentWords(words, k);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMaxHeapify() throws Exception {
        // create test heap: a:2, b:1, c:3
        HashMap<String, HeapNode> map = new HashMap<String, HeapNode>();
        HeapNode a = new HeapNode("a");
        a.addFreq();
        HeapNode b = new HeapNode("b");
        HeapNode c = new HeapNode("c");
        c.addFreq();
        c.addFreq();

        ArrayList<HeapNode> heap = new ArrayList<HeapNode>();

        map.put("a",a);
        map.put("b",b);
        map.put("c",c);

        sol.heapInsert(heap, 0, "a", map);
        sol.heapInsert(heap, 0, "b", map);
        sol.heapInsert(heap, 0, "c", map);

        int expected[] = {1,2,3};
        int actual[] = new int[expected.length];

        for (int i=0; i<expected.length; i++) {
            actual[i] = heap.get(i).freq;
        }

        assertArrayEquals(expected, actual);
    }
}