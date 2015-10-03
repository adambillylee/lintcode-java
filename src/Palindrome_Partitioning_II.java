/**
 * Created by adamli on 9/26/15.
 */
public class Palindrome_Partitioning_II {
    public boolean isPalindrome(String s, int start, int end) {
        for (int i=start, j=end; i<j; i++,j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }

        return true;
    }

    public boolean[][] getIsPalindomeMatrix(String s) {
        // "is s[i][j] a palindrome?" matrix
        boolean isPalindromeMatrix[][] = new boolean[s.length()+1][s.length()+1];

        // initiate all substrings of length 1
        for(int i=0; i<s.length()+1; i++)
            isPalindromeMatrix[i][i] = true;

        // initiate all substrings of length 2
        for (int i=0; i<s.length()+1-2; i++)
            isPalindromeMatrix[i][i+1] = s.charAt(i) == s.charAt(i+1);

        /**
         * outer loop: difference of index starting from 2
         * when index difference is 2, the actual length of string is 3 (s[1~3])
         * the max index_diff is s.length - 1
         */
        for (int index_diff = 2; index_diff < s.length(); index_diff++) {
            /**
             * inner loop: starting point starting from 0 (when starting index_diff is 2) to s.index_diff
             */
            for (int start = 0; start + index_diff < s.length(); start++) {
                isPalindromeMatrix[start][start+index_diff] =
                        isPalindromeMatrix[start+1][start+index_diff-1] && s.charAt(start) == s.charAt(start+index_diff);
            }
        }

        return isPalindromeMatrix;
    }

    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if (s == null || s.length()==0)
            return 0;

        /**
         * state definition:
         * cut[i] = min palindrome cut in s[:i]
         */
        int cut[] = new int[s.length()+1];


        /**
         * initialization:
         * it requires i-1 cut to make i substring
         * cut[0] = -1 in this case
         */
        for (int i=0; i<s.length()+1; i++) {
            cut[i] = i-1;
        }

        boolean isPalindromeMatrix[][] = getIsPalindomeMatrix(s);

        /**
         * recurrence relationship:
         * cut[i] = min palindrome cut for first i characters s[0~i-1]
         * cut[i] = either i-1 (one cut after each character)
         * OR
         * cut[j] + 1, if s[j~i-1] is a palindrome, where cut j is min cut of s[0~j-1]
         */
        for (int i=1; i<s.length()+1; i++) {
            for (int j=0; j<i; j++) {
                /**
                 * WHY [j][i-1]?
                 * because isPalindromeMatrix index is index of s
                 */
                if (isPalindromeMatrix[j][i-1]) {
                    /**
                     * why[i]:
                     * because cut index is "first i characters in s"
                     * first ith character = s[i-1]
                     */
                    cut[i] = Math.min(cut[i], cut[j]+1);
//                    System.out.println("j="+j+ ", i="+i+", string="+s.substring(j,i));
                }
            }
        }

        // return min cut # of first s.length characters
        return cut[s.length()];
    }

    public static void main(String[] args) {
        String s = "abccbabc";
        System.out.println(s);

        Palindrome_Partitioning_II sol = new Palindrome_Partitioning_II();

        boolean isPalindromeMatrix[][] = sol.getIsPalindomeMatrix(s);

        for (int i=0; i<s.length()+1;i++) {
            for (int j=0; j<s.length()+1;j++) {
                System.out.print(i+","+j+" "+isPalindromeMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        sol.minCut(s);
    }
}
