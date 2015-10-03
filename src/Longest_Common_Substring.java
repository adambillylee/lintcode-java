/**
 * Created by adamli on 9/28/15.
 */
public class Longest_Common_Substring {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null)
            return 0;

        /**
         * state definition:
         * longest substring length of A[:i] and B[:j]
         */
        int dp[][] = new int[A.length()+1][B.length()+1];

        /**
         * initialization:
         * if A or B is empty string, than max common substring length is 0
         */
        for (int i=0; i<A.length()+1; i++)
            dp[i][0] = 0;

        for (int j=0; j<B.length()+1; j++)
            dp[0][j] = 0;

        int max = 0;

        /**
         * recurrence relationship:
         * if A[i-1] == B[j-1], dp[i][j] = dp[i-1][j-1] + 1
         * TAKE CARE, its dp[i-1][j-1] instead of dp[i][j-1] since common string
         * has same length in both A and B
         */
        for (int i=1; i<A.length()+1; i++) {
            for (int j=1; j<B.length()+1; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;

                    // update max
                    if (max < dp[i][j])
                        max = dp[i][j];
                }
            }
        }

        return max;
    }
}
