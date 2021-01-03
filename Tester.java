class Tester{
    public static void main(String[] args) {
        StringFuncs tester1 = new StringFuncs();
        //System.out.println(tester1.isPalidrome("racecare"));
        
        //System.out.println(tester1.oneAway("racecar","racecar"));
        //System.out.println(tester1.oneAway("racecar","racea")); //two chars removed
        //System.out.println(tester1.oneAway("racecar","raceca")); //one char removed
        //System.out.println(tester1.oneAway("racecar","racekad")); //same length, two diff chars
        //System.out.println(tester1.oneAway("racecar","racecar")); //same string
        //System.out.println(tester1.oneAway("racear","racecar")); //one insertion string

        //System.out.println(tester1.stringComp("aabcccccaaa"));

        System.out.println(tester1.isSubstring("waterbottle","erbottlewat"));
    }
}