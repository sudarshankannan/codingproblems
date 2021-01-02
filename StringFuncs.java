import java.util.HashMap;

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
}