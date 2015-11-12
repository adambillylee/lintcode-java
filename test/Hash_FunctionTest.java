import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 11/10/15.
 */
public class Hash_FunctionTest {
    Hash_Function sol = new Hash_Function();

    @Test
    public void testHashCode1() throws Exception {
        char[] key = "abcd".toCharArray();
        int HEAP_SIZE = 100;

        System.out.println(sol.hashCode(key, HEAP_SIZE));
    }

    @Test
    public void testHashCode2() throws Exception {
        char[] key = "ubuntu".toCharArray();
        int HEAP_SIZE = 1007;

        System.out.println(sol.hashCode(key, HEAP_SIZE));
    }
}