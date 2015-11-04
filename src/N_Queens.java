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
        ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>>();

        // write your code here
        this.n = n;
        ArrayList<Integer> cols = new ArrayList<Integer>();

        helper(cols, 0);

        return this.rst;
    }

    public void helper(ArrayList<Integer> cols, int row) {
        // when last recur call is at last row, it will make row = n+1
        if (cols.size() == n) {
            rst.add(drawBoard(cols));
            return;
        }

        for (int j = 0; j<n; j++) {
            if (isValid(cols, row, j)) {
                cols.add(j);
                helper(cols, row + 1);
                cols.remove(cols.size() - 1);
            }
        }
    }

    public boolean isValid(ArrayList<Integer> cols, int row, int col) {
        // check "same column"
        for (int i=0; i<row; i++) {
            if (cols.get(i) == col)
                return false;
        }

        // check "same diagnal"
        for (int i=0; i<row; i++) {
            if (row - i == Math.abs(col - cols.get(i)))
                return false;
        }

        return true;
    }

    public ArrayList<String> drawBoard(ArrayList<Integer> cols) {
        ArrayList<String> board = new ArrayList<String>();

        for (int i=0; i<n; i++) {
            char line[] = new char[n];

            for (int j=0; j<n; j++) {
                if (cols.get(i) == j) {
                    line[j] = 'Q';
                }else{
                    line[j] = '.';
                }
            }

            String tmp = new String(line);
            board.add(tmp);
        }

        return board;
    }

    public static void main (String[] args) {
        int n = 1;
        N_Queens sol = new N_Queens();
        ArrayList<ArrayList<String>> rst = sol.solveNQueens(n);
        System.out.println();
    }
}
