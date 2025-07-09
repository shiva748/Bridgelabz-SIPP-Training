package StackQueueHash;
import java.util.Stack;
class SortStackRecursion {
    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sort(stack);
            insert(stack, x);
        }
    }
    private void insert(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || stack.peek() <= x) {
            stack.push(x);
        } else {
            int y = stack.pop();
            insert(stack, x);
            stack.push(y);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        SortStackRecursion s = new SortStackRecursion();
        s.sort(stack);
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }
} 