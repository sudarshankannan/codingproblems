import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

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
    
}