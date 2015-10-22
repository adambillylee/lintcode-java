import java.util.HashMap;

/**
 * Created by adamli on 10/21/15.
 */
public class Two_Sum {
    /*
 * @param numbers : An array of Integer
 * @param target : target = numbers[index1] + numbers[index2]
 * @return : [index1 + 1, index2 + 1] (index1 < index2)
 */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        int rst[] = new int[2];

        // create an map recording the index of (target-current number)
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        /**
         * loop through numbers, if there is an target - numbers[i] in the map
         * we have our 2-sum
         */
        for (int i = 0; i<numbers.length; i++) {
            int diff = target - numbers[i];

            if (map.containsKey(numbers[i])) {
                // get the index of the diff
                int index = map.get(numbers[i]);
                rst[0] = Math.min(i, index) + 1;    //stupid problem requirement( start of index with 1)
                rst[1] = Math.max(i, index) + 1;
                break;
            }else {
                map.put(diff, i);
            }
        }

        return rst;
    }
}
