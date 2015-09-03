import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.Collections;

/**
 * Created by adamli on 9/1/15.
 */
public class Merge_Sorted_Array {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m-1;    // looping through all existing elements in A, starting from the end
        int j = n-1;    // looping through all elements in B, starting from the end
        int index = m+n-1;  // looping through all positions in A, since A.length = m+n, starting from the end

        /**
         * since there are n empty spaces at the end of A
         * and both A and B elements are sorted
         * the elements inserted from the end of A will never overwrite previous elements
         */
        while (i>=0 && j>=0) {
            if (A[i] >= B[j]) {
                A[index--] = A[i--];
            }else{
                A[index--] = B[j--];
            }
        }

        // when m > n
        while (i>=0) {
            A[index--] = A[i--];
        }

        // when n > m
        while(j>=0) {
            A[index--] = B[j--];
        }

//        for (int k=0;k<n+m;k++)
//            System.out.println(A[k]);
    }

//    public static void main(String arg[]) {
//        int A[] = new int[5];
//        A[0] = 1;
//        A[1] = 2;
//        A[2] = 3;
//
//        int B[] = new int[2];
//        B[0] = 4;
//        B[1] = 5;
//
//        Merge_Sorted_Array sol = new Merge_Sorted_Array();
//        sol.mergeSortedArray(A, 3, B, B.length);
//
//    }
}
