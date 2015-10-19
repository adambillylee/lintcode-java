/**
 * Created by adamli on 10/17/15.
 */
public class Sort_Colors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
//    public void sortColors(int[] nums) {
//        /**
//         * initialization
//         * "the next 1 supposed to be at position 0"
//         * "the next 0 suposed to be at position 0"
//         */
//        int lastZero = 0;
//        int lastOne = 0;
//        int i = 0;
//
//        /**
//         * start with assuming there is only 2 in the array (from end to beginning of array)
//         * use i to loop through all elements
//         * start rewriting 2 with 0 and 1 as i finds 0 and 1's in array
//         * rewrite start with the order of 2 -> 1 -> 0 since 0 is at the beginning of arrays
//         */
//        while (i<nums.length) {
//            // if i finds 0
//            if (nums[i] == 0) {
//                // rewrite i as 2, as our assumption is array only has 2 to begin with
//                nums[i] = 2;
//
//                // rewrite next possible 1 position to be 1 and more "last 1" position forward
//                nums[lastOne++] = 1;
//
//                // since there is a 0, rewrite last 0 position to be 0 and move "last 0" position forward
//                nums[lastZero++] = 0;
//            }else if (nums[i] == 1) {
//                // same thing with above
//                nums[i] = 2;
//
//                // there is no 0's, so only rewrite 1 and move "last 1" position forward
//                nums[lastOne++] = 1;
//            }
//
//            // don't forget to move i forward
//            i++;
//        }
//    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int i = 0;

        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left++);
                i++;
            }else if (nums[i] == 1) {
                i++;
            }else {
                swap(nums, i, right--);
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String args[]) {
        int nums[] = new int[]{1, 0, 2, 1, 0};

        for (int i=0; i<nums.length;i++) {
            System.out.print(nums[i]);
        }
        System.out.println("\n");

        Sort_Colors sol = new Sort_Colors();

        sol.sortColors(nums);
    }
}
