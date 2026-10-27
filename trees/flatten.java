import java.util.Scanner;
import java.util.*;
public class flatten{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
   }
    public static node flatten(node root){
    if(root==null) return root;
    node lefttree=flatten(root.left);
    node righttree=flatten(root.right);
    
    root.right=lefttree;
      root.left=null;
    node temp=root;
    while(temp.right!=null){
        temp=temp.right;
    }
   
    temp.right=righttree;
   
  
   return root;
}




  
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);

        root.left.left = new node(4);
        root.left.left.left = new node(5);
        root.left.left.right = new node(6);

        root.right.left = new node(7);
        root.right.right = new node(8);
        root.right.right.left = new node(9);
        root.right.right.right = new node(10);

              
                 
    node flattenlist = flatten(root);
node temp = flattenlist;
while (temp != null) {
    System.out.print(temp.val + " ");
    temp = temp.right;
}

}
}