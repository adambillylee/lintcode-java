/**
 * Created by adamli on 11/3/15.
 */
public class N_Queens_II {
    int counter = 0;
    int n = 0;

    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        this.n = n;

        /**
         * define an col array
         * with cols[i] = queen's col index on row i
         */
        int cols[] = new int[n];

        helper(cols, 0);

        return counter;
    }

    public void helper(int cols[], int row) {
        // base condition: all n rows have a valid col value, add number of valid sols by 1
        // when last row is finished
        // the iteration at last col (n-1) will add row number to n in next recur call
        if (row == n) {
            // when all rows has a valid column value
            // add valid solution counter by 1
            counter++;
            return;
        }

        // loop through all columns in current row
        for (int j=0; j<n; j++) {
            // if current row and current col is a valid queen pos
            if (isValidPos(cols, row, j)) {
                // add this queen position to cols array
                cols[row] = j;

                // make recur call to find valid queen starting from next row
                helper(cols, row+1);
            }
        }

    }

    public boolean isValidPos(int cols[], int row, int col) {
        /**
         * check "same row"
         * loop through all previous rows, and row has same col value as col
         * they are in same column
         */
        for (int i=0; i<row; i++) {
            if (cols[i] == col)
                return false;
        }

        /**
         * check "same diagnal"
         * row (passed in parameter) - current row in loop = abs(col - col value of current row in loop)
         */
        for (int i=0; i<row; i++) {
            if((row - i) == Math.abs(cols[i] - col))
                return false;
        }

        // if above 2 tests are passed, return true
        return true;
    }
}
