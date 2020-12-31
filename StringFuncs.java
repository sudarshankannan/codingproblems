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
    boolean checkPermutation(String str1, String str2){
        String greater = null;
        String less = null;
        HashMap<String,Integer> mapGreater = new HashMap<String, Integer>();
        HashMap<String, Integer> mapLess = new HashMap<String, Integer>();
        if(str1.length()<str2.length()){
            greater = str2;
            less = str1;
        }
        else{
            greater = str1;
            less = str1;
        }
        //put greater's chars in hashmap
        for(int i=0; i<greater.length(); i++){
            String curr = greater.substring(i,i+1);
            if(mapGreater.containsKey(curr)==false){
                mapGreater.put(greater.substring(i,i+1), 1);
            }
            else{
                Integer temp = mapGreater.get(curr);
                mapGreater.put(curr,temp+1);
            }
        }
        //compare greater with less
        for(int i=0; i<less.length();i++){
            String curr = less.substring(i, i+1);
            if(mapGreater.containsKey(curr) == false){
                return false;
            }
            else if(mapGreater.get(curr) == 0){
                return false;
            }
            else{
                Integer temp = mapGreater.get(curr);
                mapGreater.put(curr,temp-1);
            }
        }
        return true;
    }
    //URLify
    String URLify(char[] str, int length){
        char[] tempArr = new char[length];
        for(int i=0; i<length; i++){
            if(str[i]== (' ')){
                //save overwritten chars    
                int curr = 0;
                tempArr[1] = str[i+1];
                tempArr[2] = str[i+2];
                for(int z=i+1; z<length; z++){
                    tempArr[curr] = str[z];
                    curr++;
                }
                //insert new chars
                str[i] = '%';
                str[i+1] = '2';
                str[i+2] = '0';
                length+=2;
                curr = 0;
                for(int x=i+3; x<tempArr.length; x++){
                    str[x] = tempArr[curr];
                    curr++;
                }
            }
        }
        //hello world itisf
        //hello%20world%20itisf
        return "";
    }
}