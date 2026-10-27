import java.util.Scanner;
import java.util.*;
public class balancedtree{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}
public static int height(node root){
    if(root==null){
        return 0;
    }
    if(root.left==null   &&  root.right==null){
        return 0;
    }
    return 1+Math.max(height(root.left),height(root.right));
}
public static boolean isbalanced(node root){
    if(root==null) return true;
  int leftans=height(root.left);
  if(root.left!=null)  leftans++;
  int rightans=height(root.right);
   if(root.right!=null)  rightans++;
   int diffrance=leftans-rightans;
   if(diffrance<0) diffrance=-diffrance;
    
   if(diffrance>1)  return false;
   
   return (isbalanced(root.left)   &&  isbalanced(root.right)); 
 }
 
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node root= new node(1);
        node a=new node(2);
            node b=new node(3);
            root.left=a;
            root.right=b;
                node c=new node(4);
                node d=new node(5);
                a.left=c;
                a.right=d;
               node e=new node(6);
               b.right=e;
          boolean flag=isbalanced(root);
          System.out.print(flag);
          
               
    
}
}