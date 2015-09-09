/**
 * Created by adamlee on 15-09-09.
 */
public class First_Bad_Version {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
//    public int findFirstBadVersion(int n) {
//        // version starts with 1 ends with n
//        int start = 1;
//        int end = n;
//
//        // search for a range so that bad version is between (start, end)
//        while(start + 1 < end) {
//            int mid = (start + end) / 2;
//
//            // if mid version is bad, than first bad must be before mid
//            // cut 0~start from search range, by moving end to mid
//            if (VersionControl.isBadVersion(mid)) {
//                end = mid;
//            }else {
//                // if mid version is good, than first bad version must be after mid
//                // cut mid+1 ~ end from search range, by moving start to mid
//                start = mid;
//            }
//        }
//
//        // since we are looking for first bad version, start with looking at [start] since its before [end],
//        // if its bad, return start
//        if(VersionControl.isBadVersion(start)) {
//            return start;
//        }else{  // if [start] is still good, return end
//            return end;
//        }
//    }

}
