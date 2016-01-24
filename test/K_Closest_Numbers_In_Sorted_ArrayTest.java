import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 1/12/16.
 */
public class K_Closest_Numbers_In_Sorted_ArrayTest {
    K_Closest_Numbers_In_Sorted_Array sol = new K_Closest_Numbers_In_Sorted_Array();

    @Test
    public void testKClosestNumbers() throws Exception {
        int A[] = {1, 2, 3};
        int target = 2;
        int k = 3;
        int actual[] = sol.kClosestNumbers(A, target, k);

        for (int ele : actual)
            System.out.println(ele);
    }
}