import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

class SetOfStacks{
    final int STACK_SIZE = 8;
    ArrayList<Stack<Integer>> set;
    int itemCount;
    //constructor
    SetOfStacks(){
        this.set = new ArrayList<Stack<Integer>>();
    }
    //push
    void push(int val){
        if(this.itemCount%8==0){
            this.set.add(new Stack<Integer>());
        }
        for(int i=0; i<set.size(); i++){
            if(this.set.get(i).size() < 8){
                this.set.get(i).push(val);
                break;
            }
        }
        this.itemCount++;
    }
    //pop
    public Integer pop(){
        Integer temp = null;
        for(int i=0; i<set.size(); i++){
            if(this.set.get(i).size() < 8){
                temp = this.set.get(i).pop();
                if(this.set.get(i).empty()){
                    this.set.remove(i);
                }
                break;
            }
        }
        this.itemCount--;
        return temp;
    }
    public Integer popAt(int i){
        int poppedVal = this.set.get(i).pop();
        ArrayList<Integer> rest = new ArrayList<Integer>();
        for(int z=i+1; z<this.set.size(); z++){
            while(!this.set.get(z).empty()){
                rest.add(this.set.get(z).pop());
            }
            //push first item of next stack to i's stack
            this.set.get(z-1).push(rest.get(rest.size()-1));
            //repush rest's items to their stack
            for(int x=0; x<rest.size(); x++){
                this.set.get(z).push(rest.get(x));
            }
        }
        return poppedVal;
    }
}