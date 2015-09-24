/**
 * Created by adamli on 9/23/15.
 */
public class Unique_Paths {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // boundary condition: invalid matrix dimensions
        if (m == 0 || n == 0)
            return 0;

        /**
         * state definition: sum[i][j] = number of unique path
         * from [0][0] to [i][j]
         */
        int sum[][] = new int[m][n];

        /**
         * initialization
         * from [0][0] to [0][0] is one unique path
         */
        sum[0][0] = 1;

        /**
         * initialization
         * since pointer can only move either down or right
         * all [i][0] and [0][j] points all has one unique path
         * (following the upper and left edge of matrix)
         */
        for (int i=0; i<m; i++)
            sum[i][0] = 1;

        for (int j=0; j<n; j++)
            sum[0][j] = 1;

        /**
         * recurrence relation
         * unique path number of [i][j] is the sum of
         * unique path number of [i-1][j] and [i][j-1]
         * since you can only reach [i][j] from these two points
         * start looping i and j from 1, since 0 is already initialized
         */
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1];
            }
        }

        // the bottom right corner is [m-1][n-1]
        return sum[m-1][n-1];

    }
}
