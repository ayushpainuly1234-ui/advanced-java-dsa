import java.util.Scanner;
import java.util.*;
public class morristraversal{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
   }
   public static node morristraversal(node root){
    node cur=root;
    while(cur!=null){
        if(cur.left!=null){
    node pred=cur.left;
    while(pred.right!=null){
        pred=pred.right;
        
    }
    pred.right=cur.right;
    cur.right=cur.left;
    cur.left=null;
        }
     cur=cur.right;
    }
    
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

              
                 
    node flattenlist = morristraversal(root);
node temp = flattenlist;
while (temp != null) {
    System.out.print(temp.val + " ");
    temp = temp.right;
}

}
}