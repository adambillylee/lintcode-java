import java.util.ArrayList;

/**
 * Created by adamlee on 15-09-08.
 */
public class Recover_Rotated_Sorted_Array {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {

        for (int i = 0; i < nums.size()-1; i++) {
            /**
             * 1. look for the biggest elements in the array at position i, when nums[i] > nums[i+1] (smallest element)
             * 2. reverse elements from 0 to i
             * 3. reverse elements from i+1 to end
             * 4. reverse the whole set
             */
            if (nums.get(i) > nums.get(i+1)) {
                reverse(nums, 0, i);
                reverse(nums, i+1, nums.size()-1);
                reverse(nums, 0, nums.size()-1);
            }
        }
    }

    public void reverse(ArrayList<Integer> nums, int start, int end) {
        // doesn't stop when start + 1 = end
        // since when start + 1 = end, we are still switching nums[start] and nums[start+1]
        // use start + 1 = end when searching for a range (with size = at least 1)
        while (start < end) {
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(4);
        A.add(5);
        A.add(1);
        A.add(2);
        A.add(3);
        Recover_Rotated_Sorted_Array sol = new Recover_Rotated_Sorted_Array();
        sol.recoverRotatedSortedArray(A);

        for (int i=0;i<A.size();i++) {
            System.out.println(A.get(i));
        }
    }
}
