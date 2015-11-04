import java.util.ArrayList;

/**
 * Created by adamli on 11/3/15.
 */
public class N_Queens {
    int n = 0;
    ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>>();

    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        this.n = n;

        ArrayList<Integer> cols = new ArrayList<Integer>();

        helper(cols, 0);

        return rst;
    }

    public void helper(ArrayList<Integer> cols, int row) {
        // if config for all rows are filled, add new config into rst
        if (cols.size() == n) {
            rst.add(drawBoard(cols));
            return;
        }

        for (int j=0; j<n; j++) {
            if (isValid(cols, row, j)){
                // add new valid col index into new row in cols
                cols.add(j);

                // REMEMBER TO USE row+1 INSTEAD OF row++
                helper(cols, row+1);

                // remove last col value for backtracking
                cols.remove(cols.size()-1);
            }
        }
    }

    public ArrayList<String> drawBoard(ArrayList<Integer> cols) {
        ArrayList<String> config = new ArrayList<String>();

        for(int i=0; i<n; i++) {
            // create a new char array for all chars in curr line
            char line[] = new char[n];
            for(int j=0; j<n; j++) {
                // put 'Q' or '.' into ling
                if (cols.get(i) == j) {
                    line[j] = 'Q';  // use single quote here
                }else {
                    line[j] = '.';  // use single quote here
                }
            }

            // convert char array into string and add it into config
            String tmp = new String(line);
            config.add(tmp);
        }

        return config;
    }

    /**
     * decide if a queen position is valid given previous queens configuration
     * @param cols previous queens configuration, cols.get(i) = col index of queen on row i
     * @param row new queen row index
     * @param col new queen column index
     * @return valid or not
     */
    public boolean isValid(ArrayList<Integer>cols, int row, int col){
        // check "same column"
        for (int i=0; i<row; i++) {
            if (cols.get(i) == col)
                return false;
        }

        // check diagonal
        for (int i=0; i<row; i++) {
            /**
             * if absolute diff of col and row are the same for two queens
             * they are on same diagonal
             */
            if (row - i == Math.abs(col - cols.get(i)))
                return false;
        }

        return true;
    }

    public static void main (String[] args) {
        int n = 2;
        N_Queens sol = new N_Queens();
        ArrayList<ArrayList<String>> rst = sol.solveNQueens(n);
        System.out.println();
    }
}
