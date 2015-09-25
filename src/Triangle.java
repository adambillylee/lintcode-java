import java.util.ArrayList;

/**
 * Created by adamli on 9/24/15.
 */
public class Triangle {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        /**
         * state definition: from bottom up to top
         * n = size of triangle ArrayList, levels of triangle are i = [0, n-1]
         * sum[i][j] = min path sum from [i][j] to level [n-1] (the bottom)
         */
        int n = triangle.size();

        int sum[][] = new int[n][n];

        /**
         * initialization of bottom level
         * the min path sum from bottom level [n-1][j] to bottom level is it self
         */
        for (int j = 0; j< n; j++) {
            sum[n-1][j] = triangle.get(n-1).get(j);
        }

        /**
         * Recurrence relationship: from bottom up to top
         * to get to [i][j], either from [i+1][j] or [i+1][j+1]
         * use i to loop through all levels from bottom up, starting from level n-2 (second level from bottom)
         * to top level (i=0)
         */
        for (int i = n-2; i >= 0; i--) {
            /**
             * use j to loop through elements in level i
             * there are [2,0] [2,1] [2,2] when i = 2, so j <= i in each level
             */
            for (int j=0; j<=i; j++) {
                // min path sum = min of (min path sum from top, min path sum from left top) + value of [i][j]
                sum[i][j] = Math.min(sum[i+1][j],  sum[i+1][j+1]) + triangle.get(i).get(j);
            }
        }

        // return min path some from bottom to [0][0]
        return sum[0][0];
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList tmp = new ArrayList();
        tmp.add(-10);
        triangle.add(tmp);
        Triangle sol = new Triangle();
        System.out.print(sol.minimumTotal(triangle));
    }
}
