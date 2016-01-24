import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by adamli on 1/12/16.
 */
public class K_Closest_Numbers_In_Sorted_Array {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A.length == 0)
            return new int[k];

        // find first occurance of target
        int start = 0;
        int end = A.length-1;

        while(start + 1< end) {
            int mid = start + (end-start) / 2;

            if (target > A[mid])
                start = mid;
            else if (target < A[mid])
                end = mid;
            else
                end = mid;
        }

        int firstOccur = -1;
        if (A[end] == target)
            firstOccur = end;

        if (A[start] == target)
            firstOccur = start;

        boolean found = false;

        if (A[start] == target || A[end] == target)
            found = true;

        // find last occurance of target
        end = A.length-1;

        while(start + 1< end) {
            int mid = start + (end-start) / 2;

            if (target > A[mid])
                start = mid;
            else if (target < A[mid])
                end = mid;
            else
                start = mid;
        }

        int lastOccur = -1;
        if (A[start] == target)
            lastOccur = start;

        if (A[end] == target)
            lastOccur = end;

        // if found target, add all targets into result
        int rst[] = new int[k];
        int rstInd = 0;

        int frontInd = -1;
        int rearInd = -1;

        if (found) {
            for (int i = firstOccur; i <= lastOccur && rstInd < k; i++)
                rst[rstInd++] = A[i++];

            if (rstInd == k-1)
                return rst;

            // if found the target, set front starting point to be before first occurrence of target
            // rear starting point
            frontInd = firstOccur-1;
            rearInd = lastOccur+1;
        }else{
            frontInd = start;
            rearInd = end;
        }

        //from before and after, find
        int i = frontInd;
        int j = rearInd;
        while(rstInd < k) {
            if (findCloserInd(A, i, j, target) == i) {
                rst[rstInd++] = A[i--];
            }else{
                rst[rstInd++] = A[j++];
            }
        }


        return rst;
    }

    public int findCloserInd(int A[], int a, int b, int target) {
        if (a<0 || a >= A.length)
            return b;

        if (b<0 || b>=A.length)
            return a;

        int deltaA = Math.abs(A[a]-target);
        int deltaB = Math.abs(A[b]-target);

        if (deltaA>deltaB) {
            return b;
        }else
            return a;
    }
}
