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

            if (nums[mid] >= target){
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }else if(nums[end] == target){
            return end;
        }else{
            return -1;
        }
    }
}

