import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by adamli on 10/21/15.
 */
public class Three_Sum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        if (numbers.length<3)
            return null;

        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();

        // sort the numbers
        Arrays.sort(numbers);

        for (int first = 0; first < numbers.length-2; first++) {
            /**
             * if first number is not at start position
             * skip iteration if current number = previous number (numbers[first]==numbers[first-1])
             */
            if (first != 0 && numbers[first] == numbers[first-1])
                continue;

            // create second and third number pointer
            int second = first+1;
            int third = numbers.length-1;
            while (second<third) {
                int sum = numbers[second] + numbers[third] + numbers[first];

                if (sum>0) {
                    third--;
                }else if (sum <0) {
                    second++;
                }else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[first]);
                    list.add(numbers[second]);
                    list.add(numbers[third]);
                    rst.add(list);

                    //remember to move cursors forward...
                    second++;
                    third--;

                    /**
                     * now start to deal with duplicates on second and third number
                     * two conditions:
                     * 1. second number still have to be smaller than third number
                     * 2. skip if current second number = previous second number or
                     * current third number = previous third number
                     */
                    while(second<third && numbers[second-1]==numbers[second])
                        second++;

                    while(second<third && numbers[third+1]==numbers[third])
                        third--;
                }
            }

        }

        return rst;
    }
}
