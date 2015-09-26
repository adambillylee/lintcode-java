/**
 * Created by adamli on 9/25/15.
 */
public class Jump_Game {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0)
            return false;

        /**
         * state definition:
         * is it possible to jump from 0 to j
         */
        boolean reachable[] = new boolean[A.length];

        // initialization: you can reach 0 from 0
        reachable[0] = true;

        /**
         * Recurrence relationship:
         * jump from j to i
         * use i to loop through all possible pos to jump to [1 ~ A.length-1]
         */
        for (int i=1; i<A.length; i++) {
            // use j to loop through all possible pos before i to jump from
            for (int j=0; j<i; j++) {
                /**
                 * to reach i from 0, 2 conditions:
                 * 1. you can reach i from j (index of j + the max jump dist on j >= index of i)
                 * 2. j is reachable from 0 (reachable[j] is true)
                 */
                if (j + A[j] >= i && reachable[j]) {
                    // we can jump from 0 to i
                    reachable[i] = true;

                    // the further the jump from j to i is, the better
                    // only keep the first j that could jump to i (longest jump)
                    break;
                }
            }
        }

        return reachable[A.length-1];
    }
}
