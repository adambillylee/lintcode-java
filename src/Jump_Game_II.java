/**
 * Created by adamli on 9/25/15.
 */
public class Jump_Game_II {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null || A.length ==0)
            return 0;

        /**
         * state definition:
         * # of steps from 0 to i
         */
        int[] step = new int[A.length];

        step[0] = 1;

        /**
         * Recurrence relationship:
         *
         */
        for (int i=1; i<A.length; i++) {
            step[i] = Integer.MAX_VALUE;
            for (int j=0; j<i; j++) {
                if (step[j] != Integer.MAX_VALUE && j + A[j] >=i) {
                    step[i] = step[j]+1;

                    // the further the jump from j to i is, the better
                    // only keep the first j that could jump to i (longest jump)
                    break;
                }
            }
        }

        return step[A.length-1];
    }
}
