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

        for (int i=0;i<source.length(); i++) {
            for (int j=0;j<target.length();j++){
                if (source.charAt(i) != target.charAt(j)) {
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
        String source = "abcdabcdefg";
        String target = "bcd";

        strStr sol  = new strStr();

        System.out.println(sol.strStr(source, target));
    }
}
