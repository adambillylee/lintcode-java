/**
 * Created by adamli on 9/29/15.
 */
public class Longest_Common_Subsequence {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }

        int dp[][] = new int[A.length()+1][B.length()+1];

        int max = 0;

        for (int i=1; i<A.length()+1; i++) {
            for (int j=1; j<B.length()+1; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        return dp[A.length()][B.length()];
    }
}
