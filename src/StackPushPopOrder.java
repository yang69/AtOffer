import java.util.Stack;

/**
 * Created by Yang on 2017/4/16.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class StackPushPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean possible = false;

        if(pushA != null && popA != null && pushA.length != 0) { //输入符合要求时才继续
            Stack<Integer> stack = new Stack<>();
            int indexToNextPush = 0;
            int indexToNextPop = 0;
            while(indexToNextPop < popA.length) {
                //只要栈顶元素与下一个要弹出的值不同，就把压栈序列中的下一个数压入栈
                while(stack.isEmpty() || stack.peek() != popA[indexToNextPop]) {
                    if(indexToNextPush == pushA.length) { //所有元素都已压入栈
                        break;
                    }
                    stack.push(pushA[indexToNextPush++]);
                }

                if(stack.peek() != popA[indexToNextPop]) { //弹栈序列不符合要求
                    break;
                }

                stack.pop();
                indexToNextPop++;
            }

            if(stack.isEmpty() && indexToNextPop == popA.length) {
                possible = true;
            }
        }

        return possible;
    }

    public static void main(String[] args) {
        StackPushPopOrder stackPushPopOrder = new StackPushPopOrder();
        System.out.println(stackPushPopOrder.IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(stackPushPopOrder.IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
        System.out.println(stackPushPopOrder.IsPopOrder(new int[]{}, new int[]{}));
        System.out.println(stackPushPopOrder.IsPopOrder(null, null));
    }
}
