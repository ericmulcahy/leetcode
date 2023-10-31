package neetcode.stacks;
import java.util.List;
import java.util.ArrayList;

public class MinStackProblem {
    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        m.getMin();
        m.pop();
        m.top();
        m.getMin();

        // [null,null,null,null,-3,null,0,-2]
    }

    private static class MinStack {
        List<Integer> stack = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;

        public MinStack() {
        }
        
        public void push(int val) {
            stack.add(val);
            if (val < min) min = val;
            minIndex = stack.size() - 1;
        }
        
        public void pop() {
            if (stack.size() - 1 == minIndex) {
                stack.remove(stack.size() - 1);
                min = Integer.MAX_VALUE;
                minIndex = Integer.MAX_VALUE;
                for (int i = 0; i < stack.size(); i++) {
                    if (stack.get(i) < min) {
                        min = stack.get(i);
                        minIndex = i;
                    }
                }
            } else {
                stack.remove(stack.size() - 1);
            }
        }
        
        public int top() {
            return stack.get(stack.size() - 1);
        }
        
        public int getMin() {
            return min;
        }
    }
    
}

