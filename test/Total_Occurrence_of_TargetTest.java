import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 1/12/16.
 */
public class Total_Occurrence_of_TargetTest {

    Total_Occurrence_of_Target sol = new Total_Occurrence_of_Target();

    @Test
    public void testTotalOccurrence() throws Exception {
        int A[] = {1,1,1,1,1,1,1,1,1,1,1};
        int target = 1;

        int actual = sol.totalOccurrence(A, target);
        System.out.println();
    }
}