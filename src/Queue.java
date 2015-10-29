import java.util.Stack;

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        // stupid question, remember to initiate stacks
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        // if you reverse the order of stack
        // its the order of queue
        while (!stack1.isEmpty()) {
            int element = stack1.pop();
            stack2.push(element);
        }

        // pop from reversed stack
        int res = stack2.pop();

        // put the rest of elements back into orig stack
        while (!stack2.isEmpty()) {
            int element = stack2.pop();
            stack1.push(element);
        }

        return res;
    }

    public int top() {
        // if you reverse the order of stack
        // its the order of queue
        while (!stack1.isEmpty()) {
            int element = stack1.pop();
            stack2.push(element);
        }

        // peek the top of reversed stack
        int res = stack2.peek();

        // put all elements back
            while (!stack2.isEmpty()) {
                int element = stack2.pop();
                stack1.push(element);
            }

        return res;
    }
}