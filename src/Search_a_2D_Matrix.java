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
        if (matrix == null || matrix.length == 0 ||
                matrix[0].length == 0)
            return false;

        int numOfRow = matrix.length;
        int numOfCol = matrix[0].length;

        // search for startRow and EndRow
        int startRow = 0;
        int endRow = numOfRow - 1;

        while (startRow + 1 < endRow) {
            int midRow = (startRow+endRow)/2;

            if (target==matrix[midRow][0]){
                return true;
            }else if(target > matrix[midRow][0]) {
                startRow = midRow;
            }else{
                endRow = midRow;
            }
        }

        int row = 0;

        // Figure out the actual row
        if (target < matrix[startRow][0]
                || target > matrix[endRow][numOfCol-1]) {
            return false;
        }

        if (target < matrix[endRow][0]){
            row = startRow;
        }else if (target <= matrix[endRow][numOfCol-1]){
            row = endRow;
        }

        // search for startCol and endCol
        int startCol = 0;
        int endCol = numOfCol - 1;

        while(startCol + 1 < endCol) {
            int midCol = (startCol+endCol)/2;

            if (target == matrix[row][midCol]){
                return true;
            }else if(target > matrix[row][midCol]){
                startCol = midCol;
            }else{
                endCol = midCol;
            }
        }


        // figure out the exact col
        if (target == matrix[row][startCol])
            return true;

        if (target == matrix[row][endCol])
            return true;

        return false;
    }
}
