/**
 * Created by adamli on 1/14/16.
 */
public class Search_a_2D_Matrix_II {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int numRow = matrix.length;
        int numCol = matrix[0].length;

        int count = 0;

        for (int i=0; i<numRow; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][numCol-1]) {
                int start = 0;
                int end = numCol-1;

                if (matrix[i][start] == target || matrix[i][end] == target) {
                    count++;
                    continue;
                }

                while(start + 1 < end) {
                    int mid = start + (end-start) / 2;

                    if (matrix[i][mid] < target) {
                        start = mid;
                    }else if (matrix[i][mid] > target) {
                        end = mid;
                    }else{
                        count++;
                        break;
                    }
                }

            }else{
                continue;
            }
        }

        return count;
    }
}
