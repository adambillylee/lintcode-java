/**
 * Created by adamli on 10/2/15.
 */
public class Search_a_2D_Matrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // make sure to cover cases of null matrix and null rows
        if (matrix.length == 0 || matrix[0].length == 0 ||
                matrix == null || matrix[0] == null)
            return false;

        int num_of_rows = matrix.length;
        int num_of_cols = matrix[0].length;

        /**
         * first binary search: look for row index
         * start with row 0
         * end with row (matrix.length - 1)
         */
        int start = 0;
        int end = num_of_rows - 1;

        /**
         * check first element of all rows
         * look for a narrow range [start, end]
         * so that target between matrix[start][0] and matrix[end][0]
         */
        while (start + 1 < end) {
            int mid = (start+end) /2;

            if (matrix[mid][0] == target) {
                return true;
            }else if (matrix[mid][0] < target) {
                /**
                 * if matrix[mid][0] < target, target must be in later rows
                 * cut [0~mid] rows from search range
                 */
                start = mid;
            }else {
                /**
                 * if matrix[mid][0] < target, target must be in upper rows
                 * cut [mid+1~end] rows from search range
                 */
                end = mid;
            }
        }

        int x = 0;

        /**
         * it could be row start or could be row end
         * if target >= row end first element
         * it can only be in last row
         */
        if (matrix[end][0] <= target){
            x = end;
            /**
             * if target between first element of row [start~end], its in start row
             */
        }else if (matrix[start][0] <= target) {
            x = start;
        }else{
             // if not, not found
            return false;
        }

        start = 0;
        end = num_of_cols - 1;

        // same search look for column index
        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (matrix[x][mid] == target) {
                return true;
            }else if(matrix[x][mid] < target) {
                start = mid;
            }else{
                end = mid;
            }
        }

        // its either at matrix[row index][start] or matrix[row index][end]
        return matrix[x][start] == target || matrix[x][end] == target;
    }
}
