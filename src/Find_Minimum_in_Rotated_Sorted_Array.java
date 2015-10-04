/**
 * Created by adamli on 10/4/15.
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;

        // in case the rotation pivot point is start (which means its not rotating)
        if (num[start] < num[end])
            return num[start];

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            /**
             * if array is rotation and mid > start, it means mid is at first increasing range (start~max)
             * mix of rotation is at its right
             * if that's not the case, mid is at the 2nd incresing range (min~end), min is at its left
             */
            if (num[mid] >= num[start]) {
                start = mid;
            }else {
                end = mid;
            }
        }

        // return the min of num[start] and num[end]
        return Math.min(num[start], num[end]);
    }


    public static void main(String args[]) {
        Find_Minimum_in_Rotated_Sorted_Array sol = new Find_Minimum_in_Rotated_Sorted_Array();

        int num[] = {6,1,2,3,4,5};

        System.out.println(sol.findMin(num));
    }
}
