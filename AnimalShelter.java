import java.util.Stack;

class AnimalShelter {
    //each node of the stack
    class Node{
        String type;
        String name;
        Node(){
            this.type = null;
            this.name = null;
        }
        Node(String type, String name){
            this.type = type;
            this.name = name;
        }
    }
    //Animal Shelter class stuff
    Stack<Node> s1;
    Stack<Node> s2;
    AnimalShelter(){
        this.s1 = new Stack<Node>();
        this.s1 = new Stack<Node>();
    }
    void enqueue(Node animal){
        s1.push(animal);
    }
    Node dequeueAny(){
        if(!s2.empty()){
            return s2.pop();
        }
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        Node temp = s2.pop();
        return temp;
    }
    //dequeue oldest dog
    Node dequeueDog(){
        Node temp = null;
        boolean foundDog = false;
        while(s1.empty() == false){
            s2.push(s1.pop());
        }
        while(s2.empty() == false){
            temp = s2.pop();
            if(foundDog == false && temp.type.equals("dog")){
                foundDog = true;
            }
            else{
                s1.push(temp);
            }
        }
        return temp;
    }
    //dequeue oldest cat
    Node dequeueCat(){
        Node temp = null;
        boolean foundCat = false;
        while(s1.empty() == false){
            s2.push(s1.pop());
        }
        while(s2.empty() == false){
            temp = s2.pop();
            if(foundCat == false && temp.type.equals("cat")){
                foundCat = true;
            }
            else{
                s1.push(temp);
            }
        }
        return temp;
    }
}