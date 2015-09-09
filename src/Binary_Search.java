/**
 * Created by adamlee on 15-09-09.
 */
public class Binary_Search {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end){
            int mid = (start + end) / 2;

            /**
             * if nums[mid] > target, the target must be in first half, so cut mid+1 ~ end from search range
             * if nums[mid] = target, since we are looking for 1st occurrence, reduce search range to first half
             * keep searching for potential prior occurrence of target
             * if nums[mid] < target, the target is in later half, so cut 0 ~ mid from search range by moving start to mid
             */
            if (nums[mid] >= target){
                end = mid;
            } else {
                start = mid;
            }
        }

        // remember to return -1 when neither start or end hits the target
        if (nums[start] == target) {
            return start;
        }else if(nums[end] == target){
            return end;
        }else{
            return -1;
        }
    }
}

