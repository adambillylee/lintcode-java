/**
 * Created by adamli on 9/24/15.
 */
public class Climbing_Stairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n==0)
            return 0;

        /**
         * state definition:
         * # of ways from bottom to n (1 ~ n+1)
         * 0 is the ground, n+1 is the top
         */
        int sum[] = new int[n+1];

        // initialization
        sum[0] = 1;
        sum[1] = 1;

        /**
         * Recurrence relationship:
         * to get to step i, you can come from either step[i-1] or step[i-2]
         */
        for (int i=2; i<=n; i++) {
            sum[i] = sum[i-1] + sum[i-2];
        }

        return sum[n];
    }
}
