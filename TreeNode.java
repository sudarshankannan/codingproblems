import jdk.nashorn.api.tree.Tree;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(){
        this.left = null;
        this.right = null;
    }
    TreeNode(int data){
        this.left = null;
        this.right = null;
        this.data = data;
    }
}