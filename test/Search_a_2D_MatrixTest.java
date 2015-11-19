import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by adamli on 11/17/15.
 */
public class Search_a_2D_MatrixTest {
    Search_a_2D_Matrix sol = new Search_a_2D_Matrix();

    @Test
    public void testSearchMatrix() throws Exception {
        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target =7;

        boolean actual = sol.searchMatrix(matrix, target);

        boolean expected = true;

        assertEquals(expected, actual);
    }

    @Test
    public void testSearchMatrix2() throws Exception {
        int matrix[][] = {
                {1,2,8,10,16,21,23,30,31,37,39,43,44,46,53,59,66,68,71},
                {90,113,125,138,157,182,207,229,242,267,289,308,331,346,370,392,415,429,440},
                {460,478,494,506,527,549,561,586,609,629,649,665,683,704,729,747,763,786,796},
                {808,830,844,864,889,906,928,947,962,976,998,1016,1037,1058,1080,1093,1111,1136,1157},
                {1180,1204,1220,1235,1251,1272,1286,1298,1320,1338,1362,1378,1402,1416,1441,1456,1475,1488,1513},
                {1533,1548,1563,1586,1609,1634,1656,1667,1681,1706,1731,1746,1760,1778,1794,1815,1830,1846,1861}
        };
        int target = 1861;

        boolean actual = sol.searchMatrix(matrix, target);

        boolean expected = true;

        assertEquals(expected, actual);
    }
}