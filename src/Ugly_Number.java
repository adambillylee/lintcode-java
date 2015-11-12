import java.util.ArrayList;

/**
 * Created by adamli on 11/10/15.
 */
public class Ugly_Number {
    public long kthPrimeNumber(int k) {
        // create an array list of ugly numbers
        ArrayList<Long> rst = new ArrayList<Long>();

        // initialization: add 1 into rst
        rst.add(new Long(1));

        /**
         * create three pointers in rst
         * for 3,5 and 7
         */
        int curr3 = 0;
        int curr5 = 0;
        int curr7 = 0;

        Long min = new Long(1);

        while(rst.size()<=k) {
            /**
             * considering 3 currs represent 3 sequences
             * each cursor pointed to number in rst to be used as base to multiply 3,5 or 7
             * in each iteration the min number is the min possible ugly number within 3 sequences
             * after that cursor is used, move that cursor front by 1 so new ugly number in that seq
             * could be used in min comparison next time.
             * The other cursor will stay in their previous min position, wait for their multiply to be the new min
             */
            Long e3 = rst.get(curr3) * 3;
            Long e5 = rst.get(curr5) * 5;
            Long e7 = rst.get(curr7) * 7;

            // pick min of 3 new multiplies to be result ugly number
            min = Math.min(Math.min(e3,e5),e7);

            // move cursor forward so new multiplies are generated based on previous min
            if(min.equals(e3))
                curr3 ++;

            if(min.equals(e5))
                curr5++;

            if(min.equals(e7))
                curr7++;

            // add min into rst last in order to avoid screw ups of indexes
            rst.add(min);
        }

        return min;
    }
}
