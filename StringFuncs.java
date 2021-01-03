import java.util.*;

class StringFuncs{
    //isUnique
    boolean isUnique(String str){
        if(str.length() > 128){
            return false;
        }
        boolean[] char_set = new boolean[128];
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
    //checkPermutation
    boolean checkPermutation(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        int letters[] = new int[128];
        //coint chars in str1
        char[] s_array = str1.toCharArray();
        for(char c: s_array){
            letters[c]++;
        }
        //check with str2
        for(int i=0; i<str2.length(); i++){
            int c = (int) str2.charAt(i);
            letters[c]--;
            if(letters[c]<0){
                return false;
            }
        }
        return true;
    }
    //URLify
    void URLify(char[] str, int trueLength){
        //"Mr John Smith    ",13
        //"Mr%20John%20Smith"
        int spaceCount = 0;
        int i=0; 
        int index = 0;
        for(i=0; i<trueLength; i++){
            if(str[i]==' '){
                spaceCount++;
            }
        }
        index = trueLength + spaceCount*2;
        if(trueLength<str.length){
            str[trueLength] = '\0'; //end array;
        }
        for(i=trueLength-1; i>=0; i--){
            if(str[i]==' '){
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index = index - 3;
            }
            else{
                str[index-1] = str[i];
                index--;
            }
        }
    }
    //isPalindrome
    boolean isPalidrome(String str){
        for(int i=0; i<str.length(); i++){
            if(!str.substring(i, i+1).equals(str.substring(str.length()-1-i,str.length()-i))){
                return false;
            }
        }
        return true;
    }
    //palPerm - palindrome permutation
    boolean palPerm(String s){
        //input "tact Coa"
        //output: true, "taco cat" "atco cta"
        s = s.toLowerCase();
        //create char array of characters and stuff
        int[] letters = new int[128];
        char[] s_array = s.toCharArray();
        for(char c : s_array){
            letters[c]++;
        }
        //iterate through hashmap
        boolean oddFlag = false; //set to true if we find a single lone character
        for(int i=0; i<letters.length; i++){
            if(letters[i]%2 == 1){
                if(oddFlag == false){
                    oddFlag = true;
                }
                else if(oddFlag==true){
                    return false;
                }
            }
        }
        return true;
    }
    boolean oneAway(String s, String t){
        //more than one edit case b/c of length
        if(Math.abs(s.length() - t.length())>1){
            return false;
        }
        //if same string case
        if(s.equals(t)){
            return true;
        }
        //create hashmaps
        HashMap<String, Integer> smap = new HashMap<String, Integer>();
        HashMap<String, Integer> tmap = new HashMap<String, Integer>();
        //insert items in smap
        for(int i=0; i<s.length(); i++){
            String temp = s.substring(i, i+1);
            if(smap.get(temp)==null){
                smap.put(temp, 1);
            }
            else{
                int a = smap.get(temp);
                smap.put(temp, a+1);
            }
        }
        //insert items in tmap
        for(int i=0; i<t.length(); i++){
            String temp = t.substring(i, i+1);
            if(tmap.get(temp)==null){
                tmap.put(temp, 1);
            }
            else{
                int a = tmap.get(temp);
                tmap.put(temp, a+1);
            }
        }
        //if same length
        Iterator i = smap.entrySet().iterator();
        boolean oneFlag = false;
        boolean nullFlag = false;
        while(i.hasNext()){
            Map.Entry element = (Map.Entry)i.next();
            String sKey = (String)element.getKey();
            int sVal = (int)element.getValue();
            if(tmap.get(sKey) == null){
                nullFlag = true;
            }
            else if(Math.abs(tmap.get(sKey) - sVal) > 1){
                return false;
            }
            else if(Math.abs(tmap.get(sKey) - sVal) == 1){
                if(oneFlag==true){
                    return false;
                }
                oneFlag = true;
            }
        }
        if(nullFlag==true && oneFlag==true){
            return false;
        }
        return true;
    }
    //stringComp
    String stringComp(String s){
        //a2b1c5a3
        String result = "";
        char[] s_array = s.toCharArray();
        char prev = '/';
        int first = 1;
        int count = 0;
        for(char c : s_array){
            if(first == 1){
                System.out.println(c + " first");
                first = 0;
            }
            else if(prev==c){
                System.out.println(c + " prev=="+c);
            }
            else if(first==0 && prev != c){
                System.out.println(c + " prev!="+c);
                result+=(Character.toString(prev) + Integer.toString(count));
                count = 0;
            }
            ++count;
            prev = c;
        }
        return result;
    }
}