/**
 * Created by adamli on 9/27/15.
 */
public class Distinct_Subsequences {
    /**
     * find a part of T in S
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if (S == null || T== null)
            return 0;

        /**
         * state definition:
         * dp[i][j] = # of subseq of T in S
         */
        int dp[][] = new int[S.length()+1][T.length()+1];

        /**
         * initialization:
         * if S = empty string,
         * than whatever T is, there will be only 1 subseq of T in S: empty string
         */
        for (int j=0; j<T.length()+1; j++) {
            dp[0][j] = 1;
        }

        dp[0][0] = 1;

        /**
         * recurrence relationship:
         * 2 cases depends on ith char in S and jth char in T is equal or not
         */
        for (int i=1; i<S.length()+1; i++) {
            for (int j=1; j< T.length()+1; j++) {
                /**
                 * if no match, j doesn't do anything
                 * total subseq # is still at the stat of previous j
                 */
                dp[i][j] = dp[i-1][j];

                /**
                 * if there is a match,
                 * we have to also consider total match number in S[i-1] to T[j-1]
                 */
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        return dp[S.length()][T.length()];
    }
}
