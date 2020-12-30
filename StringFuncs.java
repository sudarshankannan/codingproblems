import java.util.HashMap;

class StringFuncs{
    //isUnique
    boolean isUnique(String str){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<str.length(); i++){
            if(map.containsKey(str.substring(i,i+1))==false){
                map.put(str.substring(i,i+1), 1);
            }
            else{
                return false;
            }
        }
        return true;
    }
    //checkPermutation
    boolean checkPermutation()
    //URLify
}