import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class Tree {
    TreeNode head;
    //constructor
    Tree(){
        this.head = null;
    }
    Tree(TreeNode root){
        this.head = root;
    }
    //add a node
    void insert(int data){
        TreeNode nuNode = new TreeNode(data);
        //empty tree case
        if(this.head == null){
            this.head = nuNode;
            return;
        }
        //
        TreeNode p = this.head;
        while(p.left != null || p.right != null){
            if(p.data == data){
                return;
            }
            //less 
            else if(p.data>data){
                if(p.left==null && p.right==null){
                    p.left = nuNode;
                    return;
                }
                else if(p.left==null && p.right!=null){
                    p.left = nuNode;
                    return;
                }
                else{
                    p = p.left;
                }
            }
            //greater
            else if(p.data<data){
                if(p.left==null && p.right==null){
                    p.right = nuNode;
                    return;
                }
                else if(p.right==null && p.left!=null){
                    p.right = nuNode;
                    return;
                }
                else{
                    p = p.right;
                }
            }
        }
    }
    //delete a node
    //minimalBST
    TreeNode createMinimalBST(int array[]){
        return createMinimalBST(array,0,array.length-1);
    }
    private TreeNode createMinimalBST(int[] arr, int start, int end) {
        if(end < start){
            return null;
        }
        int mid = (start + end) /2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid-1);
        n.right = createMinimalBST(arr, mid+1, end);
        return n;
    }
    HashMap<Integer,ArrayList<TreeNode>> depthListIterative(Tree tree){
        //height val, list of nodes 
        HashMap<Integer,ArrayList<TreeNode>> heightList = new HashMap<Integer,ArrayList<TreeNode>>();
        //create stack
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        //traversal
        TreeNode p = tree.head;
        while(s1.empty() == false || p!=null){
            //go left
            while(p != null){
                s1.push(p);
                p = p.left;
            }
            //add to arraylist
            Integer tempHeight = getHeight(p);
            if(heightList.containsKey(tempHeight) == true){
                heightList.get(tempHeight).add(p);
            }
            else{
                heightList.put(tempHeight, new ArrayList<TreeNode>());
                heightList.get(tempHeight).add(p);
            }
            p = s1.pop();
        }
        return heightList;
    }
    void depthListRecursive(TreeNode node, HashMap<Integer,ArrayList<TreeNode>> heightList){
        //base case
        if(node == null){
            return;
        }
        //recurse left
        depthListRecursive(node.left, heightList);
        //add node to arraylist
        Integer tempHeight = getHeight(node);
        if(heightList.containsKey(tempHeight) == true){
            heightList.get(tempHeight).add(node);
        }
        else{
            heightList.put(tempHeight, new ArrayList<TreeNode>());
            heightList.get(tempHeight).add(node);
        }
        //recurse right
        depthListRecursive(node.right, heightList);
    }
    //checkBalanced
    boolean checkBalanced(){
        //create stack
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        //traversal
        TreeNode p = this.head;
        while(s1.empty() == false || p!=null){
            //go left
            while(p != null){
                s1.push(p);
                p = p.left;
            }
            //check height balance at a node
            if(Math.abs((double)(getHeight(p.left)-getHeight(p.right))) > 1){
                return false;
            }
            //hit the right 
            p = s1.pop();
        }
        return true;
    }
    //getHeight
    int getHeight(TreeNode node){
        if(node==null){
            return -1;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    void inorder(TreeNode node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.println(node.data + " ");
        inorder(node.right);
    }
}