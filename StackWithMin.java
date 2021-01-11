import java.util.Stack;

class StackWithMin extends Stack<Integer>{
    Stack<Integer> minStack;
    StackWithMin(){
        super();
        this.minStack = new Stack<Integer>();
    }
    //push
    void push(int val){
        super.push(val);
        if(val>this.minStack.peek()){
            this.minStack.push(val);
        }
    }
    
    // pop
    public Integer pop() {
        int temp = super.pop();
        if (temp == this.minStack.peek()) {
            this.minStack.pop();
        }
        return temp;
    }
    //getMin
    int getMin(){
        return 0;
    }
}