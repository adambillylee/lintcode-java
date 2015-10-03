/**
 * Created by adamli on 9/29/15.
 */
public class Interleaving_String {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length() != s3.length())
            return false;

        /**
         * state definition:
         * dp[i][j] = s3 is "interleaving breakable" by s1[:i] and s2[:j]
         */
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];

        dp[0][0] = true;

        /**
         * initialization:
         * when s2 is empty, then s3 must be breakable in s1
         */
        for (int i=1; i<s1.length()+1; i++) {
            if (s3.charAt(i-1) == s1.charAt(i-1) &&
                    dp[i-1][0]) {
                dp[i][0] = true;
            }
        }

        for (int j=1; j<s2.length()+1; j++) {
            if (s3.charAt(j-1) == s2.charAt(j-1) &&
                    dp[0][j-1]) {
                dp[0][j] = true;
            }
        }

        /**
         * recurrence relationship
         * for s3, since matching string length is the sum in s1 and s2, the mathing index is [i+j-1]
         * if it matches s1[i-1], check DP matrix of previous s1 position (s1 up to i-1, s1 up to j)
         * if it maches s2[j-1], check DP matrix of previous j2 position (s1 up to i, s2 up to j-1)
         */
        for (int i=1; i<s1.length()+1; i++) {
            for (int j=1; j<s2.length()+1; j++){
                if ((s3.charAt(i-1) == s1.charAt(i-1) && dp[i-1][j])||
                        (s3.charAt(j-1) == s2.charAt(j-1) && dp[i][j-1])) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
