import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by adamli on 11/8/15.
 */
public class TestUtil {
    public static ArrayList ArraytoArrayList(Object objects[]) {
        ArrayList rst = new ArrayList();

        for (Object obj : objects) {
            rst.add(obj);
        }

        return rst;
    }
}
