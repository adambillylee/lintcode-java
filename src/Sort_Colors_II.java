/**
 * Created by adamli on 10/18/15.
 */
public class Sort_Colors_II {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // initialization
        int count = 0;

        // two pointers at start and the end
        int start = 0;
        int end = colors.length-1;

        /**
         * outer loop:
         * each iteration moves the min/max value to
         * start/end of the iterative range
         */
        while (count <= k) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            /**
             * look for min/max value in current
             * iteration (of outer loop)
             */
            for (int j=start; j<=end; j++) {
                if (colors[j]<min)
                    min = colors[j];

                if (colors[j]>max)
                    max = colors[j];
            }

            // reset the curr cursor to start of inner loop
            int curr = start;

            /**
             * inner loop
             * from start to end (close interval)
             * use swap to move min/max value elements
             * to both side
             */
            while (curr <= end) {
                /**
                 * use start to track last min value position
                 */
                if (colors[curr] == min) {
                    // swap to left
                    swap(colors, curr, start++);

                    /**
                     * since swapped new value comes from left
                     * the value is already checked
                     * so we can move curr forward
                     */
                    curr++;
                } else if (colors[curr] == max) {
                    /**
                     * swap max value element to the right
                     * swapped value is a new unchecked value
                     * from the right
                     * no curr++, curr stays to check this new value
                     */
                    swap(colors, curr, end--);
                } else {
                    // don't worry about other values
                    curr++;
                }
            }

            // each inner loop take care of a min/max pair
            // add count by 2
            count+=2;
        }
    }

    /**
     * swap two values in array
     * @param colors
     * @param left
     * @param right
     */
    public void swap(int[] colors, int left, int right) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }

    public static void main(String args[]) {
        int nums[] = new int[]{3,2,3,3,4,3,3,2,4,4,1,2,1,1,1,3,4,3,4,2};

        for (int i=0; i<nums.length;i++) {
            System.out.print(nums[i]);
        }
        System.out.println("\n");

        Sort_Colors_II sol = new Sort_Colors_II();

        sol.sortColors2(nums,4);

        for (int i=0; i<nums.length;i++) {
            System.out.print(nums[i]);
        }
        System.out.println("\n");
    }
}
