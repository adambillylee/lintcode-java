import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by adamli on 10/22/15.
 */
public class Four_Sum {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();

        if (numbers.length < 4)
            return rst;

        Arrays.sort(numbers);

        /**
         * use a hashmap to dedup the result
         * if a list is alreay in rst, don't add it again
         */
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<ArrayList<Integer>, Integer>();

        /**
         * O(n^2) loop through first two numbers
         * two sum method for last two numbers
         */
        for (int i=0; i<numbers.length-3; i++) {
            /**
             * REMEMBER, THE SECOND NUMBER STARTS WITH THE NUMBER NEXT TO
             * FIRST NUMBER!!!
             */
            for (int j=i+1; j<numbers.length-2; j++) {
                // start third number after second number
                int k = j + 1;
                // start last number pointer at the end
                int l = numbers.length - 1;

                /**
                 * two sum for last two numbers
                 */
                while (k < l) {
                    int sum = numbers[i] + numbers[j] + numbers[k] + numbers[l];

                    if (sum < target) {
                        k++;
                    }else if (sum > target) {
                        l--;
                    }else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        list.add(numbers[l]);

                        /**
                         * if current solution is not in rst yet
                         * add solution into result
                         * record this solution as "used" in hashmap
                         */
                        if (!map.containsKey(list)) {
                            rst.add(list);
                            map.put(list, 1);
                        }

                        //DON'T FORGET TO MOVE THE CURSOR!!!
                        k++;
                        l--;
                    }
                }
            }
        }

        return rst;
    }
}
