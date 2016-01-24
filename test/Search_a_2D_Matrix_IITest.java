import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 1/14/16.
 */
public class Search_a_2D_Matrix_IITest {
    Search_a_2D_Matrix_II sol = new Search_a_2D_Matrix_II();

    @Test
    public void testSearchMatrix1() throws Exception {
        int matrix[][] = {{62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80},{63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81},{64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82},{65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83},{66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84},{67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85}};
        int target = 81;

        sol.searchMatrix(matrix, target);
    }

    @Test
    public void testSearchMatrix2() throws Exception {
        int matrix[][] = {{3,4}};
        int target = 3;

        sol.searchMatrix(matrix, target);
    }
}