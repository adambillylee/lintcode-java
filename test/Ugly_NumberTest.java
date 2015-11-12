import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 11/10/15.
 */
public class Ugly_NumberTest {
    Ugly_Number sol = new Ugly_Number();

    @Test
    public void testKthPrimeNumber() throws Exception {
        int k = 321;
        System.out.println(sol.kthPrimeNumber(k));
    }
}