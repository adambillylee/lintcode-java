/**
 * Created by adamli on 9/23/15.
 */
public class Unique_Paths_II {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // m = number of rows = number of elements in first dimension
        int m = obstacleGrid.length;
        // n = number of cols = number of elements in second dimention
        int n = obstacleGrid[0].length;

        /**
         * state definition
         * sum[i][j] = # of unique path from [0][0] to [i][j]
         */
        int[][] sum = new int[m][n];

        /**
         * initialization
         * all top and left edge should have unique path = 1
         * since we can only move to right or bottom
         * but if there are blockers on these two edges
         * the later blocks can never be reached
         */
        for (int i=0; i<m; i++) {
            if (obstacleGrid[i][0] != 1) {
                sum[i][0] = 1;
            }else{
                break;
            }
        }

        for (int j=0; j<n; j++) {
            if (obstacleGrid[0][j] != 1) {
                sum[0][j] = 1;
            }else {
                break;
            }
        }

        /**
         * you can only reach [i][j] from [i-1][j] or [i][j-1]
         * so # of unique paths to [i][j] = sum of # unique path of these two
         */
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                // if [i][j] is blocker, than # of unique path to it is 0
                if (obstacleGrid[i][j] != 1) {
                    sum[i][j] = sum[i-1][j] + sum[i][j-1];
                }else {
                    sum[i][j] = 0;
                }
            }
        }

        // right bottom corner position is [m-1][n-1]
        return sum[m-1][n-1];
    }
}
