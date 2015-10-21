/**
 * Created by adamli on 10/20/15.
 */
public class Three_Sum_Closest {
    public int threeSumClosest(int[] numbers ,int target) {
        int rst = 0;

        for (int i = 0; i < numbers.length - 2; i++) {
            int j = i + 1;
            int k = numbers.length - 1;

            int diff = 0;
            int minDiff = Integer.MAX_VALUE;
            int sum = 0;
            while (j < k) {
                sum = numbers[i] + numbers[j] + numbers[k];

                diff = Math.abs(sum - target);

                if (diff == 0)
                    return sum;

                if (sum < target) {
                    j++;
                }else {
                    k--;
                }
            }

            if (diff < minDiff) {
                minDiff = diff;
                rst = sum;
            }
        }

        return rst;
    }

    public static void main(String args[]) {
        Three_Sum_Closest sol = new Three_Sum_Closest();
        int[] numbers = {5,11,22,23};
        int target = 3;
        System.out.println(sol.threeSumClosest(numbers, target));
    }
}
