/**
 * Created by adamli on 9/1/15.
 */
public class strStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {

        if (source == null || target == null)
            return -1;

        if (target == "")
            return 0;

        /**
         * outer loop: loop through source
         */
        for (int i=0;i<source.length(); i++) {
            /**
             * inner loop: loop through target
             */
            for (int j=0;j<target.length();j++){
                if (source.charAt(i) != target.charAt(j)) {
                    /**
                     * the trick is here:
                     * when j reaches end of target but doesn't equal to source[i]
                     * continue will bring loop into i++ instead of going into return below
                     */
                    continue;
                }

                if (j==target.length()-1) {
                    return i-target.length()+1;
                }
            }
        }


        return -1;
    }

    public static void main(String arg[]) {
        String source = "fgabdabcde";
        String target = "abc";

        strStr sol  = new strStr();

        System.out.println(sol.strStr(source, target));
    }
}
