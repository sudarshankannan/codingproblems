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
    HashMap<Integer,ArrayList<TreeNode>> depthListRecursive(Tree tree){
        //height val, list of nodes 
        HashMap<Integer,ArrayList<TreeNode>> heightList = new HashMap<Integer,ArrayList<TreeNode>>();
        //iterative inorder traversal
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        return null;
    }
    HashMap<Integer,ArrayList<TreeNode>> depthListIterative(TreeNode node, HashMap<Integer,ArrayList<TreeNode>> heightList){
        //height val, list of nodes 
        HashMap<Integer,ArrayList<TreeNode>> heightList = new HashMap<Integer,ArrayList<TreeNode>>();
        //iterative inorder traversal
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        return null;
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