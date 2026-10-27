import java.util.Scanner;
import java.util.*;
public class predsucc{
    // declare the global variable.
    static node temp=null;
    static int pred=-1;
    static int succ=-1;
   public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}
public static void inorder(node root,int key){
    if(root==null) return;
   
   
    inorder(root.left,key);
    //magic
    if(temp==null){
         temp=root;
    }
    else if(root.val==key){
            pred=temp.val;
       temp=root;
    }
        else if(root.val>key){
            succ=root.val;
            temp=root;
        }
        else{
            temp=root;
        }
    

    inorder(root.right,key);
    return;
}

    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
      node root = new node(4);
root.left = new node(1);
root.right = new node(7);

root.left.right = new node(3);
root.right.right = new node(8);
       int key = 7;
       inorder(root,key);
       System.out.println(pred);
       System.out.print(succ);
    }

}   

