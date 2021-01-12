import java.util.Stack;

class MyQueue{
    Stack<Integer> s1; //contains oldest elements at bottom
    Stack<Integer> s2; //contains the oldest elements at the top
    //constructor
    MyQueue(){
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();
    }
    void enqueue(int num){
        s1.push(num);
    }
    int dequeue(){
        if(!s2.empty()){
            return s2.pop();
        }
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int temp = s2.pop();
        return temp;
    }
    int size(){
        return s1.size() + s2.size();
    }
    int peek(){
        if(!s2.empty()){
            return s2.pop();
        }
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int temp = s2.peek();
        return temp;
    }
}