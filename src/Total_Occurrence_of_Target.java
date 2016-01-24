/**
 * Created by adamli on 1/12/16.
 */
public class Total_Occurrence_of_Target {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A.length ==0)
            return 0;


        // find first occurence
        int start = 0;
        int end = A.length-1;

        while(start+1<end) {
            int mid = start + (end-start)/2;

            if (target > A[mid])
                start = mid;
            else if (target < A[mid])
                end = mid;
            else
                end = mid;
        }

        int startPos = -1;

        // System.out.println("start:"+start);
        // System.out.println("end:"+end);

        if (A[end]==target)
            startPos = end;
        if (A[start]==target)
            startPos = start;
        if (startPos == -1)
            return 0;

        // System.out.println("startPos:"+startPos);

        // find last occurence
        start = startPos;
        end = A.length-1;

        while(start+1<end) {
            int mid = start + (end-start)/2;

            if (target > A[mid])
                start = mid;
            else if (target <A[mid])
                end = mid;
            else
                start = mid;
        }

        int endPos = A.length-1;
        if (A[start]==target)
            endPos = start;
        if (A[end]==target)
            endPos = end;

        // System.out.println("endPos:"+endPos);

        return endPos-startPos+1;
    }
}
