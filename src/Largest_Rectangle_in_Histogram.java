import java.util.Arrays;
import java.util.Stack;

/**
 * Created by adamli on 11/1/15.
 */
public class Largest_Rectangle_in_Histogram {
    Stack<Integer> stack = new Stack<Integer>();
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;

        // create a new array with last element = 0
        // so that the end of array triggers stack pop
        int height_with_dummy[] = new int[height.length+1];

        height_with_dummy = Arrays.copyOf(height, height.length+1);

        int i = 0;
        int width = 0;
        // loop through the while height array
        while (i < height_with_dummy.length) {
            /**
             * push to stack if stack is empty
             * or next height is increasing
             */
            if (stack.isEmpty() ||
                    height_with_dummy[i] >= height_with_dummy[stack.peek()]) {
                stack.push(i++);
            } else {
                /**
                 * when hit an element < stack top
                 * pop top from stack
                 */
                int index_of_height = stack.pop();

                /**
                 * if stack is empty after poping top
                 * then top is already the min value of height in stack
                 */
                if(stack.isEmpty()) {
                    /**
                     * since there is no smaller element on the left
                     * rectangle can go from start up to i (0~i-1), with width = i
                     */
                    width = i;
                }else{
                    /**
                     * if stack is not empty, there are smaller height on the left
                     * rectangle is between i and previous smaller element (stack.peek()+1 ~ i-1)
                     */
                    width = (i-1) - (stack.peek()+1) + 1;
                }

                // calculate area and update maxArea if needed
                int area = width * height_with_dummy[index_of_height];

                if (area > maxArea)
                    maxArea = area;
            }
        }

        return maxArea;
    }

    public static void main(String args[]) {
        int height[] = {2,1,5,6,2,3};
    }
}
