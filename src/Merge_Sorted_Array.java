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
        int[] tmp = new int[A.length];

        for (int i=A.length; i>=0; i--) {
            if (A[i] != null)
                tmp[i] = Math.max(A[i], B[i]);
        }

        A = tmp;
    }

    public static void main(String arg[]) {
        int A[] = new int[5];
        A[1] = 1;
        A[2] = 2;
        A[3] = 3;

        int B[] = new int[2];
        B[1] = 4;
        B[2] = 5;

        Merge_Sorted_Array sol = new Merge_Sorted_Array();
        sol.mergeSortedArray(A, A.length, B, B.length);
    }
}
