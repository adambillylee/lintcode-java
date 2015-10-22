import java.util.Arrays;

/**
 * Created by adamli on 10/20/15.
 */
public class Three_Sum_Closest {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        int rst = 0;

        Arrays.sort(numbers);
        int minDiff = Integer.MAX_VALUE;

        /**
         * outer loop:
         * for first number, from position 0 to position [length-3]
         */
        for (int first = 0; first < numbers.length-2; first++) {
            int second = first + 1;
            int third = numbers.length - 1;

            while (second < third) {
                int sum = numbers[first] + numbers[second] + numbers[third];

                int diff = Math.abs(sum - target);

                /**
                 * since first number is fixed in each outer loop iteration
                 * if sum is too small, increase 2nd number
                 * if sum is too big, choose a smaller 3rd number
                 */
                if (sum > target) {
                    third--;
                }else if(sum < target) {
                    second++;
                }else{
                    return sum;
                }

                if (diff < minDiff) {
                    minDiff = diff;
                    rst = sum;
                }

            }
        }

        return rst;
    }

    public static void main(String args[]) {
        Three_Sum_Closest sol = new Three_Sum_Closest();
        int[] numbers = {5,11,22,23};
        int target = 100;
        System.out.println(sol.threeSumClosest(numbers, target));
    }
}
