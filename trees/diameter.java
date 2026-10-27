import java.util.Scanner;
import java.util.*;
public class diameter{
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
public static int diameter(node root){
    if(root==null)  return 0;
     if(root.left==null   &&  root.right==null) return 0;
    int leftans=diameter(root.left);
    int rightans=diameter(root.right);
    int mid=height(root.left)+height(root.right);
    if(root.left!=null)  mid++;
    if(root.right!=null) mid++;
    int max=Math.max(leftans,Math.max(rightans,mid));
          return max;
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
            System.out.print(diameter(root));
          
               
    
}
}