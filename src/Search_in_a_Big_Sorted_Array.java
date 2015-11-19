/**
 * Created by adamli on 10/4/15.
 */
public class Search_in_a_Big_Sorted_Array {
    /**
     * @param reader: ArrayReader where reader.get(k) returns Kth number in input
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        if (reader.get(0) == -1)
            return -1;

        int start = 0;
        int end = 0;

        // find an end to start with
        while(reader.get(end) != -1 && reader.get(end)<target) {
            end = end * 2 + 1;
        }

        // binary search from start to end, search for target
        while(start + 1 < end) {
            int mid = (start+end)/2;
            /** REMEMBER, WHEN target == mid
             * LET end = mid INSTEAD OF RETURNING mid DIRECTLY
             * SINCE WE ARE LOOKING FOR FIRST MATCHING POSITION
             * NEED TO CONSIDER MULTIPLE TARGET VALUE IN INPUT
             */
            if (target > reader.get(mid)) {
                start = mid;
            }else{
                end = mid;
            }
        }


        // figure out its start, end or not at all
        // ascending order, so start with end
        if (target == reader.get(end))
            return end;

        if (target == reader.get(start))
            return start;

        return -1;
    }
}

class ArrayReader{
    ArrayReader(){};

    public int get(int k){return 0;}
}
