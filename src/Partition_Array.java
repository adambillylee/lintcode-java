/**
 * Created by adamli on 10/25/15.
 */
public class Partition_Array {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // two cursors, from both side
        int left = 0;
        int right = nums.length-1;

        /**
         * move two cursors from two sides to middle
         */
        while(left<right) {
            //at start of each iteration

            // move left cursor to first element >= k
            while(left<right && nums[left]<k)
                left++;

            // move right cursor to first elements <k
            while(left<right && nums[right] >=k)
                right--;

            // if left and right elements are in wrong position, swap
            if(nums[left]>= k && nums[right]<k)
                swap(nums, left, right);
        }

        /**
         * if right still at the end, k > all elements
         * return right + 1 since index is not 0 based (stupid question)
         */
        if(right == nums.length-1) {
            return right+1;
        }else{
            /**
             * note that return right cursor as split line
             * since left part doesn't have to be sorted (as long as < k)
             * so left does not necessarily be at split line
             */
            return right;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
