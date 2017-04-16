import java.util.Stack;

/**
 * Created by Yang on 2017/4/16.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinInStack {
    /**
     * 最小值初始化为Integer.MAX_VALUE
     * 每次添加node时，如果node不大于最小值的话，就把旧的最小值先压入栈，再压入node
     * 弹出时，如果弹出的值node不大于最小值的话，就需要更新最小值（也就是node的下一个元素）
     */
    private Stack<Integer> stack = new Stack<>();
    private int size = 0;
    private int min = Integer.MAX_VALUE;

//    public MinInStack() {
//        stack = new Stack<>();
//        min = Integer.MAX_VALUE;
//        size = 0;
//    }

    public void push(int node) {
        if(node > min) {
            stack.push(node);
        } else {
            stack.push(min);
            stack.push(node);
            min = node;
        }
        size++;
    }

    public void pop() {
        if(stack.size() == 0) {
            return;
        }
        int value = stack.pop();
        size--;
        if(value == min) {
            min = stack.pop();
        }
        if(stack.size() == 0) {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MinInStack minInStack = new MinInStack();
        minInStack.push(5);
        System.out.printf("压入5，最小值变为：");
        System.out.println(minInStack.min());
        minInStack.push(2);
        System.out.printf("压入2，最小值变为：");
        System.out.println(minInStack.min());
        minInStack.push(3);
        System.out.printf("压入3，最小值变为：");
        System.out.println(minInStack.min());
        minInStack.push(2);
        System.out.printf("压入2，最小值变为：");
        System.out.println(minInStack.min());
        while(!minInStack.isEmpty()) {
            System.out.printf("弹出%d，最小值变为：", minInStack.top());
            minInStack.pop();
            if(minInStack.isEmpty()) {
                System.out.println("空栈");
            } else {
                System.out.println(minInStack.min());
            }
        }
    }
}
