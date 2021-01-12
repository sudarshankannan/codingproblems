import java.util.Stack;

class StackQueueTest {
    Stack<Integer> sortStack(Stack<Integer> stack){
        //2 40 89 17 24 85
        int min = stack.peek();
        int oLength = stack.size();
        Stack<Integer> temp = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();
        //keep finding the minimum
        while(minStack.size() < oLength){
            //find the minimum element
            min = stack.peek();
            while(stack.isEmpty() == false){
                if(stack.peek() < min){
                    min = stack.peek();
                }
                temp.push(stack.pop());
            }
            //push min to new stack
            minStack.push(min);
            //push everything back to original stack
            boolean minFound = false;
            while(temp.isEmpty() == false){
                if(minFound == false && temp.peek()==min){
                    temp.pop();
                    minFound = true;
                }
                else{
                    stack.push(temp.pop());
                }
            }
        }
        //set stack to minStack
        stack = minStack;
        return minStack;
    }
    void printStack(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<Integer>();
        while(s1.empty() == false){
            s2.push(s1.pop());
        }
        int temp = s2.peek();
        while(s2.isEmpty() == false){
            temp = s2.pop();
            System.out.println(temp);
            s1.push(temp);
        }
        return;
    }
    public static void main(String[] args) {
        StackQueueTest tester = new StackQueueTest();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(40);
        stack.push(89);
        stack.push(17);
        stack.push(24);
        stack.push(45);
        System.out.println("--------Unsorted---------");
        tester.printStack(stack);
        System.out.println("--------Sorted---------");
        tester.printStack(tester.sortStack(stack));
    }
}