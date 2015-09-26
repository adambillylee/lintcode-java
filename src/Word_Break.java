import java.util.Set;

/**
 * Created by adamli on 9/26/15.
 */
public class Word_Break {
    /**
     * Return max word length in dictionary
     * this is for optimization
     * @param dict
     * @return
     */
    public int maxLengthInDic(Set<String> dict) {
        int maxLen = 0;

        for (String word : dict)
            maxLen = Math.max(maxLen, word.length());

        return maxLen;
    }

    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length()== 0)
            return true;

        // get longest word length in dictionary
        int maxLen = maxLengthInDic(dict);

        /**
         * state definition:
         * breakable[i] = first i characters in s is breakable
         * i in (0~s.length() + 1) since there can be a cut before first char and after last char
         */
        boolean breakable[] = new boolean[s.length() + 1];

        // initialization: first 0 character is always breakable
        breakable[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            breakable[i] = false;

            /**
             * use j to cut a substring back from j, j is the length of the cut
             */
            for (int j=1; j <= i && j <= maxLen; j++) {
                /**
                 * to ensure s[0~i] is breakable, two conditions
                 * 1. there is an j<=i so that s[i-j~j] is breakable
                 * 2. s[i-j~i] is a word in dictionary
                 */
                if (!breakable[i-j])
                    // if s[0~j] is not breakable, j++ to find another j
                    continue;

                /**
                 * now breakable[j] = true already
                 * make sure s[i-j~i] is word in dictionary
                 */
                String word = s.substring(i-j, i);
                if (dict.contains(word)){
                    breakable[i] = true;

                    // if we can find an j that makes s[i-j~i] in dictionary, we don't care about the later part in i
                    break;
                }
            }
        }

        // first s.length characters in s is breakable
        return breakable[s.length()];
    }
}
