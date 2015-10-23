/**
 * Created by adamli on 10/22/15.
 */
public class Sort_Letters_by_Case {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length ==0 )
            return;

        // create two pointers, head and tail
        int i = 0;
        int j = chars.length - 1;

        /**
         * move head and tail to middle
         * 1. move i to first upper case
         * 2. move j to first lower case
         * 3. only need to swap when i is upper case on left,
         * and j is lower case on right
         */
        while(i<j) {
            // find first upper case from left (i)
            while(i<j && Character.isLowerCase(chars[i]))
                i++;

            // find first lower case from right (j)
            while(i<j && Character.isUpperCase(chars[j]))
                j--;

            // swap i and j when upper on right and lower on left
            if (Character.isUpperCase(chars[i]) && Character.isLowerCase(chars[j])) {
                swap(chars, i, j);
                //remember to move cursor forward/backward
                i++;
                j--;
            }
        }

    }

    public void swap(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }

    public static void main (String args[]) {
        String target = "abAcD";

        Sort_Letters_by_Case sol = new Sort_Letters_by_Case();
        sol.sortLetters(target.toCharArray());


    }
}
