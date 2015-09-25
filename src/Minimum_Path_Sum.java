/**
 * Created by adamli on 9/24/15.
 */
public class Minimum_Path_Sum {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // boundary condition
        if (grid.length == 0 || grid == null || grid[0].length == 0)
            return 0;

        /**
         * state definition: min path sum from origin to [i][j]
         */
        int m = grid.length;
        int n = grid[0].length;

        int sum[][] = new int[m][n];

        //initialization:

        // resolve the array out of bound case where i = 1 and j = 1
        sum[0][0] = grid[0][0];

        // resolve the array out of bound case where j=0
        // initialize the left boundary
        for (int i=1; i < m; i++)
            sum[i][0] = sum[i-1][0] + grid[i][0];

        // resovle the array out of bound case where i=0
        // initialize the top row
        for (int j=1; j<n ; j++)
            sum[0][j] = sum[0][j-1] + grid[0][j];


        /**
         * Recurrence relationship: bottom up
         * to get to [i][j], either from [i-1][j] or [i][j-1]
         */
        for (int i=1; i < m; i++) {
            for (int j=1; j< n; j++) {
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
            }
        }

        // return min path sum from origin to [m-1][n-1]
        return sum[m-1][n-1];
    }
}
