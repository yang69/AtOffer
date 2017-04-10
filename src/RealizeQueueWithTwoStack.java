import java.util.Stack;

/**
 * Created by Yang on 2017/4/10.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 */
public class RealizeQueueWithTwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(node);
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public static void main(String[] args) {
        RealizeQueueWithTwoStack queue = new RealizeQueueWithTwoStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
