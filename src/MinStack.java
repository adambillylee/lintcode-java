import java.util.Stack;

/**
 * Created by adamli on 10/30/15.
 */
public class MinStack {
    private Stack<Integer> stack;

    /**
     * minStack always has same length as stack
     * minStack.peek() gives the min number when
     * stack is at current length
     */
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        /**
         * whenever a int in pushed into stack
         * compare it with previous min value in minStack
         * and put the new min in minStack
         */
        if (minStack.isEmpty()) {
            minStack.push(number);
        }else{
            // get previous min number
            int prevMin = minStack.peek();

            // if current number is small, current min is current number
            // otherwise, current min is still prev min
            minStack.push(Math.max(prevMin, number));
        }
    }

    public int pop() {
        // always keep two stacks with same length
        minStack.pop();

        // DON'T GET CONFUSED, WE ARE STILL POPING FROM STACK
        return stack.pop();
    }

    public int min() {
        /**
         * minStack.peek() is the min number
         * when stack is at current length
         */
        return minStack.peek();
    }
}
