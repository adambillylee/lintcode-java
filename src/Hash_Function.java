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

        long sum = (int)key[key.length-1];
//        for (int i=len-1; i>=0; i--) {
//            for (int j=0; j<len;j++) {
//                int asc = (int)key[j];
//                sum += asc * Math.pow(33, i);
//            }
//        }

        for (int i=len-2; i>=0; i--) {
            int asc = (int)key[i];
            sum += 33 * (sum) + asc;
            sum %= HASH_SIZE;
        }

        return (int)sum;
    }
}
