import java.util.Scanner;
import java.util.*;
public class invertbinarysearchtree{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}
public static void display(node root){
    if(root==null) return ;
    node temp=root;
   if(temp!=null){
        System.out.print(temp.val+" ");
   }
    display(root.left);
    display(root.right);
    return;
}
public static node bst(node root,int insert){
    node temp=new node(insert);
    if(root==null) return root;
    if(root.right==null  &&  root.val<insert){
        root.right=temp;
      return root;
    }

    if( root.left==null  &&  root.val>insert){
      root.left=temp;
      return root;
    }
    if(root.val<insert){
        bst(root.right,insert);

    }
    else{
          bst(root.left,insert);
        
    }
    return root;


}





  
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node root = new node(4);
        root.left = new node(2);
        root.right = new node(7);

        root.left.left = new node(1);
       
         root.left.right=new node(3);

            int insert=5;
           node ans=bst(root,insert);
          display(ans);
   
}

}