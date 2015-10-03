/**
 * Created by adamli on 9/27/15.
 */
public class Edit_Distance {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        /**
         * state definition:
         * f[i][j] = min edit distance when word1[:i-1] == word2[:j-1]
         */
        int len_w1 = word1.length();
        int len_w2 = word2.length();

        // there is always an length + 1 since f[0][i] f[i][0] can mean word2 and word1 being empty string
        int f[][] = new int[len_w1+1][len_w2+1];

        //initialization

        /**
         * when w1 is empty
         * from empty string to any substring in w2 takes up to len_w2 steps
         */
        for (int i=0; i<len_w2+1; i++) {
            f[0][i] = i;
        }

        /**
         * when w2 is empty
         * from any substring in w1 to empty string takes up to len_w2 steps
         */
        for (int j=0; j<len_w1+1; j++) {
            f[j][0] = j;
        }

        /**
         * recurrence relationship:
         * to make word1[:i] = word[:j], 3 ways
         * 1. insert, w1[:i] = w2[:j-1], f[i][j-1]+1
         * 2. delete, w1[:i-1] = w2[:j], f[i-1][j]+1
         * 3. edit w1[:i-1] = w2[:i-1], f[i-1][j-1]+1
         *
         * if w1[i] = w2[j] than f[i][j] = f[i-1][j-1] (no edit)
         */
        for (int i=1; i<len_w1+1; i++) {
            for (int j=1; j<len_w2+1; j++) {
                /**
                 * f[i][j] correspond to word1.charat[i-1], word2.charat[j-1]
                 */
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    // when its already equal, no edit
                    f[i][j] = f[i-1][j-1];
                }else{
                    // 1 operation + Min(edit length of edit, insert, delete)
                    f[i][j] = 1 + Math.min(f[i-1][j-1], Math.min(f[i][j-1], f[i-1][j]));
                }
            }
        }

        // min edit distance when word1[len_w1-1] == word2[len_w2-1]
        return f[len_w1][len_w2];
    }
}
