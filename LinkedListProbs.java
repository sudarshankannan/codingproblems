import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

class LinkedListProbs{
    void removeDups(LinkedList<Integer> l){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<l.size(); i++){
            if(map.containsKey(l.get(i))){
                l.remove(i);
            }
            else{  
                map.put(l.get(i), 0);
            }
        }
    }
    int kLast(LinkedList<Integer> l, int num){
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<l.size(); i++){
            s.push(l.get(i));
        }
        int item = 0;
        for(int i=0; i<num; i++){
            item = s.pop();
        }
        return item;
    }
    void partition(LinkedList<Integer> l, int x){
        // Input: 3 -> 5 -> 8 -> 5  ->  10 -> 2 -> 1 [partition= 5] 
        // Output: 3 ->  1 -> 2 -> 10 -> 5 -> 5 -> 8
    }
    int sumLists(LinkedList<Integer> one, LinkedList<Integer> two){
        Stack<Integer> stackOne = new Stack<Integer>();
        Stack<Integer> stackTwo = new Stack<Integer>();
        //add one to a stack
        for(int z=0; z<one.size(); z++){
            stackOne.push((Integer)one.get(z));
        }
        //add two to a stack
        for(int i=0; i<two.size(); i++){
            stackTwo.push(two.get((Integer)two.get(i)));
        }
        //calculate each number
        int numOne = 0;
        int numTwo = 0;
        int expOne = one.size()-1;
        int expTwo = two.size()-1;
        while(!stackOne.isEmpty()){
            int tempOne = stackOne.pop() * (int)Math.pow(10, expOne);
            numTwo+=tempOne;
        }
        while(!stackTwo.isEmpty()){
            int tempTwo = stackOne.pop() * (int)Math.pow(10, expTwo);
            numTwo+=tempTwo;
            expTwo--;
        }
        //return
        return numOne + numTwo;
    }
}