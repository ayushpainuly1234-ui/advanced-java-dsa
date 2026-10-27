import java.util.Scanner;
import java.util.*;
public class deleteanynode{// inorderpredecessor
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}
public static void display(node root,int n){
    if(root==null) return ;
    node temp=root;
   if(n==1){
        System.out.print(temp.val+" ");
   }
    display(root.left,n-1);
    display(root.right,n-1);
    return;
}
public static node delete(node root, int delete) {
    if (root == null) return null;
    if (delete < root.val) {
        root.left = delete(root.left, delete);
    } 
    else if (delete > root.val) {
        root.right = delete(root.right, delete);
    } 
    else {
        // Found the node to delete
        if (root.left == null) return root.right;
        else if (root.right == null) return root.left;
      
     else{  // Find inorder predecessor (max in left subtree)
        node temp = root.left;
        while (temp.right != null) temp = temp.right;
        // Swap values
        root.val = temp.val;
        // Delete the predecessor node
        root.left = delete(root.left, temp.val);
    }
    }
    return root;
}
public static int hi(node root){
    if(root==null) return 0;
    int ans=1+Math.max(hi(root.left),hi(root.right));
    return ans;
}
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
      node root = new node(4);
root.left = new node(1);
root.right = new node(7);

root.left.right = new node(3);
root.right.right = new node(8);


       int delete = 7;
       int height=hi(root);
   
         node ans=delete(root,delete);
         for(int i=1;i<=height;i++){
          display(ans,i);
          System.out.println("");
         }
     
} 

}   