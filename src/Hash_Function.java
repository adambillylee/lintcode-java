/**
 * Created by adamli on 11/10/15.
 */
public class Hash_Function {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        int len = key.length;

        // initiation: put first key in
        // remember to use long for overflow control
        long sum = (int)key[0];

        /**
         * transitive relationship: for "abcd"
         * hash = a * 33^3 + b * 33^2 + c * 33 + d
         *      = ( (33a + b) * 33 + c) * 33 + d)
         * hash[i+1] = 33 * hash[i] + key[i+1]
         */
        for (int i=1; i<len; i++) {
            // since sum go modded in last iteration, probably not gonna overflow
            // unless hash_size is crazy
            sum = 33 * sum;

            // add curr key
            sum += key[i];

            // mod sum to keep sum in each iteration in control
            sum = sum % HASH_SIZE;
        }

        return (int)sum;
    }
}
