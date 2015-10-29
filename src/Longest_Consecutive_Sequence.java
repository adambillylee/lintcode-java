import java.util.HashSet;

/**
 * Created by adamli on 10/28/15.
 */
public class Longest_Consecutive_Sequence {
    /**
     * @param num: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // create a hash set to locate number in O(1) and remove in O(1)
        HashSet<Integer> set = new HashSet<Integer>();

        // add all numbers to set
        for (int number:num)
            set.add(number);

        int max = 1;
        for (int number:num) {
            // start left cursor with num-1
            int left = number - 1;

            // start right cursor with num+1
            int right = number + 1;

            // the min seq length is 1
            int count = 1;

            // if num has left
            while (set.contains(left)) {
                // for each left in num, add count by 1
                count++;

                // remove left from set so it never get hit anymore
                set.remove(left);

                // keep minus left by 1 until all consecutive smaller number is counted
                left--;
            }

            while (set.contains(right)) {
                // for each right in num, add count by 1
                count++;

                // remove right from set so it never get hit again
                set.remove(right);

                // keep adding 1 to right until all consecutive bigger number is counted
                right++;
            }

            // update max consecutive sequence length
            max = Math.max(max, count);
        }

        return max;
    }
}
